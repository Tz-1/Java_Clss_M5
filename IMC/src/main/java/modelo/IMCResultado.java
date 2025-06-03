package modelo;

public class IMCResultado {
	private int userId;
	private float peso;
	private float altura;
	private float imc;
	
	public IMCResultado(int userId, float peso, float altura) {
		super();
		this.userId = userId;
		this.peso = peso;
		this.altura = altura;
		this.imc = calcularIMC();
	}

	private float calcularIMC() {
		return peso/(altura * altura);
	}
	
	public String CategoriaIMC() {
		float imc = getImc();
		if(imc < 18.5) {
			return "Delgado";
		}else if(imc >= 18.5 && imc < 24.9) {
			return "Aceptable";
		}else if (imc >= 25 && imc < 29.9) {
			return "Sobrepeso";
		}
		return "Obesidad";
	}
	
	public String getCategoriaClass() {
	    float imc = getImc();
	    if (imc < 18.5) {
	        return "imc-underweight"; 
	    } else if (imc >= 18.5 && imc < 24.9) {
	        return "imc-acceptable"; 
	    } else if (imc >= 25 && imc < 29.9) {
	        return "imc-overweight"; 
	    }
	    return "imc-obesity"; 
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getImc() {
		return imc;
	}
	
	
}
