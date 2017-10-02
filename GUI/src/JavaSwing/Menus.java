package JavaSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Menus {

	JFrame ventana;
	JPanel contenedor;
	JMenuBar barraMenu;
	JMenu menuColores;
	JMenuItem rojo, azul, verde, negrita, cursiva, normal;
	JTextField txtTexto;
	JButton btnSalir;
	Font f;
	
	public Menus() {
		definirVentana();
		definirMenu();
		definirContenedor();
		definirElementos();
		controlEventos();
		
		ventana.setVisible(true);
	}
	
	public void definirVentana() {
		ventana = new JFrame("Menus");
		ventana.setBounds(0, 0, 350, 200);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void definirMenu() {
		barraMenu = new JMenuBar();
		menuColores = new JMenu("Colores");
		
		barraMenu.add(menuColores);
		
		rojo = new JMenuItem("Rojo");
		azul = new JMenuItem("Azul");
		verde = new JMenuItem("Verde");
		negrita = new JMenuItem("Negrita");
		cursiva = new JMenuItem("Cursiva");
		normal = new JMenuItem("Normal");
		
		/*rojo.setActionCommand("red");
		azul.setActionCommand("blue");
		verde.setActionCommand("green");*/
		
		rojo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenedor.setBackground(Color.red);
				txtTexto.setForeground(Color.red);
			}
		});
		azul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenedor.setBackground(Color.blue);
				txtTexto.setForeground(Color.blue);
			}
		});
		verde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenedor.setBackground(Color.green);
				txtTexto.setForeground(Color.green);
			}
		});
		negrita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new Font("Arial", Font.BOLD, 12);
				txtTexto.setFont(f);
			}
		});
		cursiva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new Font("Arial", Font.ITALIC, 12);
				txtTexto.setFont(f);
			}
		});
		normal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new Font("Arial", Font.PLAIN, 12);
				txtTexto.setFont(f);
			}
		});
		
		menuColores.add(rojo);
		menuColores.add(azul);
		menuColores.add(verde);
		menuColores.add(new JSeparator());
		menuColores.add(negrita);
		menuColores.add(cursiva);
		menuColores.add(normal);
		
		ventana.setJMenuBar(barraMenu);
	}
	
	public void definirContenedor() {
		contenedor = new JPanel();
		contenedor.setLayout(null);
		ventana.getContentPane().add(contenedor);	
	}
	
	public void definirElementos() {
		txtTexto = new JTextField();
		txtTexto.setBounds(5, 5, 325, 30);
		contenedor.add(txtTexto);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(115, 60, 100, 30);
		contenedor.add(btnSalir);
	}
	
	public void controlEventos() {
		btnSalir.addActionListener(new accionSalir());
	}
	
	/*public class escuchandoColor implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			if(comando.equals("blue"));
				System.out.println("Funciona");
		}
	}*/
	
	public class accionSalir implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Menus m = new Menus();
	}
}
