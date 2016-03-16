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
	private Text txt_paid;
	private double soldi;
	private int n=1,m=2,b=3;
	private int c=0;
	
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
	
	public void Vincita(Image immagine[],int b,int n,int m){
		double soldi1 = 0; 
		soldi1 = soldi1+soldi;
		if(soldi == 0){
			soldi1=1;
		}
		if(immagine[n] == immagine[0] && immagine[m] == immagine[0] && immagine[b] == immagine[0]){
			soldi1=soldi1+soldi1*1.5;
			txt_paid.setText(String.valueOf(soldi1));
	
		}
		if(immagine[n] == immagine[1] && immagine[m] == immagine[1] && immagine[b] == immagine[1]){
			soldi1=soldi1+soldi1*2;
			txt_paid.setText(String.valueOf(soldi1));
			
		}
		if(immagine[n] == immagine[2] && immagine[m] == immagine[2] && immagine[b] == immagine[2]){
			soldi1=soldi1+soldi1*10;
			txt_paid.setText(String.valueOf(soldi));
			
		}
		if(immagine[n] == immagine[3] && immagine[m] == immagine[3] && immagine[b] == immagine[3]){
			soldi1=soldi1+soldi1*4;
			txt_paid.setText(String.valueOf(soldi1));
			
		}
		if(immagine[n] == immagine[4] && immagine[m] == immagine[4] && immagine[b] == immagine[4]){
			soldi1=soldi1+soldi1*15;
			txt_paid.setText(String.valueOf(soldi1));
			
		}
		if(immagine[n] == immagine[5] && immagine[m] == immagine[5] && immagine[b] == immagine[5]){
			soldi1=soldi1+soldi1*12;
			txt_paid.setText(String.valueOf(soldi1));
			
		}
		if(immagine[n] == immagine[6] && immagine[m] == immagine[6] && immagine[b] == immagine[6]){
			soldi1=soldi1+soldi1*5;
			txt_paid.setText(String.valueOf(soldi1));
			
		}
		if(immagine[n] == immagine[7] && immagine[m] == immagine[7] && immagine[b] == immagine[7]){
			soldi1=0;
			soldi=0;
			txt_paid.setText(String.valueOf(soldi1));
			txt_credits.setText(String.valueOf(soldi));
		}
		if(immagine[n] == immagine[8] && immagine[m] == immagine[8] && immagine[b] == immagine[8]){
			soldi1=soldi1+soldi1*20;
			txt_paid.setText(String.valueOf(soldi1));
			
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
		txt_credits.setBounds(34, 228, 76, 21);
		
		txt_paid = new Text(shlSlotMachine, SWT.BORDER | SWT.CENTER);
		txt_paid.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		txt_paid.setEditable(false);
		txt_paid.setBounds(162, 228, 76, 21);
		
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
		
		
		Button btnSpin = new Button(shlSlotMachine, SWT.NONE);
		btnSpin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				c=0;
				if(soldi>0){
					btnSpin.setEnabled(false);
					btnReset.setEnabled(false);
					btnBetMax.setEnabled(false);
					btnBetOne.setEnabled(false);
				}
				GC mycanvas = new GC(canvas);
				if(soldi>0){
					soldi-=0.5;
					txt_credits.setText(String.valueOf(soldi));
					btnSpin.setEnabled(false);
						Thread thread = new Thread() {
							@Override
							public void run() {
	
								for (int i = 0; i < 7; i++) {
																
									Display.getDefault().asyncExec(new Runnable() {
										public void run() {
											
											int giri=0;
											for(int i=0;i<100 && giri<3;i++,giri++){
												n = (int) (Math.random() * 9);
												mycanvas.drawImage(immagine[n], 0, i );
												
												m = (int) (Math.random() * 9);
												m = (int) (Math.random() * 9);
												mycanvas.drawImage(immagine[m], 100, i );
												
												b = (int) (Math.random() * 9);
												mycanvas.drawImage(immagine[b], 200, i );
												
												
											}
											
											
										}
									});
									try {
										Thread.sleep(200);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}

								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										
										c = 1;
										if(c==1){
											btnSpin.setEnabled(true);
											btnReset.setEnabled(true);
											btnBetMax.setEnabled(true);
											btnBetOne.setEnabled(true);
										}
											
											
										
										
										
									}
								});
								
	
							}
	
						};
						thread.start();
						
				}else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"Errore, inserisci dei soldi prima","Error",JOptionPane.WARNING_MESSAGE);
				}
				Vincita(immagine,b,n,m);
				
			}
			
		});
		btnSpin.setBounds(325, 274, 75, 43);
		btnSpin.setText("SPIN");
		
		
		
		

	}
}
