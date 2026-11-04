package mx.edu.utez.yzrf_Maria_Colima_CA2.service;


import mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Curso.DTO.RequestRegistrarCursoDTO;
import mx.edu.utez.yzrf_Maria_Colima_CA2.exception.CustomBadRequestException;
import mx.edu.utez.yzrf_Maria_Colima_CA2.exception.CustomNotFoundException;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Curso;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Estado;
import mx.edu.utez.yzrf_Maria_Colima_CA2.repository.CursoRepository;
import mx.edu.utez.yzrf_Maria_Colima_CA2.repository.InscripcionRepository;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    public CursoService(CursoRepository cursoRepository, InscripcionRepository inscripcionRepository){
        this.cursoRepository =  cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    public Curso cambiarEstado (Long  id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new CustomBadRequestException("El curso no existe "));
        if (curso.getEstado()== Estado.FINALIZADO){
            throw new CustomBadRequestException("El estado ya esta finalizado");
        } else if (curso.getEstado() == Estado.DISPONIBLE) {
            curso.setEstado(Estado.EN_CURSO);
        } else {
            curso.setEstado(Estado.FINALIZADO);
        }

        return cursoRepository.save(curso);
    }




      public Curso registrarCurso (RequestRegistrarCursoDTO payload) {
        Curso curso = cursoRepository.findById(payload.cursoId).orElseThrow(() -> new CustomNotFoundException("El curso no existe"));

            Curso c = new Curso();
            c.setEstado(Estado.DISPONIBLE);
            c.setDescripcion(payload.getDescripcion());
            c.setFechaFin(payload.getFechaFin());
            c.setFechaInicio(payload.getFechaInicio());
            c.setId(curso.getId());
            return cursoRepository.save(curso);


}












}
