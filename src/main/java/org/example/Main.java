package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //config de conexão
        String url = "jdbc:mysql://localhost:3306/poo";
        String usuario = "root";
        String senha = "";

        //comando SQL
        String sql = "SELECT * FROM aluno";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

            //prepara uma instrução SQL
            PreparedStatement statement = conexao.prepareStatement(sql);

            //statement.setString(1, "Kathe");
           //statement.setString(2, "Rua Qualquer, número ");

            //if (linhasAfetadas > 0) {
              //System.out.println("Inseriu com sucesso!");
            //}

            ResultSet alunos = statement.executeQuery();
            while (alunos.next()) {
                int id = alunos.getInt("id");
                String nome = alunos.getString("nome");
                String endereco = alunos.getString("endereco");
                System.out.println(id + " - " + nome + " - " + endereco);
            }

            statement.close();
            conexao.close();

        }catch (SQLException erro) {
            System.out.println("Ocorreu um erro! Entre em contato com admin.");
        }
    }
}