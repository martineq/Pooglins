package srcMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;


@SuppressWarnings("serial")
public class VentanaInicio extends JFrame{
	private JPanel panel;
	private JPanel panelNivel;;
	private JButton btJugar;
	private JButton btSalir;
	private JButton btCargarNivel;
	private JLabel lbElejirNivel;
	private JComboBox NumeroDenivel;
	private int numeroDeNivel;
	private JPanel panelDeFondo;
	private String imagenDeFondo= "..//lospooglins//imagenes//fondoPantallaPrincipal.jpg";
	private BufferedImage imagen;
	
	public int getNumeroDeNivel() {
		return numeroDeNivel;
	}

	public VentanaInicio() {
		panel = new JPanel();
		panelNivel = new JPanel();
		btJugar = new JButton("Jugar");
		btSalir = new JButton("Salir");
		btCargarNivel = new JButton("Cargar Nivel");
		lbElejirNivel = new JLabel ("Elejir Nivel:");
		NumeroDenivel = new JComboBox ();
		setNombreArchivoImagen();

		
		this.setResizable(false);
		MouseParaMenu oyenteMenu = new MouseParaMenu(this);	
		
		btJugar.addMouseListener(oyenteMenu);
		btSalir.addMouseListener(oyenteMenu);
		btCargarNivel.addMouseListener(oyenteMenu);
		
		panel.add(btJugar);
		panel.add(btCargarNivel);
		panel.add(btSalir);
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(3,1));
		//panel.setLayout(new FlowLayout());
		
		lbElejirNivel.setForeground(Color.green);
		panelNivel.add (lbElejirNivel); 
		
		NumeroDenivel.addItem("Nivel 0");
		NumeroDenivel.addItem ("Nivel 1");
		NumeroDenivel.addItem ("Nivel 2");
		NumeroDenivel.addItem ("Nivel 3");
		NumeroDenivel.addItem ("Nivel 4");
		NumeroDenivel.addItem ("Nivel 5");
		NumeroDenivel.addItem ("Nivel 6"); 
		NumeroDenivel.addItem ("Nivel 7");
		NumeroDenivel.addItem ("Nivel 8");
		NumeroDenivel.addItem ("Nivel 9");
		
		panelNivel.add (NumeroDenivel); 
		panelNivel.setOpaque(false);
		
		NumeroDenivel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				numeroDeNivel = ((JComboBox)e.getSource()).getSelectedIndex();
			}
		});
		 
		panelDeFondo = new JPanel(new GridLayout(1,2));
	    
		panelDeFondo.setBorder(BorderFactory.createEmptyBorder(230,50,70,45));
	    panelDeFondo.setOpaque(false);
		
	    
	    panelDeFondo.add(panelNivel);
	    panelDeFondo.add(panel);
		ImageIcon icon = new ImageIcon(imagen);
	    //this.setContentPane(wrapInBackgroundImage(panelDeFondo, new ImageIcon( VentanaInicio.class.getResource(imagenDeFondo))));
	    this.setContentPane(wrapInBackgroundImage(panelDeFondo, icon));
	    this.pack();
	    
	    addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	
	}
	public void setNombreArchivoImagen() {
		try{
			InputStream in = new FileInputStream(this.imagenDeFondo);
		    JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
			this.imagen = decoder.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){
			System.out.println("No se reconoce la imagen o la ruta de acceso esta mal.");
		}			
	}
	
	public JPanel wrapInBackgroundImage(JComponent component, Icon backgroundIcon) {
	        return wrapInBackgroundImage(component, backgroundIcon,JLabel.TOP,JLabel.LEADING);
	}

	public JPanel wrapInBackgroundImage(JComponent component,
		 Icon backgroundIcon,
	     int verticalAlignment,
	     int horizontalAlignment) {
	   
		 component.setOpaque(false);
	     JPanel backgroundPanel = new JPanel(new GridBagLayout());
	     backgroundPanel.add(component, gbc);
	     JLabel backgroundImage = new JLabel(backgroundIcon);
	     backgroundImage.setPreferredSize(new Dimension(1,1));
	     backgroundImage.setMinimumSize(new Dimension(1,1));
	     backgroundImage.setVerticalAlignment(verticalAlignment);
	     backgroundImage.setHorizontalAlignment(horizontalAlignment);
	     backgroundPanel.add(backgroundImage, gbc);
	     return backgroundPanel;
	 }
	    
	private static final GridBagConstraints gbc;
	    static {
	        gbc = new GridBagConstraints();
	        gbc.gridx = 20;
	        gbc.gridy = 0;
	        gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.anchor = GridBagConstraints.NORTHWEST;
	}	
}


