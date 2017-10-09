package JavaSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Formulario {

	JFrame v;
	JPanel c;
	JTextField txtNombre, txtApellidos, txtExp, txtFecha;
	JTextArea txtObs;
	JRadioButton rbtnSexo1, rbtnSexo2;
	JLabel lblNombre, lblApellidos, lblCurso, lblExp, lblFecha, lblSexo, lblObservaciones;
	JComboBox cbxLista;
	JButton btnGuardar, btnSalir;
	ButtonGroup bgpSexo;
	
	public Formulario() {
		definirVentana();
		definirContenedor();
		definirComponentes();
		controlarComponentes();
		
		v.setVisible(true);
	}
	
	public void definirVentana() {
		v = new JFrame();
		v.setTitle("Formulario");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setBounds(0, 0, 400, 500);
		v.setLocationRelativeTo(null);
	}
	
	public void definirContenedor() {
		c = new JPanel();
		c.setLayout(null);
		v.getContentPane().add(c);
	}
	
	public void definirComponentes() {
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(65, 420, 100, 30);
		c.add(btnGuardar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(185, 420, 100, 30);
		c.add(btnSalir);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 20, 100, 30);
		c.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(20, 50, 150, 30);
		c.add(txtNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(200, 20, 100, 30);
		c.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(200, 50, 150, 30);
		c.add(txtApellidos);
		
		lblExp = new JLabel("Nº Exp");
		lblExp.setBounds(20, 90, 100, 30);
		c.add(lblExp);
		
		txtExp = new JTextField();
		txtExp.setBounds(20, 120, 80, 30);
		c.add(txtExp);
		
		lblFecha = new JLabel("Fecha Nac.");
		lblFecha.setBounds(120, 90, 150, 30);
		c.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(120, 120, 80, 30);
		c.add(txtFecha);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(240, 90, 100, 30);
		c.add(lblSexo);
		
		rbtnSexo1 = new JRadioButton("Hombre");
		rbtnSexo1.setBounds(240, 110, 100, 30);
		c.add(rbtnSexo1);
		
		rbtnSexo2 = new JRadioButton("Mujer");
		rbtnSexo2.setBounds(240, 130, 100, 30);
		c.add(rbtnSexo2);
		
		bgpSexo = new ButtonGroup();
		bgpSexo.add(rbtnSexo1);
		bgpSexo.add(rbtnSexo2);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(20, 160, 100, 30);
		c.add(lblCurso);
		
		cbxLista = new JComboBox<>();
		cbxLista.addItem("AE");
		cbxLista.addItem("DAM");
		cbxLista.addItem("CE");
		cbxLista.setBounds(20, 190, 100, 30);
		c.add(cbxLista);
		
		lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(20, 230, 100, 30);
		c.add(lblObservaciones);
		
		txtObs = new JTextArea();
		txtObs.setBounds(20, 260, 250, 80);
		c.add(txtObs);
	}
	
	public void controlarComponentes() {
		btnSalir.addActionListener(new accionSalir());
		btnGuardar.addActionListener(new accionGuardar());
	}
	
	public class accionGuardar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(c, "Has guardado los datos", "Datos guardados", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class accionSalir implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int opcion;
			opcion = JOptionPane.showConfirmDialog(c, "Estas seguro de que quieres salir?", "Estas seguro?", JOptionPane.YES_NO_OPTION);
			if(opcion == JOptionPane.YES_OPTION)
				System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Formulario f = new Formulario();
	}
}
