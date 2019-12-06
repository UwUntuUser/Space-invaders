package TP.PR1.Juego;

public enum PrinterType {
	
	BOARDPRINTER("BoardPrinter", "prints the game formatted as a board of dimensions: ", new BoardPrinter()),
	STRINGIFIER("Stringifier","prints the game as plain text", new Stringifier());
	
	private GamePrinter printerObject;
	private String nombre;
	private String texto;
	
	private PrinterType(String name,String text,GamePrinter printer)
	{
		this.nombre=name;
		this.texto=text;
		this.printerObject=printer;
	}
	public static String printerHelp(Game game)
	{
		String info="\nBoardPrinter : Prints the game formatted as a board of dimension: 9x8 \nStringifier : Prints the game as plain text\n";
		return info;
	}
	public GamePrinter getObject(Game game)
	{
		return printerObject;
	}
}
