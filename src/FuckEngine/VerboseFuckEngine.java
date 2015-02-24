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
	 * @throws IOException 
	 */
	public static String runVF(int cells, String p) throws IOException{
		return BrainFuckEngine.runBF(cells, toBF(p));	
	}
	
	/**
	 * 
	 * @param VerboseFuck program
	 * @return runs VerboseFuck
	 * @throws IOException 
	 */
	public static String runVF(String p) throws IOException{
		return runVF(100, p);		
	}
	
	public static String runVf(File f) throws IOException{
		BufferedReader in;
		String prog= null;
		try {
			in = new BufferedReader(new FileReader(f.getPath()));
			while (in.ready()) { 
				  prog += in.readLine(); 
				}
			in.close();
		} catch (IOException e) {
			// file not found
			System.out.println("Error - File Not Found");
		} 
		
		
		return runVF(prog);
	}
	
	/**
	 * converts VerboseFuck program to BrainFuck
	 * @param VerboseFuck program
	 * @throws IOException 
	 */
	public static String toBF(String vf) throws IOException{
		String bf = new String();
		char[] ch = new char[500];
		vf = new String(ch) + vf; 
		
		for(int i = vf.length();i >= 0; i--){
			//System.out.println("index:" + i);
			if(i < 500){
				break;
			}			
			else if(vf.substring(i-VerboseFuckCommands.PLUS.length(), i).equals(VerboseFuckCommands.PLUS)){
				bf = "+" + bf;
				//System.out.println ("+++");
				i -= VerboseFuckCommands.PLUS.length();
			}
			else if(vf.substring(i-VerboseFuckCommands.MINUS.length(), i).equals(VerboseFuckCommands.MINUS)){
				bf = "-" + bf;
				//System.out.println ("---");
				i -= VerboseFuckCommands.MINUS.length();
			}
			else if(vf.substring(i-VerboseFuckCommands.RIGHT.length(), i).equals(VerboseFuckCommands.RIGHT)){
				bf = "]" + bf;
				//System.out.println ("]]]");
				i -= VerboseFuckCommands.RIGHT.length();
			}
			else if(vf.substring(i-VerboseFuckCommands.LEFT.length(), i).equals(VerboseFuckCommands.LEFT)){
				bf = "[" + bf;
				//System.out.println ("[[[");
				i -= VerboseFuckCommands.LEFT.length();
			}
			else if(vf.substring(i-VerboseFuckCommands.NEXT.length(), i).equals(VerboseFuckCommands.NEXT)){
				bf = ">" + bf;
				//System.out.println (">>>");
				i -= VerboseFuckCommands.NEXT.length();
			}
			else if(vf.substring(i-VerboseFuckCommands.PREVIOUS.length(), i).equals(VerboseFuckCommands.PREVIOUS)){
				bf = "<" + bf;
				//System.out.println ("<<");
				i -= VerboseFuckCommands.PREVIOUS.length();
			}
			else if(vf.substring(i-VerboseFuckCommands.OUTPUT.length(), i).equals(VerboseFuckCommands.OUTPUT)){
				bf = "." + bf;
				//System.out.println ("...");
				i -= VerboseFuckCommands.OUTPUT.length();
			}
			else if(vf.substring(i-VerboseFuckCommands.INPUT.length(), i).equals(VerboseFuckCommands.INPUT)){
				bf = "," + bf;
				//System.out.println (",,,");
				i -= VerboseFuckCommands.INPUT.length();
			}	
			
			//System.out.print(bf);
		}
		
		//System.out.println(bf);
		return bf;
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
		printer.close();
	}
	
	/**
	 * converts VerboseFuck program to BrainFuck
	 * @param VerboseFuck program in a file
	 * @return 
	 * @throws IOException 
	 */
	public static String toBF(File f) throws IOException{
		
		BufferedReader in = new BufferedReader(new FileReader(f.getPath())); 
		String text = null;
		while (in.ready()) { 
			  text += in.readLine() + "\n"; 
			}
		in.close();
		//System.out.println(text);
		return toBF(text);
	}
	
	/**
	 * 
	 * @param bf file
	 * @param vf file
	 * @throws IOException
	 */
	public static void toBF(File bf, File vf) throws IOException{
		toBF(toBF(vf),bf);
	}
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//System.out.print(FuckCommands.PLUS.getBF());
		
		//System.out.println(VerboseFuckCommands.COMMENT_START+VerboseFuckCommands.END.length() +" "+ VerboseFuckCommands.BEGIN.length()+VerboseFuckCommands.COMMENT_END);
		//runVF((System.getProperty("user.dir") + "\\TestFuck\\Peter.vf"));
		File vf = new File(System.getProperty("user.dir") + "\\TestFuck\\VerboseFuckTest.vf");
		System.out.println(toBF(vf));
	}

}
