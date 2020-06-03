package calc;

public class main {
	//SimpleGraphs -  Input coefficients and get a .txt file graph
	//Jack St. Hilaire - 2020
	//D: [-20, 20] R: [-20, 20]
	//options: linear, quadratic, cubic, logarithmic
	//file names are in format sg-type-coefficients.txt, so graphs will be overwritten if they exist already
	//ex: y = 2x + 1 --> sg-linear-21.txt
	public static void main(String[] args){	
		//run the main program window
		try {
			GUI window = new GUI();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
