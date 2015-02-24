package FuckEngine;
import java.io.*;
import java.util.*;

/**
 * @author Peter
 *
 */
public class BrainFuckEngine {
	static boolean debug;
	
	public static void debug(boolean b){
		debug = b;
	}
	
	public static void debug(){
		debug(!debug);
	}
	
	public static void debugMessage(String d){
		if(debug){
			System.out.println(d);
		}
	}
	
	/**
	 * 
	 * @param cells
	 * @param BrainFuck program
	 * @return runs BrainFuck
	 */
	public static String runBF(int cells, String program){
		byte[] array = new byte[cells];	int array_pointer = 0; 
		String print = "";
		Stack<Integer> loop_program_position = new Stack<>(); Stack<Integer> loop_array_position = new Stack<>();
		
		for(int program_pointer = 0; program_pointer < program.length(); program_pointer++){
			debugMessage("a["+ array_pointer + "] = "+ array[array_pointer]+ " \"" + program.charAt(program_pointer)+ " \"  ");

			switch(program.charAt(program_pointer)){
			case '>':
					array_pointer++;
				break;
			case '<':
					array_pointer--;
				break;
			case '+':
					array[array_pointer] += 1;
				break;
			case '-':
					array[array_pointer] -= 1;
				break;
			case '.':
					print += (char)(array[array_pointer]);
				break;
			case ',':
					//Scanner scan = new Scanner(System.in);
					//array[array_pointer] = (byte) scan.next().charAt(0);
				System.out.print("Input: ");
				Scanner scan = new Scanner(System.in);
				String input = new String();
				input = scan.next();
				array[array_pointer] = (byte) input.charAt(0);
				
				
				
				
				
				scan.close();
				break;
			case '[':
					loop_program_position.push(new Integer(program_pointer++));
					loop_array_position.push(new Integer(array_pointer));
					program_pointer--;			
				break;
			case ']':
				if(array[loop_array_position.peek()] == 0){
					loop_program_position.pop();
					loop_array_position.pop();
				}
				else
					program_pointer = loop_program_position.peek();
				break;
			default:
				break;
			}
			//System.out.println();
		}
		return print;
	}
	
	/**
	 * 
	 * @param BrainFuck program
	 * @return interprets BF
	 */
	public static String runBF(String p){
		return runBF(100,p);
	}
	
	/**
	 * 
	 * @param file containing BrainFuck
	 * @return Interprets BF 
	 */
	public static String runBF(File f){ 
		BufferedReader in;
		String prog= null;
		try {
			in = new BufferedReader(new FileReader(f.getPath()));
		while (in.ready()) { 
				  prog += in.readLine(); 
				}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return runBF(prog);
		
	}
	
	/**
	 * converts BrainFuck program to VerboseFuck 
	 * @param BrainFuck program
	 * @throws IOException 
	 */
	public static void toVF(File reader, File writer) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(reader.getPath())); 
		String text = null;
		while (in.ready()) { 
			  text += in.readLine(); 
			  //System.out.println(text); 
			}
		in.close();
		
		toVF(text, writer);
	}
	
/**
 * 
 * @param BrainFuck program
 * @param file to be written to 
 * @throws IOException
 */
	public static void toVF(String s, File writer) throws IOException{
		PrintWriter outt = new PrintWriter(new FileWriter(writer.getAbsolutePath()));
		outt.print(toVF(s));
		outt.close();

		
		
	}
	
	/**
	 * converts BrainFuck program to VerboseFuck
	 * @param BrainFuck Program
	 */
	public static String toVF(String s){
		String ver = new String();
		int lastCharCheck = 0;
		
		ver += VerboseFuckCommands.MANDITORY_COMMENT + "\n" + VerboseFuckCommands.BEGIN + "\n";
		//System.out.println(ver.length());
		for(int i = 0; i < s.length(); i++){
			//System.out.println(s.length());
			debugMessage(i + ", " + s.charAt(i));	
			debugMessage( "\n("+lastCharCheck + "," + i +  ") " + ver.substring(lastCharCheck).length() + "");
			
			if(ver.substring(lastCharCheck).length() >= 250){
				ver += VerboseFuckCommands.MANDITORY_COMMENT + "\n";
				lastCharCheck += ver.substring(lastCharCheck).length();
				//i--;
			}
			else{	
			}
			
			if(s.charAt(i) == '>'){
				ver += VerboseFuckCommands.NEXT + "\n";
				//ver += ">>>\n";
			}
			else if(s.charAt(i) == '<'){
				ver += VerboseFuckCommands.PREVIOUS + "\n";
				//ver += "<<<\n";
			}
			else if(s.charAt(i) == '+'){
				ver += VerboseFuckCommands.PLUS + "\n";
				//ver += "+++\n";
			}
			else if(s.charAt(i) == '-'){
				ver += VerboseFuckCommands.MINUS + "\n";
				//ver += "---\n";
			}
			else if(s.charAt(i) == ','){
				ver += VerboseFuckCommands.INPUT + "\n";
				//ver += ",,,\n";
			}
			else if(s.charAt(i) == '.'){
				ver += VerboseFuckCommands.OUTPUT + "\n";
				//ver += "...\n";
			}
			else if(s.charAt(i) == '['){
				ver += VerboseFuckCommands.LEFT + "\n";
				//ver += "[[[\n";
			}
			else if(s.charAt(i) == ']'){
				ver += VerboseFuckCommands.RIGHT + "\n";
				//ver += "]]]\n";
			}
			else{	
			}
			
		}
		ver += VerboseFuckCommands.END;
		return ver;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		
		File bf = new File(System.getProperty("user.dir") + "\\TestFuck\\BrainFuckTest.bf");
		File vf = new File(System.getProperty("user.dir") + "\\TestFuck\\VerboseFuckTest.vf");
		//debug();
		System.out.println("run:" + runBF(bf));
		//debug(false);
		toVF(bf,vf);
		System.out.println("Done");

	}

}
