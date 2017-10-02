package JavaSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Contador {
	
	JFrame ventana; 
	JPanel contenedor;
	JLabel lblTexto; 
	JButton bntInc, btnDec, btnExit, btnComenzarEn;
	JTextField txtCaja;
	int num_veces = 1;
	
	public Contador() {
		definirVentana();
		definirContenedor();
		definirComponentes();
		controlarEventos();
		
		ventana.setVisible(true);
	}
	
	private void definirVentana() {
		ventana=new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Mejor Contador del mundo mundial");
		ventana.setBounds(0, 0, 300, 300);
		ventana.setLocationRelativeTo(null); //Centrar la ventana
	}
	
	private void definirContenedor() {
		contenedor=new JPanel();
		contenedor.setLayout(null);
		contenedor.setBackground(Color.CYAN);
		ventana.getContentPane().add(contenedor);
	}

	private void definirComponentes() {
		lblTexto=new JLabel("Cuando quieras empezamos");
		lblTexto.setBounds(20, 25, 250, 30);
		contenedor.add(lblTexto); //Añadir el elemento al contenedor JPanel
		
		bntInc=new JButton("Incrementar");
		bntInc.setBounds(20, 65, 250, 30);
		contenedor.add(bntInc);
		
		btnDec=new JButton("Poner a 0");
		btnDec.setBounds(20, 105, 250, 30);
		contenedor.add(btnDec);
		
		btnExit=new JButton("Salir");
		btnExit.setBounds(20, 145, 250, 30);
		contenedor.add(btnExit);

		txtCaja = new JTextField();
		txtCaja.setBounds(20, 185, 250, 30);
		contenedor.add(txtCaja); //Si no se añade el elemento al contador no se vera en la aplicacion
		
		btnComenzarEn = new JButton("Comenzar en");
		btnComenzarEn.setBounds(20, 225, 250, 30);
		contenedor.add(btnComenzarEn);
	}
	
	private void controlarEventos() {
		accionSalir sal = new accionSalir(); //Llamar a la clase accionSalir
		btnExit.addActionListener(sal); //Añadir al boton Salir la accion de la clase accionSalir
		/*btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});*/   //Crear el objeto ActionListener sin crear la clase (Clase Anonima)
		
		accionIncrementar inc = new accionIncrementar();
		bntInc.addActionListener(inc);
		
		accionPonerCero pcer = new accionPonerCero();
		btnDec.addActionListener(pcer);
		//btnDec.addActionListener(new accionPonerCero()); /Añadir la accion sin Instanciar un objeto de la clase
		
		btnComenzarEn.addActionListener(new accionEmpezarEn());
		txtCaja.addFocusListener(new accionEntrarCaja());
	}

	public class accionSalir implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	}
		
	public class accionIncrementar implements ActionListener{ //Declarar que se puede pulsar

		@Override
		public void actionPerformed(ActionEvent e) { //Que hace cuando se pulsa
			lblTexto.setText("Has pulsado " + num_veces + " veces");
			num_veces++;
		}
	}
	
	public class accionPonerCero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			lblTexto.setText("Contador de nuevo en 0");
			num_veces = 0;
			
		}
	}
	
	public class accionEmpezarEn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				num_veces = Integer.parseInt(txtCaja.getText());
				lblTexto.setText("Empezando desde " + num_veces + " veces");
			}catch(Exception error){
				JOptionPane.showMessageDialog(contenedor, "Introduce un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
				//Si no es un numero entero salta una ventanita de error
			}
		}
	}
	
	public class accionEntrarCaja implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			txtCaja.setBackground(Color.GRAY);
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			txtCaja.setBackground(Color.WHITE);
			
		}
		
	}
	
	
	public static void main(String[] args) { //Lanzar la aplicacion(Main)
		Contador e=new Contador();

	}

}
