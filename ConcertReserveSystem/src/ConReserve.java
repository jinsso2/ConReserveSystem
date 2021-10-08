import java.util.Scanner;
public class ConReserve {
	private String hallName;
	private SeatGroup[] seatgroup = new SeatGroup[3];
	private Scanner sc = new Scanner(System.in);
	
	public String reserve(String hallName) {	
		this.hallName = hallName;
		seatgroup[0] = new SeatGroup('S', 10);
		seatgroup[1] = new SeatGroup('A', 10);
		seatgroup[2] = new SeatGroup('B', 10);
		
		int bool = 1;
		 while(bool == 1) {
			System.out.println(hallName + "예약 시스텝입니다.");
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
			int sNum = sc.nextInt();
			if(sNum < 1 || sNum > 4) {
				System.out.println("잘못된 입력입니다.");
			}
			else
			{
				switch(sNum) {
				case 1:
					System.out.println("좌석구분 S(1), A(2), B(3) >> ");
					int gNum = sc.nextInt();
					seatgroup[gNum - 1].seatReserve();
					break;
				case 2:
					for(int i = 0; i < seatgroup.length; i++) {
						seatgroup[i].showGroup();
					}					
					System.out.println("<<조회를 완료하였습니다.>>");
					break;
				case 3:
					System.out.print("좌석 : S:1, A:2, B:3>>");
					int gNum2 = sc.nextInt();
					if(gNum2 < 1 || gNum2 > 3) {
						System.out.println("잘못된 좌석 타입입니다.");
					}
					seatgroup[gNum2 - 1].cancel();
				case 4:
					bool++;
					break;
				}			
			}
		}
		return hallName;
	}
	public static void main(String[] args) {
		ConReserve reserve = new ConReserve();
		reserve.reserve("명품콘서트홀 ");
	}

}

class SeatGroup {
	private int num;
	private char type;
	private Seat[] seats;	// 현재 등급의 좌석 객체 배열
	private Scanner sc = new Scanner(System.in);
	
	public SeatGroup(char type, int num) {
		this.type = type;
		seats = new Seat[num];
		for(int i = 0; i < seats.length; i++)
			seats[i] = new Seat();
	}
	
	public boolean seatReserve() {
		int num;
		String name;
		showGroup();
		System.out.print("이름>>");
		name = sc.next();
		System.out.print("번호>>");
		num = sc.nextInt();
		if(num < 1 || num >= seats.length) {
			System.out.println("잘못된 좌석번호입니다.");
			return false;
		}
		if(seats[num - 1].isReserved()) {
			System.out.println("이미 예약된 좌석입니다.");
			return false;
		}
		seats[num - 1].setSeat(name);
		return true;
	}
	
	public void showGroup() {
		System.out.print(type + ">> ");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isReserved()) {
				System.out.print(seats[i].getName());
			}
			else
				System.out.print("--- ");
		}
		System.out.println();
	}
	
	public boolean cancel() {
		showGroup();
		System.out.print("이름>>");
		String name = sc.next();
		if(name != null) {
			for(int i = 0; i < seats.length; i++) {
				if(seats[i].match(name)) {
					seats[i].cancel();
					return true;
				}
			}
			System.out.println("예약자 이름을 찾을 수 없습니다.");
		}
		return false;
	}
}

class Seat {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void cancel() {
		name = null;
	}
	public void setSeat(String name) {
		this.name = name;
	}
	
	public boolean isReserved() {
		if(name == null) return false;
		else return true;
	}
	
	public boolean match(String name) {
		return(name.equals(this.name));
	}
}