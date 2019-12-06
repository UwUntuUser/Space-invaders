package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.GameObject;

public class laser extends weapon{
	
	
	public laser(int x, int y, Game g) {
		super(x, y, 1, g);
	}	
	public String toString() {
		return "oo";
	}
	public void weaponAttack(GameObject obj) // el laser ataca a una nave o bomba
	{
		obj.receiveMissileAttack(1);
	}
	public void onDelete() //Cuando se destruyen se activan en su creador player a través de game
	{
		this.g.enableMissile();
		this.g.removeObject(this);
	}
	public boolean receiveBombAttack(int damage) 
	{
		if(this.getDamage(damage))
			{
				this.g.enableMissile();
				return true;
			}
		else
			return false;
	}
	
	public void move() {
		this.setX(-1);
		if(this.getX()==0)
			{
				g.removeObject(this);
				g.enableMissile();
			}
	}
	public boolean performAttack(GameObject other)
	{
		boolean ok=false;
		if(super.performAttack(other))
		{
			if(other.receiveMissileAttack(1))
				{
					this.getDamage(1);
					this.g.enableMissile();
					ok=true;
				}
		}
		return ok;
	}
	public String serialize(int CA,int v)
	{
		return "M;"+this.getX()+";"+this.getY()+";";
	}
	@Override
	public boolean esLaser() {return true;}
}
