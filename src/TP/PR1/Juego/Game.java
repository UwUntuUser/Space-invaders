package TP.PR1.Juego;

import java.util.Random;

import TP.PR1.excepciones.CommandExecuteException;
import TP.PR1.naves.*;


public class Game implements IPlayerController{
	
	public final static int  DIM_X=9;
	public final static int DIM_Y=8;
	private GameObjectBoard board;
	private UCM_Ship ucm;
	private levelEnum level;
	private int cicloActual;
	private boolean doExit;
	private BoardInitializer initializer;
	private Random random;
	private boolean serializing;
	
	public Game(levelEnum level, int seed)
	{
		this.level=level;
		this.initializer=new BoardInitializer(); 
		this.initGame();
		this.doExit=false;
		this.serializing=false;
	}
	public void initGame()
	{
		this.cicloActual=0;
		this.ucm=new UCM_Ship(this);
		this.random= new Random();
		this.board= this.initializer.initialize(this, level);
		board.add(ucm);
		
	}
	public Random getRandom()
	{
		return this.random;
	}
	public levelEnum getLevel()
	{
		return this.level;		
	}
	////////////////////////////////////////////////// FUNCIONES QUE DELEGAN EN LA UCM_Ship
	public boolean move(int numCells) { 
		this.ucm.move(numCells);
		return true;
	}
	public boolean shootMissile() throws CommandExecuteException { 
		if(this.ucm.shootMissile())
			return true;
		else
			return false;
	}
	public boolean tieneSuperMisil()
	{
		return this.ucm.getSuperMisiles()>0;
	}
	public void shootSuperMisil()
	{
		this.ucm.shootSuperMissile();
	}
	public boolean shockWave() {
		this.ucm.executeShockWave();
		return true;
	}
	public boolean enRango(int cantidad)
	{
		return this.ucm.enRango(cantidad);
	}
	public void receivePoints(int points) {
		this.ucm.receivePoints(points);
	}
	public void enableShockWave() {
		this.ucm.enableShockwave();
		
	}
	public void enableMissile() { 
		this.ucm.enableLaser();
	}
	public void disableMissile()
	{
		this.ucm.disableLaser();
	}
	public boolean VeintePuntos()
	{
		return this.ucm.getPuntos()>=20;
	}
	public void añadirSuperMisil()
	{
		this.ucm.añadirSuperMisil();
	}
	///////////////////////////////////////////// FUNCIONES QUE DELEGAN EN EL BOARD
	public void addObject(GameObject obj)
	{
		this.board.add(obj);
	}
	public void removeObject(GameObject obj)
	{
		this.board.remove(obj); 
	}
	public void doDamage(int x, int y,int damage)
	{
		this.board.doDamage(x,y,damage); 
	}
	public String positionToString(int x, int y)
	{
		return this.board.toString(x,y);
	}
	public void transformInExplosive(int x, int y)
	{
		this.board.transformInExplosive(this,x,y);
	}
	public int getNumAliensVivos()
	{
		return this.board.getNumAliensVivos();
	}
	/////////////////////////////////////////// FUNCIONES PROPIAS DEL GAME
	public void update()
	{
		this.board.computerAction();
		this.board.update();
		this.cicloActual++;
		if(!pierde())
		{
			if(gana())
			{
				System.out.println("************** ");
				System.out.println("¡¡GANASTE!! ");
				System.out.println("**************\n");
			}
		}
	}
	public String toStringObjectAt(int i, int j) {
		return this.board.toString(i, j);
	}	
	public void infoRonda() {
		System.out.println("Life : " + ucm.getVida());
		System.out.println("Number of cycles : " + this.cicloActual);
		System.out.println("Points : " + this.ucm.getPuntos());
		if(this.ucm.getShockWave())
			System.out.println("Superpoder : SI");
		else
			System.out.println("Superpoder : NO");
		System.out.println("SuperMisiles : "+ this.ucm.getSuperMisiles());
		System.out.println("Remaining aliens : " + (this.board.getNumAliensVivos()));
		System.out.println();
		
	}
	public boolean reset(Game game) {
		this.initGame();
		return true;
	}
	public boolean gana() {
		if(this.board.allDead())
			{
				this.doExit=true;
				return true;
			}
		else
			return false;
	}
	public boolean pierde() 
	{
		boolean ok=false;
		if(!ucm.vivo() || this.board.navesAterrizan() || this.doExit)
		{
			ok=true;
			System.out.println("************** ");
			System.out.println("¡¡PERDISTE!! ");
			System.out.println("**************\n");
			this.doExit=true;
		}
		return ok;
	}
	public boolean list() {
		System.out.println(regularString());
		System.out.println(destroyerString());
		System.out.println(ovniString());
		System.out.println(explosiveString());
		System.out.println(ucmString());
		return true;
	}
	public boolean exit()
	{
		this.doExit=true;
		return true;
	}
	public boolean finJuego()
	{
		if(this.doExit==true)
		{
			System.out.println("************** ");
			System.out.println("¡¡PERDISTE!! ");
			System.out.println("**************\n");
			return true;
		}
		else
			return false;
	}
	public String serialize(int CA, int v)
	{
		this.serializing=false;
		return this.board.serialize(CA, v);
	}
	//////////////////////////////////////////////IMPRIMIR DATOS DE NAVES
	public String regularString() {
		return ("[R]egular ship: Puntos : 5 - Harm : 0 - Vida : 2");
	}
	public String destroyerString() {
		return ("[D]estroyer ship: Puntos : 10 - Harm : 1 - Vida : 1");
	}
	public String ovniString() {
		return ("[O]vni - Puntos : 25 - Harm : 0 - Vida : 1");
	}
	public String ucmString() {

		return ("^__^ -  Daño : 1 - Vida :  3 \n");
	}
	public String explosiveString()
	{
		return ("[E]xplosive ship: Puntos : 5 - Harm : 1 - Vida : 2");
	}
	public int getCicloActual() {
		return this.cicloActual;
	}
	public boolean isSerializing()
	{
		return this.serializing;
	}
	public void setSerializing()
	{
		this.serializing=true;
	}
}

