package com.pmf.view.courbe;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TraceurCourbes extends JFrame {

    private Courbe courbe;

    public TraceurCourbes(){
        super("Courbe de température");
        this.setSize(500, 500);
        this.setLocation(700, 0);

        this.courbe=new Courbe();

        this.getContentPane().add(this.courbe);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (int i=0; i<99999; i++) {
            this.courbe.ajouterPoint(new Point(i*1, (i*0.1)+11));
        }

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });


    }

}