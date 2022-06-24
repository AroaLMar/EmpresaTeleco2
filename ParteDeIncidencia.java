package com.company;

public class ParteDeIncidencia extends ParteDeTrabajo {

    private int descuento;

    public ParteDeIncidencia(String descripcionTrabajo, int numeroHorasInvertidas, double costeHora, int descuento) throws ExArgumentoIncorrecto {
        super(descripcionTrabajo, numeroHorasInvertidas, costeHora);
        this.descuento = descuento;
        if ((descuento <= 0) || descuento >= 100)
            throw new ExArgumentoIncorrecto("El descuento tiene que ser mayor que 0 y menor que 100");
    }


    //METODO CALCULACOSTETOTAL
    public double calculaCosteTotal() {

        return getNumeroHorasInvertidas() * (getCosteHora() - (getCosteHora() * (descuento / 100)));

    }

    //METODO GETINFO QUE DEVUELVE LOS ATRIBUTOS DEL PARTE Y EL COSTE TOTAL

    public String getInfo(){
        return "-PARTE:DescripcionTrabajo=" + getDescripcionTrabajo() +
                ", NumeroHorasInvertidas=" + getNumeroHorasInvertidas() +
                ", CosteHora=" + getCosteHora() +
                ", FechaDeCreacion=" + getFechaDeCreacion() +
                ", Descuento="+descuento+
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
                ", Descuento="+descuento+
                '}';
    }
}
