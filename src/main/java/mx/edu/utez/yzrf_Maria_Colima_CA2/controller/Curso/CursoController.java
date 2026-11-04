package mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Curso;


import jakarta.validation.Valid;
import mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Curso.DTO.RequestRegistrarCursoDTO;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Curso;
import mx.edu.utez.yzrf_Maria_Colima_CA2.service.CursoService;
import mx.edu.utez.yzrf_Maria_Colima_CA2.service.InscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/curso")
@CrossOrigin("*")
public class CursoController {

    private final CursoService cursoService;
    private final InscripcionService inscripcionService;

    public CursoController (CursoService cursoService, InscripcionService inscripcionService) {
        this.cursoService = cursoService;
        this.inscripcionService = inscripcionService;
    }

    @PatchMapping ("/{id}/cambiar")
    public ResponseEntity<Curso> cambiarEstado (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.cambiarEstado(id));
    }

    @PostMapping
    public ResponseEntity<Curso> registrarCurso (@RequestBody @Valid RequestRegistrarCursoDTO payload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.registrarCurso(payload));
    }


}
