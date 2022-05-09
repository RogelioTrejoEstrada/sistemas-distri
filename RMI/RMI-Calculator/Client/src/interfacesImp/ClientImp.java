package interfacesImp;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interfaces.Operaciones;

import java.util.Scanner;

public class ClientImp {
    public void ConnectorServer() {

        try {
            Scanner entrada = new Scanner(System.in);

            int opción,n1,n2,Suma,Resta,Multiplicación,Divición=0;
            
            Registry registry = LocateRegistry.getRegistry(9090);

            Operaciones op = (Operaciones) registry.lookup("Operaciones");
            


            System.out.print("Elija una opción: \n"+"1.- Calcular suma = 1\n"+"2.- Calcular resta = 2\n"+"3.- Calcular multiplicación = 3\n"+"4.- Calcular divición = 4 \n"+"Opción: ");
            opción = entrada.nextInt();

            if(opción>4||opción<1){
                System.out.println("No existe esa opción");
                System.exit(0);
            }

            System.out.println("\n");

            System.out.print("Ingrese el primer número: ");
            n1 = entrada.nextInt();

            System.out.print("Ingrese el segundo número: ");
            n2 = entrada.nextInt();
            
            System.out.println("\n");

            if(opción==1){
                Suma = op.suma(n1, n2);
                System.out.print("Respuesta: "+Suma);

            }else if(opción==2){
                Resta = op.resta(n1, n2);
                System.out.print("Respuesta: "+Resta);
                
            }else if(opción==3){
                Multiplicación = op.multiplicación(n1, n2);
                System.out.print("Respuesta: "+Multiplicación);

            }else if(opción==4){
                Divición = op.divición(n1, n2);
                System.out.print("Respuesta: "+Divición);
            }



        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();

        }

    }
}
