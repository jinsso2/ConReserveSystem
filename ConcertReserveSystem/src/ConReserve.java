import java.util.Scanner;
public class ConReserve {

	public void reserve() {	
		SitGroup sitgroup = new SitGroup();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("��ǰ�ܼ�ƮȦ ���� �ý����Դϴ�.");
		System.out.print("����:1, ��ȸ:2, ���:3, ������:4 >> ");
		
		int sNum = sc.nextInt();
		switch(sNum) {
		case 1:
			System.out.println("�¼����� S(1), A(2), B(3) >> ");
			int gNum = sc.nextInt();
			sitgroup.setGroup(gNum);
		}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConReserve reserve = new ConReserve();
		reserve.reserve();
		sc.close();
	}

}


class SitGroup {
	private int num;
	Sit sit = new Sit();
	
	public void setGroup(int num) {
		switch(num){
		case 1: 
			System.out.print("S>> ");
			sit.showSit();
			System.out.print("\n");
			
		}
		
	}
}

class Sit {
	private String[] name = {"---", "---", "---", "---", "---", "---", "---", "---", "---", "---", "---"};
	
	public void showSit() {
		for(int i = 0; i < name.length; i++) {
			System.out.print(name[i] + " ");
		}
	}
}