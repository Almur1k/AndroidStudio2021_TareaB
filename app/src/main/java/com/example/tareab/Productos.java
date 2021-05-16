package com.example.tareab;

public class Productos {
    private Integer IdProd;
    private String nombreProd;
    private String tipoProd;
    private String estadoProd;

    public Integer getIdProd() {
        return IdProd;
    }

    public void setIdProd(Integer idProd) {
        IdProd = idProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public String getEstadoProd() {
        return estadoProd;
    }

    public void setEstadoProd(String estadoProd) {
        this.estadoProd = estadoProd;
    }

    public Productos(Integer idProd, String nombreProd, String tipoProd, String estadoProd) {
        IdProd = idProd;
        this.nombreProd = nombreProd;
        this.tipoProd = tipoProd;
        this.estadoProd = estadoProd;
    }
}
