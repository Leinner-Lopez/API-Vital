package com.vitalapi.Repositories;

import com.vitalapi.Entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    boolean existsByNumeroDocumento(Long numeroDocumento);
}
