package com.codegym.Repository;

import com.codegym.Entity.FootballPitches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IFootballPitchesRepository extends JpaRepository<FootballPitches, Integer> {
    List<FootballPitches> findFootballPitchesByNamePitchesContaining (String name);
}
