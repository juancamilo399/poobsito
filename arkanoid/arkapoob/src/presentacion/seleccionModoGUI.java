package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class seleccionModoGUI extends JFrame{
	
	private JPanelB panelPantalla;
	private JPanel	panelBotones, panelLogo;
	private myButton single;
	private myButton  coop;
	private myButton  jVsCpu;
	private myButton  volverBoton,volverBoton2J;
	private myButton  jugarBoton1J;
	private myButton  jugarBoton2J;
	private myButton  jugarBotonPc;
	private myButton  cancelarBoton;
	private JLabel logo;
	private Container contenedor;
	private JComboBox<String> selecColorBar,selecColorBar2,selecColorBarP1;
	private JTextField nameJ1,nameP1;
	private JTextField nameJ2;
	private JPanel cards;
	private static final String []colores = { "Verde", "Azul","Amarillo","Rojo"};
	
	public seleccionModoGUI(){
		super("Seleccion Modo");
		contenedor = getContentPane();
		setResizable(false);
		prepareElementos();
		prepareAcciones();
		prepareAccionesConfig();
	}
	
	public void prepareElementos(){
		ajusteFrame();
		prepareElementosPantalla();
		prepareElementosConfig1J();
		prepareElementosConfig2J();
		prepareElementosConfigPc();
	}
	
	public void ajusteFrame(){
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int height=250;
		int width=700;
		setSize(width,height);
		int centerX = size.width/2;
		int centerY = size.height/2;
		int halfWidth = width/2;
		int halfHeight = height-125;
		setLocation(centerX - halfWidth, centerY - halfHeight);
	}
	
	public void ajusteFrameConfig(){
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int height=700;
		int width=600;
		setSize(width,height);
		int centerX = size.width/2;
		int centerY = size.height/2;
		int halfWidth = width/2;
		int halfHeight = height-340;
		setLocation(centerX - halfWidth, centerY - halfHeight);
	}
	
	public void prepareElementosPantalla(){
		setIconImage(new ImageIcon(getClass().getResource("/resources/icono.png")).getImage());
		panelPantalla = new JPanelB();
		panelPantalla.setLayout(new GridLayout(2,1));
		panelPantalla.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		contenedor.add(panelPantalla);
		
		panelLogo = new JPanel(new GridBagLayout());
		logo = new JLabel(new ImageIcon(getClass().getResource("/resources/logo.png")));
		panelLogo.add(logo);
		panelPantalla.add(panelLogo);
		panelLogo.setOpaque(false);
		
		panelBotones = new JPanel(new GridLayout(2,3));
		panelBotones.setOpaque(false);
		Icon icono1j = new ImageIcon(getClass().getResource("/resources/1J.png"));
		single = new myButton(icono1j);
		single.setTransparent();
		Icon icono2j = new ImageIcon(getClass().getResource("/resources/2J.png"));
		coop = new myButton(icono2j);
		coop.setTransparent();
		Icon iconoJVC = new ImageIcon(getClass().getResource("/resources/jVC.png"));
		jVsCpu = new myButton(iconoJVC);
		jVsCpu.setTransparent();
		Icon iconot = new ImageIcon(getClass().getResource("/resources/blan.png"));
		myButton t = new myButton(iconot);
		t.setTransparent();
		Icon iconoCancelar = new ImageIcon(getClass().getResource("/resources/volver.png"));
		cancelarBoton = new myButton(iconoCancelar);
		cancelarBoton.setTransparent();
		
		panelBotones.add(single);
		panelBotones.add(coop);
		panelBotones.add(jVsCpu);
		panelBotones.add(t);
		panelBotones.add(cancelarBoton);
		
		panelPantalla.add(panelBotones);
		
		cards = new JPanel(new CardLayout());
		cards.add(panelPantalla, "Principal");
		contenedor.add(cards);
	}
	
	public void prepareElementosConfig1J(){
		JPanelB configPanel = new JPanelB();
		configPanel.setLayout(new GridLayout(3,1));
		configPanel.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		cards.add(configPanel,"Configuracion1J");
		JPanel panelCButton = new JPanel();
		panelCButton.setOpaque(false);
		
		JPanel panelConfigLogo= new JPanel(new GridBagLayout());
		logo = new JLabel(new ImageIcon(getClass().getResource("/resources/logo.png")));
		panelConfigLogo.add(logo);
		panelConfigLogo.setOpaque(false);
		
		JPanel combo = new JPanel();
		combo.setLayout(null);
		combo.setOpaque(false);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setForeground(Color.WHITE);
		nombre.setBounds(27, 40, 78, 14);
		combo.add(nombre);
		nameJ1 = new JTextField();
		nameJ1.setBounds(135, 37, 121, 23);
		combo.add(nameJ1);
		nameJ1.setColumns(10);
		
		JLabel colorBarra = new JLabel("Color barra");
		colorBarra.setForeground(Color.WHITE);
		colorBarra.setBounds(27, 85, 78, 14);
		combo.add(colorBarra);
		selecColorBar = new JComboBox<>(colores);
		selecColorBar.setBounds(135, 82, 121, 17);
		combo.add(selecColorBar);
		
		Icon iconoCancelar = new ImageIcon(getClass().getResource("/resources/volver.png"));
		volverBoton = new myButton(iconoCancelar);
		volverBoton.setTransparent();
		
		Icon iconoJ = new ImageIcon(getClass().getResource("/resources/jugar1.png"));
		jugarBoton1J = new myButton(iconoJ);
		jugarBoton1J.setTransparent();
		
		panelCButton.add(jugarBoton1J);
		panelCButton.add(volverBoton);
		
		configPanel.add(panelConfigLogo);
		configPanel.add(combo);
		configPanel.add(panelCButton);
		configPanel.setOpaque(false);
		
	}
	
	public void prepareElementosConfig2J(){
		
		JPanelB configPanel = new JPanelB();
		configPanel.setLayout(new GridLayout(3,1));
		configPanel.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		cards.add(configPanel,"Configuracion2J");
		JPanel panelCButton = new JPanel();
		panelCButton.setOpaque(false);
		
		JPanel panelConfigLogo= new JPanel(new GridBagLayout());
		logo = new JLabel(new ImageIcon(getClass().getResource("/resources/logo.png")));
		panelConfigLogo.add(logo);
		panelConfigLogo.setOpaque(false);
		
		JPanel combo = new JPanel();
		combo.setLayout(null);
		combo.setOpaque(false);
		
		JLabel nombre = new JLabel("Nombre J1");
		nombre.setForeground(Color.WHITE);
		nombre.setBounds(27, 40, 85, 14);
		combo.add(nombre);
		nameP1 = new JTextField();
		nameP1.setBounds(145, 37, 121, 23);
		combo.add(nameP1);
		nameP1.setColumns(10);
		
		JLabel nombre2 = new JLabel("Nombre J2");
		nombre2.setForeground(Color.WHITE);
		nombre2.setBounds( 286,40,85, 14 );
		combo.add(nombre2);
		nameJ2 = new JTextField();
		nameJ2.setBounds(414,37,121,23);
		combo.add(nameJ2);
		nameJ2.setColumns(10);
		
		JLabel colorBarra = new JLabel("Color barra J1");
		colorBarra.setForeground(Color.WHITE);
		colorBarra.setBounds(27, 85, 85, 14);
		combo.add(colorBarra);
		selecColorBarP1 = new JComboBox<>(colores);
		selecColorBarP1.setBounds(145, 82, 121, 17);
		combo.add(selecColorBarP1);
		
		JLabel colorBarra2 = new JLabel("Color barra J2");
		colorBarra2.setForeground(Color.WHITE);
		colorBarra2.setBounds(286, 85, 85, 14);
		combo.add(colorBarra2);
		selecColorBar2 = new JComboBox<>(colores);
		selecColorBar2.setBounds(414, 82, 121, 17);
		combo.add(selecColorBar2);
		
		Icon iconoCancelar = new ImageIcon(getClass().getResource("/resources/volver.png"));
		volverBoton2J = new myButton(iconoCancelar);
		volverBoton2J.setTransparent();
		
		Icon iconoJ = new ImageIcon(getClass().getResource("/resources/jugar1.png"));
		jugarBoton2J = new myButton(iconoJ);
		
		jugarBoton2J.setTransparent();
		
		panelCButton.add(jugarBoton2J);
		panelCButton.add(volverBoton2J);
		
		configPanel.add(panelConfigLogo);
		configPanel.add(combo);
		configPanel.add(panelCButton);
		configPanel.setOpaque(false);
		
		
	}
	
	public void prepareElementosConfigPc(){
		
	}
	public void prepareAcciones(){
		
		single.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrirConfig1J();
			}
		});
		
		cancelarBoton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		coop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrirConfig2J();
			}
		});
		
		jVsCpu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrirConfig1J();
			}
		});
	}
	
	private void prepareAccionesConfig() {
		volverBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal();
			}
		});
		
		volverBoton2J.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal();
			}
		});
		
		jugarBoton1J.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegue1J();
			}
		});
		
		jugarBoton2J.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegue2J();
			}
		});
	}
	
	public void abrirConfig1J(){
		setTitle("Configuracion");
		ajusteFrameConfig();
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards,"Configuracion1J");
	}
	
	public void abrirConfig2J(){
		setTitle("Configuracion");
		ajusteFrameConfig();
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards,"Configuracion2J");
	}
	
	public void juegue1J(){
		dispose();
		pantallaJuego j = null;
		j=new pantallaJuego(nameJ1.getText(),(String)selecColorBar.getSelectedItem());
		j.setVisible(true);
	}
	
	public void juegue2J(){
		
	}
	
	private void principal() {
		setTitle("Configuracion");
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards,"Principal");
		ajusteFrame();
	}
}