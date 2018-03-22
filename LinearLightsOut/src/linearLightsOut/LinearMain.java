
package linearLightsOut;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author <TODO: YOUR NAME HERE>. Created Jan 18, 2010.
 */
public class LinearMain {
	static double num;
	static String insideButton;

	
	

	/**
	 * Starts here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nButtonsString = JOptionPane
				.showInputDialog("How many buttons would you like?");
		int buttonSize=70;
		int nButtons = Integer.parseInt(nButtonsString);
		JFrame myFrame = new JFrame();
		myFrame.setSize((nButtons+1)* buttonSize, 120);// make a JFrame according to the 
		//number of Buttons
		myFrame.setTitle("Linear Lights Out!"); // set the title 
		
		
		JPanel buttonPanel= new JPanel(); // different panels for buttons and options 
		JPanel optionPanel= new JPanel();
		Button[] myButtons = new Button[nButtons]; // an arrayList of buttons 
        for(int i=0; i<nButtons; i++){
    		myButtons[i] = new Button(Math.random()>0.5?"O":"X"); // randomly generate text to buttons
    		
        	buttonPanel.add(myButtons[i]);// add buttons to panel 
    	}
        	
        for(int i=0; i<nButtons; i++){
        	myButtons[i].addActionListener(new ButtonGameListener(nButtons,myButtons, i, myFrame));
        	// add action Listener to buttons 
        }
        
        Button quitButton= new Button("quit");  // make a button for 'quit"
        quitButton.setSize(70, 50);
        class quitButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			myFrame.dispose(); // the frame disappear when user click on quit
				
			}
        	
        }
        quitButton.addActionListener(new quitButtonListener());// add actionListner to the quit button
        
        
        
        Button newGame= new Button("start a new game");  // start newgame Button
        newGame.setSize(70, 50);
        class startGameListener implements ActionListener{ // When the start New game button is pressed ,

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i<nButtons; i++){
					double a=Math.random();    // reassign texts on the button
					if (a<0.5){
					  myButtons[i].setText("O");
					}else{
					  myButtons[i].setText("x");
					}
				}
			}
        	
        }
        newGame.addActionListener(new startGameListener()); // add ActionListener to the Button
        optionPanel.add(quitButton);
        optionPanel.add(newGame);
        
        myFrame.add(buttonPanel, BorderLayout.NORTH);  //make the buttons with texts on the top of "New Game" and 'quit" button
        myFrame.add(optionPanel, BorderLayout.SOUTH);

		myFrame.setVisible(true);
	}
}
