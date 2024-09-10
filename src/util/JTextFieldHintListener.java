package util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JTextFieldHintListener implements FocusListener{
		private String mHindText;
	    private JTextField mTextField;
	    private JPasswordField txt;

	    public JTextFieldHintListener(JTextField textField, String hintText) {
	        this.mHindText = hintText;
	        this.mTextField = textField;
	        textField.setForeground(Color.GRAY);
	    }
	    @Override
	    public void focusGained(FocusEvent e) {
	        String temp = mTextField.getText();
	        if(temp.equals(mHindText)){
	            mTextField.setText("");
	            mTextField.setForeground(Color.BLACK);
	        }
	    }
	    @Override
	    public void focusLost(FocusEvent e) {
	        String temp = mTextField.getText();
	        if(temp.equals("")){
	            mTextField.setForeground(Color.GRAY);
	            mTextField.setText(mHindText);
	        }
	    }
}
