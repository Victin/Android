package JavaSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentasOrdenadores {

	JFrame v;
	JPanel c;
	JLabel e1,e2,e3,e4,e5;
	JTextField c1,c2;
	JRadioButton bo1,bo2,bo3,bo4,bo5,bo6,bo7,bo8;
	JCheckBox ch1;
	JButton b1;
	ButtonGroup micro,micro2,micro3;
	
	
	public VentasOrdenadores(){
		crearVentana();
		crearContenedor();
		crearEtiquetas();
		crearCajasTexto();
		crearRadioBotones();
		crearCasillas();
		crearBotones();
		asignarControles();
		
		v.getContentPane().add(c);
		v.setVisible(true);
	}
	
	
	void crearVentana(){
		v=new JFrame();
		v.setTitle("Venta Ordenadores");
		v.setBounds(0, 0, 500, 500);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
		v.setResizable(false);
	}
	
	void crearContenedor(){
		c=new JPanel();
		c.setLayout(null);
	}
	
	void crearEtiquetas(){
		e1 =new JLabel("Precio Base: ");
		e1.setBounds(50, 20, 150, 20);
		c.add(e1);
		
		e2 =new JLabel("Seleciona Microprocesador:");
		e2.setBounds(50, 60, 200, 20);
		c.add(e2);
		
		e3 =new JLabel("Seleciona RAM: ");
		e3.setBounds(50, 140, 200, 20);
		c.add(e3);
		
		e4 =new JLabel("Selecciona Disco Duro: ");
		e4.setBounds(50, 220, 200, 20);
		c.add(e4);
		
		e5 =new JLabel("Precio Total: ");
		e5.setBounds(50, 340, 200, 20);
		c.add(e5);
	}
	
	void crearCajasTexto(){
		c1 =new JTextField();
		c1.setBounds(200, 20, 170, 20);
		c.add(c1);
		
		c2 =new JTextField();
		c2.setBounds(200, 340, 170, 20);
		c2.setEditable(false);
		c.add(c2);
	}
	
	void crearRadioBotones(){
		
		bo1 =new JRadioButton("Core i3");
		bo1.setBounds(50, 100, 100, 20);
		c.add(bo1);
		
		bo2 =new JRadioButton("Core i5");
		bo2.setBounds(180, 100, 100, 20);
		c.add(bo2);
		
		bo3 =new JRadioButton("Core i7");
		bo3.setBounds(300, 100, 100, 20);
		c.add(bo3);
		
		bo4 =new JRadioButton("4 GB");
		bo4.setBounds(50, 180, 100, 20);
		c.add(bo4);
		bo5 =new JRadioButton("8 GB");
		bo5.setBounds(180, 180, 100, 20);
		c.add(bo5);
		
		bo6 =new JRadioButton("500 GB");
		bo6.setBounds(50, 260, 100, 20);
		c.add(bo6);
		
		bo7 =new JRadioButton("1 TB");
		bo7.setBounds(180, 260, 100, 20);
		c.add(bo7);
		
		bo8 =new JRadioButton("2 TB");
		bo8.setBounds(300, 260, 100, 20);
		c.add(bo8);
		
		micro=new ButtonGroup();
		micro2=new ButtonGroup();
		micro3=new ButtonGroup();
		
		micro.add(bo1);
		micro.add(bo2);
		micro.add(bo3);
		
		micro2.add(bo4);
		micro2.add(bo5);
		
		micro3.add(bo6);
		micro3.add(bo7);
		micro3.add(bo8);
	}
	
	void crearCasillas(){
		ch1=new JCheckBox("DVD");
		ch1.setBounds(50,300, 100,20);
		c.add(ch1);
	}
	
	void crearBotones(){
		b1=new JButton("Calcular");
		b1.setBounds(50, 380, 360, 50);
		c.add(b1);
	}
	
	void asignarControles() {
		b1.addActionListener(new calcular());
	}
	
	public class calcular implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			try {
				int pMicro = 0, pRAM = 0, pDisco = 0, pDVD = 0, suma = 0;
				int pBase = Integer.parseInt(c1.getText());					
				
				try {
					if (bo1.isSelected())
						pMicro = 150;
					if (bo2.isSelected())
						pMicro = 250;
					if(bo3.isSelected())
						pMicro = 350;
					if(bo4.isSelected())
						pRAM=40;
					if(bo5.isSelected())
						pRAM=80;
					if(bo6.isSelected())
						pDisco = 50;
					if(bo7.isSelected())
						pDisco = 100;
					if(bo8.isSelected())
						pDisco = 200;
					if(ch1.isSelected())
						pDVD = 25;
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(c, "Elige todas las opciones");
				}
				
				suma = pBase + pMicro + pRAM + pDisco + pDVD;
				System.out.println(suma);
				String total = Integer.toString(suma);
				c2.setText(total);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(c, "Pon un precio base");
			}
		}
	}
	
	public static void main(String[] args) {
		
		VentasOrdenadores v=new VentasOrdenadores();
	}
}