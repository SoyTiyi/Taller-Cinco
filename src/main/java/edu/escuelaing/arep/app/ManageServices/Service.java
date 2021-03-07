package edu.escuelaing.arep.app.ManageServices;

import edu.escuelaing.arep.app.Persistencia.BaseDeDatos;

public class Service {
    private BaseDeDatos baseDeDatos;

    public Service(){
        baseDeDatos = new BaseDeDatos();
    }

    public String getData(){
        return baseDeDatos.consult();
    }

    public void insert(String message){
        baseDeDatos.insert(message);
    }
}
