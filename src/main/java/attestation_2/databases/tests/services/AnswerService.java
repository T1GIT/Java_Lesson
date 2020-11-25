package attestation_2.databases.tests.services;

import attestation_2.databases.tests.dao.AnswerDao;
import attestation_2.databases.tests.models.Answer;

import java.util.List;

public class AnswerService {
    private final AnswerDao answerDao = new AnswerDao();

    public AnswerService(){}

    public Answer findAnswer(int id){
        return answerDao.findById(id);
    }

    public void saveAnswer(Answer answer){
        answerDao.save(answer);
    }

    public void updateAnswer(Answer answer){
        answerDao.update(answer);
    }

    public void deleteAnswer(Answer answer){
        answerDao.delete(answer);
    }

    public List<Answer> findAllAnswers(){
        return answerDao.getAll();
    }
}
