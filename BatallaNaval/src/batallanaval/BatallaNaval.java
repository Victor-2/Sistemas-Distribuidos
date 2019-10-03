/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batallanaval;

/**
 *
 * @author AsusX542U
 */
import java.util.*;
public class BatallaNaval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner en=new Scanner(System.in);
        Guerrita obj=new Guerrita();
        int fichas[][]=new int[26][2];
        int fichas2[][]=new int [26][2];
        int TurnoPonerfichas=(int)(Math.random()*(2-1+1)+1);
        System.out.println("Pone Ficha el Jugador: "+TurnoPonerfichas);
            if(TurnoPonerfichas==1)
            {
                for(int i=0;i<26;i++)
                {
                    for(int j=0;j<2;j++)
                        fichas[i][j]=en.nextInt();
                }
                obj.PonerFichas(1, fichas);
                
            }
            else
            {
                for(int i=0;i<26;i++)
                {
                    for(int j=0;j<2;j++)
                        fichas2[i][j]=en.nextInt();
                }
                obj.PonerFichas(2, fichas2);
            }
        int salida=0;
        int TurnoDisparo=(int)(Math.random()*(2-1+1)+1);
        System.out.println("Juega el Jugador: "+TurnoDisparo);
        int x,y;
        while(salida==0)
        {   
            if(TurnoDisparo==1)
            {
                System.out.println("introduzca una posicion para disparar en el jugador 2");
                x=en.nextInt();
                y=en.nextInt();
                int disp=obj.Disparar(1, x-1, y-1);
                while(disp==3);
                {
                    System.out.println("introduzca una posicion para disparar en el jugador 2");
                    x=en.nextInt();
                    y=en.nextInt();
                    disp=obj.Disparar(1, x-1, y-1);
                    if(disp!=3)
                        TurnoDisparo=2;
                }
            }
            else
            {
                System.out.println("introduzca una posicion para disparar en el jugador 1");
                x=en.nextInt();
                y=en.nextInt();
                int disp=obj.Disparar(2, x-1, y-1);
                while(disp==3);
                {
                    System.out.println("introduzca una posicion para disparar en el jugador 1");
                    x=en.nextInt();
                    y=en.nextInt();
                    disp=obj.Disparar(2, x-1, y-1);
                    if(disp!=3)
                        TurnoDisparo=1;
                }
                
            }
                
            
            break;
        }
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<2;j++)
                fichas[i][j]=en.nextInt();
        }
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<2;j++)
                System.out.print(fichas[i][j]+" ");
                System.out.println();
        }
        
        
        //obj.Disparar(2, 4, 5);
    }
}
