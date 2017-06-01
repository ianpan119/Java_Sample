import java.util.*;
class Book implements Comparable<Book> {  // �������O
//�ҥ��쥻�{��
//class Book implements Comparable {  // �������O
   int id;        // �Ѹ�
   String name;   // �ѦW
   Book(int id, String name)  
      { this.id = id; this.name = name; }
   public String toString()        // �N���e�ର��Ū���r��
      { return id + "-" + name; }
   public boolean equals(Object o) // ����O�_�۵�
      { return (o instanceof Book) && id ==  ((Book)o).id; }
   public int hashCode()           // �Ǧ^����X
      { return id; } 
   public int compareTo(Book o)  // ���O����������j�p��k
      { return (this.id - o.id); }
   /* �ҥ��쥻�{���X
   public int compareTo(Object o)  // ���O����������j�p��k
   { return (this.id - ((Book)o).id); }*/
}
class BookByName implements Comparator<Book> { // �̮ѦW���W�ƧǪ����O
   public int compare(Book o1, Book o2) 
      { return o1.name.compareTo(o2.name); }
}
/* �ҥ��쥻�{���X
class BookByName implements Comparator { // �̮ѦW���W�ƧǪ����O
	   public int compare(Object o1, Object o2) 
	      { return ((Book)o1).name.compareTo(((Book)o2).name); }
	}
*/