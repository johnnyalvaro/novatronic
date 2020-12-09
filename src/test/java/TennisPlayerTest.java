import novatronicchallenge.TennisGame;
import novatronicchallenge.TennisPlayer;
import org.junit.Assert;
import org.junit.Test;

public class TennisPlayerTest {
    @Test
    public void testingGetterAndSetter() {
        Integer puntaje = 10;
        String mensaje = "Love";
        String nombre = "Alvaro";

        TennisPlayer tennisPlayer = new TennisPlayer();
        tennisPlayer.setPuntaje(puntaje);
        tennisPlayer.setPuntajeMessage(mensaje);
        tennisPlayer.setName(nombre);

        Assert.assertEquals(puntaje, tennisPlayer.getPuntaje());
        Assert.assertEquals(mensaje, tennisPlayer.getPuntajeMessage());
        Assert.assertEquals(nombre, tennisPlayer.getName());

    }

    @Test
    public void probarAgregarPunto() {
        Integer puntajeInicial = 10;
        TennisPlayer tennisPlayer = new TennisPlayer();
        tennisPlayer.setPuntaje(puntajeInicial);
        // Ejectuando anotarPunto()
        tennisPlayer.anotarPunto();

        Integer puntajeEsperado = puntajeInicial + 1;
        Integer puntajeActual = tennisPlayer.getPuntaje();

        Assert.assertEquals(puntajeEsperado, puntajeActual);
    }

    @Test
    public void testingGettersAndSetters() {
        // Creando player1 y player2
        TennisPlayer tennisPlayer1 = new TennisPlayer();
        tennisPlayer1.setPuntaje(10);
        tennisPlayer1.setPuntajeMessage("10");
        tennisPlayer1.setName("Alvaro");
        TennisPlayer tennisPlayer2 = new TennisPlayer();
        tennisPlayer2.setPuntaje(11);
        tennisPlayer2.setPuntajeMessage("11");
        tennisPlayer2.setName("Johnny");

        //Creando TennisGame
        TennisGame tennisGame = new TennisGame();

        //Testing Getter and Setter
        tennisGame.setPlayer1(tennisPlayer1);
        tennisGame.setPlayer2(tennisPlayer2);

        Assert.assertEquals(tennisPlayer1, tennisGame.getPlayer1());
        Assert.assertEquals(tennisPlayer2, tennisGame.getPlayer2());

    }
}
