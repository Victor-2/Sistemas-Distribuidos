package batallanaval;
import java.util.Random;
public class Guerrita 
{
    int [][] Tablero1=new int[10][10];
    int [][] Tablero2=new int[10][10];
    public void IniciarPartida()
    {
        System.out.println("Partida Iniciada.");
    }
    public void PonerFichas(int J,int M[][])
    {
        int x=0;
        int y=0;
        if(J==1)
        {
            for(int i=0;i<26;i++)
            {
                    x=M[i][0];
                    y=M[i][1];
                    Tablero1[x][y]=1;
                    System.out.println("X: "+x+" Y: "+y);
            }
        }
        else
        {
            for(int i=0;i<26;i++)
            {
                    x=M[i][0];
                    y=M[i][1];
                    Tablero2[x][y]=1;
                    System.out.println("X: "+x+" Y: "+y);
            }
        }
        MostrarTerreno(1);
        MostrarTerreno(2);
    }
    public int Disparar(int J,int x, int y)
    {
        int resultadoDisparo=0;
        if(J==1)
        {
            if(Tablero2[x][y]==1)
            {    
                resultadoDisparo=3;
                Tablero2[x][y]=5;
            }
                
        }
        if(J==2)
        {
            if(Tablero1[x][y]==1)
            {
                resultadoDisparo=3;
                Tablero1[x][y]=4;
            }
        }
        MostrarTerreno(1);
        MostrarTerreno(2);
        return resultadoDisparo;
    }
    void MostrarTerreno(int N)
    {
        if(N==2)
        {   
            System.out.println("TABLERO 2");
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                    System.out.print(Tablero2[i][j]+" ");
                    System.out.println();
            }
        }
        else
        {  
            System.out.println("TABLERO 1");
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                    System.out.print(Tablero1[i][j]+" ");
                    System.out.println();
            }
        
        }    
    }
}
