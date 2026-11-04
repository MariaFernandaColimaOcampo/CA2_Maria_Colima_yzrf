package mx.edu.utez.yzrf_Maria_Colima_CA2.service;

import jakarta.validation.Valid;
import mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Inscripcion.DTO.RequestInscribirParticipanteDto;
import mx.edu.utez.yzrf_Maria_Colima_CA2.exception.CustomBadRequestException;
import mx.edu.utez.yzrf_Maria_Colima_CA2.exception.CustomNotFoundException;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Curso;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Estado;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.inscripcion.EstadoI;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.inscripcion.Inscripcion;
import mx.edu.utez.yzrf_Maria_Colima_CA2.repository.CursoRepository;
import mx.edu.utez.yzrf_Maria_Colima_CA2.repository.InscripcionRepository;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {
    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionService(CursoRepository cursoRepository, InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    //cancelar inscripcion - 20

    //Recibir el ID de la inscripción.
    //Validar que exista.
    //Permitir cancelar únicamente inscripciones en estado ACTIVA.
    //Validar que el curso no haya comenzado.
    //Cambiar el estado a CANCELADA.
    //Conservar el registro histórico.
    //Guardar los cambios en la base de datos.

    public Inscripcion cancelarInscripcion (Long  id) {
        Inscripcion inscripcion = inscripcionRepository.findById(id).orElseThrow(() -> new CustomBadRequestException("El curso no existe "));
        if (inscripcion.getEstado() == EstadoI.COMPLETADA  || inscripcion.getEstado() ==  EstadoI.CANCELADA) {
            throw new CustomBadRequestException("Y no esta activa la inscripcion");
        } else {
            inscripcion.setEstado(EstadoI.CANCELADA);
        }

        return inscripcionRepository.save(inscripcion);
    }
//inscribir participante - 30 puntos
//Recibir el ID del curso y los datos del participante.
//Validar que el curso exista.
//Validar que el nombre no esté vacío.
//Validar que el correo tenga un formato válido.
//Validar que la edad sea positiva.
//Validar que el curso se encuentre en estado DISPONIBLE.
//Registrar automáticamente la fecha de inscripción.
//Crear la inscripción con estado ACTIVA.
//Guardar los cambios en la base de datos.

    public Inscripcion inscribirParticipante (@Valid RequestInscribirParticipanteDto payload) {
        Curso curso = cursoRepository.findById(payload.cursoId).orElseThrow(() -> new CustomNotFoundException("No existe el curso"));
        if (curso.getEstado() == Estado.DISPONIBLE) {
            Curso c = new Curso();
            c.setId(curso.getId());
            c.setFechaInicio(payload.getFechaInicio());
            c.setFechaFin(payload.getFechaFin());
            c.setDescripcion(payload.getDescripcion());
            c.setNombre(payload.getNombre());
            c.setEstado(payload.getEstado());
        }
    }


}