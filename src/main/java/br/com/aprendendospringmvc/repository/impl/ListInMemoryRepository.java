package br.com.aprendendospringmvc.repository.impl;

import br.com.aprendendospringmvc.entity.BasicPojo;
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
     * So, whenever we invoke an object that invoke an this implementation of repository,
     * we'll invoking the repository with actual objects in memory.
     *
     * @return
     */
    public static final ListInMemoryRepository getInstance() {
        return INSTANCE;
    }


    @Override
    public void save(Pojo basicPojo) {

        Optional<Long> optionalId = INSTANCE.listAll().stream()
                .map(p -> p.getId())
                .max(Long::compare);

        optionalId.ifPresent((c) -> basicPojo.setId(c + 1L));

        if (!optionalId.isPresent()) {
            basicPojo.setId(1L);
        }

        persistedPojos.add(basicPojo);
    }

    @Override
    public void remove(Pojo pojo) {
        persistedPojos.removeIf((p) -> p.getId().equals(pojo.getId()));
    }

    @Override
    public Pojo get(Serializable id) {

        Pojo retorno = persistedPojos.stream()
                .filter((p) -> id.equals(p.getId()))
                .findFirst()
                .orElse((Pojo) BasicPojo.NULL);

        return retorno;
    }

    @Override
    public List<Pojo> listAll() {
        return persistedPojos;
    }

}