// TestRMIServer_2

// Suma, resta, multiplicacion y divicion:  metodos
// Area y perimetro: objeto con dos metodos, serialisable
// Chat

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfacesImp.OperacionesImp;

public class ServerRMI_test {
    public static void main(String[]arg){
        try{
            OperacionesImp operacionesImp= new OperacionesImp();
            Registry registry = LocateRegistry.createRegistry(9090);
            registry.rebind("Operaciones", operacionesImp);
            System.out.println("Servidor corriendo");
        }catch(RemoteException e){
         System.out.println(e.getMessage());

        }


    }
    
}
