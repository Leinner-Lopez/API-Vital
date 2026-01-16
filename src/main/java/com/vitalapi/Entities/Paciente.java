package com.vitalapi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Usuario{
    private String seguroMedico;
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
