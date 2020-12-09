package novatronicchallenge;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
public class TennisPlayer {
    private String name;
    private Integer puntaje = 0;
    private String puntajeMessage;

    public boolean anotarPunto() {
        this.puntaje++;
        return true;
    }

   /* public String getMensaje() {
        String description = "";
        switch (this.puntaje) {
            case 0:
                description = "Love";
                break;
            case 1:
                description = "Fifteen";
                break;
            case 2:
                description = "Thirty";
                break;
            case 3:
                description = "Forty";
                break;
            default:
                description = this.puntaje.toString();
                break;
        }
        return description;
    }*/
}
