package attestation_2.hibernate.orms.users_autos.services;

import attestation_2.hibernate.orms.users_autos.dao.UserDao;
import attestation_2.hibernate.orms.users_autos.models.Auto;
import attestation_2.hibernate.orms.users_autos.models.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public UserService(){}

    public User findUser(int id){
        return userDao.findById(id);
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public void updateUser(User user){
        userDao.update(user);
    }

    public void deleteUser(User user){
        userDao.delete(user);
    }

    public List<User> findAllUsers(){
        return userDao.getAll();
    }

    public Auto findAuto(int id){
        return userDao.findAutoById(id);
    }
}
