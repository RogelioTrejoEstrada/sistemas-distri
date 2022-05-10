package interfacesImplements;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfaces.Server;
import models.UserMessage;

public class ServerImplement extends UnicastRemoteObject implements Server {
    private ArrayList<String> users;
    private ArrayList<UserMessage> messages;

    public ServerImplement() throws RemoteException {
        this.users = new ArrayList<String>();
        this.messages = new ArrayList<UserMessage>();
    }

    @Override
    public boolean register(String username) throws RemoteException {
        // Agrego el usuario si no esta registrado en la aplicación
        return !this.users.contains(username) && this.users.add(username);
    }

    @Override
    public boolean destroy(String username) throws RemoteException {
        return this.users.remove(username);
    }

    @Override
    public ArrayList<UserMessage> brodcast(UserMessage message) throws RemoteException {
        return this.messages;
    }
}
