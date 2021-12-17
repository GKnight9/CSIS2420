package pizzaMenu;
/**
 * @author Garrett Knight
 * CSIS 2420
 * Final Project - Pizza Menu
 * This class contains the commands of the GUI Window
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class PizzaPriceFrame extends JFrame {
private static final long serialVersionUID = 1L;
private JFrame frame;
private JPanel pizzaPanel, centerPanel, pricePanel, checkBoxPanel, radioButtonPanel, radioButtonPanel2,
	textPanel, buttonPanel;
private final int FRAME_WIDTH = 300;
private final int FRAME_HEIGHT = 450;
private ButtonGroup group;
private JRadioButton smallButton, mediumButton, largeButton, xlargeButton, hButton, tButton, dButton, 
invisButton, invizButton;
private JCheckBox peppCheckBox, mushCheckBox, onionCheckBox, sausCheckBox;
private JTextField priceTextField, typeTextField;
JButton send = new JButton("Submit");
JButton reset = new JButton("Reset");
JLabel messageLabel = new JLabel();
HashMap<String,String> logininfo = new HashMap<String,String>();
private double price = 0.0;
private double topPrice = 0.0;
private double showPrice = 0.0;
private ActionListener listener = new PriceListener();
private ActionListener press = new PriceListener();


public PizzaPriceFrame() {
pizzaPanel = new JPanel();
pizzaPanel.setLayout(new BorderLayout(10, 10));
pizzaPanel.setBackground(Color.YELLOW);
createRadioButtonPanel();
createTextPanel();
createCheckBoxPanel();
createRadioButtonPanel2();
submitButton();
createPricePanel();
createCenterPanel();
pizzaPanel.add(centerPanel, BorderLayout.CENTER);
pizzaPanel.add(pricePanel, BorderLayout.SOUTH);
frame = new JFrame(" G'Knights Pizza");
frame.add(pizzaPanel, BorderLayout.CENTER);
frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setLocation(100, 100);
frame.setVisible(true);


messageLabel.setBounds(125,250,250,35);
messageLabel.setFont(new Font(null,Font.ITALIC,25));
}
private void createRadioButtonPanel() {
radioButtonPanel = new JPanel();
radioButtonPanel.setLayout(new GridLayout(4, 1));
radioButtonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Size "));
radioButtonPanel.setBackground(Color.ORANGE);
group = new ButtonGroup();
smallButton = new JRadioButton(" Small (10 Inch) ");
smallButton.setBackground(Color.ORANGE);
group.add(smallButton);
smallButton.addActionListener(listener);
radioButtonPanel.add(smallButton);
mediumButton = new JRadioButton(" Medium (12  Inch) ");
mediumButton.setBackground(Color.ORANGE);
group.add(mediumButton);
mediumButton.addActionListener(listener);
radioButtonPanel.add(mediumButton);
largeButton = new JRadioButton(" Large (14 Inch) ");
largeButton.setBackground(Color.ORANGE);
group.add(largeButton);
largeButton.addActionListener(listener);
radioButtonPanel.add(largeButton);
xlargeButton = new JRadioButton(" X-Large (16 Inch) ");
xlargeButton.setBackground(Color.ORANGE);
group.add(xlargeButton);
xlargeButton.addActionListener(listener);
radioButtonPanel.add(xlargeButton);
invisButton = new JRadioButton();
group.add(invisButton);
invisButton.addActionListener(listener);
}
private void createRadioButtonPanel2() {
radioButtonPanel2 = new JPanel();
radioButtonPanel2.setLayout(new GridLayout(3, 1));
radioButtonPanel2.setBorder(new TitledBorder(new EtchedBorder(), "Type of Crust"));
radioButtonPanel2.setBackground(Color.ORANGE);
group = new ButtonGroup();
hButton = new JRadioButton(" (H)Hand-tossed ");
hButton.setBackground(Color.ORANGE);
group.add(hButton);
hButton.addActionListener(listener);
radioButtonPanel2.add(hButton);
tButton = new JRadioButton(" (T) Thin-crust ");
tButton.setBackground(Color.ORANGE);
group.add(tButton);
tButton.addActionListener(listener);
radioButtonPanel2.add(tButton);
dButton = new JRadioButton(" (D) Deep-dish ");
dButton.setBackground(Color.ORANGE);
group.add(dButton);
dButton.addActionListener(listener);
radioButtonPanel2.add(dButton);
invizButton = new JRadioButton();
group.add(invizButton);
invizButton.addActionListener(listener);

}
private void createTextPanel() {
textPanel = new JPanel(); // the panel is not visible in output
textPanel.setLayout(new GridLayout(1, 1));
textPanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
textPanel.setBackground(Color.ORANGE);
textPanel.add(new JLabel(" Your Name: "));
typeTextField = new JTextField(12);

typeTextField.setFont(new Font("Serif", Font.BOLD, 12));
typeTextField.setEditable(true);
typeTextField.setForeground(Color.black);
typeTextField.setBackground(Color.WHITE);
typeTextField.setDisabledTextColor(Color.black);
typeTextField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
textPanel.add(typeTextField);
}
private void createCheckBoxPanel() {
checkBoxPanel = new JPanel();
checkBoxPanel.setLayout(new GridLayout(4, 1));
checkBoxPanel.setBackground(Color.ORANGE);
checkBoxPanel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));
peppCheckBox = new JCheckBox(" Pepperoni ");
peppCheckBox.setBackground(Color.ORANGE);
peppCheckBox.addActionListener(listener);
checkBoxPanel.add(peppCheckBox);
mushCheckBox = new JCheckBox(" Mushrooms ");
mushCheckBox.setBackground(Color.ORANGE);
mushCheckBox.addActionListener(listener);
checkBoxPanel.add(mushCheckBox);
onionCheckBox = new JCheckBox(" Onion ");
onionCheckBox.setBackground(Color.ORANGE);
onionCheckBox.addActionListener(listener);
checkBoxPanel.add(onionCheckBox);
sausCheckBox = new JCheckBox(" Sausage ");
sausCheckBox.setBackground(Color.ORANGE);
sausCheckBox.addActionListener(listener);
checkBoxPanel.add(sausCheckBox);
}

//Creating the panel at bottom and adding components
private void submitButton() {
buttonPanel = new JPanel(); // the panel is not visible in output
reset.setFocusable(false);
send.setFocusable(false);
buttonPanel.setBackground(Color.ORANGE);
 // Components Added using Flow Layout
send.addActionListener(press);
send.setBackground(new Color(0,153,0));
buttonPanel.add(send);
reset.addActionListener(press);
reset.setBackground(new Color(51,153,225));
buttonPanel.add(reset);
}
private void createPricePanel() {
pricePanel = new JPanel();
pricePanel.add(new JLabel("Your Price:"));
pricePanel.setBackground(new Color(153,102,0));
priceTextField = new JTextField(7);
priceTextField.setFont(new Font("Serif", Font.BOLD, 12));
priceTextField.setEditable(false);
priceTextField.setForeground(Color.red);
priceTextField.setBackground(Color.WHITE);
priceTextField.setDisabledTextColor(Color.red);
priceTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
pricePanel.add(priceTextField);
priceTextField.setText(" n/a Price");
}
private void createCenterPanel() {
centerPanel = new JPanel();
centerPanel.add(new JLabel("Welcome to G'Knights Pizza! "));
centerPanel.setBackground(Color.YELLOW);
centerPanel.add(radioButtonPanel);
centerPanel.add(checkBoxPanel);
centerPanel.add(radioButtonPanel2);
centerPanel.add(textPanel);
centerPanel.add(buttonPanel);
centerPanel.add(messageLabel, BorderLayout.SOUTH);
}
private class PriceListener implements ActionListener {
public void actionPerformed(ActionEvent event) {
topPrice = 0;
if (smallButton.isSelected()) {
price = 10.99;
} else if (mediumButton.isSelected()) {
price = 12.99;
} else if (largeButton.isSelected()) {
price = 14.99;
} else if (xlargeButton.isSelected()) {
	price = 16.99;
}
if (peppCheckBox.isSelected()) {
topPrice += 1.25;
}  if (mushCheckBox.isSelected()) {
topPrice += 1.25;
}  if (onionCheckBox.isSelected()) {
topPrice += 1.25;
}  if (sausCheckBox.isSelected()) {
	topPrice += 1.25;
}
if(event.getSource()== reset) {
		typeTextField.setText("");
		topPrice = 0;
		price = 0;
		peppCheckBox.setSelected(false);
		mushCheckBox.setSelected(false);
		onionCheckBox.setSelected(false);
		sausCheckBox.setSelected(false);
		invisButton.doClick();
		invizButton.doClick();
	}
if(event.getSource()== send) {
		
		String customerName = typeTextField.getText();
		messageLabel.setText("Thank you " + customerName + "!");
		messageLabel.setForeground(Color.green);	
		OrderConfirmation orderPage = new OrderConfirmation(customerName);
		
		}
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
showPrice = price + topPrice;
priceTextField.setText(" $" + showPrice);
}
});
}


}

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
PizzaPriceFrame pPF = new PizzaPriceFrame();
System.out.println("Run");
}
});
}
}
