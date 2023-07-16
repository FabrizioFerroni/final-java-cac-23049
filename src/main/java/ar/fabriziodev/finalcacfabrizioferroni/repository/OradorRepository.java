package ar.fabriziodev.finalcacfabrizioferroni.repository;

import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.OradorDto;

import java.util.ArrayList;

public interface OradorRepository {

    public ArrayList<Orador> findAll() throws Exception;

    public Orador getById(Long id) throws Exception;

    public boolean create(OradorDto orador) throws Exception;

    public boolean update(Long id, OradorDto orador) throws Exception;

    public boolean delete(Long id) throws Exception;
}
