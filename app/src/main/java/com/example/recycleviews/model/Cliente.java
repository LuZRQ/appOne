package com.example.recycleviews.model;

public class Cliente {
    private String razonSocial;
    private int nit;

    public Cliente(String razonSocial, int nit) {
        this.razonSocial = razonSocial;
        this.nit = nit;
    }

    //get and set

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
}
