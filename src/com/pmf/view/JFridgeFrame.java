package common.view;

import javax.swing.*;

public class JFridgeFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8152953576695182538L;

	JFridgeFrame() {
        super();
        this.setSize(800,600);
        this.add(new JFridgePanel());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("JFridge");
        this.validate();
        this.setVisible(true);
    }
}
