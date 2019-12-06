package TP.PR1.Juego;

public class Stringifier extends GamePrinter{
	
	
	@Override
	public String toString() {
		return toString(game.getCicloActual(), game.getLevel().getVelocidad());
	}



	public String toString(int CA, int v)
	{
		return this.game.serialize(CA, v);
	}
	
}
