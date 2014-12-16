package FuckEngine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

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
	 * converts BrainFuck program to VerboseFuck 
	 * @param BrainFuck program
	 * @throws IOException 
	 */
	public static void toVF(File f) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(f.getPath())); 
		String text = null;
		while (in.ready()) { 
			  text += in.readLine(); 
			  System.out.println(text); 
			}
		in.close();
		
		toVF(text);
	}
	
	/**
	 * converts BrainFuck program to VerboseFuck
	 * @param BrainFuck Program
	 */
	public static void toVF(String s){
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("run:" + runBF(100," ++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."));
		System.out.print("Done");

	}

}
