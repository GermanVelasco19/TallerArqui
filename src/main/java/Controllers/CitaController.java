package Controllers;

import Entities.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.CitaService;

import java.util.ArrayList;

@RestController
public class CitaController {

    @Autowired
    CitaService cita;

    @GetMapping(value="/Todas", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ArrayList<Cita> getAll(){

        System.out.println("HOLAAAAAAAAAA");
        return cita.SearchAll();
    }

}
