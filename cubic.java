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

public class cubic {

	//cubic graph creation window
	protected Shell shlSg;
	private Text a;
	private Text b;
	private Text c;
	private Text d;

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
		shlSg.setSize(308, 234);
		shlSg.setText("SG");
		
		Label title = new Label(shlSg, SWT.NONE);
		title.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		title.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		title.setBounds(55, 21, 183, 20);
		title.setText("y = ax^3 + bx^2 + cx + d format");
		
		a = new Text(shlSg, SWT.BORDER);
		a.setBounds(26, 58, 43, 26);
		
		b = new Text(shlSg, SWT.BORDER);
		b.setBounds(97, 58, 43, 26);
		
		c = new Text(shlSg, SWT.BORDER);
		c.setBounds(163, 58, 43, 26);
	
		d = new Text(shlSg, SWT.BORDER);
		d.setBounds(228, 58, 43, 26);
		
		Label lblA = new Label(shlSg, SWT.NONE);
		lblA.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblA.setBounds(10, 61, 14, 20);
		lblA.setText("a: ");
		
		Label lblB = new Label(shlSg, SWT.NONE);
		lblB.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblB.setText("b:");
		lblB.setBounds(75, 61, 12, 20);
		
		Label lblC = new Label(shlSg, SWT.NONE);
		lblC.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblC.setBounds(146, 61, 14, 20);
		lblC.setText("c: ");
		
		Label lblD = new Label(shlSg, SWT.NONE);
		lblD.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblD.setText("d: ");
		lblD.setBounds(212, 61, 14, 20);
		
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
				int[] userInput = new int[]{Integer.parseInt(a.getText()), Integer.parseInt(b.getText()), Integer.parseInt(c.getText()), Integer.parseInt(d.getText())};
				
				//calculate the points, and create the gridlines 
				coordinates = calculator.calculateCubic(coordinates, userInput[0], userInput[1], userInput[2], userInput[3]);
				coordinates = printer.updateGridLines(coordinates);
		
				try {
					//print from the final array, and set the output label to the name of the text file that was saved
					outputLbl.setText("Graph Saved: " + printer.printFromArr(coordinates, 'C', userInput[0], userInput[1], userInput[2], userInput[3]));
				
				} catch (FileNotFoundException e1) {
			
					e1.printStackTrace();
				}
				System.out.println();
			}
		});
		graphBtn.setBounds(107, 103, 90, 30);
		graphBtn.setText("Graph");
	}
}
