import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class GUI implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	
	private JLabel passwordLengthLabel;
	
	private JTextField generatedPasswordField;
	private JTextField passwordLengthField;
	
	private JButton generatePasswordButton;
	
	private JCheckBox alphabetCheckbox;
	private JCheckBox numbersCheckbox;
	private JCheckBox goofyCharactersCheckbox;
	
	private GUI() {
		frame = new JFrame();
		
		generatedPasswordField = new JTextField("");
		generatedPasswordField.setEditable(false);
		
		passwordLengthLabel = new JLabel("password length");
		
		passwordLengthField = new JTextField("10");
		
		generatePasswordButton = new JButton("generate password");
		generatePasswordButton.addActionListener(this);
		
		alphabetCheckbox = new JCheckBox("letters");
		alphabetCheckbox.addActionListener(this);
		
		numbersCheckbox = new JCheckBox("numbers");
		numbersCheckbox.addActionListener(this);
		
		goofyCharactersCheckbox = new JCheckBox("goofy characters");
		goofyCharactersCheckbox.addActionListener(this);
		
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(passwordLengthLabel);
		panel.add(passwordLengthField);
		panel.add(alphabetCheckbox);
		panel.add(numbersCheckbox);
		panel.add(goofyCharactersCheckbox);
		panel.add(generatePasswordButton);
		panel.add(generatedPasswordField);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("pasowrd gneartor");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String s = e.getActionCommand();
		
	    switch (s) {
	    	case "generate password":
	    		generatedPasswordField.setText(DaShit.GeneratePassword(Integer.parseInt(passwordLengthField.getText())));
	    		break;

	    	case "letters":
	    		DaShit.useAlphabet = alphabetCheckbox.isSelected();
	    		break;
	    		
	    	case "numbers":
	    		DaShit.useNumbers = numbersCheckbox.isSelected();
	    		break;
	    		
	    	case "goofy characters":
	    		DaShit.useGoofyCharacters = goofyCharactersCheckbox.isSelected();
	    		break;
	    }
	}
}