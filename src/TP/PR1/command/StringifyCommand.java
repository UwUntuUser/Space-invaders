package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.GamePrinter;
import TP.PR1.Juego.PrinterType;
//import TP.PR1.Juego.PrinterType;
import TP.PR1.excepciones.*;

public class StringifyCommand extends command{

	private final String helpText="Stringifier : Muestra el juego en formato de texto plano\n";
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		GamePrinter printer= PrinterType.STRINGIFIER.getObject(game);
		printer.setGame(game);
		System.out.println(printer);
		return false;
	}

	@Override
	public command parse(String[] commandWords) throws CommandParseException 
	{
		if(commandWords[0].equalsIgnoreCase("z") && commandWords.length!=1) throw new CommandParseException("\n El comando HELP solo tiene un parametro\n\n");
		StringifyCommand s=null;
		if(commandWords[0].equalsIgnoreCase("STRINGIFIER") || commandWords[0].equalsIgnoreCase("Z"))
			s=new StringifyCommand();
		return s;
	}

	@Override
	public String helpText() {
		return this.helpText;
	}

}
