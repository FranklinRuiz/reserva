package pe.upn.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditoria<U> {

    @CreatedBy
    @JsonIgnore
    @Column(updatable = false)
    private U usuarioReg;

    @CreatedDate
    @JsonIgnore
    @Column(updatable = false)
    private Date fechaReg;


    @LastModifiedBy
    @JsonIgnore
    private U usuarioAct;

    @LastModifiedDate
    @JsonIgnore
    private Date fechaAct;

}
