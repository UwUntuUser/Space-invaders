package TP.PR1.naves;

import TP.PR1.Juego.Game;


public class UCM_Ship extends ship{

	private int puntos;
	private boolean puedeDisparar;
	private boolean puedeSW;
	private int numMisiles;

	public UCM_Ship(Game g) {
		super(7, 4, 3, g);
		this.puedeDisparar=true;
		this.puedeSW=true;
		this.puntos=0;
		this.numMisiles=0;
	}
	
	public void añadirSuperMisil()
	{
		this.numMisiles++;
	}
	public int getSuperMisiles()
	{
		return this.numMisiles;
	}
	public int getPuntos()
	{
		return this.puntos;
	}
	public String toString() {
		return "^__^["+ this.getVida() +"]";
	}
	public String toStringDatos() {
		return ("^__^ -  Daño : 1 - Vida :  3");
	}
	public void move(int cantidad) {
		this.setY(cantidad);
	}	
	public boolean vivo()
	{
		return this.getVida()>=1;
	}
	public boolean shootMissile() 
	{
		boolean ok=false;
		if(this.puedeDisparar)
		{
			int x= this.getX();
			int y= this.getY();
			laser laser=new laser(x-1,y,this.g);
			this.g.addObject(laser);
			this.puedeDisparar=false;
			ok=true;
		}
		return ok;
	}
	public boolean shootSuperMissile() 
	{
		int x= this.getX();
		int y= this.getY();
		superMisil misil=new superMisil(x-1,y,this.g);
		this.g.addObject(misil);
		this.numMisiles--;
		return true;
	}
	public void executeShockWave()
	{
		if(this.puedeSW)
		{
			this.puedeSW=false;
			this.g.addObject(new shockwave(this.getX(),this.getY(),this.g));
		}
	}
	public void enableLaser()
	{
		this.puedeDisparar=true;
	}
	public void disableLaser()
	{
		this.puedeDisparar=false;
	}
	public void enableShockwave()
	{
		this.puedeSW=true;
	}
	public void desableShockWave()
	{
		this.puedeSW=false;
	}
	public boolean receiveBombAttack(int damage)
	{
		this.getDamage(1);
		return true;
	}
	public void receivePoints(int points)
	{
		this.puntos+=points;
	}
	public boolean getShockWave()
	{
		return this.puedeSW;
	}
	public String serialize(int CA,int v)
	{
		return "UCM;"+this.getX()+";"+this.getY()+";"+this.getVida()+";"+this.getPuntos()+";"+this.puedeSW;
	}
	public boolean esUCM()
	{
		return true;
	}
	public boolean enRango(int cantidad)
	{
		if(this.getY()+cantidad<0 || this.getY()+cantidad>Game.DIM_Y-1)
			return false;
		else 
			return true;
	}
	//funciones que hereda pero no implementa
	public void computerAction() {}
	public void move() {}
	public void onDelete() {}
	
	

}
