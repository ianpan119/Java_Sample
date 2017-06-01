import java.util.*;

class SoByName implements Comparator<Student> { // 依姓名遞增排序

   public int compare(Student o1, Student o2)
   { return o1.name.compareTo(o2.name); }
   
}
class SoByIdDes implements Comparator<Student> { // 依學號遞減排序

   public int compare(Student o1, Student o2)
   { return o2.id - o1.id; }
   
}
public class StudentSort2 {
   public static void main(String[] args) {
      TreeSet<Student> t1 = new TreeSet<Student>(new SoByName()); // 依姓名遞增排序      
      t1.add(new Student(4502, "陳大東"));
      t1.add(new Student(4503, "簡中南"));
      t1.add(new Student(4501, "王小明"));
      System.out.println(t1);
      TreeSet<Student> t2 = new TreeSet<Student>(new SoByIdDes()); // 依學號遞減排序      
      t2.addAll(t1);
      System.out.println(t2);
  }
}
