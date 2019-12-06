package TP.PR1.Juego;

import TP.PR1.naves.ExplosiveAlien;
import TP.PR1.naves.destroyerShip;
import TP.PR1.naves.ovni;
import TP.PR1.naves.regularShip;
import TP.PR1.Juego.IExecuteRandomActions;
public class GameObjectBoard {

	private int x;
	private int y;
	private GameObject[] objects;
	private int numObjetos;
	public GameObjectBoard(int x, int y)
	{
		this.x=x;
		this.y=y;
		this.numObjetos=0;
		this.objects = new GameObject[72];
	}
	
	private int getNumObjectos()
	{
		return this.numObjetos;
	}
	public void add(GameObject obj) //para bombas, el laser,la ucm y shockwave
	{
		this.objects[this.numObjetos]= obj;
		this.numObjetos++;
	}
	private GameObject getObjectInPositon(int x, int y)
	{
		int aux=0;
		boolean encontrado=false;
		GameObject objeto=null;
		while(aux<this.numObjetos && !encontrado)
		{
			if(this.objects[aux].getX()==x && this.objects[aux].getY()==y)
				{
					encontrado=true;
					objeto=this.objects[aux];
				}
			else
				aux++;
		}
		return objeto;
	}
	private int getIndex(int x, int y) // devuelve la posicion en la que esta el objeto con coordenadas x,y ??
	{
		int pos=0;
		boolean encontrado=false;
		while(pos<this.numObjetos && !encontrado)
		{
			if(this.objects[pos].getX()==x && this.objects[pos].getY()==y)
				encontrado=true;
			else
				pos++;
		}
		return pos;
	}
	public void remove(GameObject obj)
	{
		int posicion= this.getIndex(obj.getX(), obj.getY());
		this.desplazarNaves(posicion);
	}
	public void update()
	{
		for(int i=0;i<this.numObjetos;i++)
		{	this.objects[i].move();
			checkAttacks(this.objects[i]);
		}
		this.removeDead();
	}
	private void checkAttacks(GameObject obj)
	{	
		for(int i=0;i<this.numObjetos;i++)
			obj.performAttack(this.objects[i]);
	}
	public void computerAction()
	{
		for(int i=0; i<this.numObjetos;i++)
			this.objects[i].computerAction();
	}
	private void removeDead() 
	{
		int aux=0;
		while(aux<this.numObjetos)
		{
			if(this.objects[aux].getVida()<1)
			{
				desplazarNaves(aux);
			}
			else
				aux++;
		}
	}
	public int getNumAliensVivos() 
	{
		int numVivos=0;
		for(int i=0;i<this.numObjetos;i++)
			if(this.objects[i].isAlien() && this.objects[i].getVida()>0)
				numVivos++;
		return numVivos;
		
	}
	public boolean allDead() // todos los aliens estan muertos?
	{
		if(this.getNumAliensVivos()==0)
			return true;
		else
			return false;
		
	}
	public void desplazarNaves(int x) // desplazas hacia la izda
	{
		for(int i=x ; i<this.numObjetos-1 ; i++)
		{
			this.objects[i]=this.objects[i+1];
		}
		this.objects[this.numObjetos]=null; //  NECESARIA ESTA LINEA
		this.numObjetos--;
		
	}
	public String toString(int x, int y)
	{
		String string="  ";
		for(int i=0;i<this.numObjetos;i++) {
			if(this.objects[i].getX()==x && this.objects[i].getY()==y)
				string=this.objects[i].toString();
		}
		return string;
	}
	public boolean navesAterrizan() 
	{
		boolean aterrizaron=false;
		int aux=0;
		int numNaves=this.getNumAliensVivos();
		while(aux<numNaves && !aterrizaron)
		{
			if(this.objects[aux].getX()==7)
				aterrizaron=true;
			else
				aux++;
		}
		return aterrizaron;
	}
	public void doDamage(int x, int y,int damage)
	{
		GameObject obj =this.getObjectInPositon(x, y);
		if(obj != null)
			obj.getDamage(damage);
	}
	public void transformInExplosive(Game g,int x, int y)
	{
		int posicion= this.getIndex(x, y);
		this.objects[posicion]=new ExplosiveAlien(x,y,2,g);
	}
	public String serialize(int CA, int velocidad) //ciclo actual y velocidad
	{
		String s=null;
		StringBuilder string = new StringBuilder();
		for(int i=0;i<this.numObjetos;i++)
		{
			string.append(this.objects[i].serialize(CA,velocidad));
			string.append("\n");
		}
		s=string.toString();
		return s;
	}
	////////////////////////////////////////////////////////////////// INIZIALIZAR NAVES
	public void initializeOvni(Game game,levelEnum level)
	{
		if(IExecuteRandomActions.canGenerateRandomOvni(game))
			{
				ovni ovni=new ovni(1,game);
				ovni.setActivado();
				this.objects[this.getNumObjectos()]=ovni;
				this.numObjetos++;
			}
	}
	public void initializeRegulars(Game game,levelEnum level)
	{
		int x=level.getNumComunes();
		if(level==levelEnum.EASY)
		{
			for(int i=0;i<x;i++)
				{
					this.objects[this.numObjetos]=new regularShip(1,i+3,2,game);
					this.numObjetos++;
				}
		}
		else
		{
			for(int j=0;j<x/2;j++)
			{
				this.objects[this.numObjetos]=new regularShip(1,j+3,2,game);
				this.numObjetos++;
			}
		for(int p=x/2;p<x;p++)
			{
				this.objects[this.numObjetos]=new regularShip(2,p-1,2,game);
				this.numObjetos++;
			}
		}
	}
	public void initializeDestroyers(Game game,levelEnum level)
	{
		int x=level.getNumDestructoras();
		if(level==levelEnum.EASY)
		{
			for(int i=0;i<x;i++)
			{
				this.objects[this.numObjetos]=new destroyerShip(2,i+4, game);
				this.numObjetos++;
			}
		}
		else if(level==levelEnum.HARD)
		{
			for(int i=0;i<x;i++)
			{
				this.objects[this.numObjetos]=new destroyerShip(3,i+4, game);
				this.numObjetos++;
			}
		}
		else
		{
			for(int i=0;i<x;i++)
			{
				this.objects[this.numObjetos]=new destroyerShip(3,i+3,game);
				this.numObjetos++;
			}
		}
	}
	
}
