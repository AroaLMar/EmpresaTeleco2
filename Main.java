package com.company;

import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args)  {


            try {
            //CREAMOS UN GESTOR
            Gestor g1=new Gestor("PROG22",new HashMap<>());

            //CREAMOS 2 CLIENTES Y LOS AÑADIMOS
            Cliente cli1=new Cliente("04227G","AROA","C/SOL, 12",new TreeSet<>());
            Cliente cli2=new Cliente("04185H","DAVID","C/TRINIDAD, 36",new TreeSet<>());

            g1.añadirCliente("042276G",cli1);
            g1.añadirCliente("04185H",cli2);

            //CREAMOS LOS PARTES DE TRABAJO Y LOS AÑADIMOS A LOS CLIENTES
            ParteDeTrabajo p1 = new ParteDeTrabajo("Parte Trabajo General FEB", 7, 23.6);
            ParteDeTrabajo p2 = new ParteDeTrabajo("Parte Trabajo General MAY", 23, 12.5);
            ParteDeTrabajo p3 = new ParteDeIncidencia("Parte Trabajo Incidencia ENE", 38, 6.2,  50);
            ParteDeTrabajo p4 = new ParteDeIncidencia("Parte Trabajo Incidencia OCT", 25, 4.2,  40);
            ParteDeTrabajo p5 = new ParteDeSolicitud("Parte Trabajo Solicitud NOV", 11, 27.3,  30);
            ParteDeTrabajo p6 = new ParteDeSolicitud("Parte Trabajo Solicitud AGO", 9, 17.3,  20);
            ParteDeTrabajo p7 = new ParteDeSolicitud("Parte Trabajo General  SEP", 13, 9.2,  15);


            cli1.asignaParte(p1);
            cli1.asignaParte(p3);
            cli1.asignaParte(p5);
            cli2.asignaParte(p2);
            cli2.asignaParte(p4);
            cli2.asignaParte(p6);
            g1.insertarParte("042276G",p7);

            //LISTA LAS FACTURAS POR FECHA DE CREACION
            System.out.println("FACTURAS CLIENTES\n"+g1.obtenerFactura());


            //CALCULA EL COSTE TOTAL DE LA EMPRESA
            System.out.println("COSTE TOTAL EMPRESA => "+g1.getNombreEmpresa()+" = "+g1.calculaCosteTotal()+" Euros");


            } catch (ExArgumentoIncorrecto e) {
                    e.printStackTrace();
            }


    }
}
