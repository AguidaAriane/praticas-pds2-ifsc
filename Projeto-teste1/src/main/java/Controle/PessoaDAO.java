package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Pessoa;

public class PessoaDAO {
  
	public boolean inserir(Pessoa p) {
	  
		//instanciar a classe
		
		Conexao c = Conexao.getInstancia();
		
		// abrir a conexao com o banco de dados 
		
		Connection con = c.conectar();
		
		String query = "INSERT INTO pessoa(idPessoa,PrimeiroNome) VALUES (?,?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			// setar as parametros 
			
			ps.setInt(1,p.getIdPessoa());
			ps.setString(2, p.getPrimeiroNome());
			
			// consolidar a execusao do comando no banco  
			ps.executeUpdate();
			
			// fecha conexao 
			c.fecharConexao();
			
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	  return false;
  }

	
	}

