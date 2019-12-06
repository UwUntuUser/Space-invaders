package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.moveEnum;

public abstract class EnemyShip extends ship{

	private moveEnum direccion;
	public EnemyShip(int x, int y, int vida, Game g) {
		super(x, y, vida, g);
		this.direccion=moveEnum.LEFT;
	}
	
	
	public void computerAction() {}
	public void move() {}
	public boolean receiveMissileAttack(int damage) // un laser golpea una nave
	{
		this.getDamage(damage);
		if(this.getVida()<1)
			this.onDelete();
		return true;
	}
	public boolean receiveShockWaveAttack(int damage) 
	{
		return false;
	}
	public moveEnum getDireccion()
	{
		return this.direccion;
	}
	public void setDireccion()
	{
		this.direccion=(this.direccion.equals(moveEnum.LEFT)? moveEnum.RIGHT : moveEnum.LEFT);
	}


}
