package taller.tallerMicroServicios.services;

import taller.tallerMicroServicios.Entities.Cita;
import taller.tallerMicroServicios.Repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CitaService {

    @Autowired
    CitaRepository Repo;

    public ArrayList<Cita> SearchAll(){
        return (ArrayList<Cita>) Repo.findAll();
    }

    public void Put(Cita c){
        Repo.save(c);
    }

    public void updateCity(Cita c){
        Repo.save(c);
    }

    public void deleteCity(Integer ID){
        Repo.deleteById(ID);
    }

    public Cita findById(Integer ID){
        if (Repo.existsById(ID)){
            return Repo.getReferenceById(ID);
        }else{
            return null;
        }
    }

}
