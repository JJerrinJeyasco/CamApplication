import java.io.DataInputStream;
import java.io.IOException;
class armsornot
{
    public static void main(String args[])
    {
        DataInputStream d=new DataInputStream(System.in);
        int number=0,digits=0;
        String input=null;
        try{
            System.out.print("enter a number:");
            input=d.readLine();
            digits=input.length();
            number=Integer.parseInt(input);
            d.close();
}
catch(IOException e)
{
    e.printStackTrace();
}
if(IsArmstrong(number,digits))System.out.print(number+"is an armstrong number");
else System.out.print(number+"is not an Armstrong number:");
    }
    public static boolean isArmstrong(int n,int digits);
{
    int copy=n,result=0;
    while(n!=0)
    {
        int digit=n%10;
        result+=Math.pow(digit,digits);
        n=n/10;
    }
return copy==result;
}
}
