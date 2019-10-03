package practicadistribuidos;
import java.io.*;
import java.net.*;

public class ServerSocketBancoCliente 
{
    public static void main(String[] args) throws InterruptedException{
        int port =5001; // puerto en el que escuchara el socket
        
        try {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            Socket client;      
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            while(true){   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // el servidorse queda esperando establecer conexion 
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String cadena;
                cadena = fromClient.readLine(); //cadena obtenida desde el lector
                String cadr="";
                if(cadena=="1")
                    cadr="id: 1 || Saldo: 300";
                if(cadena=="2")
                    cadr="id:2 || Saldo: 400";
                if(cadena=="3")
                    cadr="id: 3 || Saldo: 100";
                else
                    cadr="id no identificado 0";
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                System.out.println(cadr+client.getInetAddress());
               
                //imprime cadena recibida desde el cliente
                //Thread.sleep(3000);
                 //for (int i=0;i<=10000000;i++);
                toClient.flush(); // 
                toClient.println("Hola cliente"+cadr);
                
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
