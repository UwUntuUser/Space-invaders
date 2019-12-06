package TP.PR1.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import TP.PR1.Juego.Game;
import TP.PR1.Juego.GamePrinter;
import TP.PR1.Juego.PrinterType;
import TP.PR1.excepciones.CommandExecuteException;
import TP.PR1.excepciones.CommandParseException;

public class SaveCommand extends command {
	
	protected String filename;
	private final String helpText="Save : Guarda el juego en un fichero .dat\n";
	public SaveCommand(String filename)
	{
		this.filename=filename+".dat";
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try(BufferedWriter outStream = new BufferedWriter(new FileWriter(filename)))
		{
			outStream.write("---Space Invaders v2.0 ---");
			outStream.newLine(); 
			outStream.newLine();
			GamePrinter printer=PrinterType.STRINGIFIER.getObject(game);
			printer.setGame(game);
			outStream.write("" + printer);
			System.out.println("La operacion tuvo exito\n");
		}
		catch(IOException e)
		{
			throw new CommandExecuteException("Archivo no abierto/encontrado");
		}
		return false;
	}

	@Override
	public command parse(String[] commandWords) throws CommandParseException {
		SaveCommand save=null;
		if(commandWords[0].equalsIgnoreCase("SAVE") && commandWords.length==1) 
			throw new CommandParseException("\nNecesitas indicar el nombre del archivo\n");
		if(commandWords[0].equalsIgnoreCase("SAVE") &&commandWords.length!=2) 
			throw new CommandParseException("\nLos parametros permitidos son : 'SAVE' y 'NombreDelArchivo.dat'\n");
		else if(commandWords.length==2)
			{
				if(commandWords[0].equalsIgnoreCase("SAVE"))
					save=new SaveCommand(commandWords[1]);
			}
		return save;
	}
	@Override
	public String helpText() {
		return this.helpText;
	}

}
