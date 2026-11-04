package mx.edu.utez.yzrf_Maria_Colima_CA2.repository;

import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
