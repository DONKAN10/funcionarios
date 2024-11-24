//se comunica con el repo
//hace las consultas
package com.iudigital.funcionario.dao;

import com.iudigital.funcionario.domain.Funcionario;
import com.iudigital.funcionario.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JR
 */
public class FuncionarioDao {

    private static final String GET_FUNCIONARIO = "select * from funcionarios";
    private static final String CREATE_FUNCIONARIO = "insert into funcionarios(Tipoid , Numerodocumento, Nombres, Apellidos, Estadocivil, Sexo, Direccion,"
            + " Telefono, Fechanacimiento) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios where id = ?;";
    private static final String UPDATE_FUNCIONARIO = "update funcionarios set Tipoid = ?, Numerodocumento = ?, Nombres = ?, Apellidos = ?, "
            + "Estadocivil = ?, Sexo = ?, Direccion = ?, Telefono = ?, Fechanacimiento = ? where ID = ?";
    private static final String DELETE_FUNCIONARIO = "delete from funcionarios where id = ?";

    //Obtener funcionario
    public List<Funcionario> obtenerFuncionarios() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("Id"));
                funcionario.setTipoid(resultSet.getString("Tipoid"));
                funcionario.setNumerodocumento(resultSet.getString("Numerodocumento"));
                funcionario.setNombres(resultSet.getString("Nombres"));
                funcionario.setApellidos(resultSet.getString("Apellidos"));
                funcionario.setEstadocivil(resultSet.getString("Estadocivil"));
                funcionario.setSexo(resultSet.getString("Sexo"));
                funcionario.setDireccion(resultSet.getString("Direccion"));
                funcionario.setTelefono(resultSet.getString("Telefono"));
                funcionario.setFechanacimiento(resultSet.getString("Fechanacimiento"));
                funcionarios.add(funcionario);
            }

            return funcionarios;

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }

        }

    }
    // crear funcionario

    public void crear(Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoid());
            preparedStatement.setString(2, funcionario.getNumerodocumento());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadocivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechanacimiento());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
    }

    // listar funcionario
    public Funcionario obtenerFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("Id"));
                funcionario.setTipoid(resultSet.getString("Tipoid"));
                funcionario.setNumerodocumento(resultSet.getString("Numerodocumento"));
                funcionario.setNombres(resultSet.getString("Nombres"));
                funcionario.setApellidos(resultSet.getString("Apellidos"));
                funcionario.setEstadocivil(resultSet.getString("Estadocivil"));
                funcionario.setSexo(resultSet.getString("Sexo"));
                funcionario.setDireccion(resultSet.getString("Direccion"));
                funcionario.setTelefono(resultSet.getString("Telefono"));
                funcionario.setFechanacimiento(resultSet.getString("Fechanacimiento"));

            }
            return funcionario;

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }

        }
    }

    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoid());
            preparedStatement.setString(2, funcionario.getNumerodocumento());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadocivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechanacimiento());
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
    }
    //eliminar fincionario
    public void eliminarFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
