package instruction.factory;

import java.util.ArrayList;
import java.util.List;

import instruction.Instruction;
import instruction.InstructionFactory;
import instruction.instructionImpl.InstructionL;
import instruction.instructionImpl.InstructionM;
import instruction.instructionImpl.InstructionR;

public class DefaultInstructionFactory implements InstructionFactory {	

	public DefaultInstructionFactory() {
	}

	public Instruction getInstruction(String instruction) {
		Instruction instruc = null;

		if (instruction != null && instruction.equalsIgnoreCase("M")) {
			instruc = new InstructionM();
		} else if (instruction != null && instruction.equalsIgnoreCase("L")) {
			instruc = new InstructionL();
		} else if (instruction != null && instruction.equalsIgnoreCase("R")) {
			instruc = new InstructionR();
		}

		return instruc;
	}

	public List<Instruction> getInstructions(String instructions) {

		List<Instruction> ints = new ArrayList<Instruction>();

		for (int i = 0; i < instructions.length(); i++) {
			Instruction ins = getInstruction(String.valueOf(instructions
					.charAt(i)));
			if (ins != null) {
				ints.add(ins);
			}
		}
		return ints;
	}

}
