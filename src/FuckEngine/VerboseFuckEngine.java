package FuckEngine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Peter
 *
 */
public class VerboseFuckEngine {
	
	/**
	 * 
	 * @param cells
	 * @param VerboseFuck program
	 * @return runs VerboseFuck 
	 */
	public static String runVF(int cells, String p){
		return BrainFuckEngine.runBF(cells, toBF(p));	
	}
	
	/**
	 * converts VerboseFuck program to BrainFuck
	 * @param VerboseFuck program
	 */
	public static String toBF(String s){
		//TODO complete converter
		
		
		
		
		return s;
	}
	

	/**
	 * 
	 * @param VerboseFuck program
	 * @param file to be written to
	 * @throws IOException 
	 */
	public static void toBF(String s, File f) throws IOException{
		PrintWriter printer = new PrintWriter(new FileWriter(f.getAbsolutePath()));
		printer.print(toBF(s));
	}
	
	/**
	 * converts VerboseFuck program to BrainFuck
	 * @param VerboseFuck program in a file
	 * @throws IOException 
	 */
	public static void toBF(File f) throws IOException{
		
		BufferedReader in = new BufferedReader(new FileReader(f.getPath())); 
		String text = null;
		while (in.ready()) { 
			  text += in.readLine(); 
			  System.out.println(text); 
			}
		in.close();
		
		toBF(text);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(VerboseFuckCommands.COMMENT_START+VerboseFuckCommands.END.length() +" "+ VerboseFuckCommands.BEGIN.length()+VerboseFuckCommands.COMMENT_END);

	}

}
