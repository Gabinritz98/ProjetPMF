package common.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import common.IFrigo;
import common.IModel;
import common.IObservableMV;
import common.IObserverMV;

public class panelDebug extends JFrame implements IObserverMV
{
/**
	 * 
	 */
	private static final long serialVersionUID = 5208506376873633580L;

static panelDebug thepanelDebug;

JPanel pnPanel0;
JTable tbTable0;
JSlider sdSlider0;
JSpinner spnSpinner0;

public panelDebug(IObservableMV model) 
{
   super( "DebugInterface" );
   try {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   model.SetListenerMV(this);
   pnPanel0 = new JPanel();
   GridBagLayout gbPanel0 = new GridBagLayout();
   GridBagConstraints gbcPanel0 = new GridBagConstraints();
   pnPanel0.setLayout( gbPanel0 );

   String [][]dataTable0 = new String[][] { new String[] {"11", "21"}, 
                                            new String[] {"12", "22"}, 
                                            new String[] {"13", "23"} };
   String []colsTable0 = new String[] { "Donnée", "Valeur" };
   DefaultTableModel dtm = new DefaultTableModel();
   //dtm.addc
   tbTable0 = new JTable( dataTable0, colsTable0 );
   gbcPanel0.gridx = 1;
   gbcPanel0.gridy = 1;
   gbcPanel0.gridwidth = 18;
   gbcPanel0.gridheight = 11;
   gbcPanel0.fill = GridBagConstraints.BOTH;
   gbcPanel0.weightx = 1;
   gbcPanel0.weighty = 1;
   gbcPanel0.anchor = GridBagConstraints.NORTH;
   gbPanel0.setConstraints( tbTable0, gbcPanel0 );
   pnPanel0.add( tbTable0 );

   sdSlider0 = new JSlider( );
   sdSlider0.setValue( 3 );
   gbcPanel0.gridx = 1;
   gbcPanel0.gridy = 13;
   gbcPanel0.gridwidth = 18;
   gbcPanel0.gridheight = 1;
   gbcPanel0.fill = GridBagConstraints.BOTH;
   gbcPanel0.weightx = 1;
   gbcPanel0.weighty = 0;
   gbcPanel0.anchor = GridBagConstraints.NORTH;
   gbPanel0.setConstraints( sdSlider0, gbcPanel0 );
   pnPanel0.add( sdSlider0 );

   spnSpinner0 = new JSpinner( );
   gbcPanel0.gridx = 1;
   gbcPanel0.gridy = 15;
   gbcPanel0.gridwidth = 7;
   gbcPanel0.gridheight = 1;
   gbcPanel0.fill = GridBagConstraints.BOTH;
   gbcPanel0.weightx = 1;
   gbcPanel0.weighty = 0;
   gbcPanel0.anchor = GridBagConstraints.NORTH;
   gbPanel0.setConstraints( spnSpinner0, gbcPanel0 );
   pnPanel0.add( spnSpinner0 );

   setDefaultCloseOperation( EXIT_ON_CLOSE );

   setContentPane( pnPanel0 );
   pack();
   setVisible( true );
}

@Override
public void NotifyMV(IObservableMV observable) {
	IModel model = (IModel)observable;
	IFrigo frigo = model.getRawFrigo(0);
	String [][]dataTable = new String[][] { 
		new String[] {"Consigne"        , ""+frigo.getConsigne()}, 
        new String[] {"Hygrométrie"     , ""+frigo.getHygro()}, 
        new String[] {"Température ext.", ""+frigo.getTempExt()}, 
        new String[] {"Température int.", ""+frigo.getTempInt()}};
    //tbTable0.
} 
} 

