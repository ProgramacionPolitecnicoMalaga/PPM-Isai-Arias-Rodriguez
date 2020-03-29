package DAO;

import Modelo.Persona;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDAO implements DAO_Interface {
    Conecta conn=new Conecta();
    public PersonaDAO() throws SQLException {}
    final String Crear="INSERT INTO Empleado(nombre, edad) VALUES(?, ?)";
    final String Modificar="UPDATE Empleado SET (nombre, edad) WHERE id=?";
    final String Borrar="DELETE FROM Empleado WHERE id=?";
    final String Consutar="SELECT * FROM Empleado WHERE id=?";
    @Override
    public void añadirPersona(Persona PersonaNueva) throws SQLException {
        conn.create("INSERT INTO Empleado(nombre ,edad) VALUES ('"+PersonaNueva.getNombre()+"','"+PersonaNueva.getEdad()+"')");
    }

    @Override
    public void BorrarPersona(Persona PersonaBorrar) throws SQLException {
        conn.delete("DELETE FROM Empleado WHERE id='"+PersonaBorrar.getId()+"'");
    }


    @Override
    public Persona ConsultarPersona(int IdPersona) throws SQLException {
        Persona PersonaBuscada=null;
        ResultSet result=conn.read("SELECT * FROM Empleado WHERE id='"+IdPersona+"'");
        while (result.next()){
           PersonaBuscada=new Persona(result.getInt("id"),result.getInt("edad"),result.getString("nombre"));
        }
        return PersonaBuscada;
    }

    public ArrayList<Persona> CargarArray() throws SQLException {
        ArrayList<Persona> ListaEmpleados=new ArrayList<>();
        ResultSet result=conn.read("SELECT id, nombre, edad FROM Empleado");
        while (result.next()){
            ListaEmpleados.add(new Persona(result.getInt("id"),result.getInt("edad"),result.getString("nombre")));
        }
        return ListaEmpleados;
    }
}
