package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.IExecuteRandomActions;

public class ovni  extends EnemyShip implements IExecuteRandomActions{
	
	private boolean activado;
	private int puntos;
	public ovni(int vida, Game g) {
		super(0, 8, 1, g);
		puntos=25;
	}
	
	
	public String toString() {
		return "O["+ this.getVida() + "]"; 	
	}
	public void computerAction()
	{
		if(!this.activado && IExecuteRandomActions.canGenerateRandomOvni(g))
		{
			this.activado=true;
			this.setY(10);
		}
	}
	public void onDelete()
	{
		this.g.receivePoints(this.puntos);
		this.g.enableShockWave();
		this.activado=false;
		
	}
	public int getPoints() {
		return this.puntos; // TODO
	}
	public void move()
	{
		if(this.activado)
			{
				this.setY(-1); 
				if(this.getY()==-1)
					{
						this.activado=false;
					}
			}	
	}
	public void setActivado()
	{
		this.activado=true;
	}
	public String serialize(int CA,int v)
	{
		return "O;"+this.getX()+";"+this.getY()+";"+this.getVida()+";";
	}
	public boolean receiveMissileAttack(int damage) // reciben un ataque (laser de la ucm)
	{
		if(this.getDamage(damage))
			{
				this.onDelete();
				return true;
			}
		else
			return false;
	}

}




