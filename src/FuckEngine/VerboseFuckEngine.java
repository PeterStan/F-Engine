package FuckEngine;
import java.io.File;

/**
 * @author Peter
 *
 */
public class VerboseFuckEngine {

	private final static String BEGIN = "program.initialize();\n"
			+ "math.equation(program.errors.handler.activated = boolean(false));\n"
			+ "program.console.standardinput.openstream();\n"
			+ "program.console.standardoutput.openstream();\n"
			+ "define(defines.variable, variable(pointer));\n"
			+ "implanttype(pointer, types.pointer(to:types.byte));\n"
			+ "math.equation(pointer = void(0));\n"
			+ "program.memory.allocate(pointer, void(math.infinity), program.memory.memorytype.bidirectional);";
	private final static String END = "program.memory.deallocate(pointer, void(math.infinity), program.memory.memorytype.bidirectional);\n"
			+ "undefine(defines.variable, variable(pointer));\n"
			+ "program.console.standardoutput.closestream();\n"
			+ "program.console.standardinput.closestream();\n"
			+ "program.terminate();";
	private final static String COMMENT_START = " ~!comment!~";
	private final static String COMMENT_END = "~!uncomment!~";
	
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
		
		return s;
	}
	
	/**
	 * converts VerboseFuck program to BrainFuck
	 * @param VerboseFuck program in a file
	 */
	public static void toBF(File f){
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(END.length());

	}

}
