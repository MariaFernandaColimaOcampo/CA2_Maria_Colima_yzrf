package mx.edu.utez.yzrf_Maria_Colima_CA2.controller.Curso.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Estado;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegistrarCursoDTO {

    public Long cursoId;
    @NotBlank(message = "mensaje de error")
    private String nombre;
    @NotBlank(message = "mensaje de error")
    private String Descripcion;
    @NotNull(message = "La fecha de inicio es obligatoria")
   private LocalDate fechaInicio;
     @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaFin;
    @NotNull(message = "El estado de inicio es obligatoria")
    private Estado estado;

}
