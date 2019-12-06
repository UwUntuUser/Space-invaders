package TP.PR1.Juego;

public abstract class GameObject implements IAttack  {
	private int x;
	private int y;
	protected Game g;
	private int vida;
	public static final String labelRefSeparator =" - ";
	protected int label=0;
	
	public GameObject(int x, int y, int vida, Game g)
	{
		this.x=x;
		this.y=y;
		this.g=g;
		this.vida=vida;
	}
	
	
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public int getVida()
	{
		return this.vida;
	}
	public void setX(int cantidad)
	{
		this.x+=cantidad;
	}
	public void setY(int cantidad) {
		this.y+=cantidad;
	}
	public boolean getDamage(int damage)
	{
		this.vida-=damage;
		return true;
	}
	////////////////////////////////////////////////////// FUNCIONES PARA EVITAR instance of
	public boolean esLaser() {return false;}
	public boolean esBomba() {return false;}
	public boolean esShockWave() {return false;}
	public boolean esUCM() {return false;}
	public boolean isAlien() {return false;}
	/////////////////////////////////////////////////////
	public abstract String serialize(int CA, int v);
	public abstract void computerAction();
	public abstract void move();
	public abstract void onDelete();
	public abstract String toString();
}
