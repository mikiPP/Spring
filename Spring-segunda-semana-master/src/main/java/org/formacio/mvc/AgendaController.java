package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Controller
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @RequestMapping(value = "/nombre")
    @ResponseBody
    public String totalDeContractes() {
        return agendaService.nombreContactes();
    }

    @RequestMapping(value = "/telefon")
    @ResponseBody
    public String obtenirTelefonPerID(@RequestParam(name=id) String id) {
        return agendaService.recupera(id).getTelefon();
    }

    @RequestMapping(value = "/contacte/{id}")
    @ResponseBody
    public Persona obtenirContactePerID(@PathVariable String id) throws Exception {

        Persona contacte = agendaService.recupera(id);

        if (contacte != null) {
            return contacte;
        } else {
            Exception contacteNoTrobat = new Exception();
            throw contacteNoTrobat;
        }
    }

    @RequestMapping(value = "/afegir",method = RequestMethod.POST)
    @ResponseBody
    public String afegirUsuari(@RequestParam( required = true) String id,@RequestParam(required = true) String nom,@RequestParam(required = true) String telefon){
        agendaService.inserta(id,nom,telefon);
        return "S'ha insertat l'usuari";
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "El contacte no existeix") //crea la resposta error 404
    @ExceptionHandler()
    public void error(Exception contacteNoTrobat){

    }

}
