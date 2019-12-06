package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.GameObject;

public class shockwave extends weapon{

	
	
	public shockwave(int x, int y,Game g) {
		super(x,y,0, g);
	}

	public void onDelete()
	{
		this.g.removeObject(this);
	}
	public String toString() {
		return null;
	}
	@Override
	public boolean esShockWave() {return true;}

	@Override
	public String serialize(int CA, int v) {
		return null;
	}
	public boolean performAttack(GameObject other)
	{
		boolean ok=false;
		if(!other.esUCM() && other.getDamage(1)) // par que no haga daño a la ucm
			ok=true;
		return ok;
	}
	

}
