public class SalaryCalculator {
	public double calcHours(int P1, int P2, int salary) {
		if (salary <= P1 * 200) {
			return (double) salary / P1;
		} else {
			return 200 + (salary - P1 * 200.0) / P2;
		}
	}
}
