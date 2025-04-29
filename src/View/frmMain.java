package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmMain frame = new frmMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frmMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JDesktopPane desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);
        
        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);

        JButton btnNovoContato = new JButton("Novo Contato");
        btnNovoContato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmCadastraContato frmContato = new frmCadastraContato();
                desktopPane.add(frmContato);
                frmContato.setVisible(true);
            }
        });

        toolBar.add(btnNovoContato);

        JButton btnTodosContatos = new JButton("Ver Todos Contatos");
        btnTodosContatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmConsultaContatos frmContato = new frmConsultaContatos();
                desktopPane.add(frmContato);
                frmContato.setVisible(true);
            }
        });
        toolBar.add(btnTodosContatos);
    }
}
