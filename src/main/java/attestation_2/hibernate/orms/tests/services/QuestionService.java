package attestation_2.hibernate.orms.tests.services;

import attestation_2.hibernate.orms.tests.dao.QuestionDao;
import attestation_2.hibernate.orms.tests.models.Question;

import java.util.List;

public class QuestionService {
    private final QuestionDao questionDao = new QuestionDao();

    public QuestionService() {
    }

    public Question findQuestion(int id) {
        return questionDao.findById(id);
    }

    public void saveQuestion(Question question) {
        questionDao.save(question);
    }

    public void updateQuestion(Question question) {
        questionDao.update(question);
    }

    public void deleteQuestion(Question question) {
        questionDao.delete(question);
    }

    public List<Question> findAllQuestions() {
        return questionDao.getAll();
    }
}