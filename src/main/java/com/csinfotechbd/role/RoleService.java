package com.csinfotechbd.role;

import java.util.Date;
import java.util.List;

import com.csinfotechbd.audittrail.AuditTrailService;
import com.csinfotechbd.user.UserService;
import com.csinfotechbd.userrole.UserRole;
import com.csinfotechbd.workflow.propertyBasedMakerChecker.PropertyBasedMakerCheckerService;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shuvo on 08/01/2017.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PropertyBasedMakerCheckerService<Role> makerCheckerService;

    @Autowired
    private AuditTrailService auditTrailService;

    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    public List<Role> getActiveList() {
        return roleDao.getActiveOnly();
    }

    public void saveOrUpdate(Role role) {
        String username = UserService.getSessionUsername();
        if (role.getRoleId() == null) {
            role.setEnabled(false);
            role.setCreatedBy(username);
            roleDao.save(role);
            auditTrailService.saveCreatedData("Role", role);
        } else {
            Role oldRole = roleDao.findById(role.getRoleId());
            Role previousRole = new Role();
            BeanUtils.copyProperties(oldRole, previousRole);

            role.setEnabled(false);
            role.setModifiedBy(username);
            role.setModifiedDate(new Date());
            roleDao.update(role);
            auditTrailService.saveUpdatedData("Role", previousRole, role);
        }
        makerCheckerService.makePending(Role.class, "roleId", role.getRoleId());
    }

    public Role findById(int roleId) {
        return roleDao.findById(roleId);
    }

    // 	TODO: Unnecessary code. Delete whenever feel safe
//	public void removeUserFromRole(long userId, int roleId) {
//		roleDao.detachUserFromRole(userId, roleId);
//	}
//
//	public void removeUserFromRoles(long userId, List<Integer> roleIds) {
//		roleIds.parallelStream().forEach(id-> roleDao.detachUserFromRole(userId, id));
//	}
//
//	public void removeAllUserFromRole(int roleId) {
//		roleDao.detachAllUserFromRole(roleId);
//	}
//
//	public void attachUserWithRoles(long userId,List<Integer> roleIds){
//		roleIds.parallelStream().forEach(id->roleDao.addUserToRole(userId,id));
//	}

    public List<UserRole> getUserRoleByUserId(Long uid) {
        return roleDao.getUserRoleByUId(uid);
    }


}
