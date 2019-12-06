package TP.PR1.Juego;

import TP.PR1.utils.MyStringUtils;

public class BoardPrinter extends GamePrinter{
	
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	Game game;
	public BoardPrinter () {
		this.numRows = Game.DIM_X-1;
		this.numCols = Game.DIM_Y;		
	}
	
	public String toString()
	{
		this.setGame(game);
		this.encodeGame(game);
		return datosTablero();
	}
	private void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
					board[i][j] =  game.toStringObjectAt(i, j); 
			}
		}
	}
	public void setGame(Game game)
	{
		this.game=game;
	}
	public String datosTablero() {

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;
		
		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);
		
		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;
		
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<numCols; j++)
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				if (i != numRows - 1) str.append(lineDelimiter);
				else str.append(lineEdge);	
		}
		
		return str.toString();
	}
}