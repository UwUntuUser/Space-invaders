package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.PrinterType;
import TP.PR1.excepciones.CommandExecuteException;
import TP.PR1.excepciones.CommandParseException;

public class ListPrintersCommand extends command{
	
	private final String helpText= "ListPrintersCommand : Muestra posibles formas de representar el juego \n";
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		String s=PrinterType.printerHelp(game);
		System.out.println(s);
		return true;
	}

	@Override
	public command parse(String[] commandWords) throws CommandParseException {
		ListPrintersCommand lpc=null;
		if(commandWords.length>3) throw new CommandParseException("Error en los parametros de LIST PRINTER COMMANDS\n");
		else
		{
			if(commandWords[0].equalsIgnoreCase("ListPrinterCommands") || commandWords[0].equalsIgnoreCase("LPC"))	
				lpc=this;
		}
		return lpc;
	}

	@Override
	public String helpText() {
		return this.helpText;
	}

}
