package ConsoleGame;

public class Game {
	static Controller con = new Controller();
	private static boolean success;
	
	public static void main(String[] args) {
		con.inform();
		con.readLimit();
		int rndNum=con.randomNumber();
		while(!success) {
			String tippS=con.readTip();
			if(con.check(tippS)) {
				success=con.evaluate(tippS, rndNum);
			}else con.dbplus();
		}

	}
	
	
}
