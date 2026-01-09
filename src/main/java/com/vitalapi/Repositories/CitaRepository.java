package com.vitalapi.Repositories;

import com.vitalapi.Entities.Cita;
import com.vitalapi.Enums.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByPacienteNumeroDocumento(Long numeroDocumento);
    List<Cita> findByMedicoNumeroDocumentoAndEstado(Long numeroDocumento, EstadoCita estado);
}
