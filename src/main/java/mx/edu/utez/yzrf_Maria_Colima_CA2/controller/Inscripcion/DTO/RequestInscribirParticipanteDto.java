package mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Inscripcion.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Curso;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Estado;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.inscripcion.EstadoI;

import java.time.LocalDate;

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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestInscribirParticipanteDto {
    @Id
    private Long inscricpcionId;

    @NotBlank (message = "No puede estar vacio")
     private String nombreParticipante;

    @NotNull (message = "No puede estar vacio")
    private int edadParticipante;

    @NotBlank (message = "No puede estar vacio")
    private String correo;

    @NotNull (message = "No puede estar vacio")
    private LocalDate fechaInscripcion;

    @Enumerated(EnumType.STRING)
    private EstadoI estado;

    @NotNull (message = "No puede estar vacio")
    private Double calificacion;

    @NotNull (message = "No puede estar vacio")
    private Curso curso;


}