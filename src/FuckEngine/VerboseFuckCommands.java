/**
 * 
 */
package FuckEngine;

/**
 * @author Peter
 *
 */
public class VerboseFuckCommands {

	final static String NEXT = ("math.equation(pointer = pointer + void(1));");
	final static String PREVIOUS = ("math.equation(pointer = pointer - void(1));");
	final static String PLUS = ("math.equation(deref(pointer) = (deref(pointer) + byte(1)):binaryand:byte(255));");
	final static String MINUS = ("math.equation(deref(pointer) = (deref(pointer) - byte(1)):binaryand:byte(255));");
	final static String OUTPUT = ("program.console.standardoutput.stream.writeunbufferedchars(array.create(1, conversion.changedatatype(deref(pointer), types.character, conversion.method.binary)), 0, 1);");
	final static String INPUT = ("math.equation(deref(pointer) = programcode(conversion.changedatatype(program.console.standardoutput.stream.readunbufferedchars(1).getvalue(0), types.byte)));");
	final static String LEFT = ("define(defines.label, defines.label.createnew());\nconditional(block.if, boolean.inequality(deref(pointer), byte(0))) {");
	final static String RIGHT = ("};\nconditional(block.if, boolean.inequality(deref(pointer), byte(0))) { program.flow.labeledjump(defines.label.last()); };\nundefine(defines.label, defines.label.last());");
	final static String BEGIN = "program.initialize();\n"
			+ "math.equation(program.errors.handler.activated = boolean(false));\n"
			+ "program.console.standardinput.openstream();\n"
			+ "program.console.standardoutput.openstream();\n"
			+ "define(defines.variable, variable(pointer));\n"
			+ "implanttype(pointer, types.pointer(to:types.byte));\n"
			+ "math.equation(pointer = void(0));\n"
			+ "program.memory.allocate(pointer, void(math.infinity), program.memory.memorytype.bidirectional);";
	final static String END = "program.memory.deallocate(pointer, void(math.infinity), program.memory.memorytype.bidirectional);\n"
			+ "undefine(defines.variable, variable(pointer));\n"
			+ "program.console.standardoutput.closestream();\n"
			+ "program.console.standardinput.closestream();\n"
			+ "program.terminate();";
	final static String COMMENT_START = " ~!comment!~";
	final static String COMMENT_END = "~!uncomment!~";
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
