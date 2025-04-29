package View;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import Control.Contato;
import model._contato;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCadastraContato extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastraContato frame = new frmCadastraContato();
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
	public frmCadastraContato() {
		
		txtId = new JTextField();
		txtNome = new JTextField();
		txtTelefone = new JTextField();
		txtCidade = new JTextField();
		txtEstado = new JTextField();
		txtEndereco = new JTextField();
		txtComplemento = new JTextField();
		textField = new JTextField();
		textField_1 = new JTextField();
		
		_contato c = new _contato();
		Contato cont = new Contato();
		int id = cont.retornaUltimoId();
		if (id != 0) {
			c = cont.ConsultaContatoById(id);
			
			txtTelefone.setText(c.get_telefone());
			txtComplemento.setText(c.get_complemento());
			txtEndereco.setText(c.get_endereco());
			txtEstado.setText(c.get_estado());
			txtId.setText(String.valueOf(c.get_id()));
			txtNome.setText(c.get_nome());
			txtId.setEnabled(false);
		} else {
			txtId.setEnabled(false);
		}
		
		setIconifiable(true);
		setClosable(true);
		setTitle("Cadastro de Contato");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(29, 21, 86, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setBackground(SystemColor.window);
		txtpnId.setText("ID");
		txtpnId.setBounds(10, 21, 24, 20);
		getContentPane().add(txtpnId);
		txtpnId.setOpaque(false);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(141, 21, 34, 20);
		getContentPane().add(txtpnNome);
		txtpnNome.setOpaque(false);
		
		txtNome = new JTextField();
		txtNome.setBounds(185, 21, 164, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JTextPane txtpnTelefone = new JTextPane();
		txtpnTelefone.setText("Telefone");
		txtpnTelefone.setBounds(10, 62, 49, 20);
		getContentPane().add(txtpnTelefone);
		txtpnTelefone.setOpaque(false);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(69, 62, 134, 20);
		getContentPane().add(txtTelefone);
		
		JTextPane txtpnEndereo = new JTextPane();
		txtpnEndereo.setText("Endereço");
		txtpnEndereo.setBounds(10, 101, 49, 20);
		getContentPane().add(txtpnEndereo);
		txtpnEndereo.setOpaque(false);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(69, 101, 134, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JTextPane txtpnComplemento = new JTextPane();
		txtpnComplemento.setText("Complemento");
		txtpnComplemento.setBounds(213, 101, 72, 20);
		getContentPane().add(txtpnComplemento);
		txtpnComplemento.setOpaque(false);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(295, 101, 111, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JTextPane txtpnCidade = new JTextPane();
		txtpnCidade.setText("Cidade");
		txtpnCidade.setBounds(10, 144, 49, 20);
		getContentPane().add(txtpnCidade);
		txtpnCidade.setOpaque(false);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(69, 144, 134, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		JTextPane txtpnEstado = new JTextPane();
		txtpnEstado.setText("Estado");
		txtpnEstado.setBounds(213, 144, 40, 20);
		getContentPane().add(txtpnEstado);
		txtpnEstado.setOpaque(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 144, 143, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPrimeiro = new JButton("<");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contato contact = new Contato();
				int id = contact.retornaPrimeiroId();
				_contato model = contact.ConsultaContatoById(id);
				
				txtTelefone.setText(model.get_telefone());
				txtComplemento.setText(model.get_complemento());
				txtEndereco.setText(model.get_endereco());
				txtEstado.setText(model.get_estado());
				txtId.setText(String.valueOf(model.get_id()));
				txtNome.setText(model.get_nome());
				
			}
		});
		
		btnPrimeiro.setBackground(new Color(0, 128, 192));
		btnPrimeiro.setBounds(10, 216, 46, 30);
		getContentPane().add(btnPrimeiro);
		
		JButton btnAnterior = new JButton("<<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				id--;
		
				Contato contact = new Contato();
				_contato model = contact.ConsultaContatoById(id);
				
				txtTelefone.setText(model.get_telefone());
				txtComplemento.setText(model.get_complemento());
				txtEndereco.setText(model.get_endereco());
				txtEstado.setText(model.get_estado());
				txtId.setText(String.valueOf(model.get_id()));
				txtNome.setText(model.get_nome());
		
			}
		});
		btnAnterior.setBackground(new Color(0, 128, 192));
		btnAnterior.setBounds(65, 216, 61, 30);
		getContentPane().add(btnAnterior);
		
		JButton btnProximo = new JButton(">>");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				id++;
		
				Contato contact = new Contato();
				_contato model = contact.ConsultaContatoById(id);
				
				txtTelefone.setText(model.get_telefone());
				txtComplemento.setText(model.get_complemento());
				txtEndereco.setText(model.get_endereco());
				txtEstado.setText(model.get_estado());
				txtId.setText(String.valueOf(model.get_id()));
				txtNome.setText(model.get_nome());
				
			}
		});
		btnProximo.setBackground(new Color(0, 128, 192));
		btnProximo.setBounds(136, 216, 61, 30);
		getContentPane().add(btnProximo);
		
		JButton btnUltimo = new JButton(">");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contato contact = new Contato();
				int id = contact.retornaUltimoId();
				_contato model = contact.ConsultaContatoById(id);
				
				txtTelefone.setText(model.get_telefone());
				txtComplemento.setText(model.get_complemento());
				txtEndereco.setText(model.get_endereco());
				txtEstado.setText(model.get_estado());
				txtId.setText(String.valueOf(model.get_id()));
				txtNome.setText(model.get_nome());
				
			}
		});
		btnUltimo.setBackground(new Color(0, 128, 192));
		btnUltimo.setBounds(207, 216, 46, 30);
		getContentPane().add(btnUltimo);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCadastraContato.this.dispose();
				frmCadastraContato frame = new frmCadastraContato();
				frame.setVisible(true);
				
				txtTelefone.setText("");
				txtComplemento.setText("");
				txtEndereco.setText("");
				txtEstado.setText("");
				txtId.setText("");
				txtNome.setText("");
				
				txtId.setEnabled(false);
				
			}
		});
		btnNovo.setBounds(263, 216, 70, 30);
		getContentPane().add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        
		        Contato contact = new Contato();
		        _contato model = new _contato();
		        
		        model.set_cidade(txtCidade.getText());
		        model.set_complemento(txtComplemento.getText());
		        model.set_endereco(txtEndereco.getText());
		        model.set_estado(txtEstado.getText());
		        model.set_nome(txtNome.getText());
		        model.set_telefone(txtTelefone.getText());
		        
		        if (!txtId.getText().isEmpty()) { // Verifica se o campo txtId não está vazio
		            model.set_id(Integer.parseInt(txtId.getText()));
		            contact.AtualizaContato(model);
		            JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso");
		        } else {
		            contact.insereContato(model);
		            JOptionPane.showMessageDialog(null, "Contato salvo com sucesso");
		        }
		    }
		});
		btnSalvar.setBounds(345, 216, 70, 30);
		getContentPane().add(btnSalvar);
	}
}
