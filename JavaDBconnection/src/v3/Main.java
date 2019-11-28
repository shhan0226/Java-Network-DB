package v3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Node> list = new ArrayList<Node>();
		
		DB_Control dc = new DB_Control();
		dc.getList(list);

		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getUserID());
		}
				
		
		/*Node n1 = new Node();
		n1.setUserID("1test1");
		n1.setUserIP("2.0.0.0");
		n1.setCpuUse("112");
		n1.setCpuCapa("113");
		n1.setMemUse("114");
		n1.setCpuCapa("115");
		n1.setState("on");
		
		dc.write(n1);*/
		
		dc.delete("2.0.0.0");
		
	}
	
}
