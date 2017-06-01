import java.io.*;

public class StringRegEx {
	
	public static void main(String[] argv) throws IOException {
		String str; // �O���ݤ����
		String pat; // �O���˦�
		//�������r�ꤺ�e
		str = "Hello";
		pat = "Hello";
		if(str.matches(pat)) {
			System.out.println("�۲�");
		} else {
			System.out.println("���۲�");
		}
		//����X�{���� 
		str = "ac";
		pat = "ab?c";
		if(str.matches(pat)) {
			System.out.println("�۲�");
		} else {
			System.out.println("���۲�");
		}
		//�r������ (Character Classes) 
		str = "Axxx";
		pat = "[a-zA-Z]xxx";
		if(str.matches(pat)) {
			System.out.println("�۲�");
		} else {
			System.out.println("���۲�");
		}
		//�w���w�q�r������(Predefined Character Classes)
		str = "a1a";
		pat = "a\\da";
		if(str.matches(pat)) {
			System.out.println("�۲�");
		} else {
			System.out.println("���۲�");
		}
		//�s�� (Grouping)
		str = "ac1cc2ca";
		pat = "a(c\\dc){2}a";
		if(str.matches(pat)) {
			System.out.println("�۲�");
		} else {
			System.out.println("���۲�");
		}
		
		str = "Hello Kitty Loves Daniel";
		pat = "[lL]oves";
		System.out.println(str.replaceAll(pat, "�R")); //"Hello Kitty �R Daniel"
		
		
	}
}
		
