package practicadistribuidos;

import java.rmi.*;
import java.rmi.registry.*;

public class ClientePruebaRMI
{
	public static void main(String args[])
	{
	Operaciones calculadora;
        Operaciones cotizar;
        int numero;
        String cad="";
	try {
            /*
	    calculadora=(Operaciones)Naming.lookup("rmi://localhost/Calculadora");
            numero=6;
	    System.out.println();
	    System.out.println( "   "+numero+"! = "+calculadora.Factorial(numero));
	    System.out.println();
            */
            cotizar=(Operaciones)Naming.lookup("rmi://localhost/cotizacion");
            cad="30-09-19";
            System.out.println("La cotizacion para la fecha: "+cad+" Es: "+cotizar.CotizacionDolar(cad));
	}
	catch (Exception e)
        {
	    e.printStackTrace();
	}
    }
}