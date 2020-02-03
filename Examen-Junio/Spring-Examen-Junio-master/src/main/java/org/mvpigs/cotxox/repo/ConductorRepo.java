package org.mvpigs.cotxox.repo;

import org.mvpigs.cotxox.domain.Carrera;
import org.mvpigs.cotxox.domain.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConductorRepo extends JpaRepository<Conductor,String> {

    Optional<Conductor> findByTarjeta (String tarjeta);
}
