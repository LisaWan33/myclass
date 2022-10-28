package tw.brad.myjava;

public class Lisa77 { //DIR_:位置
	private static final int DIR_STOP=0;
	private static final int DIR_LEFT=1;
	private static final int DIR_RIGHT=2;
	private static final int DIR_UP=3;
	private static final int DIR_DOWN=4;
	
	
	public static void main(String[] args) {
		int dir=DIR_STOP;
		dir=DIR_LEFT;
		dir=123; //要注意小心，不可以搞混，若是替代的話=>>> 所以可以用下方列舉的方式，就會被限制
		
		Dir dir2=Dir.STOP;
		dir2=Dir.LEFT;
		System.out.println(dir2);
		System.out.println(dir2.getV());
		
		switch(dir2) {
		case STOP:break;
		case UP:break;
		case DOWN:break;
		case LEFT:break;
		case RIGHT:break;
		
		}
		
	}
}
//列舉:把東西講出來有哪些 //想列舉的項目直接寫
enum Dir{
	STOP(0),UP(1),DOWN(2),LEFT(3),RIGHT(4);
	private int v;
	Dir(int v){
		this.v=v;
	}
	int getV() {return v;}
}
