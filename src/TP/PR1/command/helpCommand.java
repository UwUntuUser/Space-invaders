package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandParseException;

public class helpCommand extends command {

	private final String helpText= "Help : Muestra los posibles comandos. \n";
	
	
	@Override
	public boolean execute(Game game) {
		System.out.println(commandGenerator.CommandHelp()+ "\n");
		return true;
	}

	@Override
	public command parse(String[] words) throws CommandParseException
	{
		if(words[0].equalsIgnoreCase("help") && words.length!=1) 
			throw new CommandParseException("\n El comando HELP solo tiene un parametro\n\n");
		helpCommand help=null;
		if(words.length==1 && words[0].equalsIgnoreCase("help") || words[0].equalsIgnoreCase("H"))
			return help=this;
		return help;
	}

	@Override
	public String helpText() {
		return this.helpText;
	}
}
