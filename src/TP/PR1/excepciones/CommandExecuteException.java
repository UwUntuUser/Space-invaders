package TP.PR1.excepciones;

public class CommandExecuteException extends Exception{
	public CommandExecuteException()
	{
		super();
	}
	public CommandExecuteException(String mensaje)
	{
		super(mensaje);
	}
	public CommandExecuteException(String mensaje, Throwable causa)
	{
		super(mensaje, causa);
	}
}
