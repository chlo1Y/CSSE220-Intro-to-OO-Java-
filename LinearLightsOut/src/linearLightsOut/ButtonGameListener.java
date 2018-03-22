package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonGameListener implements ActionListener {
	
	public int numButtons;  // pass values from main to here
	public Button[] b;
	public int index;
	public JFrame myframe;
	
	public ButtonGameListener(int nButtons,Button[] buttons, int index, JFrame theFrame){
		this.numButtons=nButtons;
		this.b=buttons;
		this.index=index;
		this.myframe=theFrame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {  // this changes the text on the button. 
		if(this.index==0){  // if user click the left most button, it will only make two button change 
			this.b[index].changetext();
			this.b[index+1].changetext();
		}
		else if(this.index==this.numButtons-1){ // same thing here with the right most button
			this.b[index].changetext();
			this.b[index-1].changetext();
		}else{  
			// other than those two cases, when buttons are clicked, the neighbors' text will also change 
			this.b[index+1].changetext();
			this.b[index].changetext();
			this.b[index-1].changetext();
			
		}
		detectWin();  // detect if the player wins. 
	}
	
	public void detectWin(){   // check whether the player has win
		int counterO=0; // counterO and counterX keep track of numbers of O or X in the game 
		int counterX=0;
		for(int i=0; i<this.numButtons; i++){  
			if(this.b[i].getText().equals("O")){ 
				counterO++;
			}else{
				counterX++;
			}
		}
		if(counterO==this.numButtons || counterX==this.numButtons){ // if all the buttons have the same text 
			this.myframe.setTitle("You win"); // reset the title to win
		}
		else{
			this.myframe.setTitle("Linear Lights Out"); // if the user click on new Game, the title will change back. 
		}
	}
	
	

}
