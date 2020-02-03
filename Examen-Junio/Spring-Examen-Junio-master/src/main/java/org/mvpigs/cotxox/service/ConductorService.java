package org.mvpigs.cotxox.service;

import org.mvpigs.cotxox.domain.Conductor;
import org.mvpigs.cotxox.repo.ConductorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepo conductorRepo;

    public ConductorRepo getConductorRepo(){
        return this.conductorRepo;
    }

    public Conductor recuperarConductor(String tarjeta){
        return getConductorRepo().findByTarjeta(tarjeta).get();
    }


    public void CrearConductor(String nombre,String matricula,String modelo){
        Conductor conductor = new Conductor(matricula);
        conductor.setNombre(nombre);
        conductor.setModelo(modelo);
        conductor.setOcupado(false);
        getConductorRepo().save(conductor);

    }

    public void init(){
        String[] nombres = {"Sabrina", "Cici"};
        String[] matriculas = {"2222222222222222", "3333333333333333"};
        String[] modelos = {"Toyota Prius", "Mercedes A"};

        for(int i = 0 ; i< nombres.length ; i++){
            this.CrearConductor(nombres[i],matriculas[i],modelos[i]);
        }
    }

}
