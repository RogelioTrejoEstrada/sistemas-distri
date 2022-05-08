package Interfaces;

import Objects.FiguraObj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Figura extends Remote {
    public FiguraObj nuevaFigura(float L1, float L2, float base, float altura) throws RemoteException;

    public float AreaCuadrado(float L1) throws RemoteException;

    public float PerímetroCuadrado(float L1) throws RemoteException;

    public float AreaRectángulo(float L1, float L2) throws RemoteException;

    public float PerímetroRectángulo(float L1, float L2) throws RemoteException;

    public float AreaTriángulo(float base, float altura) throws RemoteException;

    public float PerímetroTriángulo(float L1, float L2, float base) throws RemoteException;
}
