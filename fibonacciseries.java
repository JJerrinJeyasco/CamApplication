import java.io.DataInputStream;
import java.io.IOException;
class fibonacciseries 
{
    public static void main(String args[])
    {
     DataInputStream d=new DataInputStream(System.in);
     int number=0;
     try{
        System.out.print("enter a number:");
        number=Integer.parseInt(d.readLine());
        d.close();
        }
        catch(IOException e)
        {
        e.printStackTrace();    
        }   
        System.out.print("Fibonacci series up to"+number+"terms:");
        for(int i=0;i<number;i++)
        {
         System.out.print(fibonacci(i)+"");   
        }
    }
    public static int fibonacci(int n)
    {
        if(n<=1)
        {
         return n;   
        }
    return fibonacci(n-1)+fibonacci(n-2);
    }
}

