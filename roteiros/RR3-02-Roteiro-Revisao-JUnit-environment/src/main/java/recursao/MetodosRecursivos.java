package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array) {
		int result = 0;
		int index = 0;

		calculaSoma(array, index, result);

		return result;
	}

	private int calculaSoma(int array[], int index, int result) {

		if (index == array.length - 1) {
			return result;
		} else {

			result += array[index];
			index++;

			return calculaSoma(array, index, result);
		}

	}

	public long calcularFatorial(int n) {
		long result = 1;

		if (n == 1) {

			return result;

		} else {

			return (n * calcularFatorial(n - 1));
		}

	}

	public int calcularFibonacci(int n) {
		int result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		return result;
	}

	public int countNotNull(Object[] array) {
		int aux = 0;
		int cont = 0;
		int result = contaNull(array, aux, cont);

		return result;
	}

	private int contaNull(Object[] array, int aux, int cont) {

		if (array.length == aux) {
			return cont;

		} else {
			if (array[aux] == null) {
				cont++;
			}

			aux++;
			return contaNull(array, aux, cont);

		}

	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		if (expoente == 0) {
			return result;
		} else {

			return potenciaDe2(expoente - 1) * 2;
		}
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}

}
