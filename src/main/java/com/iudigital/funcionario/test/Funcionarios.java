package com.iudigital.funcionario.test;

import com.iudigital.funcionario.controller.FuncionarioController;
import com.iudigital.funcionario.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Funcionarios {

    public static void crear(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el tipo_id");
            String tid = sc.nextLine();
            System.out.println("El Nombre es" + tid);
            System.out.println("--------------------");

            System.out.println("Digite el Numero de Documento");
            String nd = sc.nextLine();
            System.out.println("El Nombre es" + nd);
            System.out.println("--------------------");

            System.out.println("Digite el nombre");
            String nombre = sc.nextLine();
            System.out.println("el nombre es " + nombre);
            System.out.println("----------");

            System.out.println("Digite el apellido");
            String apellido = sc.nextLine();
            System.out.println("El apellido es " + apellido);
            System.out.println("--------------------");

            System.out.println("Digite el estado civil");
            String ec = sc.nextLine();
            System.out.println("el estado civil es " + ec);
            System.out.println("----------");

            System.out.println("Digite el sexo");
            String sexo = sc.nextLine();
            System.out.println("El sexo es" + sexo);
            System.out.println("--------------------");

            System.out.println("Digite el direccion");
            String direccion = sc.nextLine();
            System.out.println("La direccion es " + direccion);
            System.out.println("----------");

            System.out.println("Digite el telefono");
            String telefono = sc.nextLine();
            System.out.println("El telefono es " + telefono);
            System.out.println("--------------------");

            System.out.println("Digite el fecha de nacimiento");
            String fc = sc.nextLine();
            System.out.println("la fecha de nacimiento es " + fc);
            System.out.println("----------");

            Funcionario funcionario = new Funcionario();
            funcionario.setTipoid(tid);
            funcionario.setNumerodocumento(nd);
            funcionario.setNombres(nombre);
            funcionario.setApellidos(apellido);
            funcionario.setEstadocivil(ec);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechanacimiento(fc);
            funcionarioController.crear(funcionario);
            System.out.println("Se creo el F con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void obtenerFuncionarios(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();

            if (funcionarios.isEmpty()) {
                System.out.println("No hay F");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("Id: " + funcionario.getId());
                    System.out.println("Tipoid: " + funcionario.getTipoid());
                    System.out.println("Numerodocumento: " + funcionario.getNumerodocumento());
                    System.out.println("Nombre: " + funcionario.getNombres());
                    System.out.println("Apellidos: " + funcionario.getApellidos());
                    System.out.println("Estadocivil: " + funcionario.getEstadocivil());
                    System.out.println("Sexo: " + funcionario.getSexo());
                    System.out.println("Direccion: " + funcionario.getDireccion());
                    System.out.println("Telefono: " + funcionario.getTelefono());
                    System.out.println("Fechanocimiento: " + funcionario.getFechanacimiento());
                    System.out.println("______________________________________________________");
                    System.out.println("______________________________________________________");
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public static void eliminar(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite el ID de F a eliminar");
            int id = sc.nextInt();
            System.out.println("El ID del f eliminado es: ");
            Funcionario funcionarioExiste = funcionarioController.obtenerFuncionario(id);
            if (funcionarioExiste == null) {
                System.out.println("No existe el F: ");
                System.out.println("-------------------");
                return;
            }

            funcionarioController.eliminarFuncionario(id);
            System.out.println("Funcionario  eliminado con exito.");
            System.out.println("-------------------------------");
            obtenerFuncionarios(funcionarioController);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // FuncionarioController funcionarioController = new FuncionarioController();
        //crear(funcionarioController);
        //obtenerFuncionarios(funcionarioController);

        var option = -1;
        var scanner = new Scanner(System.in);
        FuncionarioController funcionarioController = new FuncionarioController();
        while (option != 0) {
            System.out.println("---------------------");
            System.out.println("---------------------");
            System.out.println("Elija una opcion");
            System.out.println("---------------------");
            System.out.println("---------------------");

            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Eliminar");

            System.out.println("---------------------");
            System.out.println("---------------------");

            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    System.out.println("Ha salido la aplicacion ");
                    break;
                case 1:
                    crear(funcionarioController);
                    break;
                case 2:
                    obtenerFuncionarios(funcionarioController);
                    break;
                case 3:
                    eliminar(funcionarioController);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }
    }
}
