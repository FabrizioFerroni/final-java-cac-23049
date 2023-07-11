package ar.fabriziodev.finalcacfabrizioferroni.repository;

import ar.fabriziodev.finalcacfabrizioferroni.models.Ticket;

import java.util.ArrayList;

public interface TicketRepository {
    public ArrayList<Ticket> findAll() throws Exception;

    public Ticket getById(Long id) throws Exception;

    public Ticket getByCode(String codigo) throws Exception;

    public boolean create(Ticket ticket) throws Exception;

    public boolean update(Long id, Ticket ticket) throws Exception;

    public boolean delete(Long id) throws Exception;
}
