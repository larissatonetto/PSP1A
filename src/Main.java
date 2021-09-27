import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
		public char verImpedimento(int A, int D, int[] Bi, int[] Ci) {
			if (A < 2) {
				System.out.println("Valor inválido para A (deve ser um inteiro maior ou igual a 2)");
				return 'A';
			}
			
			if (D > 11) {
				System.out.println("Valor inválido para A (deve ser um inteiro menor ou igual a 11)");
				return 'D';
			}
			
			if (D == 1) { // Se houver apenas 1 defensor, o atacante está impedido
				return 'Y';
			}
			
			if (Bi[0] < Ci[1]) { // Verifica se o atacante está mais próximo do gol do que o penúltimo defensor
				return 'Y';
			} else if (Bi[0] == Ci[1]) { // Verifica se o atacante está na mesma distância do penúltimo defensor
				return 'N';
			} else {  // Se nenhum dos critérios acima foi atendido, o atacante está mais longe do que o penúltimo defensor
				return 'N';
			}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		int A = 1, D = 1;
		Scanner sc = new Scanner(System.in);
		
		// Lê dois inteiros: A (atacantes) e D (defensores). Se ambos forem diferentes de 0,
		// lê A inteiros seguidos de D inteiros, guardando em arrays separados representando
		// os atacantes e os defensores
		while (true) {
			boolean valido = false;
			
			while (!valido) {
				try {
					A = sc.nextInt();
					valido = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido para A (insira apenas números inteiros)");
					sc.next();
				}
			}
			
			valido = false;
			while (!valido) {
				try {
					D = sc.nextInt();
					valido = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido para D (insira apenas números inteiros)");
					sc.next();
				}
			}
			
			if (A == 0 && D == 0) {
				break;
			}
			
			int[] Bi = new int[A];
			int[] Ci = new int[D];
			
			for (int i = 0; i < A; i++) {
				valido = false;
				while (!valido) {
					try {
						Bi[i] = sc.nextInt();
						valido = true;
					} catch (InputMismatchException e) {
						System.out.println("Valor inválido para Bi (insira apenas números inteiros)");
						sc.next();
					}
				}
			}
			
			for (int i = 0; i < D; i++) {
				valido = false;
				while (!valido) {
					try {
						Ci[i] = sc.nextInt();
						valido = true;
					} catch (InputMismatchException e) {
						System.out.println("Valor inválido para Ci (insira apenas números inteiros)");
						sc.next();
					}
				}
			}
			
			// Ordenando os arrays para facilitar o acesso aos jogadores mais próximos do gol
			Arrays.sort(Bi);
			Arrays.sort(Ci);
			
			char resp = main.verImpedimento(A, D, Bi, Ci);
			System.out.println(resp);
		}
	}
}