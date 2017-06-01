import java.lang.annotation.*;



//Part 1. 常用標準標註: @Override(1-1), @Deprecated(1-2), @SuppressWarnings(1-3)
//-------------------------------------------------------------------------//

public class AnnoTest {
	
	@Override			//1-1 告訴Compiler:下列方法定義乃 覆寫(重新定義)從祖先類別繼承下來的相同方法
	public String toString(){
		return "AnnoTest";
	}
	
	@Deprecated			//1-2.1 宣告 md1()為"不建議再使用了"
	public static void md1(){
		
	}
	
	public static void main(String[] args) {
		
		AnnoTest.md1();	//1-2.2 左式出現刪除線乃因md1()在定義時被宣告為@Deprecated
		
		@SuppressWarnings(value={"unused"})
		//1-3 使用@SuppressWarnings可抑制下列 "變數宣告後未使用" 的編譯器警告訊息
			//value為@SuppressWarnings之必要元素(element)
			//value之data type為字串陣列,一般需使用{}將字串值包起來(字串值間以,間隔); 當陣列中只具單一值時,{}可省略,如 @SuppressWarnings( value="unused" )
		    //若標註只設定了value元素值,則"value="也可省略,如 @SuppressWarnings( "unused" )
		
		int v1; //編譯警告: The value of the local variable v1 is not used	
	
	}
}



//Part 2.自訂標註
//-------------------------------------------------------------------------//

//2-1.1 定義最簡單的標註(標示標註 /Marker Annotation)
@interface Anno1{
	
}

//2-2.1 定義具元素(elements)的標註
@interface Anno2{
	public String md1() default "";   
	public int[] value() default {100,200};
	  
	/* 注意事項:
	A. 標註內定義的元素用以讓使用者設定標註的進一步資訊; 標註內的element有時亦被稱為attribute
	B. 標註元素可用的Data Type只有 (1)primitive type, (2)String, (3)Class, (4)annotation, (5)enumeration or (6)1-dimensional arrays thereof
	C. default片語非必要  且 default值不可null	
	*/	
}

//2-3.1 使用應用於標註型別的標註
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE, ElementType.FIELD})
@interface Anno3{	
}

/* Java API 參考:

(a)保留標註
@Retention(value = RetentionPolicy列舉型別定義之列舉值)  //value預設值=RetentionPolicy.CLASS

public enum RetentionPolicy{
	SOURCE,CLASS,RUNTIME;
}

(b)目標標註
@Target(value = ElementType[]/即ElementType列舉型別定義之列舉值之陣列) //value預設值=ElementType的所有列舉值(TYPE_PARAMETER除外)之陣列

public enum ElementType{
	TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,
	ANNOTATION_TYPE,PACKAGE,TYPE_PARAMETER,TYPE_USE
}
*/


class MyClass {
		
	@Anno1 //2-1.2  使用自訂 標示標註/Marker Annotation
	public void md1(){}
	
	//2-2.2  使用具元素(elements)的標註
	@Anno2(md1="kitty",value={300,400}) 
	public void md2(){}	
	
	//@Anno3 //2-3.2  使用違反@Target限制的標註時,將產生編譯錯誤: "The annotation @Anno3 is disallowed for this location"
	public void md3(){}
}


