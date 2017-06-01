import java.lang.annotation.*;



//Part 1. �`�μзǼе�: @Override(1-1), @Deprecated(1-2), @SuppressWarnings(1-3)
//-------------------------------------------------------------------------//

public class AnnoTest {
	
	@Override			//1-1 �i�DCompiler:�U�C��k�w�q�D �мg(���s�w�q)�q�������O�~�ӤU�Ӫ��ۦP��k
	public String toString(){
		return "AnnoTest";
	}
	
	@Deprecated			//1-2.1 �ŧi md1()��"����ĳ�A�ϥΤF"
	public static void md1(){
		
	}
	
	public static void main(String[] args) {
		
		AnnoTest.md1();	//1-2.2 �����X�{�R���u�D�]md1()�b�w�q�ɳQ�ŧi��@Deprecated
		
		@SuppressWarnings(value={"unused"})
		//1-3 �ϥ�@SuppressWarnings�i���U�C "�ܼƫŧi�᥼�ϥ�" ���sĶ��ĵ�i�T��
			//value��@SuppressWarnings�����n����(element)
			//value��data type���r��}�C,�@��ݨϥ�{}�N�r��ȥ]�_��(�r��ȶ��H,���j); ��}�C���u���@�Ȯ�,{}�i�ٲ�,�p @SuppressWarnings( value="unused" )
		    //�Y�е��u�]�w�Fvalue������,�h"value="�]�i�ٲ�,�p @SuppressWarnings( "unused" )
		
		int v1; //�sĶĵ�i: The value of the local variable v1 is not used	
	
	}
}



//Part 2.�ۭq�е�
//-------------------------------------------------------------------------//

//2-1.1 �w�q��²�檺�е�(�Хܼе� /Marker Annotation)
@interface Anno1{
	
}

//2-2.1 �w�q�㤸��(elements)���е�
@interface Anno2{
	public String md1() default "";   
	public int[] value() default {100,200};
	  
	/* �`�N�ƶ�:
	A. �е����w�q�������ΥH���ϥΪ̳]�w�е����i�@�B��T; �е�����element���ɥ�Q�٬�attribute
	B. �е������i�Ϊ�Data Type�u�� (1)primitive type, (2)String, (3)Class, (4)annotation, (5)enumeration or (6)1-dimensional arrays thereof
	C. default���y�D���n  �B default�Ȥ��inull	
	*/	
}

//2-3.1 �ϥ����Ω�е����O���е�
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE, ElementType.FIELD})
@interface Anno3{	
}

/* Java API �Ѧ�:

(a)�O�d�е�
@Retention(value = RetentionPolicy�C�|���O�w�q���C�|��)  //value�w�]��=RetentionPolicy.CLASS

public enum RetentionPolicy{
	SOURCE,CLASS,RUNTIME;
}

(b)�ؼме�
@Target(value = ElementType[]/�YElementType�C�|���O�w�q���C�|�Ȥ��}�C) //value�w�]��=ElementType���Ҧ��C�|��(TYPE_PARAMETER���~)���}�C

public enum ElementType{
	TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,
	ANNOTATION_TYPE,PACKAGE,TYPE_PARAMETER,TYPE_USE
}
*/


class MyClass {
		
	@Anno1 //2-1.2  �ϥΦۭq �Хܼе�/Marker Annotation
	public void md1(){}
	
	//2-2.2  �ϥΨ㤸��(elements)���е�
	@Anno2(md1="kitty",value={300,400}) 
	public void md2(){}	
	
	//@Anno3 //2-3.2  �ϥιH��@Target����е���,�N���ͽsĶ���~: "The annotation @Anno3 is disallowed for this location"
	public void md3(){}
}


