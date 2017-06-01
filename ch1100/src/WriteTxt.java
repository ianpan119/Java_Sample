import java.io.*;

public class WriteTxt {

  public static void main(String args[]) throws IOException {

    String filename = "aaa.txt";           // ���o�ɦW�r��
    FileWriter fw = new FileWriter(filename);  // �إ� FileWriter ����
    
    String str = "Hello World";
    fw.write(str,0,str.length());      // �g�J��r�r��
    //fw.write(str);  //��i
    fw.write('\n');                    // �g�J����r��

    str = "12345";
    fw.write(str,0,str.length());      // �g�J��Ʀr��
    //fw.write(str);  //��i
    fw.write('\n');                    // �g�J����r��

    str = "345.678";
    fw.write(str,0,str.length());       // �g�J�B�I�Ʀr��
    //fw.write(str);  //��i

    fw.flush();         // �Y���|���g�J�����e, �ߧY�����g�J��y��
    fw.close();         // ���� FileWriter ��y����

    FileReader fr = new FileReader(filename);  // �إ� FileReader ����
    int ch;
    while ((ch=fr.read()) != -1)    // �bŪ�� -1 ���e, ����Ū��
      System.out.print((char)ch);   // �����NŪ�쪺��r��X
    fr.close();
  }
}
