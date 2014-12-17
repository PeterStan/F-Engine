package FuckEngine;
import java.io.*;
import java.util.*;

/**
 * @author Peter
 *
 */
public class BrainFuckEngine {
	
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
			//System.out.print("("+ array_pointer + ")"+ array[array_pointer]+ "," + program.charAt(program_pointer)+ "   ");

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
					Scanner scan = new Scanner(System.in);
					array[array_pointer] = (byte) scan.next().charAt(0);
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
	 * @throws IOException 
	 */
	public static String runBF(File f) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(f.getPath())); 
		String prog= null;
		while (in.ready()) { 
			  prog += in.readLine(); 
			}
		in.close();
		
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
			  System.out.println(text); 
			}
		in.close();
		
		toVF(text, writer);
	}
	
	/**
	 * converts BrainFuck program to VerboseFuck
	 * @param BrainFuck Program
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
		//TODO complete converter
		return s;
		
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("run:" + runBF(new File(System.getProperty("user.dir") + "\\TestFuck\\HelloWorld.bf")));
		System.out.print("Done");

	}

}
