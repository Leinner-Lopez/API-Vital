package com.vitalapi.Repositories;

import com.vitalapi.Entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    boolean existsByNumeroDocumento(Long numeroDocumento);

    List<Medico> findByEspecialidadIgnoreCase(String especialidad);
}
