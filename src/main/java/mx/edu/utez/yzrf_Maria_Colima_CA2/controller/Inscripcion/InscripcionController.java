package mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Inscripcion;

import jakarta.validation.Valid;
import mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Inscripcion.DTO.RequestInscribirParticipanteDto;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Curso;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.inscripcion.Inscripcion;
import mx.edu.utez.yzrf_Maria_Colima_CA2.service.CursoService;
import mx.edu.utez.yzrf_Maria_Colima_CA2.service.InscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripcion")
@CrossOrigin("*")
public class InscripcionController {

    private final CursoService cursoService;
    private final InscripcionService inscripcionService;

    public InscripcionController (CursoService cursoService, InscripcionService inscripcionService) {
        this.cursoService = cursoService;
        this.inscripcionService = inscripcionService;
    }

/*
@PostMapping
public ResponseEntity<Inscripcion> inscribirParticipante (@RequestBody @Valid RequestInscribirParticipanteDto payload) {
    return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.inscribirParticipante(payload));
}


 */
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Inscripcion> cancelarInscripcion (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.cancelarInscripcion(id));
    }


}
