// Paso 2: Definir la implementación de la clase

package interfacesImp; //Agregar el paquete donde este la interfaz remota 

import Interfaces.Operaciones;// Importar la clase Adder para que pueda ser utilizada 

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperacionesImp extends UnicastRemoteObject implements Operaciones{

    public OperacionesImp() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public int suma(int a, int b) throws RemoteException{
        return a+b;
    }

    @Override
    public int resta(int a, int b) throws RemoteException{
        return a-b;
    }

    @Override
    public int multiplicación(int a, int b) throws RemoteException{
        return a*b;
    }

    @Override
    public int divición(int a, int b) throws RemoteException{
        return a/b;
    }

}
