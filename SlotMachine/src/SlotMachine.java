import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

public class SlotMachine {

	protected Shell shlSlotMachine;
	private Text txt_credits;
	private Text txt_bet;
	private Text txt_paid;
	private double soldi;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SlotMachine window = new SlotMachine();
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
		createContents();
		shlSlotMachine.open();
		shlSlotMachine.layout();
		while (!shlSlotMachine.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSlotMachine = new Shell();
		shlSlotMachine.setSize(450, 400);
		//shlSlotMachine.setBackgroundImage(SWTResourceManager.getImage(""));
		shlSlotMachine.setText("Slot Machine");
		
		txt_credits = new Text(shlSlotMachine, SWT.BORDER);
		txt_credits.setBounds(10, 233, 76, 21);
		
		txt_bet = new Text(shlSlotMachine, SWT.BORDER);
		txt_bet.setBounds(104, 233, 76, 21);
		
		txt_paid = new Text(shlSlotMachine, SWT.BORDER);
		txt_paid.setBounds(200, 233, 76, 21);
		
		Label lblSuperSlot = new Label(shlSlotMachine, SWT.NONE);
		lblSuperSlot.setAlignment(SWT.CENTER);
		lblSuperSlot.setFont(SWTResourceManager.getFont("Segoe Marker", 12, SWT.BOLD));
		lblSuperSlot.setBounds(162, 10, 99, 21);
		lblSuperSlot.setText("Super Slots");
		
		Label lblCredits = new Label(shlSlotMachine, SWT.NONE);
		lblCredits.setBounds(20, 288, 55, 15);
		lblCredits.setText("Credits");
		
		Label lblBet = new Label(shlSlotMachine, SWT.NONE);
		lblBet.setBounds(115, 288, 55, 15);
		lblBet.setText("Bet");
		
		Label lblWinnerPaid = new Label(shlSlotMachine, SWT.NONE);
		lblWinnerPaid.setBounds(200, 288, 76, 15);
		lblWinnerPaid.setText("Winner Paid");
		
		Button btnReset = new Button(shlSlotMachine, SWT.NONE);
		btnReset.setBounds(20, 326, 55, 25);
		btnReset.setText("RESET");
		
		Button btnPlayTable = new Button(shlSlotMachine, SWT.NONE);
		btnPlayTable.setBounds(81, 326, 75, 25);
		btnPlayTable.setText("PLAY TABLE");
		
		Button btnBetOne = new Button(shlSlotMachine, SWT.NONE);
		btnBetOne.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				soldi=soldi+0.50;
				txt_credits.setText(String.valueOf(soldi));
				}
			});
			btnBetOne.setBounds(162, 326, 55, 25);
			btnBetOne.setText("BET ONE");
			
			Button btnBetMax = new Button(shlSlotMachine, SWT.NONE);
			btnBetMax.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					soldi=soldi+2.00;
					txt_credits.setText(String.valueOf(soldi));
				}
			});
			btnBetMax.setBounds(223, 326, 64, 25);
			btnBetMax.setText("BET MAX");
		
		Canvas canvas = new Canvas(shlSlotMachine, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		canvas.setBounds(61, 51, 300, 100);
		
		
		ArrayList immagini = new ArrayList();
		
		Image banana = new Image(null, "banana.jpg");
		Image anguria = new Image(null, "anguria.jpg");
		Image biscaro = new Image(null, "biscaro.jpg");
		Image collina = new Image(null, "collina.jpg");
		Image donald = new Image(null, "donaldtrum.jpg");
		Image frusca = new Image(null, "fruscalzo.jpeg");
		Image quadri = new Image(null, "quadrifoglio.jpg");
		Image regi = new Image(null, "reginato.jpg");
		Image zlata = new Image(null, "zlatan.jpg");
		
		immagini.add(banana);
		immagini.add(anguria);
		immagini.add(biscaro);
		immagini.add(collina);
		immagini.add(donald);
		immagini.add(frusca);
		immagini.add(quadri);
		immagini.add(regi);
		immagini.add(zlata);
		
		Button btnSpin = new Button(shlSlotMachine, SWT.NONE);
		btnSpin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GC mycanvas = new GC(canvas);
				
				/*class scorri extends Thread{
					public void run() {
					 for (int i = 0; i < 10; i++) {
					 System.out.println(i + " " +
					 getName());
					 try {
					 sleep((int)(Math.random()*
					 1000));
					 } catch (InterruptedException e){}
					 }
					 System.out.println("DONE! " +
					 getName());
					 }
				}*/
					
			}
		});
		btnSpin.setBounds(325, 274, 75, 43);
		btnSpin.setText("SPIN");
		
		
		
		/*public void loadImages() {
        images.add(createImageIcon("images/Banana.png", "Banana"));
        images.add(createImageIcon("images/Bar.png", "Bar"));
        images.add(createImageIcon("images/Bell.png", "Bell"));
        images.add(createImageIcon("images/Cherry.png", "Cherry"));
        images.add(createImageIcon("images/Clover.png", "Clover"));
        images.add(createImageIcon("images/Diamond.png", "Diamond"));
        images.add(createImageIcon("images/Plum.png", "Plum"));
        images.add(createImageIcon("images/Seven.png", "Seven"));
        images.add(createImageIcon("images/Watermelon.png", "Watermelon"));
    }
*/
		

	}
}
