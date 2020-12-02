package attestation_2.databases.users_autos.services;

import attestation_2.databases.users_autos.dao.AutoDao;
import attestation_2.databases.users_autos.models.Auto;

import java.util.List;

public class AutoService {
    private final AutoDao autoDao = new AutoDao();

    public AutoService(){}

    public Auto findAuto(int id){
        return autoDao.findById(id);
    }

    public void saveAuto(Auto auto){
        autoDao.save(auto);
    }

    public void updateAuto(Auto auto){
        autoDao.update(auto);
    }

    public void deleteAuto(Auto auto){
        autoDao.delete(auto);
    }

    public List<Auto> findAllAutos(){
        return autoDao.getAll();
    }
}
