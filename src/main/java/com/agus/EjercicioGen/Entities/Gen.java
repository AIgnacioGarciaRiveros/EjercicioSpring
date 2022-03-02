package com.agus.EjercicioGen.Entities;

import java.util.Objects;

public class Gen {

    private int id;

    private String nucleotidos;

    public Gen(int id, String nucleotidos) {
        this.id = id;
        this.nucleotidos = nucleotidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNucleotidos() {
        return nucleotidos;
    }

    public void setNucleotidos(String nucleotidos) {
        this.nucleotidos = nucleotidos;
    }

    public int getNucleotidosSize() {
        return nucleotidos.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gen gen = (Gen) o;
        return id == gen.id && Objects.equals(nucleotidos, gen.nucleotidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nucleotidos);
    }

    @Override
    public String toString() {
        return "Gen Id= "+id+" , "+"Gen Nucleotidos= "+nucleotidos;
    }
}
