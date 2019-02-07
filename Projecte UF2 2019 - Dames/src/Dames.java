import java.util.Scanner;

public class Dames {

	static void omplirTauler(String tablero[][], int blanconegre) {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				
				blanconegre++;
				if ((blanconegre % 2) == 0) {
					tablero[i][j] = "███";
				} else {
					tablero[i][j] = "   ";
				}
			}
			blanconegre++;
		}
	}

	static void pintaTauler(String tablero[][]) {
		
		for (int i = 0; i < tablero.length; i++) {
			System.out.print("[" + (i + 1) + "] ");
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
		System.out.println("    |A||B||C||D||E||F||G||H||I| ");
	}
	
	static void afegirFitxes(String tablero[][], int blanconegre) {
		//blanques
		
		blanconegre=0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < tablero.length; j++) {
				
				if (blanconegre==0) {
					if ((j % 2) != 0) {
						tablero[i][j] = "█◘█";
					} else {
						tablero[i][j] = " ○ ";
					}
				}else {
					if ((j % 2) != 0) {
						tablero[i][j] = " ○ ";
					} else {
						tablero[i][j] = "█◘█";
					}
				}
					
			}
			blanconegre++;
		}
		
		blanconegre=0;
		
		for (int i = tablero.length-1; i > (tablero.length-4); i--) {
			for (int j = 0; j < tablero.length; j++) {
				
				if (blanconegre==0) {
					if ((j % 2) != 0) {
						tablero[i][j] = "█◙█";
					} else {
						tablero[i][j] = " • ";
					}
				}else {
					if ((j % 2) != 0) {
						tablero[i][j] = " • ";
					} else {
						tablero[i][j] = "█◙█";
					}
				}
			}
			blanconegre++;
		}
	}

	
	
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String[][] tablero = new String[8][8];
		int blanconegre = 0;
		
		//pintar matriu
		//pintaTauler(tablero);
		
		//crear matriu
		omplirTauler(tablero, blanconegre);
		pintaTauler(tablero);
		
		System.out.println();
		System.out.println("██████╗  █████╗ ███╗   ███╗ █████╗ ███████╗");
		System.out.println("██╔══██╗██╔══██╗████╗ ████║██╔══██╗██╔════╝");
		System.out.println("██║  ██║███████║██╔████╔██║███████║███████╗");
		System.out.println("██║  ██║██╔══██║██║╚██╔╝██║██╔══██║╚════██║");
		System.out.println("██████╔╝██║  ██║██║ ╚═╝ ██║██║  ██║███████║");
		System.out.println("╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝");
		System.out.println();
		System.out.println("╔══════════════╗");
		System.out.println("║Choose:       ║");
		System.out.println("║              ║");
		System.out.println("║1. New Game   ║");
		System.out.println("║2. Exit       ║");
		System.out.println("╚══════════════╝");
		
		int opcio = teclado.nextInt();
		
		if(opcio==1) {
			
			//afegir fitxes
			afegirFitxes(tablero, blanconegre);
			
			//pintar matriu
			pintaTauler(tablero);
			
			double start = (int) (Math.random() * 2) + 1;
			if(start == 1) {
				System.out.println("Començen les blanques");

			}else {
				System.out.println("Començen les negre");
			}

			
		}else if (opcio == 2){
			System.out.println("Fi del programa:");
		}else {
			
		}
		
		
				
	}
}
