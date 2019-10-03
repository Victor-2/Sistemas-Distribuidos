package practicadistribuidos;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class RMIBancoCentral extends UnicastRemoteObject implements Operaciones
{
	RMIBancoCentral() throws java.rmi.RemoteException
	{
            super();
        }
    
	public long Factorial(long a) 
	{
		if (a==0 || a==1) 
		{
                    return 1;
		}
		else 
		{
                    return a*Factorial(a-1);
		}
        }
        public float CotizacionDolar(String Do)
        {
            if(Do.compareTo("26-09-19")==0)
                return (float) 6.90;
            if(Do.compareTo("27-09-19")==0)
                return (float) 6.91;
            if(Do.compareTo("28-09-19")==0)
                return (float) 6.93;
            if(Do.compareTo("29-09-19")==0)
                return (float) 6.92;
            if(Do.compareTo("30-09-19")==0)
                return (float) 6.96;
            else
                return 0;
        }        
    public static void main(String args[]) 
    { 
	try 
	{
            /*
	    RMIBancoCentral calculadora;
	    LocateRegistry.createRegistry(1099);
	    calculadora=new RMIBancoCentral(); 
	    Naming.bind("Calculadora", calculadora); 
            System.out.println("El servidor esta listo\n");
            */
            RMIBancoCentral cotizacion;
	    LocateRegistry.createRegistry(1099);
	    cotizacion=new RMIBancoCentral(); 
	    Naming.bind("cotizacion", cotizacion); 
            System.out.println("El servidor esta listo\n");
              
        }
	catch (Exception e)
        {
            e.printStackTrace();
	}
   } 
}