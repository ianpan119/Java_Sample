import java.util.*;

public class StudentSort1 {
   public static void main(String[] args) {
      TreeSet<Student> ts = new TreeSet<Student>();
      
      ts.add(new Student(4502, "陳大東"));
      ts.add(new Student(4503, "簡中南"));
      ts.add(new Student(4501, "王小明"));
      System.out.println(ts);
  }
}
