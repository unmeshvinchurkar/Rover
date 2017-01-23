package plateau;

/*
 * This class encloses plateau dimensions
 * i.e. wigth and height
 * 
 */
public class PlateauDimensions {

	private Integer width;

	private Integer height;

	private static Integer DEFAULT_WIDTH = 10;

	private static Integer DEFAULT_HEIGHT = 10;

	public PlateauDimensions() {

		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;

	}

	public PlateauDimensions(Integer width, Integer height) {

		this.width = width;
		this.height = width;

	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

}
