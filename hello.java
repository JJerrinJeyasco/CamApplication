public class hello
{
    static void checkage(int age)
    {
        if(age<18)
        {
            throw new ArithmeticException("Access denied you must be 18 years old");
        }
        else
        {
            System.out.println("Access granted-u r a big boy");
        }
    }
    public static void main(String []a)
    {
        checkage(15);
    }
}