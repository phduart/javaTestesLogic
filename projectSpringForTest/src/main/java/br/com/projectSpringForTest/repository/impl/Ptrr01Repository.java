package br.com.projectSpringForTest.repository.impl;

import br.com.projectSpringForTest.entity.Ptrr01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface Ptrr01Repository extends JpaRepository<Ptrr01, Integer> {

    @Query(value="SELECT * FROM PTRR01 WHERE APLICA = 3", nativeQuery=true)
    List<Ptrr01> getPolizaUm();
}
