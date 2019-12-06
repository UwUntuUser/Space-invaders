package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.IExecuteRandomActions;

public class regularShip extends AlienShip{
	private int puntos;
	
	public regularShip(int x, int y, int vida, Game g) {
		super(x, y, vida, g);
		this.puntos=5;
	}

	public String toString() {
		return "R["+ this.getVida() + "]";
	}
	public int getPoints() {
		return 5;
	}
	public void computerAction() {
		if(IExecuteRandomActions.canTransformExplosiveAlien(g))
			g.transformInExplosive(this.getX(),this.getY());
	}
	public boolean isAlien()
	{
		return true;
	}
	@Override
	public void onDelete() {
		this.g.receivePoints(this.puntos);
	}
	public String serialize(int CA,int v)
	{
		return "R;"+this.getX()+";"+this.getY()+";"+this.getVida()+";"+ CA%v+ ";" + this.getDireccion();
	}
}



