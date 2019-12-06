package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandExecuteException;
import TP.PR1.excepciones.CommandParseException;

public class ShootSuperMisilCommand extends command{

	private static final String HelpText="Dispara un super misil que hace 2 de daño";
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(!game.tieneSuperMisil())
			throw new CommandExecuteException("No dispones de super misiles :(\n\n");
		else
			game.shootSuperMisil();
		return true;
	}

	@Override
	// EL PARSE LO HACE EL SHOOT COMMAND
	public  command parse(String[] commandWords) throws CommandParseException 
	{
		return null;
	}

	@Override
	public String helpText() {
		return HelpText;
	}

}
