package movingStrategy.startegyImpl;

import java.util.List;

import instruction.Instruction;
import instruction.factory.DefaultInstructionFactory;
import instruction.InstructionFactory;
import rover.Rover;
import movingStrategy.MovingStrategy;

/*
 * This is a default implementation of
 * interface MovingStrategy.
 * 
 */

public class DefaultMovingStrategy implements MovingStrategy {

	private Rover rover = null;	
	private InstructionFactory factory=null;

	public DefaultMovingStrategy(Rover rover) {
		this.rover = rover;
		factory=new DefaultInstructionFactory();
	}
	
	public DefaultMovingStrategy(Rover rover,InstructionFactory factory) {
		this.rover = rover;
		this.factory=factory;
	}

	public String moveRover(String instructionLine) {
		if (instructionLine != null && instructionLine.trim().length() != 0) {
			 
			List<Instruction> instructs = factory
					.getInstructions(instructionLine.trim());
			for (Instruction inst : instructs) {
				inst.executeInstruction(rover);
			}
		}
		return "" + rover.getXLocation() + rover.getYLocation()
				+ rover.getHeadDirectionString();
	}
	
	public Rover getRover() {
		return rover;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}	

	public void setInstructionFactory(InstructionFactory factory) {
		this.factory = factory;
	}
}
