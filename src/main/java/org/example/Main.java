package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //config de conexão
        String url = "jdbc:mysql://localhost:3306/poo";
        String usuario = "root";
        String senha = "";

        //comando SQL
        String sql = "INSERT INTO aluno (nome, endereco) VALUES (?, ?)";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

            //prepara uma instrução SQL
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, "Leandro");
            statement.setString(2, "Rua Aleatória, número 1");

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Inseriu com sucesso!");
            }
            statement.close();
            conexao.close();

        }catch (SQLException erro) {
            System.out.println("Ocorreu um erro! Entre em contato com admin");
        }
    }
}