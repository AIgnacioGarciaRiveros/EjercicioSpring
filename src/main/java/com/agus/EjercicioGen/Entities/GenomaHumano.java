package com.agus.EjercicioGen.Entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GenomaHumano {

    private final List<Gen> genes = new ArrayList<>();

    private final Logger log = LogManager.getFormatterLogger(this.getClass().getName());

    public GenomaHumano() {
        for(int i=0;i<50;i++) addGen(i);
        log.debug("Creacion 50 mil instancias de gen");
    }

    public void addGen(int id){
        Gen gen = new Gen(id, getRandomLength(5,10));
        genes.add(gen);
        log.debug("Asignacion longitud de los nucleotidos y id al Gen");
    }

    public String getRandomLength(int min, int max) {
        int randomLength = new Random().nextInt(max - min) + min;
        String randomWord =   Stream.generate(() -> "a")
                                     .limit(randomLength)
                                     .collect(Collectors.joining());
        return randomWord;
    }

        public List<Gen> getGenes() {
        return genes;
    }



}
