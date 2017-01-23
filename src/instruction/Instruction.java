package instruction;

import rover.Rover;

/*
 * This interface defines a contract
 * for implementing rover Instructions.
 * 
 */

public interface Instruction {
	/*
	 * This method executes instruction operation on rover.
	 */

	public void executeInstruction(Rover rover);
}
