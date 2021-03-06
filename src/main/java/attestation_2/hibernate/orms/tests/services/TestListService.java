package attestation_2.hibernate.orms.tests.services;

import attestation_2.hibernate.orms.tests.dao.TestListDao;
import attestation_2.hibernate.orms.tests.models.TestList;

import java.util.List;

public class TestListService {
    private final TestListDao testListDao = new TestListDao();

    public TestListService() {
    }

    public TestList findTestList(int id) {
        return testListDao.findById(id);
    }

    public void saveTestList(TestList testList) {
        testListDao.save(testList);
    }

    public void updateTestList(TestList testList) {
        testListDao.update(testList);
    }

    public void deleteTestList(TestList testList) {
        testListDao.delete(testList);
    }

    public List<TestList> findAllTestLists() {
        return testListDao.getAll();
    }
}