package instruction;

import java.util.List;

public interface InstructionFactory {
	 Instruction getInstruction(String instruction);
	 List<Instruction> getInstructions(String instructions);
}
