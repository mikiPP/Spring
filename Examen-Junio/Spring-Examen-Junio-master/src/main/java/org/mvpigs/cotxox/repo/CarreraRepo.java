package org.mvpigs.cotxox.repo;

import org.mvpigs.cotxox.domain.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarreraRepo extends JpaRepository<Carrera,Long> {

    Optional<Carrera> findByTarjetaCredito(String tarjetaCredito);

    Optional<Carrera> findById(Long id);
}
