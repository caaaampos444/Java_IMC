package br.senai.sp.jandira;

public class CalcularIMC {

	public double peso;
	public double altura;
	
	public double calcularImc() {
		double imc;
		imc=peso/(altura*altura);
		return imc;
	}
	
	public String classificarImc() {
		String classificacao;
		if(calcularImc()<18.5) {
			classificacao="Baixo peso.";
		}
		else if(calcularImc()>=18.6&&calcularImc()<=24.9) {
			classificacao="Peso normal.";
		}
		else if(calcularImc()>=25&&calcularImc()<=29.9) {
			classificacao="Sobrepeso.";
		}
		else if(calcularImc()>=30&&calcularImc()<=34.9) {
			classificacao="Obesidade grau I";
		}
		else if(calcularImc()>=35&&calcularImc()<=39.9) {
			classificacao="Obesidade grau II";
		}
		else {
			classificacao="Obesidade grau III";
		}
		return classificacao;
	}
	
}
