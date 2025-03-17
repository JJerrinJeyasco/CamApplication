import java.lang.System;
import java.util.Scanner;

class heyfly 
{
    public static void main(String args[])
    {
        Scanner scan =new Scanner(System.in);
          System.out.print("enter name:");
        String name=scan.nextLine();
          System.out.print("enter your age:");
        int age=scan.nextInt();
        scan.nextLine();
         System.out.print("enter your place:");
        String place=scan.nextLine();
          System.out.print("enter your regno:");
        String regno=scan.nextLine();
          System.out.print("enter your DOB:");
        String DOB=scan.nextLine();
         System.out.println("givenname "+name);
         System.out.println("  ");
            System.out.println("givenage "+age);
         System.out.println("  ");
         System.out.println("givenplace "+place);
           System.out.println("  ");
          System.out.println("givenregno "+regno);
         System.out.println("  ");
         System.out.println("givenDOB "+DOB);
         }    
}
