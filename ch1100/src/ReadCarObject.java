import java.io.*;

public class ReadCarObject {

  public static void main(String[] argv)
                throws IOException, ClassNotFoundException {
    System.out.println("�p��T���Ӫo���p��Ū�ɵ{��");

    ObjectInputStream ois =                 // �إߪ����J��y
      new ObjectInputStream(new FileInputStream("mycar"));
    MyCar Car1 = (MyCar) ois.readObject();  // Ū�J�T������
    ois.close();                            // ������y

    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));

    do {
      System.out.print("\n�z�{�b�Q�}�h��(����)��");
      String str = br.readLine();
      double m = Double.parseDouble(str);

      try {
        Car1.go(m);
        System.out.print("�}�F " + m + " ������, ");
        System.out.println("�ٳ� " + Car1.checkGas() + " ���ɪ��o�C");
      }
      catch (NoGasException e) {
        System.out.println("�o�q�����I");
      }
    } while (Car1.checkGas()>=0);
  }
}
