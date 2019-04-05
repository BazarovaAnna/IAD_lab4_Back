package com.example.lab.database;

import com.example.lab.entities.ResultEntity;
import org.springframework.data.repository.CrudRepository;

public interface ResultsRepository extends CrudRepository<ResultEntity, Long> {
    public Iterable<ResultEntity> findAllBySessionid(String sessionid);

    public int deleteAllBySessionid(String sessionid);
}
