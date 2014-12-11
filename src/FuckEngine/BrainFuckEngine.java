package FuckEngine;
import java.io.File;

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
		int[] cell = new int[cells];
		int pointer = 0;
		for(int l = 0; l < p.length()-1; l++){ 
			switch(p.charAt(l)){
				case FuckCommands.NEXT.getBF():
					break;
				case FuckCommands.PREVIOUS.getBF():
					break;
				case FuckCommands.PLUS.getBF():
					break;
				case FuckCommands.MINUS.getBF():
					break;
				case FuckCommands.OUTPUT.getBF():
					break;
				case FuckCommands.INPUT.getBF():
					break;
				case FuckCommands.OUTPUT.getBF():
					break;
				case FuckCommands.LEFT.getBF():
					break;
				case FuckCommands.RIGHT.getBF():
					break;
				default:
					break;
			}
			
		}
		
		
		
		
		return p;
	}
	
	
	/**
	 * converts BrainFuck program to VerboseFuck 
	 * @param BrainFuck program
	 */
	public static void toVF(File f){
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runBF(3,"...");

	}

}
