package ua.remzsolutions.onlinespreadsheets.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {

    List<T> save(Iterable<T> entities);

    T save(T entity);

    List<T> findAll();

    T findOne(ID id);

    void delete(T entity);

    Page<T> findAll(Pageable pageable);
}
