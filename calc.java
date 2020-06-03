package calc;

public class calc {
	//for each type of graph, take the input coefficients, and calculate the Y value at every X, -20 to 20
	//return the grid with plotted points
	
	//LINEAR
	char[][] calculateLinear(char[][] input, int m, int b){
		
		char[][] output = input;
		
		for(int i = -20; i <= 20; i++){
			int y = 0;
			y = (i * m) + b;
			
			if(y <= 20 && y >= -20){
				output[20 - y][20 + i] = 'x';
			}
		}
		
		return output;
	}

	//QUADRATIC
	char[][] calculateQuadratic(char[][] input, int a, int b, int c){
		
		char[][] output = input;
		
		for(int i = -20; i <= 20; i++){
			int y = 0;
			y = ((i * i) * a) + (b * i) + c;
			
			if(y <= 20 && y >= -20){
				output[20 - y][20 + i] = 'x';
			}
		}
		
		return output;
	}
	
	//CUBIC
	char[][] calculateCubic(char[][] input, int a, int b, int c, int d){
		
		char[][] output = input;
			
		for(int i = -20; i <= 20; i++){
			int y = 0;
			y = ((i * i * i) * a) + (b * (i * i)) + (c * i) + d;
				
			if(y <= 20 && y >= -20){
					output[20 - y][20 + i] = 'x';
			}
		}
			
		return output;
	}
	
	//LOGARITHMIC
	char[][] calculateLogarithmic(char[][] input, int a, int b, int c){
		
		char[][] output = input;
				
		for(int i = 0; i <= 20; i++){
			int y = 0;
			double theLog = 0;
				
			theLog = Math.round((a * (Math.log(i) / Math.log(b)) + c ));
			y = (int) Math.round((a * theLog) + c);
				
			if(y <= 20 && y >= -20){
				output[20 - y][20 + i] = 'x';
			}
		}
				
		return output;
	}
				
}
