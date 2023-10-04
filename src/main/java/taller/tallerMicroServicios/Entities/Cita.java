package taller.tallerMicroServicios.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Data
public class Cita implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cita;

    private String nombre;

    private String last_name;

    private String fecha;

    private BigInteger cedula;

    private String proposito;
}
