package attestation_2.hibernate.orms.tests.services;

import attestation_2.hibernate.orms.tests.dao.RoleDao;
import attestation_2.hibernate.orms.tests.models.Role;

import java.util.List;

public class RoleService {
    private final RoleDao roleDao = new RoleDao();

    public RoleService() {
    }

    public Role findRole(int id) {
        return roleDao.findById(id);
    }

    public void saveRole(Role role) {
        roleDao.save(role);
    }

    public void updateRole(Role role) {
        roleDao.update(role);
    }

    public void deleteRole(Role role) {
        roleDao.delete(role);
    }

    public List<Role> findAllRoles() {
        return roleDao.getAll();
    }
}