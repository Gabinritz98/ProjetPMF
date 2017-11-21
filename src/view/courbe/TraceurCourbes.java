package view.courbe;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TraceurCourbes extends JFrame {

    private Courbe courbe;

    public TraceurCourbes(){
        super("Courbe");
        this.setSize(500, 500);

        this.courbe=new Courbe();

        this.getContentPane().add(this.courbe);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (int i=0; i<100; i++) {
            int y = i*i - 16*i;
            this.courbe.ajouterPoint(new Point(i,y));
        }

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });


    }

}