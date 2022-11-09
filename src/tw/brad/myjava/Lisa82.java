package tw.brad.myjava;

public class Lisa82 {

	public static void main(String[] args) {
		Lisa821 obj=new Lisa821();
		obj.m1(1);
	}

}



class Lisa821{
	void m1(int a) { //在方法內，可以用finally使用，return碰到會繼續做，所以後面end其實就沒有意義了。
		try {
			if(a<0) {
				throw new Exception();
				//return;
			}
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println("xx");
			return;
		}finally {
			System.out.println("finally");
		}
		System.out.println("end");
	}
}