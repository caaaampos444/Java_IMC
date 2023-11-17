package br.senai.sp.jandira;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalculoIMC extends JFrame implements ActionListener {

	JButton btnCalcular=new JButton("Calcular IMC");
	JButton btnSair=new JButton("Sair");
	
	JLabel lblTitulo=new JLabel("Cálculo do IMC");
	JLabel lblPeso=new JLabel("Peso em kg:");
	JLabel lblAltura=new JLabel("Altura em cm:");
			
	JTextField txtPeso=new JTextField();
	JTextField txtAltura=new JTextField();
	
	public CalculoIMC() {
		
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
		lblAltura.setBounds(170, 120, 100, 20);
		lblPeso.setBounds(170, 170, 110, 20);
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
				String strAltura=txtAltura.getText();
				String strPeso=txtPeso.getText();
				int alturaCm=Integer.parseInt(strAltura);
				int peso=Integer.parseInt(strPeso);
				double altura=alturaCm/100;
				double imc=peso/(altura*altura);
				String classificacao;
				if(imc<18.5) {
					classificacao="Baixo peso.";
				}
				else if(imc>=18.6&&imc<=24.9) {
					classificacao="Peso normal.";
				}
				else if(imc>=25&&imc<=29.9) {
					classificacao="Sobrepeso.";
				}
				else if(imc>=30&&imc<=34.9) {
					classificacao="Obesidade grau I";
				}
				else if(imc>=35&&imc<=39.9) {
					classificacao="Obesidade grau II";
				}
				else {
					classificacao="Obesidade grau III";
				}
				JOptionPane.showMessageDialog(null, "IMC: "+imc+"\nClassificação"+classificacao);
			}
			else {
				JOptionPane.showMessageDialog(null, "Por favor, insira os dois valores.");
			}
		}
	}
	
	public static void main(String[] args) {
		new CalculoIMC();
		}
	
}
