import java.util.Scanner;
public class ConReserve {

	public void reserve() {	
		SitGroup sitgroup = new SitGroup();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("명품콘서트홀 예약 시스텝입니다.");
		System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
		
		int sNum = sc.nextInt();
		switch(sNum) {
		case 1:
			System.out.println("좌석구분 S(1), A(2), B(3) >> ");
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