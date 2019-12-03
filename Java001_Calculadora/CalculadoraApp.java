import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class App {
	private Text txtUnidades;
	private Text txtPrecio;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			App window = new App();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblUnidades = new Label(shell, SWT.NONE);
		lblUnidades.setFont(SWTResourceManager.getFont("Fixedsys", 9, SWT.NORMAL));
		lblUnidades.setBounds(125, 57, 55, 15);
		lblUnidades.setText("Unidades");
		
		Label lblPrecio = new Label(shell, SWT.NONE);
		lblPrecio.setFont(SWTResourceManager.getFont("Fixedsys", 9, SWT.NORMAL));
		lblPrecio.setBounds(125, 99, 55, 15);
		lblPrecio.setText("Precio");
		
		txtUnidades = new Text(shell, SWT.BORDER);
		txtUnidades.setBounds(203, 54, 76, 21);
		
		txtPrecio = new Text(shell, SWT.BORDER);
		txtPrecio.setBounds(203, 96, 76, 21);
		
		Label lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblResultado.setBounds(125, 198, 154, 33);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.setFont(SWTResourceManager.getFont("Fixedsys", 12, SWT.NORMAL));
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int u = Integer.parseInt(txtUnidades.getText());
				double p = Double.parseDouble(txtPrecio.getText());
				String txtResultado = Double.toString(u*p);
				
				if(u==0) {
					lblResultado.setText("ERROR");
				}else {
					lblResultado.setText(txtResultado + " €");
				}
				
			}
		});
		btnCalcular.setBounds(143, 141, 109, 33);
		btnCalcular.setText("CALCULAR");
		
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
