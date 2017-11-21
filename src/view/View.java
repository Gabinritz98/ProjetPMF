package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;

public class View extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View frame = new View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 320);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setTitle("Pimp My Fridge");

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
        lbl_Humid.setBounds(250, 110, 140, 20);
        contentPane.add(lbl_Humid);

        // LABEL TEMPERATURE CONSIGNE
        JLabel lbl_TempTarget = new JLabel("Temp\u00E9rature consigne");
        lbl_TempTarget.setFont(new Font("Roboto", Font.PLAIN, 14));
        lbl_TempTarget.setBounds(250, 150, 140, 20);
        contentPane.add(lbl_TempTarget);

        // VALEUR TEMPERATURE FRIGO
        JLabel lbl_TempFrigoVal = new JLabel("10\u00B0C");
        lbl_TempFrigoVal.setForeground(Color.RED);
        lbl_TempFrigoVal.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_TempFrigoVal.setBounds(196, 113, 34, 14);
        contentPane.add(lbl_TempFrigoVal);

        // VALEUR TEMPERATURE EXTERIEUR
        JLabel lbl_TempExtVal = new JLabel("10\u00B0C");
        lbl_TempExtVal.setForeground(Color.RED);
        lbl_TempExtVal.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_TempExtVal.setBounds(196, 153, 34, 14);
        contentPane.add(lbl_TempExtVal);

        // VALEUR HUMIDITE
        JLabel lbl_HumidVal = new JLabel("100%");
        lbl_HumidVal.setForeground(Color.RED);
        lbl_HumidVal.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_HumidVal.setBounds(406, 112, 40, 14);
        contentPane.add(lbl_HumidVal);

        // LABEL CONSIGNE
        JLabel lbl_TempTargetDeg = new JLabel("\u00B0C");
        lbl_TempTargetDeg.setForeground(Color.BLACK);
        lbl_TempTargetDeg.setFont(new Font("Roboto", Font.BOLD, 16));
        lbl_TempTargetDeg.setBounds(450, 152, 16, 14);
        contentPane.add(lbl_TempTargetDeg);

        // VALEUR TEMPERATURE CONSIGNE
        JSpinner spinner_TempTarget = new JSpinner();
        spinner_TempTarget.setModel(new SpinnerNumberModel(new Integer(10), null, null, new Integer(1)));
        spinner_TempTarget.setFont(new Font("Roboto", Font.PLAIN, 12));
        spinner_TempTarget.setBounds(406, 150, 40, 20);
        contentPane.add(spinner_TempTarget);

        // SEPARATEUR
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        separator.setBackground(Color.BLACK);
        separator.setBounds(0, 52, 512, 2);
        contentPane.add(separator);

        // BOUTON ASSIGNATION TEMPERATURE CONSIGNE
        JButton btn_SetTarget = new JButton("ASSIGNER LA CONSIGNE");
        btn_SetTarget.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }
        });
        btn_Stop.setBounds(66, 205, 80, 40);
        contentPane.add(btn_Stop);

        btn_Stop.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_Statut.setText("clicked");
            }
        });

    }
}
