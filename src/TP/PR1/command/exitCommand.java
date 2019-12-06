package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandParseException;

public class exitCommand extends command {
	
	private final  String helpText= "Exit : Termina el juego. \n";
	
	public command parse(String[] words)throws CommandParseException
	{
		if(words[0].equalsIgnoreCase("exit") && words.length!=1)
			throw new CommandParseException("\n El comando EXIT solo tiene un parametro\n\n");
		exitCommand exit=null;
		if(words.length==1 && words[0].equalsIgnoreCase("EXIT") || words[0].equalsIgnoreCase("E"))
			return exit=this;
		return exit;
	}

	@Override
	public boolean execute(Game game) {
		boolean ok=false;
		if(game.exit())
			ok=true;
		return ok;
	}
	public String helpText()
	{
		return this.helpText;
	}
}
