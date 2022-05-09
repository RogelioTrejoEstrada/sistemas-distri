package interfacesImp;

import Interfaces.Figura;
import Objects.FiguraObj;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FigurasImp extends UnicastRemoteObject implements Figura {

    public FigurasImp() throws RemoteException{
        super();
    }

    @Override
    public FiguraObj nuevaFigura(float L1, float L2, float base, float altura) throws RemoteException {
        return new FiguraObj(L1,L2,base,altura);
    }

    @Override
    public float AreaCuadrado(float L1){
        return L1*L1;
    }

    @Override
    public float PerímetroCuadrado(float L1){
        return 4*L1;
    }

    @Override
    public float AreaRectángulo(float L1, float L2){
        return L1*L2;
    }

    @Override
    public float PerímetroRectángulo(float L1, float L2){
        return (2*L1)+(2*L2);
    }

    @Override
    public float AreaTriángulo(float base, float altura){
        return (base*altura)/2;
    }

    @Override
    public float PerímetroTriángulo(float L1, float L2, float base){
        return L1+L2+base;
    }


}
