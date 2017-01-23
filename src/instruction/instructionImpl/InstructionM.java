package instruction.instructionImpl;

import instruction.Instruction;
import rover.Rover;

/*
 * Moves rover one step forward
 * maintaining the same heading.
 */

public class InstructionM implements Instruction {

	private Integer moveStep = 1;

	public InstructionM() {
	}

	public InstructionM(Integer moveStep) {
		this.moveStep = moveStep;
	}	
	
	public void executeInstruction(Rover rover) {
		Integer tempX = rover.getXLocation() + (int) moveStep
				* ((int) Math.cos(rover.getHeadDirection() * (Math.PI / 180)));
		Integer tempY = rover.getYLocation() + (int) moveStep
				* ((int) Math.sin(rover.getHeadDirection() * (Math.PI / 180)));

		if (tempX >= 0 && tempX <= rover.getDimentions().getWidth()) {
			rover.setXLocation(tempX);
		}
		if (tempY >= 0 && tempY <= rover.getDimentions().getHeight()) {
			rover.setYLocation(tempY);
		}
	}
}