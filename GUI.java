package calc;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class GUI {
	//main gui window, where the user can select the type of graph they want to create
	//stays open, so multiple graph types can be selected at once, each in separate windows
	protected Shell shlSimplegraphs;

	//open the frame
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSimplegraphs.open();
		shlSimplegraphs.layout();
		while (!shlSimplegraphs.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlSimplegraphs = new Shell();
		shlSimplegraphs.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		shlSimplegraphs.setSize(420, 242);
		shlSimplegraphs.setText("SimpleGraphs");
		shlSimplegraphs.setLayout(null);
		
		Button LinearButton = new Button(shlSimplegraphs, SWT.NONE);
		LinearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					//open the graph window separately
					linear window = new linear();
					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		LinearButton.setBounds(10, 53, 90, 30);
		LinearButton.setText("Linear");
		
		Button QuadraticButton = new Button(shlSimplegraphs, SWT.NONE);
		QuadraticButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					quadratic window = new quadratic();
					window.open();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		QuadraticButton.setBounds(106, 53, 90, 30);
		QuadraticButton.setText("Quadratic");
		
		Button CubicButton = new Button(shlSimplegraphs, SWT.NONE);
		CubicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					cubic window = new cubic();
					window.open();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		CubicButton.setBounds(202, 53, 90, 30);
		CubicButton.setText("Cubic");
		
		Button LogButton = new Button(shlSimplegraphs, SWT.NONE);
		LogButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					logarithmic window = new logarithmic();
					window.open();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		LogButton.setBounds(298, 53, 90, 30);
		LogButton.setText("Logarithmic");
		
		//viewable domain/range info
		Label OutLbl = new Label(shlSimplegraphs, SWT.NONE);
		OutLbl.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		OutLbl.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		OutLbl.setBounds(69, 101, 272, 20);
		OutLbl.setText("Domain = [-20, 20], Range= [-20, 20]");
		
		//credits
		Label lblJackStHilaire = new Label(shlSimplegraphs, SWT.NONE);
		lblJackStHilaire.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		lblJackStHilaire.setText("Jack St. Hilaire - 2020");
		lblJackStHilaire.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblJackStHilaire.setBounds(138, 165, 137, 20);
		
		Label lblNewLabel = new Label(shlSimplegraphs, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblNewLabel.setBounds(125, 10, 144, 36);
		lblNewLabel.setText("SimpleGraphs");

	}
}


