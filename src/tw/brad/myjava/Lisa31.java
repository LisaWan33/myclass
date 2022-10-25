package tw.brad.myjava;

import tw.brad.myclass.TWid;

public class Lisa31 { //5

	public static void main(String[] args) {
		String id="K223008800";
		if(TWid.isValidTWid(id)) {
			System.out.println("ok");
		}else {
			System.out.println("x");
			}
		
		
		
		TWid id1=new TWid();
		System.out.printf("ID1: %S  \n",id1.getid());
		
		TWid id2=new TWid(false);
		System.out.printf("ID2: %S  \n",id2.getid());
		
		TWid id3=new TWid(4);
		System.out.printf("ID3: %S  \n",id3.getid());
		
		TWid id4=new TWid(7);
		System.out.printf("ID4: %S  \n",id4.getid());
		}
	}

