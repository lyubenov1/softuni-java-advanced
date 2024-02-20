package magicGame.models.magicians;
import magicGame.models.magics.*;

public class Wizard extends MagicianImpl {
    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
