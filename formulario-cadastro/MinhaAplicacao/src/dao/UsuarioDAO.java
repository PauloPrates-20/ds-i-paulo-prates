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
    private String sexo;
    private String cidade;
    private String estado;
    
    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, cpf, email, telefone, sexo, cidade, estado) VALUES(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCPF());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getSexo());
            stmt.setString(6, usuario.getCidade());
            stmt.setString(7, usuario.getEstado());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
