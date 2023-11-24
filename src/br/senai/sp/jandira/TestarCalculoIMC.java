package br.senai.sp.jandira;

import br.senai.sp.jandira.CalcularIMC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestarCalculoIMC extends JFrame implements ActionListener {

	JButton btnCalcular=new JButton("Calcular IMC");
	JButton btnSair=new JButton("Sair");
	
	JLabel lblTitulo=new JLabel("Cálculo do IMC");
	JLabel lblPeso=new JLabel("Peso em kg:");
	JLabel lblAltura=new JLabel("Altura em metros:");
			
	JTextField txtPeso=new JTextField();
	JTextField txtAltura=new JTextField();
	
	public TestarCalculoIMC() {
		
		btnCalcular.addActionListener(this);
		btnSair.addActionListener(this);
		
		// Botões
		setLayout(null);
		btnCalcular.setBounds(50, 300, 120, 30);
		btnSair.setBounds(340, 300, 100, 30);
		add(btnCalcular);
		add(btnSair);		
		
		// Label
		lblTitulo.setBounds(200,10,300,30);
		lblAltura.setBounds(138, 123, 160, 20);
		lblPeso.setBounds(170, 173, 110, 20);
		add(lblTitulo);
		add(lblAltura);
		add(lblPeso);
		
		// Campo de texto
		txtAltura.setBounds(250, 120, 100, 30);
		txtPeso.setBounds(250, 170, 100, 30);
		add(txtAltura);
		add(txtPeso);		
		
		// JFrame
		setTitle("Calculo de IMC");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource()==btnCalcular) {
			if(!txtAltura.getText().equals("")&&!txtPeso.getText().equals("")) {
				CalcularIMC c1=new CalcularIMC();
				String strAltura=txtAltura.getText();
				String strPeso=txtPeso.getText();
				double altura=Double.parseDouble(strAltura);
				double peso=Double.parseDouble(strPeso);
				c1.altura=altura;
				c1.peso=peso;
				double imc=c1.calcularImc();
				String classificacao=c1.classificarImc();
				JOptionPane.showMessageDialog(null, "IMC: " + imc + "\nClassificação: " + classificacao);
			}
			else {
				JOptionPane.showMessageDialog(null, "Por favor, insira os dois valores.");
			}
		}
		else if(evento.getSource()==btnSair) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new TestarCalculoIMC();
		}
	
}
