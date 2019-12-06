package TP.PR1.excepciones;

public class CommandParseException extends Exception{
	public CommandParseException()
	{
		super();
	}
	public CommandParseException(String mensaje)
	{
		super(mensaje);
	}
	public CommandParseException(String mensaje, Throwable causa)
	{
		super(mensaje, causa);
	}
}
