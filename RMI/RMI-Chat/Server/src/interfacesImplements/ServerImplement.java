package interfacesImplements;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfaces.Client;
import interfaces.Server;

public class ServerImplement extends UnicastRemoteObject implements Server {
    private ArrayList<String> users;
    private String hostRegitry;

    public ServerImplement(String host) throws RemoteException {
        this.users = new ArrayList<String>();
        this.hostRegitry = host;
    }

    @Override
    public String register(String username) throws RemoteException {
        // Valido que el nombre de usuario no exista
        if (this.users.contains(username))
            return "Username already exists";

        this.users.add(username);
        return "User registered";
    }

    @Override
    public boolean destroy(String username) throws RemoteException {
        return this.users.remove(username);
    }

    @Override
    public void brodcast(String message) throws RemoteException {
        for (int i = 0; i < this.users.size(); i++)
            showMessage(this.users.get(i), message);
    }

    public void showMessage(String username, String message) {
        try {
            Registry registry = LocateRegistry.getRegistry(this.hostRegitry);
            Client instans = (Client) registry.lookup(username);

            // Envia el mensaje al usuario
            instans.showMessage(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
