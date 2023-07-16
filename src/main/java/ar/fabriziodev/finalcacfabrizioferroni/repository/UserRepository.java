package ar.fabriziodev.finalcacfabrizioferroni.repository;

import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.UsuarioDto;

import java.util.ArrayList;

public interface UserRepository {

    public ArrayList<Usuario> findAll() throws Exception;

    public Usuario getById(Long id) throws Exception;

    public boolean update(Long id, UsuarioDto usuario) throws Exception;

    public boolean delete(Long id) throws Exception;
}
