package com.company;


import java.util.HashMap;
import java.util.Map;



public class Gestor {

    //ATRIBUTOS
    private String nombreEmpresa;
    private HashMap<String,Cliente> clientes;

    //CONSTRUCTOR

    public Gestor(String nombreEmpresa,HashMap<String,Cliente> clientes ) throws ExArgumentoIncorrecto {
        this.nombreEmpresa = nombreEmpresa;
        if (nombreEmpresa == null) throw new ExArgumentoIncorrecto("El nombre del cliente no puede ser nulo");
        this.clientes = new HashMap<>();;
    }

    //GETTERS Y SETTERS


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    //METODO AÑADIR CLIENTE


    public void añadirCliente(String NIF,Cliente cliente) {

        clientes.put(NIF,cliente);


    }

    //INSERTAR PARTES

    public void insertarParte(String NIF,ParteDeTrabajo p) {

        for (Map.Entry entry : clientes.entrySet()) {
            if(NIF==entry.getKey()) {
                Cliente cliente = (Cliente) entry.getValue();
                cliente.asignaParte(p);

            }

        }

    }

    //OBTENER FACTURA QUE DEVUELVE LA INFORMACION DE TODOS LOS PARTES DE TODOS CLIENTE ORDENADO POR FECHA CREACION

    public String obtenerFactura(){

        String result=" ";
        for (Cliente cli : clientes.values()) {

            result+= cli.obtenerFactura()+"\n ";

        }
        return result;

    }

    //CALCULA COSTE TOTAL EMPRESA

    public double calculaCosteTotal() {

        double result = 0.0;

        for (Cliente  cli: clientes.values()) {
            result+=cli.calculaCosteTotal();

        }

        return result;

    }


}
