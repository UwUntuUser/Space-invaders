package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.*;

public class shootCommand extends command{
	
	private final  String helpText="Shoot : La UCM_Ship dispara. \n";
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException
	{ 
		boolean ok=false;
		if(game.shootMissile())
			ok=true;
		else
			throw new CommandExecuteException("******Ya disparaste******\n");
		return ok;
	}

	@Override
	public command parse(String[] commandWords) throws CommandParseException
	{
		if(commandWords[0].equalsIgnoreCase("shoot") && commandWords.length>2) 
			throw new CommandParseException("\n El comando SHOOT solo tiene un parametro\n\n");
		
		command comando=null;
		if(commandWords.length ==1 && (commandWords[0].equalsIgnoreCase("SHOOT") || commandWords[0].equalsIgnoreCase("S")))
			comando= this;
		else
		{
			if(commandWords.length==2 && (commandWords[0].equalsIgnoreCase("SHOOT") || commandWords[0].equalsIgnoreCase("S")) && (commandWords[1].equalsIgnoreCase("SUPERMISIL") || commandWords[1].equalsIgnoreCase("SM")))
				comando=new ShootSuperMisilCommand();
		}
		return comando;
	}
	public String helpText()
	{
		return this.helpText;
	}

}
