package TP.PR1.main;
import java.util.Scanner;
import TP.PR1.Juego.*;
import TP.PR1.command.command;
import TP.PR1.command.commandGenerator;
import TP.PR1.excepciones.*; 

public class controller {
	private Game game;
	private Scanner scanner;
	private  boolean exit=false;
	private GamePrinter printer;
	
	public controller(Game game, Scanner scanner){
		this.game=game;
		this.scanner=scanner;
		this.printer= PrinterType.BOARDPRINTER.getObject(game);
		this.printer.setGame(game);
	}
	
	public void run() { 
		String []ordenes;
		boolean finJuego=false;
		game.infoRonda();
		System.out.println(this.printer);
		System.out.print("!!INTRODUCE UN COMANDO¡¡" + "\n" + "Command->");
		ordenes=scanner.nextLine().trim().split(" ");   
		do {
			try {
				command command = commandGenerator.commandParse(ordenes);
				if(command!=null)
				{
					if (command.execute(game)) 
						{
							game.infoRonda();
							System.out.println(this.printer);
						}
				}
			}
			catch(CommandParseException | CommandExecuteException ex){
				System.out.format(ex.getMessage());
			}
			finJuego=game.finJuego();
			if(!finJuego)
			{
				game.update();
				System.out.print("Introduce un comando" + "\n" + "Command->");
				System.out.println();
				ordenes=scanner.nextLine().trim().split(" "); 
			}	
		}while(!finJuego);
	}
}
