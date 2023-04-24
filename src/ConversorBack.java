import java.text.DecimalFormat;

public class ConversorBack {
	private double vDolar = 0.05553;
	private double vLibra = 0.0446;
	private double vEuro = 0.0505;
	private double vYen = 7.435;
	private double vWon = 9.932;
	
	public String conversion(double cantidad, double factor) {
		DecimalFormat f = new DecimalFormat("#.####");
		
		return f.format(cantidad*factor);
	}

	public double getvDolar() {
		return vDolar;
	}

	public double getvLibra() {
		return vLibra;
	}

	public double getvEuro() {
		return vEuro;
	}

	public double getvYen() {
		return vYen;
	}

	public double getvWon() {
		return vWon;
	}
	
	
}
