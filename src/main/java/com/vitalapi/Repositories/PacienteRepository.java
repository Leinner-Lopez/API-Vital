package com.vitalapi.Repositories;

import com.vitalapi.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsByNumeroDocumento(Long numeroDocumento);
}
