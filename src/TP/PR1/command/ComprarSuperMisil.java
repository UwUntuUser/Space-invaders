package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.CommandExecuteException;
import TP.PR1.excepciones.CommandParseException;

public class ComprarSuperMisil extends command{
	
	private final String helpText="ComprarSuperMisil : Por 20 puntos compra un misil que hace 2 de daño\n";
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(!game.VeintePuntos())
			throw new CommandExecuteException("!!!No puedes comprar SuperMisiles¡¡¡\n");
		else
		{
			game.añadirSuperMisil();    // añade un super misil a la artilleria de la ucm ship
			game.receivePoints(-20);    // le quita 20 puntos a la ucm ship
		}
		return true;
	}

	@Override
	public command parse(String[] commandWords) throws CommandParseException {
		ComprarSuperMisil misil=null;
		if(commandWords[0].equalsIgnoreCase("COMPRAR") && commandWords.length>2) 
			throw new CommandParseException("El comando COMPRAR SUPERMISIL solo admite dos parametros\n");
		else
		{
			if(commandWords[0].equalsIgnoreCase("COMPRAR") || commandWords[0].equalsIgnoreCase("SM"))
				misil=this;
		}
		return misil;
	}

	@Override
	public String helpText() {
		return this.helpText;
	}

}
