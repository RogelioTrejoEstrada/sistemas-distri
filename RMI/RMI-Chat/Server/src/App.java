import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfacesImplements.ServerImplement;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Defino el puerto de la aplicación
            int PORT = 3000;

            ServerImplement server = new ServerImplement();

            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("Chat", server);

            System.out.println("Server on port " + PORT);
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}
