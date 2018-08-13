package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.dao.organization.UserMapper;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.DepartmentAdminVo;
import org.topview.service.organization.OrganizationService;
import org.topview.util.Result;

@Service
public class OrganizationServiceImpl implements OrganizationService {

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
                case "校级":break;
                case "院级":break;
                case "兴趣类":break;
                default:
                    String message = "社团类别出错";
                    return new Result(false, message);
            }
        }
        organizationMapper.updateByPrimaryKey(organization);
        String message = "更新社团信息成功";
        return new Result(true, message);
    }

    /**
     * 获取社团信息
     * @param organizationId 社团信息
     * @return 结果集(请求是否成功,描述信息,社团信息)
     */
    @Override
    public Result getOrganization(int organizationId) {
        Organization organization = organizationMapper.selectByPrimaryKey(organizationId);
        if(organization == null) {
            return new Result<>(false, "获取失败,该社团不存在");
        }
        return new Result<>(true, "获取社团信息成功", organization);
    }

    /**
     * 添加部门管理员
     * @param departmentAdminVo 部门管理员vo对象
     * @return 结果集(包含是否操作成功,以及描述信息)
     */
    @Override
    public Result addDepartmentAdmin(DepartmentAdminVo departmentAdminVo) {
        //判断数据库是否存在该用户名
        String username = departmentAdminVo.getUser().getUsername();
        if(userMapper.hasUsername(username) > 0) {
            return new Result(false, "该用户名已存在");
        }
        departmentAdminVo.getUser().setStatus(1);
        //在用户表添加社团管理员的信息
        userMapper.addDepartmentAdmin(departmentAdminVo);
        //在部门表添加社团管理员的信息
        departmentMapper.updateDepartmentAdmin(departmentAdminVo.getUser().getId(),
                departmentAdminVo.getDepartmentId());
        return new Result(true, "添加部门管理员成功");
    }

    /**
     * 获取部门管理员的信息
     * @param departmentId 部门的id
     * @return 结果集(包含是否操作成功,描述信息,请求结果)
     */
    @Override
    public Result getDepartmentAdmin(int departmentId) {
        User user = userMapper.getDepartmentAdmin(departmentId);
        if(user == null) {
            return new Result(false, "获取部门管理员失败");
        }
        return new Result<>(true, "获取部门管理员成功", user);
    }

    /**
     * 修改部门管理员的信息
     * @param user 部门管理员对象
     * @return 结果集(包含是否操作成功,描述信息)
     */
    @Override
    public Result updateDepartmentAdmin(User user) {
        String username = user.getUsername();
        if(username == null || "".equals(username)) {
            return new Result(false, "用户名不能为空");
        }
        userMapper.updateDepartmentAdmin(user);
        return new Result(true, "修改部门管理员成功");
    }

    /**
     * 删除部门管理员的信息
     * @param departmentId 部门id
     * @return 结果集(包含是否操作成功,描述信息)
     */
    @Override
    public Result deleteDepartmentAdmin(int departmentId) {
        if(userMapper.deleteDepartmentAdmin(departmentId) != 0) {
            return new Result(true, "删除部门管理信息成功");
        } else {
            return new Result(false, "删除部门管理信息失败");
        }
    }

}
