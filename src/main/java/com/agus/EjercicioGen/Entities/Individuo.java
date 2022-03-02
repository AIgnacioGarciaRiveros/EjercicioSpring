package com.agus.EjercicioGen.Entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class Individuo implements InitializingBean {

    private final Logger log = LogManager.getFormatterLogger(this.getClass().getName());

    public List<Gen> getGenes() {
        return genes;
    }

    private final List<Gen> genes = new ArrayList<>();

    @Autowired
    private GenomaHumano genoma;

    @PostConstruct
    public void init() {
    }

    @Override
    public void afterPropertiesSet() {
        log.debug("Agrego los genes al individuo: ");
        genoma.getGenes().forEach(gen -> addGen(gen.getId(),getSequenceNucleotidos(gen.getNucleotidosSize())));
    }


    private void addGen(int id, String nucleotidos) {
        Gen gen = new Gen(id, nucleotidos);
        genes.add(gen);
    }

     private String getSequenceNucleotidos(int sizeNucleotidos){
        String sequenceNucleotidos="";
        String sequenceAvailable="A-C-G-T";
         int j=0;
         List<String> a = Pattern.compile("-").splitAsStream(sequenceAvailable).collect(Collectors.toList());
         log.debug("Generación de  la secuencia de nucleotidos ");
        for (int i=0;i<sizeNucleotidos;i++){
            sequenceNucleotidos=sequenceNucleotidos+a.get(j);
            j++;
            if(j==4)j=0;
        }
        return sequenceNucleotidos;
    }

    public List<Gen> genesIguales(Individuo otroIndividuo) {
        log.debug("Comparacion los genes de los individuos");
        List<Gen> sameGenes = genes.stream()
                                   .filter(otroIndividuo.getGenes()::contains)
                                    .collect(Collectors.toList());
        return sameGenes;
    }

    @PreDestroy
    public void exit() {
    }
}
