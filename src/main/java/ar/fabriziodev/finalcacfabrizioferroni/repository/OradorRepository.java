package ar.fabriziodev.finalcacfabrizioferroni.repository;

import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;

import java.util.ArrayList;

public interface OradorRepository {

    public ArrayList<Orador> findAll() throws Exception;

    public Orador getById(Long id) throws Exception;

    public boolean create(Orador orador) throws Exception;

    public boolean update(Long id, Orador orador) throws Exception;

    public boolean delete(Long id) throws Exception;
}
