import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfacesImp.FigurasImp;

public class ServerRMI_test {
    public static void main(String[]arg){
        try{
            FigurasImp figurasImp= new FigurasImp();

            Registry registry = LocateRegistry.createRegistry(9090);
            registry.rebind("Figuras", figurasImp);

            System.out.println("Servidor corriendo");
        }catch(RemoteException e){
         System.out.println(e.getMessage());

        }


    }
    
}
