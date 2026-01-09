package com.vitalapi.Repositories;

import com.vitalapi.Entities.Cita;
import com.vitalapi.Enums.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    //Encontrar Citas con el número de Documento del Paciente
    List<Cita> findByPacienteNumeroDocumento(Long numeroDocumento);

    //Encontrar Citas con el número de Documento del Médico filtrando por el estado de la Cita
    List<Cita> findByMedicoNumeroDocumentoAndEstado(Long numeroDocumento, EstadoCita estado);

    //Encontrar Citas con el número de Documento del Médico que estén en medio de las fechas
    List<Cita> findByMedicoNumeroDocumentoAndFechaCitaBetween(Long numeroDocumento, LocalDateTime inicioDia, LocalDateTime finDia);
}
