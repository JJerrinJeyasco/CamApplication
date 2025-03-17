import java.util.Scanner;
public class rectareaandperimtr
{
    public static void main(String []Strings)
    {
        double width;
        double height;
        Scanner in=new Scanner(System.in);
            width=in.nextDouble();
            height=in.nextDouble();
        double area=width*height;
        double perimeter=(width+height)*2;
        System.out.printf("perimeter is 2*(%.1f+%.1f)=%.2f\n",height,width,perimeter);
        System.out.printf("area is %.1f*%.1f=%.2f",width,height,area);
    }
}

