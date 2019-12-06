package TP.PR1.naves;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.IExecuteRandomActions;

public class destroyerShip extends AlienShip implements IExecuteRandomActions{
	
	private boolean puedeDisparar;
	private int puntos;
	private static int currentSerialNumber;
	
	public destroyerShip(int x, int y, Game g)
	{
		super(x,y,1,g);
		this.puntos=10;
		puedeDisparar=true;
	}
	private void initialiseLabelling()
	{
		currentSerialNumber=1;
	}
	private String generateLabelling()
	{
		label= currentSerialNumber;
		currentSerialNumber++;
		return labelRefSeparator + label;
	}
	public String toString() {
		return "D["+ this.getVida() + "]"; 
	}
	public boolean getPuedeDisparar(){
		return this.puedeDisparar==true;
	}
	public int getPoints() {
		return this.puntos;
	}
	public void enableBomb()
	{
		this.puedeDisparar=(puedeDisparar)? false : true;	
	}
	public void computerAction() {
		if(this.puedeDisparar)
			{
				if(IExecuteRandomActions.canGenerateRandomBomb(g)) 
				{
					this.puedeDisparar=false;
					bomb bomb= new bomb(this.getX()+1,this.getY(),this.g,this);
					g.addObject(bomb);
				}
			}
	}
	public int getLabel()
	{
		return label;
	}
	public String serialize(int CA,int veloidad)
	{
		if(!this.g.isSerializing())
		{
			this.g.setSerializing();
			this.initialiseLabelling();
		}
		return "D;"+this.getX()+";"+this.getY()+";"+this.getVida()+";"+ CA%velocidad+ ";" + this.getDireccion()+ this.generateLabelling();
	}
	
	public boolean isAlien()
	{
		return true;
	}
	@Override
	public void onDelete() {
		this.g.receivePoints(this.puntos);
	}
}



