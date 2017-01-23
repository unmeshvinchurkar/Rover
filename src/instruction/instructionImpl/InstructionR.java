package instruction.instructionImpl;


import rover.Rover;
import instruction.Instruction;

/*
 * Spins rover 90 degrees right.
 */
public class InstructionR implements Instruction {	
	public void executeInstruction(Rover rover) {
		Integer headDirection = rover.getHeadDirection();
		headDirection = (headDirection - 90) >= 0 ? (headDirection - 90)
				: (headDirection - 90 + 360);
		rover.setHeadDirection(headDirection);
	}
}
