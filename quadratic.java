package calc;

import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class quadratic {

	//quadratic graph creation window
	protected Shell shlSg;
	private Text a;
	private Text b;
	private Text c;

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSg.open();
		shlSg.layout();
		while (!shlSg.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shlSg = new Shell();
		shlSg.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		shlSg.setSize(261, 234);
		shlSg.setText("SG");
		
		Label title = new Label(shlSg, SWT.NONE);
		title.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		title.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		title.setBounds(54, 20, 157, 20);
		title.setText("y = ax^2 + bx + c ");
		
		a = new Text(shlSg, SWT.BORDER);
		a.setBounds(30, 58, 43, 26);
		
		b = new Text(shlSg, SWT.BORDER);
		b.setBounds(97, 58, 43, 26);
		
		c = new Text(shlSg, SWT.BORDER);
		c.setBounds(166, 58, 43, 26);
	
		Label lblA = new Label(shlSg, SWT.NONE);
		lblA.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblA.setBounds(10, 61, 14, 20);
		lblA.setText("a: ");
		
		Label lblB = new Label(shlSg, SWT.NONE);
		lblB.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblB.setText("b:");
		lblB.setBounds(79, 61, 12, 20);
		
		Label lblC = new Label(shlSg, SWT.NONE);
		lblC.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblC.setBounds(150, 61, 14, 20);
		lblC.setText("c: ");
		
		Label outputLbl = new Label(shlSg, SWT.NONE);
		outputLbl.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		outputLbl.setBounds(10, 139, 223, 20);
		
		Button graphBtn = new Button(shlSg, SWT.NONE);
		graphBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				//make printer and calculator objects, as well as the coordinates array, and a user input array
				print printer = new print();
				char[][] coordinates = printer.createArray();
				calc calculator = new calc();
				int[] userInput = new int[]{Integer.parseInt(a.getText()), Integer.parseInt(b.getText()), Integer.parseInt(c.getText())};
				
				//calculate the points, and create the gridlines 
				coordinates = calculator.calculateQuadratic(coordinates, userInput[0], userInput[1], userInput[2]);
				coordinates = printer.updateGridLines(coordinates);
		
				try {
					//print from the final array, and set the output label to the name of the text file that was saved
					outputLbl.setText("Graph Saved: " + printer.printFromArr(coordinates, 'Q', userInput[0], userInput[1], userInput[2], 0));
					
				} catch (FileNotFoundException e1) {
			
					e1.printStackTrace();
				}
				System.out.println();
			}
		});
		graphBtn.setBounds(74, 103, 90, 30);
		graphBtn.setText("Graph");
	}

}
