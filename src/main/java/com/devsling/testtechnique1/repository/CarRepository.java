package com.devsling.testtechnique1.repository;

import com.devsling.testtechnique1.entity.Car;
import com.devsling.testtechnique1.enums.TypeCarburant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByTypeCarburantAndPrixLessThanEqual(TypeCarburant typeCarburant, double prixMax);
}
