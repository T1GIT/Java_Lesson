package attestation_2.hibernate.orms.tests.services;

import attestation_2.hibernate.orms.tests.dao.GroupDao;
import attestation_2.hibernate.orms.tests.models.Group;

import java.util.List;

public class GroupService {
    private final GroupDao groupDao = new GroupDao();

    public GroupService() {
    }

    public Group findGroup(int id) {
        return groupDao.findById(id);
    }

    public void saveGroup(Group group) {
        groupDao.save(group);
    }

    public void updateGroup(Group group) {
        groupDao.update(group);
    }

    public void deleteGroup(Group group) {
        groupDao.delete(group);
    }

    public List<Group> findAllGroups() {
        return groupDao.getAll();
    }
}