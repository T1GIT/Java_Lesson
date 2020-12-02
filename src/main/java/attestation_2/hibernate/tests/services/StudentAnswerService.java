package attestation_2.hibernate.tests.services;

import attestation_2.hibernate.tests.dao.StudentAnswerDao;
import attestation_2.hibernate.tests.models.StudentAnswer;

import java.util.List;

public class StudentAnswerService {
    private final StudentAnswerDao studentAnswerDao = new StudentAnswerDao();

    public StudentAnswerService() {
    }

    public StudentAnswer findStudentAnswer(int id) {
        return studentAnswerDao.findById(id);
    }

    public void saveStudentAnswer(StudentAnswer studentAnswer) {
        studentAnswerDao.save(studentAnswer);
    }

    public void updateStudentAnswer(StudentAnswer studentAnswer) {
        studentAnswerDao.update(studentAnswer);
    }

    public void deleteStudentAnswer(StudentAnswer studentAnswer) {
        studentAnswerDao.delete(studentAnswer);
    }

    public List<StudentAnswer> findAllStudentAnswers() {
        return studentAnswerDao.getAll();
    }
}