import java.util.Scanner;

class employee
{
    private String name;
    private int age;
    private String department;
    private double salary;

    public employee(String name,int age,String department,double salary)
    {
      this.name=name;
      this.age=age;
      this.department=department;
      this.salary=salary;
    }
    public void displayinfo()
    {
      System.out.println("Employer info");
      System.out.println("name:"+name);
      System.out.println("age:"+age);
      System.out.println("department:"+department);
      System.out.println("salary: $"+salary);
    }
}
public class EmployeeData
{
  public static void main(String a[])
  {
      Scanner scanner=new Scanner(System.in);

      System.out.println("enter the name: ");
      String name=scanner.nextLine();
      
      System.out.println("enter the age: ");
      int age=scanner.nextInt();
      scanner.nextLine();
      
      System.out.println("enter the department: ");
      String department=scanner.nextLine();
      
      System.out.println("enter the salary: ");
      double salary=scanner.nextDouble();
      
      employee employ = new employee(name,age,department,salary);
        employ.displayinfo();
      
      scanner.close();
  }
}    

