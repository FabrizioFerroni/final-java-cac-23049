package ar.fabriziodev.finalcacfabrizioferroni.repository;

import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;

public interface AuthRepository {
    public boolean register(Usuario usuario) throws Exception;

    public Object login(String username, String password) throws Exception;
}
