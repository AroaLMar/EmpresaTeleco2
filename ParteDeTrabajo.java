package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParteDeTrabajo implements Comparable<ParteDeTrabajo> {


    //ATRIBUTOS
    private String descripcionTrabajo;
    private int numeroHorasInvertidas;
    private double costeHora;
    private long FechaDeCreacion;


    //CONSTRUCTOR
    public ParteDeTrabajo(String descripcionTrabajo, int numeroHorasInvertidas, double costeHora) throws ExArgumentoIncorrecto {
        this.descripcionTrabajo = descripcionTrabajo;
        if (descripcionTrabajo == null) throw new ExArgumentoIncorrecto("La descripcion no puede ser nula");
        this.numeroHorasInvertidas = numeroHorasInvertidas;
        if (numeroHorasInvertidas < 0)
            throw new ExArgumentoIncorrecto("Las horas invertidas no pueden ser menor que cero");
        this.costeHora = costeHora;
        if (costeHora <= 0.0) throw new ExArgumentoIncorrecto("El precio coste por hora no puede ser menor o igual a cero");
        Date creacion = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        this.setFechaDeCreacion(Long.parseLong(dateFormat.format(creacion)));


    }

    //GETTERS Y SETTERS


    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public int getNumeroHorasInvertidas() {
        return numeroHorasInvertidas;
    }

    public void setNumeroHorasInvertidas(int numeroHorasInvertidas) {
        this.numeroHorasInvertidas = numeroHorasInvertidas;
    }

    public double getCosteHora() {
        return costeHora;
    }

    public void setCosteHora(double costeHora) {
        this.costeHora = costeHora;
    }

    public long getFechaDeCreacion() {
        return FechaDeCreacion;
    }

    public void setFechaDeCreacion(long fechaDeCreacion) {
        FechaDeCreacion = fechaDeCreacion;
    }

    //METODO CALCULACOSTETOTAL

    public double calculaCosteTotal(){
        return numeroHorasInvertidas * costeHora;
    }


    //METODO GETINFO QUE DEVUELVE LOS ATRIBUTOS DEL PARTE Y EL COSTE TOTAL

    public String getInfo(){
        return "-PARTE:DescripcionTrabajo=" + descripcionTrabajo +
                ", NumeroHorasInvertidas=" + numeroHorasInvertidas +
                ", CosteHora=" + costeHora +
                ", FechaDeCreacion=" + FechaDeCreacion +
                ", CosteTotal=" + calculaCosteTotal();
    }


    //METODO COMPARETO PARA ORDENAR POR FECHA DE CREACION
    public int compareTo(ParteDeTrabajo other) {
        if (this.getFechaDeCreacion() > other.getFechaDeCreacion()) return 1;
        if (this.getFechaDeCreacion() < other.getFechaDeCreacion()) return -1;
        return other.getDescripcionTrabajo().compareTo(this.descripcionTrabajo) * (-1);
    }

    //METODO TOSTRING

    @Override
    public String toString() {
        return "ParteDeTrabajo{" +
                "descripcionTrabajo='" + descripcionTrabajo + '\'' +
                ", numeroHorasInvertidas=" + numeroHorasInvertidas +
                ", costeHora=" + costeHora +
                ", FechaDeCreacion=" + FechaDeCreacion +
                '}';
    }
}