package edu.pucmm.srmi;

import edu.pucmm.srmi.servicios.ServidorRMI;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Proyecto Demo RMI");
        new ServidorRMI().iniciarServidor();
    }
}
