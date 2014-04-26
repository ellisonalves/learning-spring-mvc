package br.com.aprendendospringmvc.repository;

import br.com.aprendendospringmvc.entity.BasicPojo;
import br.com.aprendendospringmvc.entity.Pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ellison on 24/04/14.
 */
public interface IRepository {

    void save(Pojo basicPojo);

    Pojo get(Serializable id);

    List<Pojo> listAll();

    void remove(Pojo basicPojo);

}
