package ConsoleGame;

import java.util.Random;
import java.util.Scanner;

public class Controller {
	static Scanner sc = new Scanner(System.in);
	static int db = 0;
	static boolean success = false;
	static int limit = 100;
	static int min =0;
	static int max = limit;
	
	
	public int randomNumber() {
		Random rand = new Random();
		
		int randInt=rand.nextInt(limit+1);
		
		return randInt;
	}
	
	public  void readLimit() {
		System.out.println("Kérem a limitet: ");
		
		String lim = sc.nextLine();
		if(check(lim)==true) {
			limit=StoInt(lim);
			max=limit;
		}else {
			readLimit();
		}
		
	}
	
	public  String readTip() {
		System.out.println("Kérem a tippedet: ");
		
		String tip = sc.nextLine();
		return tip;
	}
	
	
	public int dbplus() {
		return db++;
	}
	
	public  boolean check(String s) {
		boolean out = true;
		
		if(s.length()==0) {
			System.out.println("Nem adtál meg adatot! ");
			out=false;
		}
		
		if(out) {
			try {
				Integer.valueOf(s);
			}catch(NumberFormatException nfe) {
				System.out.println("Hibás a beírt adat formátuma!");
				out=false;
			}
		}
		
		return out;
	}
	
	
	public int StoInt(String s) {
		int x = -1;
		try {
			x=Integer.valueOf(s);
		}catch(NumberFormatException nfe) {
			System.out.println("StoInt: "+nfe.getMessage());
		}
		
		return x;
	}
	
	public boolean evaluate(String s, int rndNum) {
		boolean ok = false;
		String mS="";
		int tipp = StoInt(s);
		db++;
		if(rndNum==tipp) {
			mS="Eltaláltad!\nTippek száma: "+db;
			ok = true;
		}
		if(rndNum < tipp) {
			mS="A szám kisebb a tippednél!";
			if(tipp<=max)max=tipp;
		}
		if(rndNum>tipp) {
			mS="A szám nagyobb a tippednél!";
			if(tipp>=min)min=tipp;
		}
		if(tipp >max)mS="A tippelt szám nagyobb, mint a már ismerhetõ legnagyobb érték!";
		if(tipp<min)mS="A tippelt szám kisebb, mint a már ismerhetõ legkiseb érték!";
		if(tipp<0)mS="A tippelt szám kisebb, mint az alsó határ!";
		if(tipp>limit)mS="A tippelt szám nagyobb, mint a felsõ határ!";
		System.out.println(mS);
		return ok;
	}
	
	public void inform() {
		System.out.println("A program generál egy számot 0 és a megadott limit között, ezt kell kitalálni!");
		System.out.println("Tippelj és kapsz egy eredményt róla!");
	}
}
