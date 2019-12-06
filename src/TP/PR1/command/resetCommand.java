package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandParseException;

public class resetCommand extends command{
	
	private final  String helpText="Reset : Resetea la partida. \n";
	
	@Override
	public boolean execute(Game game) {
		boolean ok=false;
		if(game.reset(game))
			ok=true;
		return ok;
	}

	@Override
	public command parse(String[] commandWords) throws CommandParseException
	{
		if(commandWords[0].equalsIgnoreCase("reset") && commandWords.length!=1) 
			throw new CommandParseException("\n El comando RESET solo tiene un parametro\n\n");
		command reset=null;
		if(commandWords.length==1 && commandWords[0].equalsIgnoreCase("RESET") || commandWords[0].equalsIgnoreCase("R"))
			reset=this;
		return reset;
	}
	public String helpText()
	{
		return this.helpText;
	}

}
