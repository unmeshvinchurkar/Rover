package movingStrategy;

import instruction.InstructionFactory;
import rover.Rover;

/*
 * This class defines a contract
 * for implementing Rover's move startegy.
 * 
 */

public interface MovingStrategy {
	/*
	 * Move rover according to the given instructions
	 */
	String moveRover(String instruction);

	/*
	 * Set rover
	 */
	void setRover(Rover rover);

	/*
	 * Get rover
	 */
	Rover getRover();

	/*
	 * Set Instruction factory for converting instruction string into a
	 * collection of instruction objects
	 */
	void setInstructionFactory(InstructionFactory factory);
}
