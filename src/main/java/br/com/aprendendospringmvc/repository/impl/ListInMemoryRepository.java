package br.com.aprendendospringmvc.repository.impl;

import br.com.aprendendospringmvc.entity.Pojo;
import br.com.aprendendospringmvc.repository.IRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A ListInMemoryRepository, when we learning something, it's not necessary go to database
 * or set hibernate(or whatever). We just want to see what happens!
 * <p>
 * Created by ellison on 24/04/14.
 */
public final class ListInMemoryRepository implements IRepository {

    private List<Pojo> persistedPojos = new ArrayList<>();

    private static final ListInMemoryRepository INSTANCE = new ListInMemoryRepository();

    // It's not granted create a new instance of this class.
    private ListInMemoryRepository() {
    }

    /**
     * A unique instance for this class.
     * So, whenever we invoke an object that invokes this implementation of repository,
     * we're invoking the repository with actual objects in memory.
     *
     * @return
     */
    public static final ListInMemoryRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Pojo basicPojo) {

        Optional<Long> optionalId = INSTANCE.listAll().stream()
                .map((p) -> p.getId())
                .max(Long::compare);

        optionalId.ifPresent((c) -> basicPojo.setId(c + 1L));

        if (!optionalId.isPresent()) {
            basicPojo.setId(1L);
        }

        persistedPojos.add(basicPojo);
    }

    @Override
    public Pojo update(Pojo pojo) {

        Pojo persistedPojo = get(pojo.getId());

        if (Pojo.NULL.equals(persistedPojo)) {
            throw new RuntimeException("Pojo can't be founded");
        }

        remove(persistedPojo);
        save(pojo);

        return pojo;
    }

    @Override
    public void remove(Pojo pojo) {
        persistedPojos.removeIf((p) -> p.getId().equals(pojo.getId()));
    }

    @Override
    public Pojo get(Serializable id) {

        return listAll().stream()
                .filter((p) -> id.equals(p.getId()))
                .findFirst()
                .orElseGet(() -> Pojo.NULL);
    }

    @Override
    public List<Pojo> listAll() {
        return persistedPojos;
    }

}