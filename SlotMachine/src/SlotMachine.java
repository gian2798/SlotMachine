import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

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
	
	
	private Image immagine[] = new Image[9];
	private GC mycanvas;
	
	public class Gira extends Thread{
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					int n;
					int giri=0;
					for(int i=0;i<100 && giri<3;i++,giri++){
						n = (int) (Math.random() * 9);
						mycanvas.drawImage(immagine[n], 0, i );
						
					}
					//n = (int) (Math.random() * 9);
					
					//n = (int) (Math.random() * 9);
					
				}
			});
			try {
				Thread.sleep(80);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
			
		  }
	}
	
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
		shlSlotMachine.setBackgroundImage(SWTResourceManager.getImage("sfondo.jpg"));
		shlSlotMachine.setText("Slot Machine");
		
		txt_credits = new Text(shlSlotMachine, SWT.BORDER | SWT.CENTER);
		txt_credits.setFont(SWTResourceManager.getFont("Segoe Print", 10, SWT.NORMAL));
		txt_credits.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		txt_credits.setEditable(false);
		txt_credits.setBounds(10, 233, 76, 21);
		
		txt_bet = new Text(shlSlotMachine, SWT.BORDER | SWT.CENTER);
		txt_bet.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		txt_bet.setEditable(false);
		txt_bet.setBounds(104, 233, 76, 21);
		
		txt_paid = new Text(shlSlotMachine, SWT.BORDER | SWT.CENTER);
		txt_paid.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		txt_paid.setEditable(false);
		txt_paid.setBounds(200, 233, 76, 21);
		
		Label lblSuperSlot = new Label(shlSlotMachine, SWT.NONE);
		lblSuperSlot.setAlignment(SWT.CENTER);
		lblSuperSlot.setFont(SWTResourceManager.getFont("Segoe Marker", 12, SWT.BOLD));
		lblSuperSlot.setBounds(162, 10, 99, 21);
		lblSuperSlot.setText("Super Slot");
		
		Label lblCredits = new Label(shlSlotMachine, SWT.CENTER);
		lblCredits.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		lblCredits.setBounds(20, 288, 55, 15);
		lblCredits.setText("Credits");
		
		Label lblBet = new Label(shlSlotMachine, SWT.CENTER);
		lblBet.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		lblBet.setBounds(115, 288, 55, 15);
		lblBet.setText("Bet");
		
		Label lblWinnerPaid = new Label(shlSlotMachine, SWT.CENTER);
		lblWinnerPaid.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		lblWinnerPaid.setBounds(200, 288, 76, 15);
		lblWinnerPaid.setText("Winner Paid");
		
		Button btnBetOne = new Button(shlSlotMachine, SWT.NONE);
		btnBetOne.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(soldi<50){
					soldi=soldi+0.50;
					txt_credits.setText(String.valueOf(soldi));
				}else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Non puoi superare i 50!");
				}
				}
			});
			btnBetOne.setBounds(115, 326, 55, 25);
			btnBetOne.setText("BET ONE");
			
			Button btnBetMax = new Button(shlSlotMachine, SWT.NONE);
			btnBetMax.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(soldi<50){
						soldi=soldi+2.00;
						txt_credits.setText(String.valueOf(soldi));
				}else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Non puoi superare i 50!");
				}
				}
			});
			btnBetMax.setBounds(211, 326, 64, 25);
			btnBetMax.setText("BET MAX");
		
		Canvas canvas = new Canvas(shlSlotMachine, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		canvas.setBounds(61, 51, 300, 100);
		
		
		
		
		Image banana = new Image(null, "banana.jpg");
		Image anguria = new Image(null, "anguria.jpg");
		Image biscaro = new Image(null, "biscaro.jpg");
		Image collina = new Image(null, "collina.jpg");
		Image donald = new Image(null, "donaldtrum.jpg");
		Image frusca = new Image(null, "fruscalzo.jpeg");
		Image quadri = new Image(null, "quadrifoglio.jpg");
		Image regi = new Image(null, "reginato.jpg");
		Image zlata = new Image(null, "zlatan.jpg");
		
		immagine[0]=banana;
		immagine[1]=anguria;
		immagine[2]=biscaro;
		immagine[3]=collina;
		immagine[4]=donald;
		immagine[5]=frusca;
		immagine[6]=quadri;
		immagine[7]=regi;
		immagine[8]=zlata;
		
		Button btnSpin = new Button(shlSlotMachine, SWT.NONE);
		btnSpin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				GC mycanvas = new GC(canvas);
				if(soldi>0){
					soldi-=0.5;
					txt_credits.setText(String.valueOf(soldi));
					
					Thread thread = new Thread() {
						@Override
						public void run() {
							// lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));

							for (int i = 0; i < 7; i++) {
															
								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										int n;
										int giri=0;
										for(int i=0;i<100 && giri<3;i++,giri++){
											n = (int) (Math.random() * 9);
											mycanvas.drawImage(immagine[n], 0, i );
											
											n = (int) (Math.random() * 9);
											n = (int) (Math.random() * 9);
											mycanvas.drawImage(immagine[n], 100, i );
											
											n = (int) (Math.random() * 9);
											mycanvas.drawImage(immagine[n], 200, i );
										}
										//n = (int) (Math.random() * 9);
										
										//n = (int) (Math.random() * 9);
										
									}
								});
								try {
									Thread.sleep(250);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

						}

					};
					thread.start();
					
				}else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"Errore, inserisci dei soldi prima","Error",JOptionPane.WARNING_MESSAGE);
				}
			
					
			}
		});
		btnSpin.setBounds(325, 274, 75, 43);
		btnSpin.setText("SPIN");
		
		Button btnReset = new Button(shlSlotMachine, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GC mycanvas = new GC(canvas);
			
				soldi=0.00;
				txt_credits.setText(String.valueOf(soldi));
			}
		});
		btnReset.setBounds(20, 326, 55, 25);
		btnReset.setText("RESET");
		
		
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
