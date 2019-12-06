package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.*;

public class shockwaveCommand extends command{
	
	private final  String helpText="ShockWave : Hace daño a todas las naves. \n";
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException{ 
		boolean ok=false;
		if(game.shockWave())
			{
				game.update(); // importante para que haga daño en el mismo turno en el que se crea
				ok=true;
			}
		else
			throw new CommandExecuteException("*****No tienes ShockWave*****");
		return ok;
	}

	@Override
	public command parse(String[] commandWords)throws CommandParseException
	{
		if(commandWords[0].equalsIgnoreCase("sw") && commandWords.length!=1) throw new CommandParseException("\n El comando SHOCKWAVE solo tiene un parametro\n\n");

		shockwaveCommand sw=null;
		if(commandWords.length==1 && commandWords[0].equalsIgnoreCase("SHOCKWAVE") || commandWords[0].equalsIgnoreCase("SW"))
			sw=new shockwaveCommand();
		return sw;
	}
	public String helpText()
	{
		return this.helpText;
	}

}
