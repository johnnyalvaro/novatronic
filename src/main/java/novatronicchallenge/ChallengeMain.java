package novatronicchallenge;

import java.util.Scanner;

public class ChallengeMain {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        TennisPlayer player1 = new TennisPlayer();
        player1.setName("Johnny");
        TennisPlayer player2 = new TennisPlayer();
        player2.setName("Alvaro");
        TennisGame tennisGame = new TennisGame();
        tennisGame.setPlayer1(player1);
        tennisGame.setPlayer2(player2);


        boolean continuar = false;
        Integer playerNumber = 0;

        do {
            playerNumber = leerNumeroJugador();
            tennisGame.anotarPunto(playerNumber);
            System.out.println("---Score actual---");
            System.out.println(tennisGame.score());
            continuar = deseaContinuar();

        } while (continuar);

        System.out.println("Programa finalizado");
    }

    private static Integer leerNumeroJugador() {
        boolean continuar = false;
        Integer numeroJugador = 0;
        String numeroJugadorString = "";
        do {
            System.out.println("Ingrese numero jugador realizo el punto(1 o 2)");
            numeroJugadorString = scanner.nextLine();
            numeroJugador = stringToInteger(numeroJugadorString);
            continuar = numeroJugador != null ? !(numeroJugador == 1 || numeroJugador == 2) : true;
            if (continuar) {
                System.out.println("----Ingreso un numero jugador invalido----");
            }
        } while (continuar);

        return numeroJugador;
    }

    private static Integer stringToInteger(String value) {
        Integer valueInteger = 0;
        try {
            valueInteger = Integer.parseInt(value.trim());
        } catch (Exception e) {
            return null;
        }
        return valueInteger;
    }

    private static boolean deseaContinuar() {
        Integer value = 0;
        boolean continuar = false;
        boolean deseaContinuar = false;
        do {
            System.out.println("Presione 1 para continuar o 2 para finalizar");
            value = stringToInteger(scanner.nextLine());
            continuar = value != null ? !(value == 1 || value == 2) : true;
            if (!continuar) {
                deseaContinuar = value == 1 ? true : false;
            } else {
                System.out.println("----Ingreso una opcion invalida----");
            }
        } while (continuar);

        return deseaContinuar;
    }
}
