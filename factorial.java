import java.io.DataInputStream;
import java.io.IOException;

class factorial 
{
    public static void main(String args[])
    {
        DataInputStream obj=new DataInputStream(System.in);
        int number=0;
        try
        {
            System.out.print("enter a number:");
            number=Integer.parseInt(obj.readLine());
            obj.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.print("factorial of"+number+"is"+factorial(number));
        }
        public static int factorial(int num)
        {
            if(num==0) return 1;
            return num*factorial(num-1);
        }
    }
