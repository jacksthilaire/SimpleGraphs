package calc;
import java.io.*;

public class print {

	//print out the function and its' graph to a text file
	String printFromArr(char[][] input, char type, int a, int b, int c, int d) throws FileNotFoundException{
		
		//switch statement for the type of graph, updating the save file name format and the function's format
		String filename = "";
		String format = "";
		switch(type){
			default:
				filename = "sg-" + "linear-" + a + b + ".txt";
				format = "                                    y = " + a + "x + " + b;
				break;
			case 'Q':
				filename = "sg-" + "quadratic-" + a + b + c + ".txt";
				format = "                                y = " + a + "x^2 + " + b + "x + " + c;
				break;
			case 'C':
				filename = "sg-" + "cubic-" + a + b + c + d + ".txt";
				format = "                            y = " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d;
				break;
			case 'G':
				filename = "sg-" + "log-" + a + b + c + ".txt";
				format = "                                 y = " + a + " * log" + b + "(x) " + c;
				break;
		}
		
		//make a new output stream to a file, with the properly formatted name, then set the output to this
		PrintStream o = new PrintStream(new File(filename));
		System.setOut(o);
		
		//print the message above the graph, consisting of title and function
		System.out.println("                              --- Simple Graphs ---");
		System.out.println();								  
		System.out.println(format);
		
		//printing the graph out, D - [-20,20] , R - [-20,20]
		//for each line
		for(int i = 0; i < 41; i++){
			//for each char in that line
			for(int j = 0; j < 41; j++){
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		
		//return the file name to use for label
		return filename;
		
	}
	
	//setting up the grid lines for the graph
	char[][] updateGridLines(char[][] input){
		
		//copy input to temp, which will be returned
		char[][] temp = input;
		
		//set the origin, if no point is there
		if(temp[20][20] == ' '){
			temp[20][20] = '+';
		}
		
		//horizontal line at input[10][x]
		for(int i = 0; i < 41; i++){
			//if there is no point at that coordinate, and is not the origin
			if(temp[20][i] == ' ' && i != 20){
				temp[20][i] = '.';
			}
		}
		
		//vertical line at input[y][10]
		for(int j = 0; j < 41; j++){
			//if no point and not origin
			if(temp[j][20] == ' ' && j != 20){
				temp[j][20] = '.';
			}
		}
		
		return temp;
	}
	
	//create an empty two dimensional array, to hold a coordinate grid
	char[][] createArray(){
		
		//41 x 41 array, initialized as empty
		char[][] output = new char[41][41];
		
		//for each line
		for(int i = 0; i < 41; i++){
			//for each char in that line
			for(int j = 0; j < 41; j++){
				output[i][j] = ' ';
			}
					
		}
		return output;
	}
}
