import java.io.*;
import java.util.*;

public class WordsGameHS {

  public static void main(String args[]) throws IOException {

    System.out.println("文字接龍遊戲, 不可用重複的詞");

    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
    System.out.print("請輸入第一個詞：");
    String str = br.readLine();

    HashSet<String> words = new HashSet<String>();
    
    while (true) {
      if (!words.add(str)) {
        System.out.println("失敗！這個詞已用過");
        break;
      }
      System.out.print("請輸入下一個詞：");
      str = br.readLine();
    }

    System.out.println("\n以下是輸入過的詞：");
    System.out.println(words);
  }
}
