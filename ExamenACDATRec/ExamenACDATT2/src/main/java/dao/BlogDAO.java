package dao;

import models.Entrada;

public interface BlogDAO {
    void guardar(Entrada e);
    void portada();
}
