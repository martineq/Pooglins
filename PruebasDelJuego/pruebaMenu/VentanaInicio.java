package pruebaMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class VentanaInicio extends JFrame{
	JPanel panel = new JPanel();
	JPanel panelNivel = new JPanel();
	JButton btJugar = new JButton("Jugar");
	//JButton btNivel = new JButton("Elejir nivel");
	JButton btSalir = new JButton("Salir");
	JButton btCargarNivel = new JButton("Cargar Nivel");
	private int numeroDeNivel;
	
	
	public int getNumeroDeNivel() {
		return numeroDeNivel;
	}

	public VentanaInicio() {
		this.setSize(300, 200);
		this.setResizable(false);
		MouseParaMenu oyenteMenu = new MouseParaMenu(this);	
		
		btJugar.addMouseListener(oyenteMenu);
	//	btNivel.addMouseListener(oyenteMenu);
		btSalir.addMouseListener(oyenteMenu);
		btCargarNivel.addMouseListener(oyenteMenu);
		
		panel.add(btJugar);
		panel.add(btCargarNivel);
		panel.add(btSalir);
		panel.setLayout(new GridLayout(4,1));
		
		 panelNivel.add (new Label ("Elejir Nivel:"));
		 JComboBox NumeroDenivel;
		  NumeroDenivel = new JComboBox ();
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
		
		  NumeroDenivel.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 numeroDeNivel = ((JComboBox)e.getSource()).getSelectedIndex();
			 }
		 });
		 
		 
		 
		 this.getContentPane().add(panel,BorderLayout.SOUTH);
		 this.getContentPane().add(panelNivel,BorderLayout.CENTER);
		
		this.setBackground(Color.black);
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
	
	
	
}


