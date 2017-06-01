import java.util.*;
public class BookSort {
   public static void main(String[] args) {
      Book[] arr = {new Book(101, "Java"),
                    new Book(102, "VB  "), new Book(105, "C#  ") };
      Arrays.sort(arr);                     // 依自然順序排序
      System.out.println("arr :" + Arrays.toString(arr));
      Arrays.sort(arr, new BookByName());       // 依書名排序
      System.out.println("arr :" + Arrays.toString(arr));
      
      ArrayList<Book> list = new ArrayList<Book>(Arrays.asList(arr));
      //課本原本程式
      //ArrayList list = new ArrayList(Arrays.asList(arr));
      
      Collections.sort(list);               // 依自然順序排序
      System.out.println("list:" + list);
      Collections.sort(list, new BookByName()); // 依書名排序
      System.out.println("list:" + list);
      
      Collections.reverse(list);               // 反轉順序
      System.out.println("revs:" + list);
      Collections.sort(list, 
                  Collections.reverseOrder()); // 反轉自然順序
      System.out.println("rNat:" + list);

      int i = Collections.binarySearch(list,   // 二元搜尋
            new Book(101, "Java"), Collections.reverseOrder());
      int j = Collections.binarySearch(list,   // 二元搜尋
            new Book(103, "Java"), Collections.reverseOrder());
      System.out.println("Search 101:" + i + ", 103:" + j);
} }

/* 執行結果:
arr :[101-Java, 102-VB  , 105-C#  ]
arr :[105-C#  , 101-Java, 102-VB  ]
list:[101-Java, 102-VB  , 105-C#  ]
list:[105-C#  , 101-Java, 102-VB  ]
revs:[102-VB  , 101-Java, 105-C#  ]
rNat:[105-C#  , 102-VB  , 101-Java]
Search 101:2, 103:-2
*/

