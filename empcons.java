import java.util.Scanner;

public class empcons
{
    private int age;
    private String name;
    private double salary;
    private String dept;

    public empcons(int age,String name,double salary,String dept)
    {
        this.age=age;
        this.name=name;
        this.salary=salary;
        this.dept=dept;
    }
    public int getage()
    {
        return age;
    }
    public void setage(int age)
    {
        this.age=age;
    }
    
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name=name;
    }
    
    public double salary()
    {
        return salary;
    }
    public void setsalary(double salary)
    {
        this.salary=salary;
    }
    
    public String getdept()
    {
        return dept;
    }
    public void setdept(String dept)
    {
        this.dept=dept;
    }
    public void displayinfo()
    {
        System.out.println("employee age:"+age);
        System.out.println("employee name:"+name);
        System.out.println("employee dept:"+dept);
        System.out.println("employee salary:"+salary);
    }
    public static void main(String a[])
    {
        Scanner scanner=new Scanner(System.in);
        
            System.out.println("enter the age:");
            int age=scanner.nextInt();
            scanner.nextLine();
        
            System.out.println("enter the name:");
            String name=scanner.nextLine();

            System.out.println("enter the salary:");
            double salary=scanner.nextDouble();
            scanner.nextLine();
        
            System.out.println("enter the dept:");
            String dept=scanner.nextLine();

            empcons emp=new empcons(age,name,salary,dept);
            emp.displayinfo();

            System.out.println("new dept:");
            String newdept=scanner.nextLine();
            emp.setdept(newdept);
                
            
            System.out.println("new salary:");
            double newsalary=scanner.nextDouble();
            emp.setsalary(newsalary);

            System.out.println("Updated value of employee:");
            emp.displayinfo();
            
            scanner.close();
    }
}
    