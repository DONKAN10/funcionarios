
package com.iudigital.funcionario.controller;

import com.iudigital.funcionario.dao.FuncionarioDao;
import com.iudigital.funcionario.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;


public class FuncionarioController {
    private FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        this.funcionarioDao = new FuncionarioDao();
    }
    //Metodo Get
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();
    }

    public void crear (Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);
    }
    //listar
    public Funcionario obtenerFuncionario (int id) throws SQLException {
        return funcionarioDao.obtenerFuncionario(id);
    }

    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {
        this.funcionarioDao.actualizarFuncionario(id, funcionario);
    }

    public void eliminarFuncionario(int id) throws SQLException {
        funcionarioDao.eliminarFuncionario(id);
    }
}
