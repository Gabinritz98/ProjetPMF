package common.view;

import javax.swing.*;
import java.awt.*;

public class JFridgePanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1948807608936900819L;
	private JLabel temp;
    private JLabel humi;

    JFridgePanel() {
        super();

        this.temp = new JLabel("0");
        this.humi = new JLabel("0");

        this.setLayout(new GridLayout(2,2));
        this.add(new JLabel("Temperature:"));
        this.add(temp);
        this.add(new JLabel("Humidity:"));
        this.add(humi);
    }
}
