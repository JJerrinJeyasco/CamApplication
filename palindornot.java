import java.io.DataInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;

class palindornot 
{
    public static void main(String args[])
    {
        DataInputStream d=new DataInputStream(System.in);
        String str=null;
        try
        {
            System.out.print("enter a string:");
            str=d.readLine();
            d.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        if(ispalindrome(str))
        {
            System.out.print("the string is palindrome:");
        }
        else
        {
            System.out.print("the string is not a palindrome:");
        }
        }
        public static boolean ispalindrome(String str)
        {
            int left=0;
            int right=str.length()-1;
            while(left<right)
            {
                if(str.charAt(left)!=str.charAt(right))
                {
                    return false;
                }
                left++;
                right--;

            }
            return true;
        }
        }
        

    

