package pe.upn.model;

import lombok.Data;
import pe.upn.utils.Auditoria;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "personas")
public class Persona extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String telefono;
    private String correo;
    private boolean estado;

    @PrePersist
    void guardar() {
        estado = true;
    }
}
