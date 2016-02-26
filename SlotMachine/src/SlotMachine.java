import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;

public class SlotMachine {

	protected Shell shlSlotMachine;
	private Text txt_credits;
	private Text txt_bet;
	private Text txt_paid;

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
		txt_credits.setBounds(10, 261, 76, 21);
		
		txt_bet = new Text(shlSlotMachine, SWT.BORDER);
		txt_bet.setBounds(105, 261, 76, 21);
		
		txt_paid = new Text(shlSlotMachine, SWT.BORDER);
		txt_paid.setBounds(200, 261, 76, 21);
		
		Label lblSuperSlot = new Label(shlSlotMachine, SWT.NONE);
		lblSuperSlot.setBounds(174, 10, 65, 15);
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
		btnBetOne.setBounds(162, 326, 55, 25);
		btnBetOne.setText("BET ONE");
		
		Button btnBetMax = new Button(shlSlotMachine, SWT.NONE);
		btnBetMax.setBounds(223, 326, 64, 25);
		btnBetMax.setText("BET MAX");
		
		Button btnSpin = new Button(shlSlotMachine, SWT.NONE);
		btnSpin.setBounds(325, 288, 75, 43);
		btnSpin.setText("SPIN");
		
		Canvas canvas = new Canvas(shlSlotMachine, SWT.NONE);
		canvas.setBounds(20, 51, 100, 100);
		
		Canvas canvas_1 = new Canvas(shlSlotMachine, SWT.NONE);
		canvas_1.setBounds(161, 51, 100, 100);
		
		Canvas canvas_2 = new Canvas(shlSlotMachine, SWT.NONE);
		canvas_2.setBounds(300, 51, 100, 100);
		
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
