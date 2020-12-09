import novatronicchallenge.TennisGame;
import novatronicchallenge.TennisPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
    private TennisGame tennisGame;
    private TennisPlayer player1;
    private TennisPlayer player2;

    @Before
    public void initalizeData() {
        tennisGame = new TennisGame();
        player1 = new TennisPlayer();
        player1.setName("Johnny");
        player2 = new TennisPlayer();
        player2.setName("Alvaro");

        tennisGame.setPlayer1(player1);
        tennisGame.setPlayer2(player2);
    }

    @Test
    public void probarMetodoScoreDevuelveString() {
        Assert.assertEquals("string".getClass(), tennisGame.score().getClass());
    }

    @Test
    public void probarCadaJugadorTengaElMetodoAnotarPunto() {

        tennisGame.getPlayer1().anotarPunto();
        tennisGame.getPlayer2().anotarPunto();

        Assert.assertTrue(tennisGame.getPlayer1().anotarPunto());
        Assert.assertTrue(tennisGame.getPlayer2().anotarPunto());

    }

    @Test
    public void validarPuntajesInicialesSonCeros() {
        Integer valorEsperadoPuntajeInicial = 0;

        Integer puntajeInicial1 = tennisGame.getPlayer1().getPuntaje();
        Integer puntajeInicial2 = tennisGame.getPlayer2().getPuntaje();
        Assert.assertEquals(valorEsperadoPuntajeInicial, puntajeInicial1);
        Assert.assertEquals(valorEsperadoPuntajeInicial, puntajeInicial2);
    }

    @Test
    public void probarAnotarPuntoIncrementaElPuntajeEnUno() {
        Integer puntajeInicial = tennisGame.getPlayer1().getPuntaje();
        tennisGame.getPlayer1().anotarPunto();
        Integer puntajeActual = tennisGame.getPlayer1().getPuntaje();
        Integer puntajeEsperado = puntajeInicial + 1;
        Assert.assertEquals(puntajeEsperado, puntajeActual);
    }

    @Test
    public void validarSiHayGanadorDelJuego() {
        // Para que haya ganador debe haber diferencia minima de 2 y uno de ellos debe haber anotado al menos 4 puntos

        // No deberia haber ganador
        player1.setPuntaje(4);
        player2.setPuntaje(3);
        Assert.assertEquals(false, tennisGame.hayGanador());

        // Deberia haber ganador
        player1.setPuntaje(4);
        player2.setPuntaje(2);
        Assert.assertEquals(true, tennisGame.hayGanador());

    }

    @Test
    public void validarDescripcionDePuntajesActuales() {
        // Puntajes de 0 a 3
        player1.setPuntaje(0);
        player2.setPuntaje(0);

        String mensajeEsperado = "Love-Love";
        Assert.assertEquals(mensajeEsperado, tennisGame.score());
        player1.setPuntaje(1);
        player2.setPuntaje(1);
        mensajeEsperado = "Fifteen-Fifteen";
        Assert.assertEquals(mensajeEsperado, tennisGame.score());
        player1.setPuntaje(2);
        player2.setPuntaje(2);
        mensajeEsperado = "Thirty-Thirty";
        Assert.assertEquals(mensajeEsperado, tennisGame.score());
        player1.setPuntaje(2);
        player2.setPuntaje(3);
        mensajeEsperado = "Thirty-Forty";
        Assert.assertEquals(mensajeEsperado, tennisGame.score());
    }

    @Test
    public void validarPuntajeDeuce() {
        player1.setPuntaje(3);
        player2.setPuntaje(3);
        Assert.assertEquals("Deuce-Deuce", tennisGame.score());
    }

}
