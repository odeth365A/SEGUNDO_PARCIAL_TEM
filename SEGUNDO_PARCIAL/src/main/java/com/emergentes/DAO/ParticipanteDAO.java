
package com.emergentes.dao;

import com.emergentes.modelos.Participante;
import java.util.List;

public interface ParticipanteDAO {
    public void insert(Participante part) throws Exception;
    public void update(Participante part) throws Exception;
    public void delete(int id) throws Exception;
    public Participante getById(int id) throws Exception;
    public List<Participante> getAll() throws Exception;
}

