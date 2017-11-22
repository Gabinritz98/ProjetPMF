package com.pmf.view.courbe;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Courbe extends JPanel {

    private Vector<Point> listePoints=new Vector<Point>();
    private double xMin=Double.MAX_VALUE;
    private double yMin=Double.MAX_VALUE;
    private double xMax=Double.MIN_VALUE;
    private double yMax=Double.MIN_VALUE;

    private int largeur=0;
    private int hauteur=0;
    private int left=10;
    private int top=10;

    public Courbe(){

    }

    public void ajouterPoint(Point p){
        if(p.getX()<this.xMin)
            this.xMin=p.getX();
        else if(p.getX()>this.xMax)
            this.xMax=p.getX();

        yMin = 0;
        yMax = 30;

        this.listePoints.add(p);

        this.repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }

    public void paint(Graphics g){
        super.paint(g);

        g.drawString("Température", 40,30);
        g.drawString("Temps", 40, getHeight()-20);

        double y0 = getHeight()-36;
        double ymx = 45;
        double yinterval = (y0-ymx)/yMax;

        for (int i=0; i<(yMax+1); i++) {
            if (i==0) { g.drawString("" + i,15, (int)y0); }
            if (i==yMax) { g.drawString("" + i, 15, (int)ymx); }
            else { g.drawString("" + i,15, (int)(y0 -(i*yinterval))); }
        }
        this.largeur=this.getWidth()-80;
        this.hauteur=this.getHeight()-80;
        this.left=40;
        this.top=40;

        g.setColor(Color.WHITE);
        g.fillRect(this.left, this.top, this.largeur, this.hauteur);

        g.setColor(Color.RED);
        if(this.listePoints.size()==1){
            int x=this.left+(this.largeur/2);
            int y=this.top+(this.hauteur/2);
            g.drawLine(x-2, y, x+2, y);
            g.drawLine(x, y-2, x, y+2);
        } else {
            for(int i=0; i<this.listePoints.size()-1; i++){
                Point p1=this.convertirPointSurReferenciel(this.listePoints.get(i));
                Point p2=this.convertirPointSurReferenciel(this.listePoints.get(i+1));
                int x1=(int)p1.getX();
                int y1=(int)p1.getY();
                int x2=(int)p2.getX();
                int y2=(int)p2.getY();

                g.setColor(Color.BLUE);
                g.drawLine(x1, y1, x2, y2);

                g.setColor(Color.RED);
                g.drawLine(x1-4, y1, x1+4, y1);
                g.drawLine(x1, y1-4, x1, y1+4);
            }

            Point p1=this.convertirPointSurReferenciel(this.listePoints.get(this.listePoints.size()-1));
            int x1=(int)p1.getX();
            int y1=(int)p1.getY();
            g.drawLine(x1-4, y1, x1+4, y1);
            g.drawLine(x1, y1-4, x1, y1+4);
        }
    }

    public Point convertirPointSurReferenciel(Point p){
        double amplitudeX=this.xMax-this.xMin;
        double amplitudeY=this.yMax-this.yMin;

        double rapportX=this.largeur/amplitudeX;
        double rapportY=this.hauteur/amplitudeY;

        double x=(p.getX()-this.xMin)*rapportX;
        double y=(p.getY()-this.yMin)*rapportY;

        y=this.hauteur-y;

        x=x+this.left;
        y=y+this.top;

        return new Point(x, y);
    }
}