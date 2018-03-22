package linearLightsOut;

import javax.swing.JButton;

public class Button extends JButton {
	String insideButton;
	
	
	// assign text to buttons. 
	public Button(String insideButton2) {
		this.insideButton=insideButton2;
		this.setText(insideButton);
	}
	
	// this make it easier for the button to change text 
	public void changetext(){
		if(this.getText()=="O"){
			this.setText("X");
			
		}else{
			this.setText("O");
		}
		
	}

}
