package FuckEngine;

public enum FuckCommands {
	
	NEXT('>',"math.equation(pointer = pointer + void(1));"),
	PREVIOUS('<',"math.equation(pointer = pointer - void(1));"),
	PLUS('+',"math.equation(deref(pointer) = (deref(pointer) + byte(1)):binaryand:byte(255));"),
	MINUS('-',"math.equation(deref(pointer) = (deref(pointer) - byte(1)):binaryand:byte(255));"),
	OUTPUT('.',"program.console.standardoutput.stream.writeunbufferedchars(array.create(1, conversion.changedatatype(deref(pointer), types.character, conversion.method.binary)), 0, 1);"),
	INPUT(',',"math.equation(deref(pointer) = programcode(conversion.changedatatype(program.console.standardoutput.stream.readunbufferedchars(1).getvalue(0), types.byte)));"),
	LEFT('[',"define(defines.label, defines.label.createnew());\nconditional(block.if, boolean.inequality(deref(pointer), byte(0))) {"),
	RIGHT(']',"};\nconditional(block.if, boolean.inequality(deref(pointer), byte(0))) { program.flow.labeledjump(defines.label.last()); };\nundefine(defines.label, defines.label.last());");

	private final char BrainFuckCommand;
	private final String VerboseFuckCommand;
	
	FuckCommands(char b, String v){
		BrainFuckCommand = b;
		VerboseFuckCommand = v;
	}
	
	/**
	 * 
	 * @return BrainFuck Command
	 */
	public char getBF(){
		return BrainFuckCommand;
	}
	 /**
	  * 
	  * @return VerboseFuck Command
	  */
	public String getVF(){
		return VerboseFuckCommand;
	}
}
