package nptel1;

package nptel2;

import nptel1.*;


public class Teacher {

  protected void showMarks() {

    System.out.println("100 Marks");

  }

}

 

public class Student extends Teacher {

  void show() {

    showMarks();

  }

  public static void main(String[] args) {

    Student st1 = new Student();

    st1.show();

  }

}