package practicadistribuidos;

import java.rmi.*;

public interface Operaciones extends Remote 
{
    long Factorial(long arg) throws RemoteException; 
    float CotizacionDolar(String j) throws RemoteException;
 
}
