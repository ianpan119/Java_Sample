import java.io.*;
import java.util.*;

public class WordsGameHS {

  public static void main(String args[]) throws IOException {

    System.out.println("��r���s�C��, ���i�έ��ƪ���");

    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
    System.out.print("�п�J�Ĥ@�ӵ��G");
    String str = br.readLine();

    HashSet<String> words = new HashSet<String>();
    
    while (true) {
      if (!words.add(str)) {
        System.out.println("���ѡI�o�ӵ��w�ιL");
        break;
      }
      System.out.print("�п�J�U�@�ӵ��G");
      str = br.readLine();
    }

    System.out.println("\n�H�U�O��J�L�����G");
    System.out.println(words);
  }
}
