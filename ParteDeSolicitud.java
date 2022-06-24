package com.company;


public class ParteDeSolicitud extends ParteDeTrabajo {

    private int recargo;

    public ParteDeSolicitud(String descripcionTrabajo, int numeroHorasInvertidas, double costeHora, int recargo) throws ExArgumentoIncorrecto {
        super(descripcionTrabajo, numeroHorasInvertidas, costeHora);
        this.recargo = recargo;
        if ((recargo <= 0) || recargo >= 100)
            throw new ExArgumentoIncorrecto("El descuento tiene que ser mayor que 0 y menor que 100");

    }

    //METODO CALCULACOSTETOTAL
    public double calculaCosteTotal() {

        return getNumeroHorasInvertidas() * (getCosteHora() + (getCosteHora() * (recargo / 100)));

    }

    //METODO GETINFO QUE DEVUELVE LOS ATRIBUTOS DEL PARTE Y EL COSTE TOTAL

    public String getInfo(){
        return "-PARTE:DescripcionTrabajo=" + getDescripcionTrabajo() +
                ", NumeroHorasInvertidas=" + getNumeroHorasInvertidas() +
                ", CosteHora=" + getCosteHora() +
                ", FechaDeCreacion=" + getFechaDeCreacion() +
                ", Recargo="+recargo+
                ", CosteTotal=" + calculaCosteTotal();
    }

    //METODO TOSTRING

    @Override
    public String toString() {
        return "ParteDeTrabajo{" +
                "descripcionTrabajo='" + getDescripcionTrabajo() +
                ", numeroHorasInvertidas=" + getNumeroHorasInvertidas() +
                ", costeHora=" + getCosteHora() +
                ", FechaDeCreacion=" + getFechaDeCreacion() +
                ", Recargo="+recargo+
                '}';
    }
}

