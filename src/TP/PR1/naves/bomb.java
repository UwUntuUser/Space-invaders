package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.GameObject;

public class bomb extends weapon{
	
	private destroyerShip destroyer; 
	
	public bomb(int x, int y, Game g,destroyerShip d) {
		super(x, y, 1, g);
		this.destroyer=d;
	}

	public String toString() {
		return " + ";
	}
	
	public void weaponAttack(GameObject obj) 	// un objeto recive un disparo de la bomba
	{
		obj.receiveBombAttack(1);
	}
	public boolean receiveMissileAttack(int damage) // reciben un ataque (laser de la ucm)
	{
		if(this.getDamage(damage))
			return true;
		else
			return false;
	}
	public boolean receiveShockWaveAttack(int damage) 
	{
		return false;
	}
	public  void onDelete()
	{
		this.g.removeObject(this);
	}
	public void move() {
		this.setX(1);
		if(this.getX()==9)
			{
				this.g.removeObject(this);
				this.destroyer.enableBomb();
			}
	}
	public boolean performAttack(GameObject other)
	{
		boolean ok=false;
		if(super.performAttack(other))
		{
			if(other.receiveBombAttack(1))
				{
					this.getDamage(1);
					ok=true;
					this.destroyer.enableBomb();
				}
		}
		return ok;
	}
	public String generateSerialRef()
	{
		return labelRefSeparator + this.destroyer.getLabel();
	}
	public String serialize(int CA, int velocidad)
	{
		String s="B;"+this.getX()+";"+this.getY()+(this.destroyer.getVida()>0? generateSerialRef() : "")+";";
		return s;
	}
	@Override
	public boolean esBomba() {return true;}
}
