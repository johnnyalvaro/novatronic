package novatronicchallenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TennisPlayer {
    private String name;
    private Integer puntaje = 0;
    private String puntajeMessage;

    public boolean anotarPunto() {
        this.puntaje++;
        return true;
    }

}
