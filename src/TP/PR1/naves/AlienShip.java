package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.levelEnum;
import TP.PR1.Juego.moveEnum;

public abstract class AlienShip extends EnemyShip{

	protected int CPM;
	static int velocidad;
	//private int numAliens;
	static int SHIPS_ON_BORDER;
	public AlienShip(int x, int y, int vida, Game g) {
		super(x, y, vida, g);
		velocidad=g.getLevel().getVelocidad();
		levelEnum l= g.getLevel();
		//this.numAliens=l.getNumDestructoras()+l.getNumComunes();
		this.CPM=velocidad;
		SHIPS_ON_BORDER=0;
	}

	@Override
	public abstract void computerAction();
	
	public boolean receiveShockWaveAttack() 
	{
		return false;
	}
	public void move()
	{
		if(this.CPM==0) // si toca moverse
		{
			if(this.getDireccion()==moveEnum.LEFT)
				this.setY(-1); // movemos a la izda
			else
				this.setY(1); // movemos a la drcha
			if(this.naveEnBorde())
				this.startShipDescent();
			this.CPM=velocidad;
		}
		else if(this.CPM!=0 && this.shipsDescending())
		{
			descend();
		}
		else
		{
			this.CPM--; // si no nos movemos, bajamos el contador uno
		}
	}
	public boolean naveEnBorde()
	{
		int border = (this.getDireccion()== moveEnum.LEFT) ? 0 : Game.DIM_Y-1;
		return getY() == border;	
	}
	public void startShipDescent()
	{
		SHIPS_ON_BORDER=this.g.getNumAliensVivos();
	}
	public boolean shipsDescending()
	{
		return SHIPS_ON_BORDER>0;
	}
	public void descend()
	{
		this.setX(1);
		this.setDireccion(); //Cambia Left a Right y viceversa 
		SHIPS_ON_BORDER -= 1;
	}
	
}
