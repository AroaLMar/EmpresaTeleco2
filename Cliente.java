package com.company;

import java.util.*;

public class Cliente {


    //ATRIBUTOS

    private String NIF;
    private String nombre;
    private String direccion;
    private TreeSet<ParteDeTrabajo> partes;

    //CONSTRUCTOR

    public Cliente(String NIF,String nombre, String direccion, TreeSet<ParteDeTrabajo> partes) throws ExArgumentoIncorrecto {

        this.NIF=NIF;
        if(NIF==null)throw new ExArgumentoIncorrecto("El DNI  no puede ser nulo");
        this.nombre = nombre;
        if(nombre==null)throw new ExArgumentoIncorrecto("El nombre  no puede ser nulo");
        this.direccion = direccion;
        if(direccion==null)throw new ExArgumentoIncorrecto("La direccion no puede ser nula");
        this.partes = new TreeSet<>();

    }

    //GETTERS Y SETTERS


    public String getNIF() {
        return NIF;
    }

    public void setDNI(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TreeSet<ParteDeTrabajo> getPartes() {
        return partes;
    }

    public void setPartes(TreeSet<ParteDeTrabajo> partes) {
        this.partes = partes;
    }


    //MÉTODO ASIGNA PARTE

    public void asignaParte(ParteDeTrabajo p){
       partes.add(p);

    }

    //METODO QUE CALCULA EL COSTE TOTAL DE TODOS LOS PARTES DE UN CLIENTE

    public double calculaCosteTotal(){

            double resultado=0.0;

            for (ParteDeTrabajo parte : partes) {
                resultado+= parte.calculaCosteTotal();
            }
            return resultado;
        }


    //OBTENER FACTURA QUE DEVUELVE LA INFORMACION DE TODOS LOS PARTES DE UN CLIENTE ORDENADO POR FECHA CREACION

    public String obtenerFactura(){

            String result=" ";
            for (ParteDeTrabajo parte : partes) {
                result+="Cliente " +getNombre()+"//"+parte.toString()+"\n  ";

            }
            return result;

    }

    @Override
    public String toString() {
        return "CLIENTE{" +
                "NIF='" + NIF + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ",PARTES:" + partes+
                '}';
    }
}



