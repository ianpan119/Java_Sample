import java.io.*;

public class StringRegEx {
	
	public static void main(String[] argv) throws IOException {
		String str; // 癘魁ゑ癸戈
		String pat; // 癘魁妓Α
		//钡ゑ癸﹃ず甧
		str = "Hello";
		pat = "Hello";
		if(str.matches(pat)) {
			System.out.println("才");
		} else {
			System.out.println("ぃ才");
		}
		//瞷Ω计 
		str = "ac";
		pat = "ab?c";
		if(str.matches(pat)) {
			System.out.println("才");
		} else {
			System.out.println("ぃ才");
		}
		//じ贺摸 (Character Classes) 
		str = "Axxx";
		pat = "[a-zA-Z]xxx";
		if(str.matches(pat)) {
			System.out.println("才");
		} else {
			System.out.println("ぃ才");
		}
		//箇﹚竡じ贺摸(Predefined Character Classes)
		str = "a1a";
		pat = "a\\da";
		if(str.matches(pat)) {
			System.out.println("才");
		} else {
			System.out.println("ぃ才");
		}
		//竤舱 (Grouping)
		str = "ac1cc2ca";
		pat = "a(c\\dc){2}a";
		if(str.matches(pat)) {
			System.out.println("才");
		} else {
			System.out.println("ぃ才");
		}
		
		str = "Hello Kitty Loves Daniel";
		pat = "[lL]oves";
		System.out.println(str.replaceAll(pat, "稲")); //"Hello Kitty 稲 Daniel"
		
		
	}
}
		
