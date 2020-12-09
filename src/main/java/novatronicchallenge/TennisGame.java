package novatronicchallenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TennisGame {
    private TennisPlayer player1;
    private TennisPlayer player2;

    public String score() {

        // Para actualizar los mensaje de la descripcion en el caso de que se hayan ingresado manualmente sin seguir el flujo
        if (!hayGanador()) {
            updatePuntajesMessages();
        }


        return this.getPlayer1().getPuntajeMessage() + "-" + this.getPlayer2().getPuntajeMessage();
    }

    public boolean hayGanador() {
        if (player1.getPuntaje() >= 4 && (player1.getPuntaje() - player2.getPuntaje() >= 2)) {
            this.player1.setPuntajeMessage("Winner");
            this.player2.setPuntajeMessage("Looser");
            return true;
        } else if (player2.getPuntaje() >= 4 && (player2.getPuntaje() - player1.getPuntaje() >= 2)) {
            this.player2.setPuntajeMessage("Winner");
            this.player1.setPuntajeMessage("Looser");
            return true;
        }
        return false;
    }

    private TennisPlayer getTennisPlayerInstance(Integer playerNumber) {
        switch (playerNumber) {
            case 1:
                return this.getPlayer1();
            case 2:
                return this.getPlayer2();
            default:
                return null;
        }
    }

    public void anotarPunto(Integer playerNumber) {
        if (!hayGanador()) {
            getTennisPlayerInstance(playerNumber).anotarPunto();
            updatePuntajesMessages();
        }
    }

    private void updatePuntajesMessages() {

        Integer puntaje1 = this.getPlayer1().getPuntaje();
        Integer puntaje2 = this.getPlayer2().getPuntaje();
        Integer diferencia = puntaje1 - puntaje2;

        if (puntaje1 >= 3 && puntaje2 >= 3) {
            if (diferencia == 0) {
                this.player1.setPuntajeMessage("Deuce");
                this.player2.setPuntajeMessage("Deuce");
            } else if (diferencia == 1) {
                this.player1.setPuntajeMessage("Advantage");
            } else if (diferencia == -1) {
                this.player2.setPuntajeMessage("Advantage");
            }
        } else if (puntaje1 <= 3 && puntaje2 <= 3) {
            setFirstMessages(this.getPlayer1());
            setFirstMessages(this.getPlayer2());
        }

    }

    private void setFirstMessages(TennisPlayer player) {
        switch (player.getPuntaje()) {
            case 0:
                player.setPuntajeMessage("Love");
                break;
            case 1:
                player.setPuntajeMessage("Fifteen");
                break;
            case 2:
                player.setPuntajeMessage("Thirty");
                break;
            case 3:
                player.setPuntajeMessage("Forty");
                break;
            default:
                player.setPuntajeMessage(player.getPuntaje().toString());
                break;
        }
    }


}
