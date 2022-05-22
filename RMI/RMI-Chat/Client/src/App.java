import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.Server;
import models.UserMessage;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Variables globales
            Scanner scanner = new Scanner(System.in);
            int PORT = 3000;
            String END_SERVER = "END";
            String IP = "192.168.100.154";

            // Genero la conexion con el servidor
            Registry resgister = LocateRegistry.getRegistry(IP, PORT);

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
            String input = "";
            do {
                // Muestro los valores
                System.out.println("Que desea Hacer: ");
                System.out.println("  (1)  -   Enviar Mensaje");
                System.out.println("  (2)  -   Ver  Mensajes");
                System.out.println(" (END) -   Acabar Chat");

                // Leo la entrada del usuario
                input = scanner.nextLine();

                // Valido que desea hacer el cliente
                if (input.equalsIgnoreCase("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    // Solicito el Mensaje
                    System.out.print("Ingrese el mensaje: ");
                    String messageText = scanner.nextLine();

                    // Envio el mensaje
                    server.sendMessage(new UserMessage(username, messageText));

                } else if (input.equalsIgnoreCase("2")) {
                    // Limpio la consola
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    // Obtengo los mensajes
                    ArrayList<UserMessage> messages = server.getMessages();
                    System.out.println("-----------------------------------------------------");
                    messages.forEach(message -> System.out.println("[" + message.username + "] - " + message.message));
                    System.out.println("-----------------------------------------------------");
                }

            } while (!input.equalsIgnoreCase(END_SERVER));
            // Termino el scanner y termino la session del chat
            scanner.close();
            if (server.destroy(username))
                System.out.println("Session Acabada!");

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}
