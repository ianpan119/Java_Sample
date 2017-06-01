import java.util.*;
import java.util.function.Consumer;

public class ForEachInt {

  public static void main(String args[]) {

    // �n�� <Integer> �y�k�Х� TreeSet ���X�O�ΨӦs���ƪ���
    TreeSet<Integer> IntTS = new TreeSet<Integer>();

    for (int i=1;i<=100;i++) // �N 1 �� 100 ���Ʀr�[�춰�X��
      IntTS.add(i);
    
    System.out.print("1��100 �� 9 �����Ʀ��G");

    for (Integer i:IntTS)    // �� IntTS �����C�Ӥ��� i ���j��B�z
      if (i%9 == 0)          // ���� i �Y��Q 9 �㰣
        System.out.print(i + " ");    
    
    
    //---------------------------------------------------//
    //Java8 Iterable<T>.forEach( Consumer<? super T> )     								
    System.out.print("\n1��100 �� 9 �����Ʀ��G");
    IntTS.forEach(new Consumer<Integer>(){
    	public void accept(Integer i){
    		if(i%9==0)
    			System.out.print(i + " ");
    	}
    });    
    //�W��forEach���޼�(�ΦW����)��g�� Java8 Lambda Expression
    IntTS.forEach( (i)-> {if(i%9==0) System.out.print(i + " "); } );
    
    
    //---------------------------------------------------//
    //�t�@�Өϥ�Lambda Expression���N�ΦW���󤧽d��
    new Thread( new Runnable(){
    	public void run(){
    		System.out.println("\nHello world...");
    	}
    } ).start();
    			
    new Thread( ()->{ System.out.println("Hello java..."); } ).start();
    //---------------------------------------------------//
    
  }
}
