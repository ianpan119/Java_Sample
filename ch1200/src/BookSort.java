import java.util.*;
public class BookSort {
   public static void main(String[] args) {
      Book[] arr = {new Book(101, "Java"),
                    new Book(102, "VB  "), new Book(105, "C#  ") };
      Arrays.sort(arr);                     // �̦۵M���ǱƧ�
      System.out.println("arr :" + Arrays.toString(arr));
      Arrays.sort(arr, new BookByName());       // �̮ѦW�Ƨ�
      System.out.println("arr :" + Arrays.toString(arr));
      
      ArrayList<Book> list = new ArrayList<Book>(Arrays.asList(arr));
      //�ҥ��쥻�{��
      //ArrayList list = new ArrayList(Arrays.asList(arr));
      
      Collections.sort(list);               // �̦۵M���ǱƧ�
      System.out.println("list:" + list);
      Collections.sort(list, new BookByName()); // �̮ѦW�Ƨ�
      System.out.println("list:" + list);
      
      Collections.reverse(list);               // ���බ��
      System.out.println("revs:" + list);
      Collections.sort(list, 
                  Collections.reverseOrder()); // ����۵M����
      System.out.println("rNat:" + list);

      int i = Collections.binarySearch(list,   // �G���j�M
            new Book(101, "Java"), Collections.reverseOrder());
      int j = Collections.binarySearch(list,   // �G���j�M
            new Book(103, "Java"), Collections.reverseOrder());
      System.out.println("Search 101:" + i + ", 103:" + j);
} }

/* ���浲�G:
arr :[101-Java, 102-VB  , 105-C#  ]
arr :[105-C#  , 101-Java, 102-VB  ]
list:[101-Java, 102-VB  , 105-C#  ]
list:[105-C#  , 101-Java, 102-VB  ]
revs:[102-VB  , 101-Java, 105-C#  ]
rNat:[105-C#  , 102-VB  , 101-Java]
Search 101:2, 103:-2
*/

