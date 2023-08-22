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
   public boolean excluir(Pessoa p) {
	   Conexao c = Conexao.getInstancia();
	   Connection con = c.conectar();
	   
	   String query = "DELETE FROM pessoa WHERE id_pessoa";
	   
	   try {
		   PreparedStatement ps = con.prepareStatement(query);
	       ps.setInt(1, p.getIdPessoa());
		   
	       ps.executeUpdate();
		   
		   c.fecharConexao();
		   
		   return true;
	   
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
   
	   
	  
   }
   public boolean atualiar(Pessoa p) {
	   Conexao c = Conexao.getInstancia();
	   Connection con = c.conectar();
	   
	   String query = "UPDATE pessoa SET" + "primeiro_nome = ? WHERE id_pessoa ";
	   
	   try {
		   PreparedStatement ps = con.prepareStatement(query);
			       ps.setString(1, p.getPrimeiroNome());
				   ps.setLong(2,p.getIdPessoa());
			       ps.executeUpdate();
				   
				   c.fecharConexao();
	   
	   return true;
   }catch(SQLException e) {
	   e.printStackTrace();
   }
   }



