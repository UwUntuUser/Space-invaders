package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandExecuteException;
import TP.PR1.excepciones.CommandParseException;

public abstract class command {
	protected final String nombre=null;
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	public abstract command parse(String[] commandWords) throws CommandParseException;
	public abstract String helpText();
}
