package P3749__Break_A_Code;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		while (true) {
			String command=in.nextLine();
			if (command.equals("ENDOFINPUT")) {
				break;
			}
			String code=in.nextLine();
			for (int i=0;i<code.length();i++) {
				char ch=code.charAt(i);
				if (ch>='A' && ch<='Z') {
					System.out.print((char)((ch-'A'+21)%26+'A'));
				}
				else {
					System.out.print(ch);
				}
			}
			System.out.println();
			in.nextLine();
		}
	}
}
