package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    /**
     * Registra un nuevo usuario en el servidor
     * 
     * @param username Nombre de usuario
     * @return
     * @throws RemoteException
     */
    public String register(String username) throws RemoteException;

    /**
     * Difunde el mensaje a todas las personas conectadas
     * 
     * @param message Mensaje a difundir
     * @throws RemoteException
     */
    public void brodcast(String message) throws RemoteException;

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
