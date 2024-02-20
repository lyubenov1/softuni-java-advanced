package magicGame.repositories.interfaces;
import magicGame.models.magicians.*;
import magicGame.common.*;
import java.util.*;
public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        return data.stream().filter(i -> i.getUsername().equals(name))
                .findFirst().orElse(null);
    }
}
