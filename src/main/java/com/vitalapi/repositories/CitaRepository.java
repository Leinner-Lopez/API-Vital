package com.vitalapi.repositories;

import com.vitalapi.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByDocumentoPaciente(Long numeroDocumento);
    List<Cita> findByDocumentoMedico(Long numeroDocumento);
}
