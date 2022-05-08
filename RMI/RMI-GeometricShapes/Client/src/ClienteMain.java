import interfacesImp.ClienteImp;

public class ClienteMain{

    public static void main(String[] args) {
        ClienteImp cliente = new ClienteImp();
        cliente.connectServer();
    }
}
