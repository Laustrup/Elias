import java.util.Scanner;

public class Program {
	
	private BMICalculator calculator = new BMICalculator();

	public void start() {
		int weight;
		double height;
		String input;
		
		System.out.println("\tWelcome\n\n");
		
		while (true) {
			while (true) {
				System.out.println("Type your weight");
				try {
					input = new Scanner(System.in).nextLine();
					weight = Integer.parseInt(input);
					break;
				} catch (Exception e) {
					System.out.print("\tThat is not a weight!\n");
				}
			}
			
			while (true) {
				System.out.println("Type your height in meters");
				try {
					input = new Scanner(System.in).nextLine();
					height = Double.parseDouble(input);
					break;
				} catch (Exception e) {
					System.out.print("\tThat is not a height!\n");
				}
			}
			
			double bmi = calculator.calculate(weight, height);
			System.out.println("\nYour BMI is " + bmi + " and " + calculator.decideStatus(bmi));
			
			promptForExit();
		}
	}
	
	private void promptForExit() {
		System.out.println("\nWish to stop the program? Type y");
		if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
			System.out.print("\n\tThe system will now shut down...");
			System.exit(0);
		}
	}
	
/*
	
	Hvis der indtastes forkert, hvad skal terminalen så sige?
*/
}
