package org.sample.com;

/*public class Demo {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;

		try {
			int c = a / b;
			System.out.println("this is try block");
		}

		catch (Exception e) {
			System.out.println("Exception Block:" + e);
		} catch (ArithmeticException ae) {
			System.out.println("dont give denominator as zero:" + ae);
		}catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("Hai:" + ae);
		}
		finally{
		System.out.println("finally Block");
		}
	}
}
*/
/*public class Demo {
	public static void main(String [] args){
		String word = "venkateswarlu";
		char[] arr = word.toCharArray();
		for(int i = arr.length-1; i >= 0; i--){
			System.out.println(arr[i]);
		}
	}
}
*/
/*public class Demo {
	public static void main(String [] args){
		String word = "javaworld";
		String reverse = new StringBuffer(word).reverse().toString();
		System.out.println("before reverse:"+word);
		System.out.println("after reverse:"+reverse);
	}
}
*/
/*public class Demo {
	public static void main(String [] args) {
		String str = "Hello World";
		String anotherString = "hello world";
		Object objStr = str;
		
		System.out.println(str.compareTo(anotherString));
		System.out.println(str.compareToIgnoreCase(anotherString));
		System.out.println(str.compareTo(objStr.toString()));
	}
}
*/
/*public class Demo {
	public static void main(String [] args){
		String s1 = "venky";
		String s2 = "venky";
	    String s3 = new String("Venky123");
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s2 == s3);
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
	}
}
*/
/*public class Demo {
	public static void main(String [] args) {
	long startTime = System.currentTimeMillis();
	for(int i=0;i<50000;i++){
		String s1 = "hello";
		String s2 = "hello";
	}
	long endTime = System.currentTimeMillis();
	System.out.println("time taken for creation of" + "string literals:" +(endTime - startTime) + "millisec");
	long startTime1 = System.currentTimeMillis();
	for(int i=0;i<50000;i++){
		String s3 = new String("hello");
		String s4 = new String("hello");
	}
	long endTime1 = System.currentTimeMillis();
	System.out.println("time taken for creation of"+"string objects:" +(endTime1 - startTime1) + "millisec");
	}
}
*/
/*public class Demo {
	public static void main(String [] args){
		String str = "hello world";
		int index = str.indexOf("world");
		if(index == -1){
			System.out.println("index not found");
		}
		else {
			System.out.println("found hello at index:"+index);
		}
	}
}
*/
/*public class Demo{
	public static void main(String [] args){
		long startTime = System.currentTimeMillis();
		for(int i=0;i<=0;i++){
			String str = "this is" + "testing the" + "defference" + "between" + "string" + "and" + "stringbuffer";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("time taken for string concatination using + operator:" + (endTime - startTime) + "millisec");
		
		long startTime1 = System.currentTimeMillis();
		for(int i=0;i<=50000;i++){
			StringBuffer result = new StringBuffer();
            result.append("this is");
            result.append("testing the");
            result.append("defference");
            result.append("between");
            result.append("string");
            result.append("and");
            result.append("stringBuffer");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("time taken for string concatination using append method:" +(endTime1-startTime1) + "millisec");
	}
}*/

/*public class Demo {
	public static void main(String [] args){
		double d = Math.E;
		System.out.format("%f%n", d);
		System.out.format(Locale.GERMANY, "%-10.4f%n%n", d);
	}
}*/

/*public class Demo {
	public static void main(String [] args) {
		String str = "Hello world, Hello reader";
		int index = str.lastIndexOf("Hello");
		
		if(index == -1){
			System.out.println("index not found");
		}else {
			System.out.println("index of Hello is:" +index);
		}
	}
}*/

/*public class Demo {
	public static void main(String [] args) {
		String str = "this is java";
		System.out.println(removeCharAt(str, 3));
	}
	
	public static String removeCharAt(String s, int pos){
		return s.substring(0, pos) + s.substring(pos + 1);
	}
}*/

/*public class Demo {
	public static void main(String [] args) {
		String str = "Hello World";
		System.out.println(str.replace("H", "W"));
		System.out.println(str.replaceFirst("He", "wa"));
		System.out.println(str.replaceAll("He", "Ha"));
	}
}*/

/*public class Demo {
	public static void main(String [] args) {
		String str = "hello world";
		String upperCase = str.toUpperCase();
		System.out.println("before upperCase:" +str);
		System.out.println("after upperCase:" +upperCase);
	}
}*/

/*public class Demo {
	 
    public static void main(String[] args) {
        int n = 5;
 
        for (int i = n; i >= 0; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }
}*/