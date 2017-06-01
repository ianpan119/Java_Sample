import java.io.*;

public class WriteCarObject {

  public static void main(String[] argv) throws IOException {

    System.out.println("計算汽車耗油情況的存檔程式");
    System.out.print("請輸入您愛車的油量(公升)→");

    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    double g = java.lang.Double.parseDouble(str);

    System.out.print("請輸入您愛車一公升可跑的公里數→");
    str = br.readLine();
    double eff = java.lang.Double.parseDouble(str);

    // 建立汽車物件
    MyCar Car1 = new MyCar(g,eff);

    ObjectOutputStream oos =            // 建立物件輸出串流物件
      new ObjectOutputStream(new FileOutputStream("mycar"));

    oos.writeObject(Car1);
    oos.flush();
    oos.close();

    System.out.println("已將您的愛車資訊存至檔案 mycar！");
  }
}
