class Student implements Comparable<Student> {
   int id;       // �Ǹ�
   String name;  // �m�W
   Student(int id, String name) 
      { this.id = id; this.name = name; }
   public String toString()
      { return id + "-" + name; }
   public int compareTo(Student o)
   { return (this.id - o.id); }   
}
