package dao;

import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    private Connection connection;
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    
    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, cpf, email, telefone) VALUES(?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCPF());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
