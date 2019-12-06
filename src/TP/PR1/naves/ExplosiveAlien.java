package TP.PR1.naves;

import TP.PR1.Juego.Game;

public class ExplosiveAlien extends AlienShip{

	private int puntos;
	private int dañoExplosion;
	public ExplosiveAlien(int x, int y, int vida, Game g) {
		super(x, y, vida, g);
		puntos=5;
		this.dañoExplosion=1;
	}



	@Override
	public void computerAction() {}

	@Override
	public String toString() {
		return "E["+ this.getVida() + "]";
	}
	public void onDelete() 
	{
		int x=this.getX();
		int y= this.getY();
		for(int columna=y-1;columna<y+1;columna++)  // comprueba las posiciones en la fila anterior : x - 1 y desplazo y
		{
			if(enRango(x-1,columna))
				this.g.doDamage(x-1, columna,dañoExplosion);
		}
		if(enRango(x,y-1)) 						   // la que esta a la izquierda
			this.g.doDamage(x, y-1,dañoExplosion);
		if(enRango(x,y+1)) 					       // la que esta a la derecha
			this.g.doDamage(x, y+1,dañoExplosion);
		for(int columna=y-1;columna<y+1;columna++) // comprueba las posiciones en la fila siguiente : x + 1 y desplazo y
		{
			if(enRango(x+1,columna))
				this.g.doDamage(x+1, columna,dañoExplosion);
		}
		this.g.receivePoints(puntos);
	}
	public String serialize(int CA,int v)
	{
		return "E;"+this.getX()+";"+this.getY()+";"+this.getVida()+";"+ CA%v+ ";" + this.getDireccion();
	}
	public boolean enRango(int x, int y)
	{
		if(x>0 && x<Game.DIM_X && y>0 && y<Game.DIM_Y)
			return true;
		else
			return false;
	}
	public boolean isAlien()
	{
		return true;
	}
}
