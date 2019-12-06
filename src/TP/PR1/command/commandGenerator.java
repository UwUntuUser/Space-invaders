package TP.PR1.command;

import TP.PR1.excepciones.CommandParseException;

public class commandGenerator {
	protected static final String incorrectArgs ="\n!!!Argumentos erroneos.¡¡¡\n\n";
	
	private static command[] availableCommands = {new updateCommand(),new exitCommand(),
			new resetCommand(),new helpCommand(),
			new shockwaveCommand(),new SaveCommand(null),new moveCommand(0),
			new listCommand(),new StringifyCommand(),new ComprarSuperMisil(),
			new shootCommand(),new ListPrintersCommand(),new ShootSuperMisilCommand()};
	
	public static command commandParse(String[] words) throws CommandParseException {
		command c=null;
		if(words.length>0 && words.length<3)
		{	
			for(command aux:availableCommands)
				{
					c=aux.parse(words);
					if(c!=null)
						return c;
				}
		}
		if(c==null)
			throw new CommandParseException(incorrectArgs);
		return c;
	}
	public static String CommandHelp()
	{
		String text = "";
		for (int i = 0; i < availableCommands.length; i++) {
			text += availableCommands[i].helpText();
		}
		return text;
	}
}
