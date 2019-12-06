package TP.PR1.Juego;

public class BoardInitializer {
	private levelEnum level;
	private GameObjectBoard board;
	private Game game;
	
	
	public GameObjectBoard  initialize(Game game, levelEnum level)
	{
		this.level=level;
		this.game=game;
		this.board =new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni();
		initializeRegulars();
		initializeDestroyers();
		return board;
	}
	
	private void initializeOvni()
	{
		this.board.initializeOvni(this.game,level);
	}
	private void initializeRegulars()
	{
		this.board.initializeRegulars(this.game,level);
	}
	private void initializeDestroyers()
	{
		this.board.initializeDestroyers(this.game,level);
	}
}
