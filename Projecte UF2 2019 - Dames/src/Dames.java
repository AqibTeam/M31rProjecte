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
		System.out.println("    |A||B||C||D||E||F||G||H| ");
	}

	static void afegirFitxes(String tablero[][], int blanconegre) {
		// blanques

		blanconegre = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < tablero.length; j++) {

				if (blanconegre % 2 == 0) {
					if ((j % 2) != 0) {
						tablero[i][j] = "█◘█";
					} else {
						tablero[i][j] = "   ";
					}
				} else {
					if ((j % 2) != 0) {
						tablero[i][j] = "   ";
					} else {
						tablero[i][j] = "█◘█";
					}
				}

			}
			blanconegre++;
		}

		blanconegre = 0;

		for (int i = tablero.length - 1; i > (tablero.length - 4); i--) {
			for (int j = 0; j < tablero.length; j++) {
				if (blanconegre % 2 != 0) {
					if ((j % 2) != 0) {
						tablero[i][j] = "█◙█";
					} else {
						tablero[i][j] = "   ";
					}
				} else {
					if ((j % 2) != 0) {
						tablero[i][j] = "   ";
					} else {
						tablero[i][j] = "█◙█";
					}
				}
			}
			blanconegre++;
		}
	}

	static int seleccionarfitxan(String tablero[][], int fila, String columna) {

		int columnaparse;
		int accio = 0;
		Scanner teclado = new Scanner(System.in);

		switch (columna) {
		case "A":
			columnaparse = 0;
			break;
		case "B":
			columnaparse = 1;
			break;
		case "C":
			columnaparse = 2;
			break;
		case "D":
			columnaparse = 3;
			break;
		case "E":
			columnaparse = 4;
			break;
		case "F":
			columnaparse = 5;
			break;
		case "G":
			columnaparse = 6;
			break;
		case "H":
			columnaparse = 7;
			break;
		default:
			System.out.println("Posicio incorrecta, torna a escollir:");
			columnaparse = 666;
		}

		int filamovida = fila;
		int columnamovida = columnaparse;
		int retorn = 0;
		do {
			if (columnaparse != 666 && (fila <= 7 && fila >= 0)) {
				if (tablero[fila][columnaparse] == "█◙█") {

					filamovida = fila;
					columnamovida = columnaparse;
					System.out.println("Cap a on vols avançar?");
					System.out.println("╔═══════════════════════╗");
					System.out.println("║1. Avançar dreta       ║");
					System.out.println("║2. Avançar esquerra    ║");
					System.out.println("║3. Enrere              ║");
					System.out.println("╚═══════════════════════╝");

					accio = teclado.nextInt();

					switch (accio) {
					case 1:
						filamovida--;
						columnamovida++;
						break;
					case 2:
						filamovida--;
						columnamovida--;
						break;
					case 3:
						filamovida = 666;
						columnamovida = 666;
					default:
						accio = 666;
						break;

					}

					if ((filamovida <= 7 && filamovida >= 0) && (columnamovida <= 7 && columnamovida >= 0)) {
						if (tablero[filamovida][columnamovida] != "█◙█") {
							if (tablero[filamovida][columnamovida] == "█◘█") {
								int filamovida2 = filamovida;
								int columnamovida2 = columnamovida;
								switch (accio) {
								case 1:
									filamovida2--;
									columnamovida2++;
									break;
								case 2:
									filamovida2--;
									columnamovida2--;
									System.out.println(filamovida2 + " " + columnamovida2);
									break;
								case 3:
									filamovida2--;
									columnamovida2--;
									System.out.println(filamovida2 + " " + columnamovida2);
									break;
								default:
									accio = 666;
									System.out.println("Opcio no valida, torna a introduir:");
									break;
								}
								if (((filamovida2 <= 7 && filamovida2 >= 0)
										&& (columnamovida2 <= 7 && columnamovida2 >= 0))
										&& tablero[filamovida2][columnamovida2] == "███") { // comer
									tablero[filamovida][columnamovida] = "███";
									tablero[fila][columnaparse] = "███";
									tablero[filamovida2][columnamovida2] = "█◙█";
									return 2;

								} else {
									accio = 666;
									System.out.println("Opcio no valida, torna a introduir:");
									return 1;
								}

							} else {
								tablero[filamovida][columnamovida] = "█◙█";
								tablero[fila][columnaparse] = "███";
								return 2;
							}

						} else {
							accio = 666;
							System.out.println("Opcio no valida, torna a introduir:");
							return 1;
						}
					} else {
						if (filamovida == 666 && columnamovida == 666) {
							return 1;
						} else {
							accio = 666;
							System.out.println("Opcio no valida, torna a introduir:");
							return 1;
						}

					}

				} else {
					System.out.println("Posicio incorrecta, torna a escollir:");
					return 1;
				}
			}
		} while (accio == 666);
		return 1;
	}

	static int seleccionarfitxab(String tablero[][], int fila, String columna) {

		int columnaparse;
		int accio = 0;
		Scanner teclado = new Scanner(System.in);

		switch (columna) {
		case "A":
			columnaparse = 0;
			break;
		case "B":
			columnaparse = 1;
			break;
		case "C":
			columnaparse = 2;
			break;
		case "D":
			columnaparse = 3;
			break;
		case "E":
			columnaparse = 4;
			break;
		case "F":
			columnaparse = 5;
			break;
		case "G":
			columnaparse = 6;
			break;
		case "H":
			columnaparse = 7;
			break;
		default:
			System.out.println("Posicio incorrecta, torna a escollir:");
			columnaparse = 666;
		}

		int filamovida = fila;
		int columnamovida = columnaparse;
		do {
			if (columnaparse != 666 && (fila <= 7 && fila >= 0)) {
				if (tablero[fila][columnaparse] == "█◘█") {

					filamovida = fila;
					columnamovida = columnaparse;
					System.out.println("Cap a on vols avançar?");
					System.out.println("╔═══════════════════════╗");
					System.out.println("║1. Avançar dreta       ║");
					System.out.println("║2. Avançar esquerra    ║");
					System.out.println("║3. Enrere              ║");
					System.out.println("╚═══════════════════════╝");

					accio = teclado.nextInt();

					switch (accio) {
					case 1:
						filamovida++;
						columnamovida++;
						break;
					case 2:
						filamovida++;
						columnamovida--;
						break;
					case 3:
						filamovida = 666;
						columnamovida = 666;
					default:
						accio = 666;
						break;

					}

					if ((filamovida <= 7 && filamovida >= 0) && (columnamovida <= 7 && columnamovida >= 0)) {
						if (tablero[filamovida][columnamovida] != "█◘█") {
							if (tablero[filamovida][columnamovida] == "█◙█") {
								int filamovida2 = filamovida;
								int columnamovida2 = columnamovida;
								switch (accio) {
								case 1:
									filamovida2++;
									columnamovida2++;
									break;
								case 2:
									filamovida2++;
									columnamovida2--;
									System.out.println(filamovida2 + " " + columnamovida2);
									break;
								case 3:
									filamovida2++;
									columnamovida2--;
									System.out.println(filamovida2 + " " + columnamovida2);
									break;
								default:
									accio = 666;
									System.out.println("Opcio no valida, torna a introduir:");
									break;
								}
								if (((filamovida2 <= 7 && filamovida2 >= 0)
										&& (columnamovida2 <= 7 && columnamovida2 >= 0))
										&& tablero[filamovida2][columnamovida2] == "███") { // comer
									tablero[filamovida][columnamovida] = "███";
									tablero[fila][columnaparse] = "███";
									tablero[filamovida2][columnamovida2] = "█◘█";
									return 1;

								} else {
									accio = 666;
									System.out.println("Opcio no valida, torna a introduir:");
									return 2;
								}

							} else {
								tablero[filamovida][columnamovida] = "█◘█";
								tablero[fila][columnaparse] = "███";
								return 1;
							}

						} else {
							accio = 666;
							System.out.println("Opcio no valida, torna a introduir:");
							return 2;
						}
					} else {
						if (filamovida == 666 && columnamovida == 666) {
							return 2;
						} else {
							accio = 666;
							System.out.println("Opcio no valida, torna a introduir:");
							return 2;
						}

					}

				} else {
					System.out.println("Posicio incorrecta, torna a escollir:");
					return 2;
				}
			} else {
				return 2;
			}

		} while (accio == 666);

	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String[][] tablero = new String[8][8];
		int blanconegre = 0;
		Boolean repeat = false;

		// pintar matriu
		// pintaTauler(tablero);

		// crear matriu
		omplirTauler(tablero, blanconegre);

		System.out.println();
		System.out.println("██████╗  █████╗ ███╗   ███╗ █████╗ ███████╗");
		System.out.println("██╔══██╗██╔══██╗████╗ ████║██╔══██╗██╔════╝");
		System.out.println("██║  ██║███████║██╔████╔██║███████║███████╗");
		System.out.println("██║  ██║██╔══██║██║╚██╔╝██║██╔══██║╚════██║");
		System.out.println("██████╔╝██║  ██║██║ ╚═╝ ██║██║  ██║███████║");
		System.out.println("╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝");
		System.out.println();
		pintaTauler(tablero);
		do {
			repeat = false;

			System.out.println();
			System.out.println("╔══════════════╗");
			System.out.println("║Choose:       ║");
			System.out.println("║              ║");
			System.out.println("║1. New Game   ║");
			System.out.println("║2. Exit       ║");
			System.out.println("╚══════════════╝");

			int opcio = teclado.nextInt();

			if (opcio == 1) {

				// afegir fitxes
				afegirFitxes(tablero, blanconegre);

				// pintar matriu
				pintaTauler(tablero);

				double start = (int) (Math.random() * 2) + 1;
				int torn;
				int contadorb;
				int contadorn;
				if (start == 1 || start == 2) {
					System.out.println();
					System.out.println();
					System.out.println("Començen les negres:");
					torn = 1;
					System.out.println();
				} else {
					System.out.println();
					System.out.println();
					System.out.println("Començen les blanques:");
					torn = 2;
					System.out.println();
				}

				do {
					contadorb = 0;
					contadorn = 0;

					if (torn == 2) {

						System.out.println("Jugador BLANC:");
						System.out.println("Selecciona la fila de la fitxa que vols moure");
						int filablanc = teclado.nextInt();
						filablanc--;
						System.out.println("Selecciona la columan de la fitxa que vols moure");
						String columnablanc = teclado.next();
						torn = seleccionarfitxab(tablero, filablanc, columnablanc);

						pintaTauler(tablero);
					}

					if (torn == 1) {
						System.out.println("Jugador NEGRE:");
						System.out.println("Selecciona la fila de la fitxa que vols moure");
						int filanegra = teclado.nextInt();
						filanegra--;
						System.out.println("Selecciona la columan de la fitxa que vols moure");
						String columnanegra = teclado.next();
						torn = seleccionarfitxan(tablero, filanegra, columnanegra);

						pintaTauler(tablero);
					}
					
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero.length; j++) {
							String[] strings = tablero[j];
							if(tablero[i][j] == "█◘█") {
								contadorb++;
							}
						}
					}
					
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero.length; j++) {
							String[] strings = tablero[j];
							if(tablero[i][j] == "█◙█") {
								contadorn++;
							}
						}
					}
					
					
					if(contadorb == 0) {
						System.out.println("Las negras ganan!");
						torn=3;
					}
					
					if(contadorn == 0) {
						System.out.println("Las blancas ganan!");
						torn=3;
					}
					
					

				} while (torn != 3);

				System.out.println("Fi del programa:");

			} else if (opcio == 2) {
				System.out.println("Fi del programa:");
			} else {
				repeat = true;
				System.out.println("Opciò no valida, torna a probar:");
			}
		} while (repeat = true);

	}
}
