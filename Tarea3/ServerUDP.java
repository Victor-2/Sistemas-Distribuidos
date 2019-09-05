/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmb.socketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class ServerUDP {

 
public static void main (String args[]) 
{
    try 
    {
      DatagramSocket socketUDP = new DatagramSocket(5000);
      byte[] bufer = new byte[5];

      while(true) 
      {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion =new DatagramPacket(bufer, bufer.length);
        String cad=new String(peticion.getData());
        //System.out.print("Peticion: "+peticion.getData().toString());
        
        //System.out.println("multiplicando el byte: "+s);
        byte[] aux=new byte[5];
        int i;
        System.out.println("tamaño del buffer: "+cad.length());
        for(i=0;i<cad.length();i++)
        {
            if(cad.charAt(i)>48&&cad.charAt(i)<=57)
            {
                aux[i]=(byte)((cad.charAt(i)-48)*5);
                System.out.println("Variable a: "+aux[i]);
            }
        }
        for(int j=0;j<i;j++)
        {
            System.out.print(aux[j]+" ");
        }
        
        //peticion.setData(aux);
        
        System.out.println("AUX: "+aux);
        
        socketUDP.receive(peticion);

        System.out.print("Datagrama recibido del host: " +peticion.getAddress());
        System.out.println(" desde el puerto remoto: " +peticion.getPort());

        // Construimos el DatagramPacket para enviar la respuesta
        DatagramPacket respuesta=new DatagramPacket(peticion.getData(), peticion.getLength(),peticion.getAddress(), peticion.getPort());
        
        // Enviamos la respuesta, que es un eco
        socketUDP.send(respuesta);
        
        // Leemos una petición del DatagramSocket
        /*
        socketUDP.receive(peticion);

        System.out.print("Datagrama recibido del host: " +peticion.getAddress());
        System.out.println(" desde el puerto remoto: " +peticion.getPort());

        // Construimos el DatagramPacket para enviar la respuesta
        DatagramPacket respuesta=new DatagramPacket(peticion.getData(), peticion.getLength(),peticion.getAddress(), peticion.getPort());
        
        // Enviamos la respuesta, que es un eco
        socketUDP.send(respuesta);
        
      */}

    }catch (SocketException e) 
    {
      System.out.println("Socket: " + e.getMessage());
    }catch (IOException e) 
    {
      System.out.println("IO: " + e.getMessage());
    }
  }
}