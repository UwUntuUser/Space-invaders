package TP.PR1.main;
import java.util.Random;
import java.util.Scanner;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.levelEnum;
public class main {

	public static void main(String[] args) {
		String nivel=args[0];
		levelEnum level = null;
		Game game;
		controller controlador;
		Scanner scanner;
		int seed;
		if(nivel.equals("EASY"))
			 {
				level =level.EASY;
				if(args[1]==null)
				{
					Random rand = null;
					seed=rand.nextInt();
				}
				else
					seed=Integer.parseInt(args[1]);
				game=new Game(level, seed);
				scanner=new Scanner(System.in);
				controlador=new controller(game, scanner);
			 }
		else if(nivel.equals("HARD"))
		{
			level = level.HARD;
			if(args[1]==null)
			{
				Random rand = null;
				seed=rand.nextInt();
			}
			else
				seed=Integer.parseInt(args[1]);
			game=new Game(level, seed);
			scanner=new Scanner(System.in);
			controlador=new controller(game, scanner);
		}
		else
		{
			level =level.INSANE;
			if(args[1]==null)
			{
				Random rand = null;
				seed=rand.nextInt();
			}
			else
				seed=Integer.parseInt(args[1]);
			game=new Game(level, seed);
			scanner=new Scanner(System.in);
			controlador=new controller(game, scanner);
		}
		controlador.run();
		
	}

}
