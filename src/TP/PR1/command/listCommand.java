package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandParseException;

public class listCommand extends command{

	private final  String helpText="List : Muestra información sobre las naves. \n";
	
	public command parse(String[] words) throws CommandParseException 
	{
		if(words[0].equalsIgnoreCase("list") && words.length<1) 
			throw new CommandParseException("\n El comando LIST solo tiene un parametro\n\n");
		listCommand list=null;
		if(words.length==1 && words[0].equalsIgnoreCase("LIST") || words[0].equalsIgnoreCase("L"))
			return list=this;
		return list;
}

	@Override
	public boolean execute(Game game) {
		boolean ok=false;
		if(game.list())
			ok=true;
		return ok;
	}
	
	public String helpText()
	{
		return this.helpText;
	}
}
