package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.GameObject;

public abstract class weapon extends GameObject{

	

	public weapon(int x, int y, int vida, Game g) {
		super(x, y, vida, g);
	}
	
	
	public void computerAction() {}
	public void onDelete() {}

	
	public boolean performAttack(GameObject other) 
	{
		boolean ok=false;
		if(this.getX()==other.getX() && this.getY()==other.getY())
			ok=true;
		return ok;
	}

	public void move() {}
	
	
}
