package Control;

import model._contato;
import Control.DAO;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Contato {
	
	private PreparedStatement stmt = null;
	
	private Statement st;
	private ResultSet rs;
	private String SQL;
	
	public Contato() {}
	
	public void insereContato(_contato contato) {
		DAO database = new DAO();
		
		try {
			SQL = "INSERT INTO contatos (nome, telefone, endereco, complemento, cidade, estado) VALUES (?,?,?,?,?,?)";
			
			stmt = database.abreConexao().prepareStatement(SQL);
			
			stmt.setString(1, contato.get_nome());
			stmt.setString(2, contato.get_telefone());
			stmt.setString(3, contato.get_endereco());
			stmt.setString(4, contato.get_complemento());
			stmt.setString(5, contato.get_cidade());
			stmt.setString(6, contato.get_estado());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} finally {
			database.fechaConexao();
		}
	}
	
	public DefaultTableModel ConsultaTodosDados() {
		DAO database = new DAO();
		try {
			SQL = "SELECT * FROM contatos";
			st = database.abreConexao().createStatement();
			rs = st.executeQuery(SQL);
			
			DefaultTableModel tableModel = new DefaultTableModel();
			
			int columnCount = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				tableModel.addColumn(rs.getMetaData().getColumnName(i));
			}
			
			while (rs.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i=1; i <= columnCount; i++) {
					rowData[i-1] = rs.getObject(i);
				}
				tableModel.addRow(rowData);
			}
			
			return tableModel;
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return null;
		}
		finally {
			database.fechaConexao();
		}
	}
	
	public _contato ConsultaContatoById(int id) {
		_contato cont = new _contato();
		DAO database = new DAO();
		
		try {
			SQL = "SELECT * FROM contatos WHERE id=" + id;
			stmt = database.abreConexao().prepareStatement(SQL);
			rs = stmt.executeQuery();
			rs.next();
			
			cont.set_cidade(rs.getObject("cidade").toString());
			cont.set_complemento(rs.getObject("complemento").toString());
			cont.set_endereco(rs.getObject("endereco").toString());
			cont.set_estado(rs.getObject("estado").toString());
			cont.set_id(Integer.parseInt(rs.getObject("id").toString()));
			cont.set_nome(rs.getObject("nome").toString());
			cont.set_telefone(rs.getObject("telefone").toString());
			
			return cont;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			database.fechaConexao();
		}
		
	}
	
	public int retornaUltimoId() {
		DAO database = new DAO();
		SQL = "SELECT MAX(id) FROM contatos";
		
		try {
			stmt = database.abreConexao().prepareStatement(SQL);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getObject(1) != null) {
				return Integer.parseInt(rs.getObject(1).toString());
			}
			else {
				return 0;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		} 
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int retornaPrimeiroId() {
		DAO database = new DAO();
		SQL = "SELECT MIN(id) FROM contatos";
		
		try {
			stmt = database.abreConexao().prepareStatement(SQL);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getObject(1) != null) {
				return Integer.parseInt(rs.getObject(1).toString());
			}
			else {
				return 0;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		} 
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void AtualizaContato(_contato contato) {
		DAO database = new DAO();
		
		try {
			SQL = "UPDATE contatos set nome=?, telefone=?, endereco=?, complemento=?, cidade=?, estado=? WHERE id=?";
			
			stmt = database.abreConexao().prepareStatement(SQL);
			
			stmt.setString(1, contato.get_nome());
			stmt.setString(2, contato.get_telefone());
			stmt.setString(3, contato.get_endereco());
			stmt.setString(4, contato.get_complemento());
			stmt.setString(5, contato.get_cidade());
			stmt.setString(6, contato.get_estado());
			stmt.setInt(7, contato.get_id());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				database.fechaConexao();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
