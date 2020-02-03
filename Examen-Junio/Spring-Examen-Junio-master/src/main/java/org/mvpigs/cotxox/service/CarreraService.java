package org.mvpigs.cotxox.service;

import org.mvpigs.cotxox.domain.Carrera;
import org.mvpigs.cotxox.repo.CarreraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepo carreraRepo;

    public CarreraRepo getCarreraRepo(){
        return this.carreraRepo;
    }


    public Long crearCarrera(String tarjeta, String origen, String destino, int distancia, int tiempo) {
        Carrera carrera = new Carrera(tarjeta);

        carrera.setOrigen(origen);
        carrera.setDestino(destino);
        carrera.setDistancia(distancia);
        carrera.setTiempoEsperado(tiempo);
        getCarreraRepo().save(carrera);
        return getCarreraRepo().findByTarjetaCredito(tarjeta).get().getId();

    }

    public Carrera recuperaCarrera(Long id){
       return getCarreraRepo().findById(id).get();
    }
}
