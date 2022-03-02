package com.agus.EjercicioGen.Controller;

import com.agus.EjercicioGen.Entities.Gen;
import com.agus.EjercicioGen.Entities.Individuo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompareGenController {

    @Autowired
    public Individuo firstIndividual;

    @Autowired
    public Individuo secondIndividual;

    @RequestMapping(value = "/compareGen", method = RequestMethod.GET, produces="application/json")
    public List<Gen> compareIndividuals(){
        List<Gen> equalGenes= firstIndividual.genesIguales(secondIndividual);
        return equalGenes;
    }

}
