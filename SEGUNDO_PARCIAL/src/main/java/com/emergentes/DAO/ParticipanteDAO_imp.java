
package com.emergentes.dao;

import com.emergentes.modelos.Participante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAO_imp extends ConexionDB implements ParticipanteDAO{

    @Override
    public void insert(Participante part) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO participantes (nombres,apellidos,id_seminario,confirmado) values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, part.getNombres());
            ps.setString(2, part.getApellidos());
            ps.setInt(3, part.getId_seminario());
            ps.setInt(4, part.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Participante part) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE participantes set nombres=?,apellidos=?,id_seminario=?,confirmado=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, part.getNombres());
            ps.setString(2, part.getApellidos());
            ps.setInt(3, part.getId_seminario());
            ps.setInt(4, part.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM participantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Participante getById(int id) throws Exception {
        Participante part = new Participante();
        try {
            this.conectar();
            String sql = "Select * FROM participantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                part.setId(rs.getInt("id"));
                part.setNombres(rs.getString("nombres"));
                part.setApellidos(rs.getString("apellidos"));
                part.setId_seminario(rs.getInt("id_seminario"));
                part.setConfirmado(rs.getInt("confirmado"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return part;
    }

    @Override
    public List<Participante> getAll() throws Exception {
        List<Participante> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM participantes";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Participante>();
            
            while(rs.next())
            {
                Participante part = new Participante();
                
                part.setId(rs.getInt("id"));
                part.setNombres(rs.getString("nombres"));
                part.setApellidos(rs.getString("apellidos"));
                part.setId_seminario(rs.getInt("id_seminario"));
                part.setConfirmado(rs.getInt("confirmado"));
                
                lista.add(part);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}

