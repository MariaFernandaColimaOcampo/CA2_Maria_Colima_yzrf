package mx.edu.utez.yzrf_Maria_Colima_CA2.model.inscripcion;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Curso;
import mx.edu.utez.yzrf_Maria_Colima_CA2.model.curso.Estado;

import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreParticipante;

    @Column(nullable = false)
    private int edadParticipante;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private LocalDate fechaInscripcion;

    @Enumerated(EnumType.STRING)
    private EstadoI estado;

    //calificacion

    @Column(nullable = false)
    private Double calificacion;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

}
