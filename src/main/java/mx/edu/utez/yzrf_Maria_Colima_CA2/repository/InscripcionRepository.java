package mx.edu.utez.yzrf_Maria_Colima_CA2.repository;


import mx.edu.utez.yzrf_Maria_Colima_CA2.model.inscripcion.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}


