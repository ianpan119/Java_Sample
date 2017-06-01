import java.io.*;
import java.util.*;

public class WordsGameLHS {

  public static void main(String args[]) throws IOException {

    System.out.println("��r���s�C��, ���i�έ��ƪ���");

    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
    System.out.print("�п�J�Ĥ@�ӵ��G");
    String str = br.readLine();

    LinkedHashSet<String> words = new LinkedHashSet<String>();
    
    while (true) {
      if (!words.add(str)) {
        System.out.println("���ѡI�o�ӵ��w�ιL");
        break;
      }
      System.out.print("�п�J�U�@�ӵ��G");
      str = br.readLine();
    }

    System.out.println("\n�H�U�O��J�L�����G");
    String[] all=new String[words.size()];
    words.toArray(all);   // �� toArray() ��k�N���X�ন�r��}�C
    for (int i=0;i<all.length;i++)
      System.out.println((i+1) + "�G" + all[i]);
  }
}
