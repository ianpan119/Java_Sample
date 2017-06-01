import java.util.*;
class Book implements Comparable<Book> {  // 書藉類別
//課本原本程式
//class Book implements Comparable {  // 書藉類別
   int id;        // 書號
   String name;   // 書名
   Book(int id, String name)  
      { this.id = id; this.name = name; }
   public String toString()        // 將內容轉為易讀的字串
      { return id + "-" + name; }
   public boolean equals(Object o) // 比較是否相等
      { return (o instanceof Book) && id ==  ((Book)o).id; }
   public int hashCode()           // 傳回雜湊碼
      { return id; } 
   public int compareTo(Book o)  // 類別本身的比較大小方法
      { return (this.id - o.id); }
   /* 課本原本程式碼
   public int compareTo(Object o)  // 類別本身的比較大小方法
   { return (this.id - ((Book)o).id); }*/
}
class BookByName implements Comparator<Book> { // 依書名遞增排序的類別
   public int compare(Book o1, Book o2) 
      { return o1.name.compareTo(o2.name); }
}
/* 課本原本程式碼
class BookByName implements Comparator { // 依書名遞增排序的類別
	   public int compare(Object o1, Object o2) 
	      { return ((Book)o1).name.compareTo(((Book)o2).name); }
	}
*/