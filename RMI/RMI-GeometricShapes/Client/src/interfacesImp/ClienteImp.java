package interfacesImp;

import Interfaces.Figura;
import Objects.FiguraObj;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

public class ClienteImp {
    public void connectServer() {
        try {
            Scanner entrada = new Scanner(System.in);

            FiguraObj figura;

            float opción, lado1, lado2, base, altura = 0;

            Registry registro = LocateRegistry.getRegistry(9090);


            Figura interfaz = (Figura) registro.lookup("Figuras");
         

            System.out.print("Elija una figura para calcular su área y su perímetro: \n" + "1.- Cuadrado = 1\n"
                    + "2.- Rectángulo = 2\n" + "3.- Triángulo = 3\n" + "Opción: ");
            opción = entrada.nextInt();

            if (opción < 1 || opción > 3) {
                System.out.println("No existe esa opción");
                System.exit(0);
            }

            if (opción == 1) {
                System.out.print("\nColoque el valor de sus lados en cm: ");
                lado1 = entrada.nextFloat();
            
                figura = (FiguraObj) interfaz.nuevaFigura(lado1, 0,0,0);
                
                System.out.println("\nEl resultado del área es: " + interfaz.AreaCuadrado(figura.getL1())+" cm^2");
                System.out.println("El resultado del perímetro es: " + interfaz.PerímetroCuadrado(figura.getL1())+" cm");
            }
            if (opción == 2) {
                System.out.print("\nColoque el valor de la base en cm: ");
                lado1 = entrada.nextFloat();
                System.out.print("Coloque el valor de la altura en cm: ");
                lado2 = entrada.nextFloat();

                figura = (FiguraObj) interfaz.nuevaFigura(lado1, lado2,0,0);

                System.out.println("\nEl resultado del área es: " + interfaz.AreaRectángulo(figura.getL1(), figura.getL2())+" cm^2");
                System.out.println("El resultado del perímetro es: " + interfaz.PerímetroRectángulo(figura.getL1(), figura.getL2())+" cm");
            }
            if (opción == 3) {
                System.out.print("\nColoque el valor del primer lado en cm: ");
                lado1 = entrada.nextFloat();
                System.out.print("Coloque el valor del segundo lado en cm: ");
                lado2 = entrada.nextFloat();
                System.out.print("Coloque el valor de la base en cm: ");
                base = entrada.nextFloat();
                System.out.print("Coloque el valor de la altura en cm: ");
                altura = entrada.nextFloat();

                figura = (FiguraObj) interfaz.nuevaFigura(lado1, lado2,base,altura);
                System.out.println("\nEl resultado del área es: " + interfaz.AreaTriángulo(figura.getBase(), figura.getAltura())+" cm^2");
                System.out.println("El resultado del perímetro es: " + interfaz.PerímetroTriángulo(figura.getL1(), figura.getL2(),figura.getBase())+" cm");
            }

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
