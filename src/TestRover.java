import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import plateau.PlateauDimensions;
import rover.Rover;

public class TestRover {

	private static PlateauDimensions plateauDim=null;

	/*
	 * This method reads plateau coordinates from
	 * the console 
	 * 
	 */

	private static void getPlateauDimentions() {

		BufferedReader br = null;

		try {
			System.out.println("Enter the Plateau coordinates:");
			br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();

			StringTokenizer st = new StringTokenizer(input, " ");

			Integer pX = Integer.parseInt(st.nextToken());
			Integer pY = Integer.parseInt(st.nextToken());
			plateauDim = new PlateauDimensions(pX, pY);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error in reading values from console");
			System.exit(0);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Wrong Input");
			System.exit(0);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}


	public static void main(String args[]) {

		java.util.List<Rover> roverList = new ArrayList<Rover>();
		java.util.List<String> iList = new ArrayList<String>();

		// Get plateau dimensions
		getPlateauDimentions();

		BufferedReader br = null;
		try {

			while (true) {

				System.out.println("Enter rover's coordinates and heading ("
						+ "enter z for running all rovers)");
				br = new BufferedReader(new InputStreamReader(System.in));
				String input = br.readLine().trim();

				// If uses presses z then exit out of loop and run all rovers

				if (input != null && input.trim().equalsIgnoreCase("z")) {
					break;
				}

				StringTokenizer st = new StringTokenizer(input, " ");

				// Get x location of rover
				Integer xLocation = Integer.valueOf(st.nextToken());

				// Get y location of rover
				Integer yLocation = Integer.valueOf(st.nextToken());

				// Get head direction of rover
				String heading = st.nextToken();

				//Get instruction string
				System.out.println("Enter instructions: ");
				input = br.readLine().trim();

				Rover rov = new Rover(xLocation, yLocation, heading);
				rov.setDimentions(plateauDim);

				//add rover to the list
				roverList.add(rov);
				iList.add(input);

				System.out.println("\n\n");
			}
		}

		catch (IOException e) {
			System.out.println("Error in reading the input from console");
		}

		catch (Exception e) {
			System.out.println("***** Wrong Input values *******");
		} finally {

			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (roverList.size() != 0) {
			System.out.println("__________________OUTPUT___________________");
		} else {
			System.out.println("NO ROVERS TO RUN");
		}

		// Run all rovers in sequence
		for (int i = 0; i < roverList.size(); i++) {
			System.out.println("Rover " + (i + 1) + ": "
					+ roverList.get(i).moveRover(iList.get(i)));
		}

	}

}
