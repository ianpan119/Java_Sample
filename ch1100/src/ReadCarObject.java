import java.io.*;

public class ReadCarObject {

  public static void main(String[] argv)
                throws IOException, ClassNotFoundException {
    System.out.println("計算汽車耗油情況的讀檔程式");

    ObjectInputStream ois =                 // 建立物件輸入串流
      new ObjectInputStream(new FileInputStream("mycar"));
    MyCar Car1 = (MyCar) ois.readObject();  // 讀入汽車物件
    ois.close();                            // 關閉串流

    BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));

    do {
      System.out.print("\n您現在想開多遠(公里)→");
      String str = br.readLine();
      double m = Double.parseDouble(str);

      try {
        Car1.go(m);
        System.out.print("開了 " + m + " 公里後, ");
        System.out.println("還剩 " + Car1.checkGas() + " 公升的油。");
      }
      catch (NoGasException e) {
        System.out.println("油量不夠！");
      }
    } while (Car1.checkGas()>=0);
  }
}
