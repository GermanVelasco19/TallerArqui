package taller.tallerMicroServicios.Repositories;

import taller.tallerMicroServicios.Entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
}
