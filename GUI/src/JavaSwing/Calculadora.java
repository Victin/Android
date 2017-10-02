package JavaSwing;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora {
	
	JFrame ventana;
	JPanel contenedor;
	JLabel lblNum1, lblNum2, lblResultado;
	JButton btnSumar, btnRestar, btnDividir, btnMultiplicar, btnSalir;
	JTextField txtNum1, txtNum2, txtResultado;
	int num1, num2, resultado;
	
	public Calculadora() {
		definirVentana();
		definirContenedor();
		definirComponentes();
		controlarEventos();
		
		ventana.setVisible(true);
	}
	
	public void definirVentana() {
		ventana = new JFrame();
		ventana.setTitle("Calculadora");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(0, 0, 300, 350);
		ventana.setLocationRelativeTo(null);
	}
	
	public void definirContenedor() {
		contenedor = new JPanel();
		contenedor.setLayout(null);
		contenedor.setBackground(Color.GRAY);
		ventana.getContentPane().add(contenedor);
	}
	
	public void definirComponentes() {
		lblNum1 = new JLabel();
		lblNum1.setText("Numero 1");
		lblNum1.setBounds(20, 25, 100, 30);
		contenedor.add(lblNum1);
		
		txtNum1  = new JTextField();
		txtNum1.setBounds(100, 25, 150, 30);
		contenedor.add(txtNum1);
		
		lblNum2 = new JLabel();
		lblNum2.setText("Numero 2");
		lblNum2.setBounds(20, 75, 100, 30);
		contenedor.add(lblNum2);
		
		txtNum2 = new JTextField();
		txtNum2.setBounds(100, 75, 150, 30);
		contenedor.add(txtNum2);
		
		lblResultado = new JLabel();
		lblResultado.setText("Resultado");
		lblResultado.setBounds(20, 125, 100, 30);
		contenedor.add(lblResultado);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(100, 125, 150, 30);
		txtResultado.setEditable(false);
		contenedor.add(txtResultado);
		
		btnSumar = new JButton();
		btnSumar.setText("+");
		btnSumar.setBounds(20, 175, 50, 50);
		contenedor.add(btnSumar);
		
		btnRestar = new JButton();
		btnRestar.setText("-");
		btnRestar.setBounds(80, 175, 50, 50);
		contenedor.add(btnRestar);
		
		btnMultiplicar = new JButton();
		btnMultiplicar .setText("*");
		btnMultiplicar .setBounds(140, 175, 50, 50);
		contenedor.add(btnMultiplicar );
		
		btnDividir = new JButton();
		btnDividir.setText("/");
		btnDividir.setBounds(200, 175, 50, 50);
		contenedor.add(btnDividir);
		
		btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.setBounds(20, 250, 230, 30);
		contenedor.add(btnSalir);
	}
	
	public void controlarEventos() {
		btnSumar.addActionListener(new accionSumar());
		btnRestar.addActionListener(new accionRestar());
		btnMultiplicar.addActionListener(new accionMultiplicar());
		btnDividir.addActionListener(new accionDividir());
		btnSalir.addActionListener(new accionSalir());
	}
	
	public class accionSumar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				num1 = Integer.parseInt(txtNum1.getText());
				num2 = Integer.parseInt(txtNum2.getText());
				resultado = num1 + num2;
				txtResultado.setText(Integer.toString(resultado));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(contenedor, "Introduce numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public class accionRestar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				num1 = Integer.parseInt(txtNum1.getText());
				num2 = Integer.parseInt(txtNum2.getText());
				resultado = num1 - num2;
				txtResultado.setText(Integer.toString(resultado));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(contenedor, "Introduce numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public class accionMultiplicar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				num1 = Integer.parseInt(txtNum1.getText());
				num2 = Integer.parseInt(txtNum2.getText());
				resultado = num1 * num2;
				txtResultado.setText(Integer.toString(resultado));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(contenedor, "Introduce numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public class accionDividir implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				num1 = Integer.parseInt(txtNum1.getText());
				num2 = Integer.parseInt(txtNum2.getText());
				resultado = num1 / num2;
				txtResultado.setText(Integer.toString(resultado));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(contenedor, "Introduce numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public class accionSalir implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int opcion;
			opcion = JOptionPane.showConfirmDialog(contenedor, "Estas seguro de que quieres salir?", "Estas seguro?", JOptionPane.YES_NO_OPTION);
			if(opcion == JOptionPane.YES_OPTION)
				System.exit(0);			
		}	
	}
	

	public static void main(String[] args) {
		Calculadora cal = new Calculadora();

	}

}
