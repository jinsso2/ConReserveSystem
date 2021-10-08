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
			System.out.println(hallName + "���� �ý����Դϴ�.");
			System.out.print("����:1, ��ȸ:2, ���:3, ������:4 >> ");
			int sNum = sc.nextInt();
			if(sNum < 1 || sNum > 4) {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
			else
			{
				switch(sNum) {
				case 1:
					System.out.println("�¼����� S(1), A(2), B(3) >> ");
					int gNum = sc.nextInt();
					seatgroup[gNum - 1].seatReserve();
					break;
				case 2:
					for(int i = 0; i < seatgroup.length; i++) {
						seatgroup[i].showGroup();
					}					
					System.out.println("<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>");
					break;
				case 3:
					System.out.print("�¼� : S:1, A:2, B:3>>");
					int gNum2 = sc.nextInt();
					if(gNum2 < 1 || gNum2 > 3) {
						System.out.println("�߸��� �¼� Ÿ���Դϴ�.");
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
		reserve.reserve("��ǰ�ܼ�ƮȦ ");
	}

}

class SeatGroup {
	private int num;
	private char type;
	private Seat[] seats;	// ���� ����� �¼� ��ü �迭
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
		System.out.print("�̸�>>");
		name = sc.next();
		System.out.print("��ȣ>>");
		num = sc.nextInt();
		if(num < 1 || num >= seats.length) {
			System.out.println("�߸��� �¼���ȣ�Դϴ�.");
			return false;
		}
		if(seats[num - 1].isReserved()) {
			System.out.println("�̹� ����� �¼��Դϴ�.");
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
		System.out.print("�̸�>>");
		String name = sc.next();
		if(name != null) {
			for(int i = 0; i < seats.length; i++) {
				if(seats[i].match(name)) {
					seats[i].cancel();
					return true;
				}
			}
			System.out.println("������ �̸��� ã�� �� �����ϴ�.");
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