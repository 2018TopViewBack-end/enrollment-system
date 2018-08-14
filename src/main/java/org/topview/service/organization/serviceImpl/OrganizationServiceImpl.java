package org.topview.service.organization.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.dao.organization.UserMapper;
import org.topview.entity.organization.bo.DepartmentAdminBo;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.OrganizationPhotoVo;
import org.topview.service.organization.OrganizationService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pan梓涵
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private static final String USERNAME_ALREADY_EXIST = "用户名已存在";
    private static final String USERNAME_NOT_BE_EMPTY = "用户名不能为空";
    private static final String PASSWORD_NOT_BE_EMPTY = "密码不能为空";

    private static final String COMMUNITY_CATEGORY_ERROR = "社团类别出错";
    private static final String ORGANIZATION_NOT_EXIST = "该社团不存在";

    private static final String GET_DEPARTMENT_ADMIN_FAILURE = "获取部门管理员信息失败";
    private static final String DELETE_DEPARTMENT_ADMIN_FAILURE = "删除部门管理员失败";

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 更新社团信息
     * @param organization 社团信息对象
     * @return 结果集(包含是否操作成功,以及描述信息)
     */
    @Override
    public Result updateOrganization(Organization organization) {
        String category = organization.getCategory();
        if(category != null) {
            switch (category) {
                //社团类别：校级
                case Constant.OrganizationCategory.COLLEGE: break;
                //社团类别：院级
                case Constant.OrganizationCategory.ACADEMY: break;
                //社团类别：兴趣类
                case Constant.OrganizationCategory.INTERESTS: break;
                default:
                    return Result.fail(COMMUNITY_CATEGORY_ERROR);
            }
        }
        //判断社团当前的状态
        Integer status = organizationMapper.getOrganizationStatusById(organization.getId());
        if(Constant.OrganizationStatus.FORBIDDEN != status) {
            organization.setStatus(1);
        }
        organizationMapper.updateByPrimaryKey(organization);
        return Result.success();
    }

    /**
     * 获取社团信息
     * @param organizationId 社团信息
     * @return 结果集(请求是否成功,描述信息,社团信息)
     */
    @Override
    public Result getOrganization(Integer organizationId) {
        Organization organization = organizationMapper.selectByPrimaryKey(organizationId);
        if(organization == null) {
            return Result.fail(ORGANIZATION_NOT_EXIST);
        }
        return Result.success(organization);
    }

    /**
     * 添加部门管理员
     * @param departmentAdminBo 部门管理员vo对象
     * @return 结果集(包含是否操作成功,以及描述信息)
     */
    @Override
    public Result addDepartmentAdmin(DepartmentAdminBo departmentAdminBo) {
        //判断数据库是否存在该用户名
        String username = departmentAdminBo.getUser().getUsername();
        if(username == null || "".equals(username)) {
            return Result.fail(USERNAME_NOT_BE_EMPTY);
        }
        if(userMapper.hasUsername(username) > 0) {
            return Result.fail(USERNAME_ALREADY_EXIST);
        }
        departmentAdminBo.getUser().setRoleId(3);
        departmentAdminBo.getUser().setStatus(1);
        //在用户表添加社团管理员的信息
        userMapper.addDepartmentAdmin(departmentAdminBo);
        //在部门表添加社团管理员的信息
        departmentMapper.updateDepartmentAdmin(departmentAdminBo.getUser().getId(),
                departmentAdminBo.getDepartmentId());
        return Result.success();
    }

    /**
     * 获取部门管理员的信息
     * @param departmentId 部门的id
     * @return 结果集(包含是否操作成功,描述信息,请求结果)
     */
    @Override
    public Result getDepartmentAdmin(Integer departmentId) {
        User user = userMapper.getDepartmentAdmin(departmentId);
        if(user == null) {
            return Result.fail(GET_DEPARTMENT_ADMIN_FAILURE);
        }
        return Result.success(user);
    }

    /**
     * 修改部门管理员的信息
     * @param user 部门管理员对象
     * @return 结果集(包含是否操作成功,描述信息)
     */
    @Override
    public Result updateDepartmentAdmin(User user) {
        String password = user.getPassword();
        if(password == null || "".equals(password)) {
            return Result.fail(PASSWORD_NOT_BE_EMPTY);
        }
        userMapper.updateDepartmentAdmin(user);
        return Result.success();
    }

    /**
     * 删除部门管理员的信息
     * @param departmentId 部门id
     * @return 结果集(包含是否操作成功,描述信息)
     */
    @Override
    public Result deleteDepartmentAdmin(Integer departmentId) {
        if(userMapper.deleteDepartmentAdmin(departmentId) != 0) {
            return Result.success();
        } else {
            return Result.fail(DELETE_DEPARTMENT_ADMIN_FAILURE);
        }
    }

    /**
     * 根据社团管理员id获取社团信息
     * @param adminId 社团管理员的id
     * @return 社团信息id,查询不到,返回null
     */
    @Override
    public Integer getOrganizationIdByAdminId(Integer adminId) {
        return organizationMapper.getOrganizationIdByAdminId(adminId);
    }

    /**
     * 获取首页的社团图片
     * @return 返回获取的结果
     */
    @Override
    public Result getAllOrganizationPhoto() {
        //获取校级的图片
        PageInfo<OrganizationPhotoVo> collegePageInfo = getOrganizationPhoto(Constant.Page.DEFAULT_PAGE_NUM,
                Constant.Page.PAGE_SIZE, Constant.OrganizationCategory.COLLEGE);

        //获取院级的图片
        PageInfo<OrganizationPhotoVo> academyPageInfo = getOrganizationPhoto(Constant.Page.DEFAULT_PAGE_NUM,
                Constant.Page.PAGE_SIZE, Constant.OrganizationCategory.ACADEMY);

        //获取兴趣类的图片
        PageInfo<OrganizationPhotoVo> interestPageInfo = getOrganizationPhoto(Constant.Page.DEFAULT_PAGE_NUM,
                Constant.Page.PAGE_SIZE, Constant.OrganizationCategory.INTERESTS);

        Map<String, PageInfo> map = new HashMap<>(3);
        map.put(Constant.OrganizationCategory.COLLEGE, collegePageInfo);
        map.put(Constant.OrganizationCategory.ACADEMY, academyPageInfo);
        map.put(Constant.OrganizationCategory.INTERESTS, interestPageInfo);
        return Result.success(map);
    }

    @Override
    public PageInfo<OrganizationPhotoVo> getOrganizationPhoto(int pageNum, int pageSize, String category) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrganizationPhotoVo> list = organizationMapper.getOrganizationPhotosByCategory(category);
        return new PageInfo<>(list);
    }
}
