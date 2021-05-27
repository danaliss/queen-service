package com.danaliss.queenservice.dao;

import com.danaliss.queenservice.model.Queen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueenRepository extends CrudRepository<Queen, Integer> {

    @Query(value = "SELECT * FROM queen WHERE (name = :pName)", nativeQuery = true)
    List<Queen> findQueensByName(final String pName);

    @Query(value = "SELECT * FROM queen WHERE (winner = true)", nativeQuery = true)
    List<Queen> findAllWinners();

}
