package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.GameObject;
public class superMisil extends weapon{

	private final int daño;
	public superMisil(int x, int y, Game g) {
		super(x, y, 1, g);
		daño=2;
	}

	@Override
	public String serialize(int CA, int v) {
		return "SM;"+this.getX()+";"+this.getY()+";";
	}

	@Override
	public String toString() {
		return "MM";
	}
	public void move() {
		this.setX(-1);
		if(this.getX()==0)
			{
				g.removeObject(this);
				g.enableMissile();
			}
	}
	public void onDelete() //Cuando se destruyen se activan en su creador player a través de game
	{
		this.g.enableMissile();
		this.g.removeObject(this);
	}
	public void weaponAttack(GameObject obj) // el laser ataca a una nave o bomba
	{
		obj.receiveMissileAttack(daño);
	}
	public boolean performAttack(GameObject other)
	{
		boolean ok=false;
		if(super.performAttack(other))
		{
			if(other.receiveMissileAttack(this.daño)) // daño = 2
				{
					this.getDamage(1);
					this.g.enableMissile();
					ok=true;
				}
		}
		return ok;
	}
	public boolean esLaser() {return true;}

}
