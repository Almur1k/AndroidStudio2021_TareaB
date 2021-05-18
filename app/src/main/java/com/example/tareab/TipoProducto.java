package com.example.tareab;

import androidx.annotation.NonNull;

public class TipoProducto {
    private String codigoTipoProd;
    private String nombreTipoProd;



    //Sobreescribir método toString para que el adaptador imprima solo lo que le indico aquí, no el "super" de este objeto llamado TipoProducto
    @NonNull
    @Override
    public String toString() {
        return nombreTipoProd;
    }

    public String getCodigoTipoProd() {
        return codigoTipoProd;
    }

    public void setCodigoTipoProd(String codigoTipoProd) {
        this.codigoTipoProd = codigoTipoProd;
    }

    public String getNombreTipoProd() {
        return nombreTipoProd;
    }

    public void setNombreTipoProd(String nombreTipoProd) {
        this.nombreTipoProd = nombreTipoProd;
    }

    public TipoProducto(String codigoTipoProd, String nombreTipoProd) {
        this.codigoTipoProd = codigoTipoProd;
        this.nombreTipoProd = nombreTipoProd;
    }
}
