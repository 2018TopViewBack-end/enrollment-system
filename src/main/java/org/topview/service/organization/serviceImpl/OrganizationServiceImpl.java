package org.topview.service.organization.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.dao.organization.UserMapper;
import org.topview.entity.organization.bo.DepartmentAdminBo;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.OrganizationPhotoVo;
import org.topview.entity.organization.bo.OrganizationBo;
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
            organization.setStatus(Constant.OrganizationStatus.ONLINE);
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
    @Transactional(rollbackFor = Exception.class)
    public Result addDepartmentAdmin(DepartmentAdminBo departmentAdminBo) {
        //判断数据库是否存在该用户名
        String username = departmentAdminBo.getUser().getUsername();
        if(username == null || "".equals(username)) {
            return Result.fail(USERNAME_NOT_BE_EMPTY);
        }
        if(userMapper.hasUsername(username) > 0) {
            return Result.fail(USERNAME_ALREADY_EXIST);
        }

        //包装注册用户的信息
        User user = departmentAdminBo.getUser();
        user.setRoleId(Constant.Role.DEPARTMENT_ADMIN);
        user.setStatus(User.NORMAL);

        //在用户表添加部门管理员的信息
        userMapper.insertUser(user);
        //在部门表添加部门管理员的信息
        departmentMapper.updateDepartmentAdmin(user.getId(), departmentAdminBo.getDepartmentId());
        return Result.success();
    }

    /**
     * 获取部门管理员的信息
     * @param departmentId 部门的id
     * @return 结果集(包含否操作成功,描述信息,请求结果)
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
     * 查询该状态下的所有社团
     * @param status 状态码 0为待审核，1为可用，2为禁用
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum, Integer status) {
        return organizationMapper.selectOrganizationByStatus(status);
    }

    /**
     * 通过名字模糊查询社团
     * @param name
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum, String name) {
        name = '%'+name+'%';
        return organizationMapper.selectOrganizationByName(name);
    }

    /**
     * 通过社团分类查询社团
     * @param category
     * @return
     */
    @Override
    public List<OrganizationBo> selectOrganizationByCategoryService(Integer pageNum, String category) {
        return organizationMapper.selectOrganizationByCategory(category);
    }

    /**
     * 查询所有社团
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum) {
        return organizationMapper.selectAllOrganization();
    }

    /**
     * 通过社团分类和状态查询社团
     * @param category
     * @param status
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum, String category, Integer status) {
        return organizationMapper.selectOrganization(category,status);
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
    @Transactional(rollbackFor = Exception.class)
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

    /**
     * 首页社团获取一组图片
     * @param pageNum 当前页
     * @param pageSize 每页大小
     * @param category 社团类别
     * @return 获取的结果集
     */
    @Override
    public PageInfo<OrganizationPhotoVo> getOrganizationPhoto(int pageNum, int pageSize, String category) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrganizationPhotoVo> list = organizationMapper.getOrganizationPhotosByCategory(category);
        return PageInfo.of(list);
    }

    /**
     * 将社团的状态改为目标状态
     * @param status 目标状态码
     * @param organizationId 社团id
     * @return 修改成功返回1,
     */
    @Override
    public Integer updateOrganizationStatusService(Integer status, Integer organizationId) {
        return organizationMapper.updateOrganizationStatus(status,organizationId);
    }
}
