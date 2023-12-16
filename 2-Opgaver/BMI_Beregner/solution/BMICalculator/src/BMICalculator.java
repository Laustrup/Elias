
public class BMICalculator {
	
	/**
	 * Calculates the BMI value
	 * @param weight The weight of the person in kilos
	 * @param height The height of the person in meters
	 * @return The calculated BMI Value
	 */
	public double calculate(int weight, double height) {
		return weight / Math.pow(height, 2);
	}
	
	public String decideStatus(double bmi) {
		String status = "your are ";
		
		if (bmi <= 18)
			status += "underweight";
		else if (bmi < 25)
			status += "normal weight";
		else
			status += "overweight";
		
		return status;
	}
}