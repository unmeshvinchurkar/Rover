package rover;

import plateau.PlateauDimensions;
import movingStrategy.MovingStrategy;
import movingStrategy.startegyImpl.DefaultMovingStrategy;
import common.Constants;

/*
 * This class defines rover.
 * 
 */

public class Rover {
	// X coordinate of rover
	private Integer xLocation;

	// Y coordinate of rover
	private Integer yLocation;

	/*
	 * Head direction of rover in degrees If North then 90 If West then 180 If
	 * South then 270 If East then 0
	 */
	private Integer headDirection;

	// Dimensions of plateau on which moves
	private PlateauDimensions dimentions;

	// This interface defines the Move startegy of rover
	private MovingStrategy movingStrategy = null;

	public Rover() {
		xLocation = 0;
		yLocation = 0;
		headDirection = Constants.HEADING_NORTH;
		dimentions = new PlateauDimensions();
		movingStrategy = new DefaultMovingStrategy(this);
	}

	public Rover(Integer xLocation, Integer yLocation, String headDirection) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.setHeadDirectionString(headDirection);
		dimentions = new PlateauDimensions();
		movingStrategy = new DefaultMovingStrategy(this);
	}

	/*
	 * This method is used to move rover 
	 * @return String New coordinates for rover
	 */

	public String moveRover(String instruction) {
		return movingStrategy.moveRover(instruction);
	}

	/* Get head direction of the rover as degrees.
	 * Example 270 degrees for South direction
	 */
	public Integer getHeadDirection() {
		return headDirection;
	}

	/*
	 * Get head direction of the rover as String
	 * Example N for north
	 */
	public String getHeadDirectionString() {

		String direction = "";

		if (headDirection.equals(Constants.HEADING_EAST)) {
			direction = "E";
		}

		else if (headDirection.equals(Constants.HEADING_NORTH)) {
			direction = "N";
		}

		else if (headDirection.equals(Constants.HEADING_SOUTH)) {
			direction = "S";
		}

		else if (headDirection.equals(Constants.HEADING_WEST)) {
			direction = "W";
		}

		return direction;
	}

	/*
	 * Set head direction of the rover as String
	 * direction String (N,S,E or W)
	 */

	public void setHeadDirectionString(String direction) {

		if (direction != null && direction.trim().length() != 0) {

			if (direction.equalsIgnoreCase("E")) {
				this.headDirection = Constants.HEADING_EAST;
			}

			else if (direction.equalsIgnoreCase("N")) {
				this.headDirection = Constants.HEADING_NORTH;
			}

			else if (direction.equalsIgnoreCase("W")) {
				this.headDirection = Constants.HEADING_WEST;
			}

			else if (direction.equalsIgnoreCase("S")) {
				this.headDirection = Constants.HEADING_SOUTH;
			}
		}
	}

	public void setHeadDirection(Integer headDirection) {
		this.headDirection = headDirection;
	}

	public Integer getXLocation() {
		return xLocation;
	}

	public void setXLocation(Integer location) {
		xLocation = location;
	}

	public Integer getYLocation() {
		return yLocation;
	}

	public void setYLocation(Integer location) {
		yLocation = location;
	}

	public PlateauDimensions getDimentions() {
		return dimentions;
	}

	public void setDimentions(PlateauDimensions dimentions) {
		this.dimentions = dimentions;
	}

	
	public MovingStrategy getMovingStrategy() {
		return movingStrategy;
	}

	public void setMovingStrategy(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
		movingStrategy.setRover(this);
	}
}
