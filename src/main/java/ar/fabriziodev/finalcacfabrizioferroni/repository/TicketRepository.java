package ar.fabriziodev.finalcacfabrizioferroni.repository;

import ar.fabriziodev.finalcacfabrizioferroni.models.Ticket;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.TicketDto;

import java.util.ArrayList;

public interface TicketRepository {
    public ArrayList<Ticket> findAll() throws Exception;

    public ArrayList<Ticket> findAllByUser(Long id) throws Exception;

    public Ticket getById(Long id) throws Exception;

    public Ticket getByCode(String codigo) throws Exception;

    public ArrayList<Ticket> getByDni(String dni) throws Exception;

    public boolean create(TicketDto ticket) throws Exception;

    public boolean update(Long id, TicketDto ticket) throws Exception;

    public boolean delete(Long id) throws Exception;
}
