package TP.PR1.Juego;

import TP.PR1.excepciones.CommandExecuteException;

public interface IPlayerController {
	// Player actions
	public boolean move (int numCells);
	public boolean shootMissile() throws CommandExecuteException;
	public boolean shockWave() throws CommandExecuteException;
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave(); // para poner true o false el atributo
	public void enableMissile(); // igual
}
