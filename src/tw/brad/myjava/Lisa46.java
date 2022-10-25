package tw.brad.myjava;

import java.io.File;

public class Lisa46 {

	public static void main(String[] args) {
		/*File.pathSeparator指: 分隔連續多路徑字符串的分隔符
		 * 例如:java   -cp   test.jar;abc.jar   HelloWorld
		 * 就是指“;”
		 * 
		 * File.separator才是用来分隔同一路徑字符串中的目錄
		 * 例如：C:/Program Files/Common Files
		 * C:/Program Files/Common Files
		 * 就是指“/”
		 * ————————————————
		 */
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
	}

}
