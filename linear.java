package calc;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class linear {

	//linear graph creation window
	protected Shell shlSg;
	private Text m;
	private Text b;

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
		title.setBounds(74, 20, 90, 20);
		title.setText("y = mx + b ");
		
		m = new Text(shlSg, SWT.BORDER);
		m.setBounds(54, 58, 43, 26);
		
		b = new Text(shlSg, SWT.BORDER);
		b.setBounds(138, 58, 43, 26);
		
		Label lblM = new Label(shlSg, SWT.NONE);
		lblM.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblM.setBounds(31, 61, 20, 20);
		lblM.setText("m: ");
		
		Label lblB = new Label(shlSg, SWT.NONE);
		lblB.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblB.setText("b:");
		lblB.setBounds(120, 61, 12, 20);
		
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
				int[] userInput = new int[]{Integer.parseInt(m.getText()), Integer.parseInt(b.getText())};
				
				//calculate the points, and create the gridlines 
				coordinates = calculator.calculateLinear(coordinates, userInput[0], userInput[1]);
				coordinates = printer.updateGridLines(coordinates);
		
				try {
					//print from the final array, and set the output label to the name of the text file that was saved
					outputLbl.setText("Graph Saved: " + printer.printFromArr(coordinates, 'L', userInput[0], userInput[1], 0, 0));
				
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
