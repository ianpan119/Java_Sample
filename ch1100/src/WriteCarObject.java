import java.io.*;

public class WriteCarObject {

  public static void main(String[] argv) throws IOException {

    System.out.println("�p��T���Ӫo���p���s�ɵ{��");
    System.out.print("�п�J�z�R�����o�q(����)��");

    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    double g = java.lang.Double.parseDouble(str);

    System.out.print("�п�J�z�R���@���ɥi�]�������ơ�");
    str = br.readLine();
    double eff = java.lang.Double.parseDouble(str);

    // �إߨT������
    MyCar Car1 = new MyCar(g,eff);

    ObjectOutputStream oos =            // �إߪ����X��y����
      new ObjectOutputStream(new FileOutputStream("mycar"));

    oos.writeObject(Car1);
    oos.flush();
    oos.close();

    System.out.println("�w�N�z���R����T�s���ɮ� mycar�I");
  }
}
