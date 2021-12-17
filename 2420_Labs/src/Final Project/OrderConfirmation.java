package pizzaMenu;
/**
 * @author Garrett Knight
 * CSIS 2420
 * Final Project Pizza Menu
 * This class informs the user that their order has been placed
 */
import java.awt.*;
import javax.swing.*;

public class OrderConfirmation {

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	
	OrderConfirmation(String customerName){
		
		welcomeLabel.setBounds(0,0,2000,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText(customerName + ", your pizza will be ready for pickup in 30 minutes.");
		welcomeLabel.setBackground(Color.YELLOW);
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
