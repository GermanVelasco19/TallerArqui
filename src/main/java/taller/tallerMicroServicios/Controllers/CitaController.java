package taller.tallerMicroServicios.Controllers;

import org.springframework.beans.factory.annotation.Value;
import taller.tallerMicroServicios.Entities.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import taller.tallerMicroServicios.services.CitaService;

import java.math.BigInteger;
import java.util.ArrayList;

@RestController
public class CitaController {

    @Autowired
    CitaService cita;

    @GetMapping(value="/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Cita> getAll(){
        return cita.SearchAll();
    }

    @GetMapping(value="/searchCedula/{cedula}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Cita> searchCedula(@PathVariable BigInteger cedula){
        return cita.findByCedula(cedula);
    }

    @PostMapping(value="/NewCita")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean NewCita(@RequestBody Cita c){
        ArrayList<Cita> citas = cita.SearchAll();

        boolean citaExists = citas.stream()
                .anyMatch(existingUser -> existingUser.getFecha().equals(c.getFecha()));

        if (citaExists) {
            return false;
        } else {
            cita.Put(c);
            return true;
        }
    }

    @PostMapping(value = "/deleteCita/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Integer id){
        cita.deleteCita(id);
    }

    @PutMapping(value = "/updateCita/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateCita(@RequestBody Cita c,@PathVariable Integer id){
        c.setId_cita(id);
        Cita x =cita.findById(id);

        if(x!=null){
            x.setNombre(c.getNombre());
            x.setLast_name(c.getLast_name());
            x.setCedula(c.getCedula());
            x.setFecha(c.getFecha());
            x.setProposito(c.getProposito());

            cita.updateCita(c);
        }
    }
}
