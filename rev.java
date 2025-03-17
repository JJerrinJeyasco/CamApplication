import java.util.Scanner;
public class rev 
{
    public static void main(String []a)
    {   
        Scanner name = new Scanner(System.in);
        System.out.println("enter the values to reverse:");
        int number=name.nextInt();
        int reversednum=0;

        while(number!=0)
        {
            int remainder=number%10;
            reversednum=reversednum*10+remainder;
            number/=10;
        }
        System.out.println("the reversed num is:"+reversednum);
        name.close();
    }
    
}
