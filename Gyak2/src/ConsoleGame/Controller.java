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
		System.out.println("K�rem a limitet: ");
		
		String lim = sc.nextLine();
		if(check(lim)==true) {
			limit=StoInt(lim);
			max=limit;
		}else {
			readLimit();
		}
		
	}
	
	public  String readTip() {
		System.out.println("K�rem a tippedet: ");
		
		String tip = sc.nextLine();
		return tip;
	}
	
	
	public int dbplus() {
		return db++;
	}
	
	public  boolean check(String s) {
		boolean out = true;
		
		if(s.length()==0) {
			System.out.println("Nem adt�l meg adatot! ");
			out=false;
		}
		
		if(out) {
			try {
				Integer.valueOf(s);
			}catch(NumberFormatException nfe) {
				System.out.println("Hib�s a be�rt adat form�tuma!");
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
			mS="Eltal�ltad!\nTippek sz�ma: "+db;
			ok = true;
		}
		if(rndNum < tipp) {
			mS="A sz�m kisebb a tippedn�l!";
			if(tipp<=max)max=tipp;
		}
		if(rndNum>tipp) {
			mS="A sz�m nagyobb a tippedn�l!";
			if(tipp>=min)min=tipp;
		}
		if(tipp >max)mS="A tippelt sz�m nagyobb, mint a m�r ismerhet� legnagyobb �rt�k!";
		if(tipp<min)mS="A tippelt sz�m kisebb, mint a m�r ismerhet� legkiseb �rt�k!";
		if(tipp<0)mS="A tippelt sz�m kisebb, mint az als� hat�r!";
		if(tipp>limit)mS="A tippelt sz�m nagyobb, mint a fels� hat�r!";
		System.out.println(mS);
		return ok;
	}
	
	public void inform() {
		System.out.println("A program gener�l egy sz�mot 0 �s a megadott limit k�z�tt, ezt kell kital�lni!");
		System.out.println("Tippelj �s kapsz egy eredm�nyt r�la!");
	}
}
