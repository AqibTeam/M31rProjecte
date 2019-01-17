
public class Dames {

	static void omplirTauler(String tablero[][], int blanconegre) {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				blanconegre++;
				if ((blanconegre % 2) == 0) {
					tablero[i][j] = "██";
				} else {
					tablero[i][j] = "  ";
				}
			}
			blanconegre++;
		}
	}

	static void pintaTauler(String tablero[][]) {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args) {

		String[][] tablero = new String[9][9];
		int blanconegre = 0;

		omplirTauler(tablero, blanconegre);
		
		pintaTauler(tablero);
		
	}

}
