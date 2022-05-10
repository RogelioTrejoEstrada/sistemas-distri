import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import interfaces.Server;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Variables globales
            Scanner scanner = new Scanner(System.in);
            int PORT = 3000;
            String END_SERVER = "END";

            // Genero la conexion con el servidor
            Registry resgister = LocateRegistry.getRegistry(PORT);

            // Obtengo los metodos del servidor
            Server server = (Server) resgister.lookup("Chat");

            // Registro al usuario
            System.out.println("Registre el nombre de Usuario: ");
            String username = scanner.nextLine();

            // Valido el usuario
            while (!server.register(username)) {
                System.out.println("El nombre de usuario es registrado, ingrese uno nuevo: ");
                username = scanner.nextLine();
            }

            // Comienza el chat
            String message = "";
            do {
                // Muestro los valores
                System.out.println("Que desea Hacer: ");
                System.out.println("  (1)  -   Enviar Mensaje");
                System.out.println("  (2)  -   Ver  Mensajes");
                System.out.println(" (END) -   Acabar Chat");

                // Leo la entrada del usuario
                String entrada = scanner.nextLine();

            } while (END_SERVER.equalsIgnoreCase(message));
            // Termino el scanner y termino la session del chat
            scanner.close();
            if (server.destroy(username))
                System.out.println("Session Acabada!");

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}
