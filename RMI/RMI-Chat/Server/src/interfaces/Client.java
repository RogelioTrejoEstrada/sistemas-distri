package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
    /**
     * Muestra el mensaje enviado
     * 
     * @param message Mensaje a mostrar
     * @throws RemoteException
     */
    public void showMessage(String message) throws RemoteException;
}
