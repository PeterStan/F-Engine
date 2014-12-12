package FuckEngine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
	public static String runBF(int cells, String p){
		byte[] array = new byte[cells];
		int pointer = 0; String print = "";
		Scanner scan = new Scanner(System.in);
		
		for(int l = 0; l < p.length(); l++){ 
			switch(p.charAt(l)){
				case '>':
						pointer++;
					break;
				case '<':
						pointer--;
					break;
				case '+':
						array[pointer]++;
					break;
				case '-':
						array[pointer]--;
					break;
				case '.':
						print += (char)(array[pointer]);
					break;
				case ',':
						array[pointer] = (byte) scan.next().charAt(0);
					break;
				case '[':
					break;
				case ']':
					break;
				default:
					break;
			}
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
		System.out.println("run:" + runBF(3,",."));
		System.out.print("Done");

	}

}
