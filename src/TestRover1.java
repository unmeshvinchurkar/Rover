import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import plateau.PlateauDimensions;
import rover.Rover;

public class TestRover1 {

	private static PlateauDimensions plateauDim;

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
		//System.out.println("calling  getPlateau()");
		getPlateauDimentions();

		BufferedReader br = null;
		try {

			while (true) {

				System.out.println("Enter rover's coordinates and heading");
				br = new BufferedReader(new InputStreamReader(System.in));
				String input = br.readLine().trim();

				StringTokenizer st = new StringTokenizer(input, " ");
				Integer xLocation = Integer.valueOf(st.nextToken());
				Integer yLocation = Integer.valueOf(st.nextToken());
				String heading = st.nextToken();

				System.out.println("Enter instructions: ");
				input = br.readLine().trim();

				Rover rov = new Rover(xLocation, yLocation, heading);
				rov.setDimentions(plateauDim);
				System.out
						.println("___________________________________________");
				System.out.println("Rover's new coordinates: "
						+ rov.moveRover(input));

				System.out.println("\n\n\n");
			}
		}

		catch (IOException e) {
			System.out.println("Error in reading input from console");
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
	}

}
