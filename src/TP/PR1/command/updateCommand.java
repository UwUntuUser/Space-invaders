package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandParseException;

public class updateCommand extends command{
	
	private final  String helpText="None : Pasa el turno. \n";

	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public command parse(String[] commandWords) throws CommandParseException{
		updateCommand none=null;
		if(commandWords.length==1 && commandWords[0].equalsIgnoreCase("NONE") || commandWords[0].equalsIgnoreCase(" ") || commandWords[0].equalsIgnoreCase(""))
			none=this;
		return none;
	}
	public String helpText()
	{
		return this.helpText;
	}
}
