package TP.PR1.command;

import TP.PR1.Juego.Game;
import TP.PR1.excepciones.*;

public class moveCommand extends command{
	private int cantidad;
	private final  String helpText="Move : Mueve la UCM_Ship <cantidad> celdas. \n";
	
	public moveCommand(int cantidad)
	{
		this.cantidad=cantidad;
	}
	public command parse(String[] words) throws CommandParseException{
		moveCommand move=null;
		if(words.length==2 && words[0].equalsIgnoreCase("move"))
		{
			try {
				cantidad=Integer.parseInt(words[1]);
				move=new moveCommand(cantidad);
			}
			catch(NumberFormatException exception)
			{
				System.out.println("\n");
				throw new CommandParseException("***Introduce un numero entero entre [-2,2]*** \n\n");
			}
		}
		return move;
}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{ // el movimiento saca al jugador del tablero
		boolean ok=false;
		if(!game.enRango(cantidad))
			throw new CommandExecuteException("\nQUE TE SALES DEL TABLERO!!!!!!!!!!\n\n");
		else if(cantidad<-2 || cantidad >2)
			throw new CommandExecuteException("No puedes moverte mas de 2 casillas de golpe\n");
		else
			if(game.move(cantidad))
				ok=true;
		return ok;
	}
	public String helpText()
	{
		return this.helpText;
	}
}
