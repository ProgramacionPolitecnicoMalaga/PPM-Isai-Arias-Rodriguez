package DAO;

import Modelo.Persona;

import java.sql.SQLException;

public interface DAO_Interface {
    public void añadirPersona(Persona PersonaNueva) throws SQLException;
    public void BorrarPersona(Persona PersonaBorrar) throws SQLException;
    public Persona ConsultarPersona(int IdPersona) throws SQLException;
}
