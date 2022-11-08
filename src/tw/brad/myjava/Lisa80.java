package tw.brad.myjava;

import tw.brad.myclass.BCrypt;

public class Lisa80 {

	public static void main(String[] args) {
		String Hash="$2a$10$OQaECJeu.jk64W6i4Mrmt.DFAWxaZSX7zNiB0dOXjkL9.sMIf.boq";
		String password="123456";
		if(BCrypt.checkpw(password, Hash)) {
			System.out.println("ok");
		}else {
			System.out.println("xx");
		}

	}

}
