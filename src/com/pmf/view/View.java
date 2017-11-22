package com.pmf.view;

import com.pmf.IObservableMV;
import com.pmf.IObserverMV;
import com.pmf.model.Model;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class View extends JFrame implements IObserverMV{

    private JPanel contentPane;

    // temperature frigo
    private float tempFrigo = 0;
    public void setTempFrigo(float tempFrigo) { this.tempFrigo = tempFrigo; }
    public float getTempFrigo() { return tempFrigo; }

    // temperature ext
    private float tempExt = 0;
    public void setTempExt(float tempExt) { this.tempExt = tempExt; }
    public float getTempExt() { return tempExt; }

    // hygrometrie
    private float hygro = 0;
    public void setHygro(float hygro) { this.hygro = hygro; }
    public float getHygro() { return hygro; }

    // consigne
    private int consigne = 0;
    public void setConsigne(int consigne) { this.consigne = consigne; }
    public int getConsigne() { return consigne; }

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 320);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setTitle("Pimp My Fridge");
        this.setVisible(true);

    // LABELS
        // LABEL TITLE
        JLabel lbl_Title = new JLabel("FRIDGE MANAGER");
        lbl_Title.setFont(new Font("Roboto", Font.PLAIN, 24));
        lbl_Title.setBounds(155, 16, 202, 20);
        contentPane.add(lbl_Title);

        // LABEL STATUT
        JLabel lbl_Statut = new JLabel("Aucun probl\u00E8me");
        lbl_Statut.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Statut.setForeground(new Color(0, 200, 83));
        lbl_Statut.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_Statut.setBounds(0, 70, 496, 20);
        contentPane.add(lbl_Statut);

        // LABEL TEMPERATURE EXTERIEURE
        JLabel lbl_TempExt = new JLabel("Temp\u00E9rature ext\u00E9rieure");
        lbl_TempExt.setFont(new Font("Roboto", Font.PLAIN, 14));
        lbl_TempExt.setBounds(20, 150, 160, 20);
        contentPane.add(lbl_TempExt);

        // LABEL TEMPERATURE FRIGO
        JLabel lbl_TempFrigo = new JLabel("Temp\u00E9rature dans le frigo");
        lbl_TempFrigo.setFont(new Font("Roboto", Font.PLAIN, 14));
        lbl_TempFrigo.setBounds(20, 110, 160, 20);
        contentPane.add(lbl_TempFrigo);

        // LABEL HUMIDITE
        JLabel lbl_Humid = new JLabel("Humidit\u00E9 dans le frigo");
        lbl_Humid.setFont(new Font("Roboto", Font.PLAIN, 14));
        lbl_Humid.setBounds(260, 110, 140, 20);
        contentPane.add(lbl_Humid);

        // LABEL TEMPERATURE CONSIGNE
        JLabel lbl_TempTarget = new JLabel("Temp\u00E9rature consigne");
        lbl_TempTarget.setFont(new Font("Roboto", Font.PLAIN, 14));
        lbl_TempTarget.setBounds(260, 150, 140, 20);
        contentPane.add(lbl_TempTarget);

        // LABEL CONSIGNE
        JLabel lbl_TempTargetDeg = new JLabel("\u00B0C");
        lbl_TempTargetDeg.setForeground(Color.BLACK);
        lbl_TempTargetDeg.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_TempTargetDeg.setBounds(450, 152, 16, 14);
        contentPane.add(lbl_TempTargetDeg);

        // SEPARATEUR
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        separator.setBackground(Color.BLACK);
        separator.setBounds(0, 52, 512, 2);
        contentPane.add(separator);


    // VALEURS + ACTIONS
        setTempFrigo(15);
        setTempExt(15);
        setHygro(50);

        // VALEUR TEMPERATURE FRIGO
        String tempFrigo = String.valueOf(getTempFrigo());
        JLabel lbl_TempFrigoVal = new JLabel(tempFrigo + "\u00B0C");
        lbl_TempFrigoVal.setForeground(Color.RED);
        lbl_TempFrigoVal.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_TempFrigoVal.setBounds(186, 113, 50, 14);
        contentPane.add(lbl_TempFrigoVal);

        // VALEUR TEMPERATURE EXTERIEUR
        String tempExt = String.valueOf(getTempExt());
        JLabel lbl_TempExtVal = new JLabel(tempExt + "\u00B0C");
        lbl_TempExtVal.setForeground(Color.RED);
        lbl_TempExtVal.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_TempExtVal.setBounds(186, 153, 50, 14);
        contentPane.add(lbl_TempExtVal);

        // VALEUR HYGROMETRIE
        String hygro = String.valueOf(getHygro());
        JLabel lbl_Hygro = new JLabel(hygro + "%");
        lbl_Hygro.setForeground(Color.RED);
        lbl_Hygro.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_Hygro.setBounds(406, 112, 50, 14);
        contentPane.add(lbl_Hygro);

        // VALEUR TEMPERATURE CONSIGNE
        JSpinner spinner_TempTarget = new JSpinner();
        spinner_TempTarget.setModel(new SpinnerNumberModel(new Integer(10), new Integer(0), new Integer(30), new Integer(1)));
        spinner_TempTarget.setFont(new Font("Roboto", Font.PLAIN, 12));
        spinner_TempTarget.setBounds(406, 150, 40, 20);
        spinner_TempTarget.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int val = (int)spinner_TempTarget.getValue();
                setConsigne(val);
                if (val == 15) {
                    lbl_Statut.setText("valeur 15");
                } else {
                    lbl_Statut.setText("valeur pas 15");
                }
            }
        });
        contentPane.add(spinner_TempTarget);

        // BOUTON ASSIGNATION TEMPERATURE CONSIGNE
        JButton btn_SetTarget = new JButton("ASSIGNER LA CONSIGNE");
        btn_SetTarget.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lbl_Statut.setText("consigne assignée");
            }
        });
        btn_SetTarget.setForeground(Color.WHITE);
        btn_SetTarget.setFont(new Font("Roboto", Font.BOLD, 12));
        btn_SetTarget.setBackground(Color.BLACK);
        btn_SetTarget.setBounds(265, 205, 182, 40);
        contentPane.add(btn_SetTarget);

        // BOUTON STOP
        JButton btn_Stop = new JButton("STOP");
        btn_Stop.setForeground(Color.WHITE);
        btn_Stop.setFont(new Font("Roboto", Font.BOLD, 12));
        btn_Stop.setBackground(Color.BLACK);
        btn_Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lbl_Statut.setText("arrêté");
            }
        });
        btn_Stop.setBounds(66, 205, 80, 40);
        contentPane.add(btn_Stop);
    }

    @Override
    public void NotifyMV(IObservableMV observable) {
        Model.getModelInstance().SetListenerMV(this);
        this.setTempFrigo(((Model)observable).getRawFrigo(0).getTempInt());
        this.setTempExt(((Model)observable).getRawFrigo(0).getTempExt());
        this.setHygro(((Model)observable).getRawFrigo(0).getHygro());
    }
}
