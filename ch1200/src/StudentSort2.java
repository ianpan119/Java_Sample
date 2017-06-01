import java.util.*;

class SoByName implements Comparator<Student> { // �̩m�W���W�Ƨ�

   public int compare(Student o1, Student o2)
   { return o1.name.compareTo(o2.name); }
   
}
class SoByIdDes implements Comparator<Student> { // �̾Ǹ�����Ƨ�

   public int compare(Student o1, Student o2)
   { return o2.id - o1.id; }
   
}
public class StudentSort2 {
   public static void main(String[] args) {
      TreeSet<Student> t1 = new TreeSet<Student>(new SoByName()); // �̩m�W���W�Ƨ�      
      t1.add(new Student(4502, "���j�F"));
      t1.add(new Student(4503, "²���n"));
      t1.add(new Student(4501, "���p��"));
      System.out.println(t1);
      TreeSet<Student> t2 = new TreeSet<Student>(new SoByIdDes()); // �̾Ǹ�����Ƨ�      
      t2.addAll(t1);
      System.out.println(t2);
  }
}
