package magicGame.repositories.interfaces;
import magicGame.models.magics.*;
import java.util.*;
import magicGame.common.*;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        data = new ArrayList<>();
    }
    @Override
    public Collection<Magic> getData() {
        return data;
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return data.stream().filter(
                i -> i.getName().equals(name))
                .findFirst().orElse(null);
    }
}
