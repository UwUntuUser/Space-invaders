package TP.PR1.Juego;

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game)
	{
		double random = game.getRandom().nextDouble();
		double frecuencia=game.getLevel().getFrecuenciaOvni();
		return  random < frecuencia;
	}
	static boolean canGenerateRandomBomb(Game game)
	{
		double random=game.getRandom().nextDouble();
		double frecuencia=game.getLevel().getFrecuenciaDispario();
		return  random < frecuencia;
	}
	static boolean canTransformExplosiveAlien(Game game)
	{
		double random=game.getRandom().nextDouble();
		double frecuencia=game.getLevel().getFrecuenciaExplosiva();
		return random < frecuencia;
	}
}
