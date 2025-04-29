package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import java.sql.*;

import Control.Contato;

public class frmConsultaContatos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaContatos frame = new frmConsultaContatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmConsultaContatos() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Dados");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.CENTER);
		
		Contato c = new Contato();
		table = new JTable(c.ConsultaTodosDados());
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getContentPane().add(table, BorderLayout.CENTER);
		
		SwingUtilities.invokeLater(() -> { table.doLayout(); });

	}

}
