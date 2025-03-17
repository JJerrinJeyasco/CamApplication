import java.util.Arrays;
import java.util.Scanner;

public class aascendingorder 
{
    public static void main(String a[])
    {
        Scanner name=new Scanner(System.in);
        System.out.println("the no. of String elements are:");
        int n=name.nextInt();
        name.nextLine();
        
        String[] array=new String[n];
        System.out.println("Enter the String values:");

        for(int i=0;i<n;i++)
        {
            array[i]=name.nextLine();
        }
        Arrays.sort(array);
        System.out.println("array in ascending order:");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
        name.close();
    }    
}
