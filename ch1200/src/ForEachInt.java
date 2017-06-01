import java.util.*;
import java.util.function.Consumer;

public class ForEachInt {

  public static void main(String args[]) {

    // 要用 <Integer> 語法標示 TreeSet 集合是用來存放整數物件
    TreeSet<Integer> IntTS = new TreeSet<Integer>();

    for (int i=1;i<=100;i++) // 將 1 到 100 的數字加到集合中
      IntTS.add(i);
    
    System.out.print("1～100 中 9 的倍數有：");

    for (Integer i:IntTS)    // 對 IntTS 中的每個元素 i 做迴圈處理
      if (i%9 == 0)          // 元素 i 若能被 9 整除
        System.out.print(i + " ");    
    
    
    //---------------------------------------------------//
    //Java8 Iterable<T>.forEach( Consumer<? super T> )     								
    System.out.print("\n1～100 中 9 的倍數有：");
    IntTS.forEach(new Consumer<Integer>(){
    	public void accept(Integer i){
    		if(i%9==0)
    			System.out.print(i + " ");
    	}
    });    
    //上式forEach之引數(匿名物件)改寫成 Java8 Lambda Expression
    IntTS.forEach( (i)-> {if(i%9==0) System.out.print(i + " "); } );
    
    
    //---------------------------------------------------//
    //另一個使用Lambda Expression取代匿名物件之範例
    new Thread( new Runnable(){
    	public void run(){
    		System.out.println("\nHello world...");
    	}
    } ).start();
    			
    new Thread( ()->{ System.out.println("Hello java..."); } ).start();
    //---------------------------------------------------//
    
  }
}
