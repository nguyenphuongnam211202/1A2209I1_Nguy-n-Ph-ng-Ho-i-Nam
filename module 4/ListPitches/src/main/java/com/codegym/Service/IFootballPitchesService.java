package com.codegym.Service;

import com.codegym.Entity.FootballPitches;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.sql.In;

import java.awt.print.Pageable;
import java.util.List;

public interface IFootballPitchesService  {

    Page<FootballPitches> findAll(Integer pageNumber);

    FootballPitches findById(Integer id);

    List<FootballPitches> order(FootballPitches footballPitches);


    boolean create(FootballPitches footballPitches);


    List<FootballPitches> findFootballPitchesByNamePitchesContaining (String name);


    boolean delete(Integer id);


}
