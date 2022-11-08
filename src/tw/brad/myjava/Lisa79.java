package tw.brad.myjava;

import tw.brad.myclass.BCrypt;

public class Lisa79 {

	public static void main(String[] args) {
		String password="123456";
		String passwordHash=BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println(passwordHash);
		System.out.println(passwordHash.length());
	}

}
