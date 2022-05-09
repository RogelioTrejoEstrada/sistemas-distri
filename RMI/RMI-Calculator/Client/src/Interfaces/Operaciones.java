// Paso 1: Crear la interfaz remota

package Interfaces; //Agregar el paquete donde este la interfaz remota 

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Operaciones extends Remote {
    public int suma (int a, int b) throws RemoteException;

    public int resta (int a, int b) throws RemoteException;

    public int multiplicación (int a, int b) throws RemoteException;

    public int divición (int a, int b) throws RemoteException;
}