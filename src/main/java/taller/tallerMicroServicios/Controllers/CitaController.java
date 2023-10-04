package taller.tallerMicroServicios.Controllers;

import taller.tallerMicroServicios.Entities.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import taller.tallerMicroServicios.services.CitaService;

import java.util.ArrayList;

@RestController
public class CitaController {

    @Autowired
    CitaService cita;

    @GetMapping(value="/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<Cita> getAll(){
        return cita.SearchAll();
    }

}
