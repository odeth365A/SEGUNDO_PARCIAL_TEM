
package com.emergentes.dao;

import com.emergentes.modelos.Seminario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDAO_imp extends ConexionDB implements SeminarioDAO{

    @Override
    public void insert(Seminario sem) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO seminarios (titulo,fecha,cupo) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, sem.getTitulo());
            ps.setDate(2, sem.getFecha());
            ps.setInt(3, sem.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seminario sem) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE seminarios set titulo=?,fecha=?,cupo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, sem.getTitulo());
            ps.setDate(2, sem.getFecha());
            ps.setInt(3, sem.getCupo());
            ps.setInt(4, sem.getId());
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
            String sql = "DELETE FROM seminarios where id=?";
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
    public Seminario getById(int id) throws Exception {
            Seminario sem = new Seminario();
        try {
            this.conectar();
            String sql = "Select * FROM seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setFecha(rs.getDate("fecha"));
                sem.setCupo(rs.getInt("cupo"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return sem;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
        List<Seminario> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seminario>();
            
            while(rs.next())
            {
                Seminario sem = new Seminario();
                
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setFecha(rs.getDate("fecha"));
                sem.setCupo(rs.getInt("cupo"));
                
                lista.add(sem);
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
