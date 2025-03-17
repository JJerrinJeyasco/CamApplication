public class calculation 
{
    public static void sum(int a, int b) 
    {
        System.out.println(a+b);
    }

    public static void sum(int a, int b, int c) 
    {
        System.out.println(a+b+c);
    }

    public static void main(String []args) 
    {
        sum(10, 10, 10);
        sum(20, 20);
    }
}
