package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Producto;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
	EntityManager em = fabrica.createEntityManager();
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
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
	public FrmManteProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 30, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id. Producto :");
		lblNewLabel.setBounds(10, 33, 102, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 108, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 112, 102, 14);
		contentPane.add(lblCategora);
	}

	void listado() {
		List<Producto> lstProducto = em.createQuery("select p from Producto p", Producto.class).getResultList();
		txtSalida.setText(">>>Listado de Productos <<<\n");
		for (Producto p : lstProducto) {
			txtSalida.append(p.getIdprod() + "\t" + p.getDescripcion() + "\t"+ p.getPrecio() +"\n");
		}
		txtSalida.append("-------------------------------\n");
	}
	
	void registrar() {
		// entradas
		String codigo = txtCódigo.getText(); // leerCodigo();

		// -- proceso -> grabar datos en la entidad Usuario
		Producto p = new Producto();
		p.setIdprod(codigo);
		p.setDescripcion("Prueba50");
		p.setStock(500);
		p.setPrecio(0.99);
		p.setIdcategoria(1);
		p.setEstado(1);

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();

		
	}
}
