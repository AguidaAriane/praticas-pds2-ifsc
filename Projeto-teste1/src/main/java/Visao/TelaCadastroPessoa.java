package Visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.PessoaDAO;
import Modelo.Pessoa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtPessoa;
	private JTextField txtidPessoa;
	private JLabel lblprimeiroNome;
	private JTextField txtprimeiroNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPessoa frame = new TelaCadastroPessoa();
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
	public TelaCadastroPessoa() {
		setTitle("Cadastrar Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblidPessoa = new JLabel("Pessoa");
		lblidPessoa.setBounds(43, 48, 46, 14);
		contentPane.add(lblidPessoa);
		
		txtPessoa = new JTextField();
		txtMarca.setBounds(253, 71, 86, 20);
		contentPane.add(txtPessoa);
		txtMarca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idPessoa = txtidPessoa.getText();
				String primeiroNome = txtprimeiroNome.getText();
				
				Pessoa a = new Pessoa();
				a.setIdPessoa(idPessoa);
				a.setPrimeiroNome(primeiroNome);
				PessoaDAO dao = new PessoaDAO();
				dao.inserir(a);
			}
		});
		btnCadastrar.setBounds(172, 214, 99, 23);
		contentPane.add(btnCadastrar);
		
		txtidPessoa = new JTextField();
		txtidPessoa.setColumns(10);
		txtidPessoa.setBounds(86, 45, 86, 20);
		contentPane.add(txtidPessoa);
		
		lblprimeiroNome = new JLabel("primeiroNome");
		lblprimeiroNome.setBounds(43, 97, 46, 17);
		contentPane.add(lblprimeiroNome);
		
		txtprimeiroNome = new JTextField();
		txtprimeiroNome.setBounds(98, 94, 122, 20);
		contentPane.add(txtprimeiroNome);
		txtprimeiroNome.setColumns(10);
	}
}