package TP.PR1.Juego;

public enum levelEnum {
	EASY(4,2,0.1,0.9,3),
	HARD(8,2,0.3,0.2,2),
	INSANE(8,4,0.5,0.1,1);
	private int Comunes;
	private int Destructoras;
	private double Disparo;
	private double Ovni;
	private int velocidad;
	private double frecuenciaNaveExplosiva=0.0;
	
	levelEnum(int comunes,int destructoras,double frecDisparo,double frecOvni,int velocidad) {
		this.Comunes=comunes;
		this.Destructoras=destructoras;
		this.Disparo=frecDisparo;
		this.Ovni=frecOvni;
		this.velocidad=velocidad;
	}
	public levelEnum nivel(levelEnum level) {
		levelEnum l;
		switch(level) {
		case EASY:
			l = levelEnum.EASY;
			break;
		case HARD:
			l = levelEnum.HARD;break;
		default :
			l = levelEnum.INSANE;break;
		}
		return l;
	}
	

	public int getNumComunes() {
		return this.Comunes;
	}
	public int getNumDestructoras() {
		return this.Destructoras;
	}
	public double getFrecuenciaDispario() {
		return this.Disparo;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public double getFrecuenciaOvni() {
		return this.Ovni;
	}
	public double getFrecuenciaExplosiva()
	{
		return this.frecuenciaNaveExplosiva;
	}
}