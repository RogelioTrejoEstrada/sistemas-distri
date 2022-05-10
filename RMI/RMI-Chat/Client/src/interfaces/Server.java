package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import models.UserMessage;

public interface Server extends Remote {
    /**
     * Registra un nuevo usuario en el servidor
     * 
     * @param username Nombre de usuario
     * @return
     * @throws RemoteException
     */
    public boolean register(String username) throws RemoteException;

    /**
     * Difunde el mensaje a todas las personas conectadas
     * 
     * @param message Mensaje a difundir
     * @throws RemoteException
     */
    public ArrayList<UserMessage> brodcast(UserMessage message) throws RemoteException;

    /**
     * Desconecta al usuario del servidor
     * 
     * @param username Nombre de usuario
     * @return true si el usuario se desconectó correctamente, false en caso
     *         contrario
     * @throws RemoteException
     */
    public boolean destroy(String username) throws RemoteException;

}
