package com.vitalapi.Repositories;

import com.vitalapi.Entities.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {
    List<Disponibilidad> findByMedicoNumeroDocumento(Long medicoNumeroDocumento);

    @Query("SELECT d FROM Disponibilidad d WHERE d.medico.numeroDocumento = :doc " +
            "AND d.inicioDisponibilidad >= :inicioDia AND d.finDisponibilidad <= :finDia")
    List<Disponibilidad> buscarPorMedicoYFecha(
            @Param("doc") Long documento,
            @Param("inicioDia") LocalDateTime inicioDia,
            @Param("finDia") LocalDateTime finDia
    );
}
