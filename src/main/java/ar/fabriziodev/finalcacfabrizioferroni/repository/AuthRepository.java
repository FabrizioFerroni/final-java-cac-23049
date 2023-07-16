package ar.fabriziodev.finalcacfabrizioferroni.repository;

import ar.fabriziodev.finalcacfabrizioferroni.models.dto.UsuarioDto;

public interface AuthRepository {
    public boolean register(UsuarioDto usuario) throws Exception;

    public Object login(String username, String password) throws Exception;
}
