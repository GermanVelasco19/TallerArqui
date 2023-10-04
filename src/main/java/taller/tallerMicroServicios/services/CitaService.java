package taller.tallerMicroServicios.services;

import taller.tallerMicroServicios.Entities.Cita;
import taller.tallerMicroServicios.Repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

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

    public void updateCita(Cita c){
        Repo.save(c);
    }

    public void deleteCita(Integer ID){
        Repo.deleteById(ID);
    }

    public Cita findById(Integer ID){
        if (Repo.existsById(ID)){
            return Repo.getReferenceById(ID);
        }else{
            return null;
        }
    }

    public ArrayList<Cita> findByCedula(BigInteger ID){
        ArrayList<Cita> citas;
        ArrayList<Cita> rta = new ArrayList<>();

        citas = this.SearchAll();

        for (int i =0;i<citas.size();i++){
            if (Objects.equals(citas.get(i).getCedula(), ID)){
                rta.add(i,citas.get(i));
            }
        }
        return rta;

    }

}
