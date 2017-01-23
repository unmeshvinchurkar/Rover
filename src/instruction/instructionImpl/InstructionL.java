package instruction.instructionImpl;

import rover.Rover;
import instruction.Instruction;

public class InstructionL implements Instruction {
	
	/*
	 * Spins rover 90 degrees left.
	 */
	
	public void executeInstruction(Rover rover) {
		Integer headDirection = rover.getHeadDirection();
		headDirection = (headDirection + 90) % 360;
		rover.setHeadDirection(headDirection);
	}
}
