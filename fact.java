import java.util.Scanner;

public class fact 
    {
    public static void main(String []a)
        {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the number:");
            int number=scanner.nextInt();


            long factorial=1;
            for(int i=1;i<=number;i++)
            {
                factorial*=i;
            }
            System.out.println("the factorial of"+number+"is"+factorial);
            scanner.close();
        }
    
}
