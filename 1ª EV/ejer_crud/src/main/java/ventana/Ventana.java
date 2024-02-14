package ventana;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;

	// Área de mensajes
	public static final JTextArea mensajes = new JTextArea();
	// Prompt de envío
	private static final JTextField prompt = new JTextField();
	// Botón de envío
	private static final JButton boton = new JButton();
	private final JScrollPane panel1 = new JScrollPane(mensajes);


	public static DataOutputStream dos;

	public Ventana() {
		// Distribución de los componentes por zonas de la ventana
		setLayout(new BorderLayout());
		panel1.setPreferredSize(new Dimension(400, 200));
		prompt.setPreferredSize(new Dimension(200, 30));
		boton.setPreferredSize(new Dimension(20, 30));
		prompt.setToolTipText("Escribe aquí tu mensaje...");
		boton.setText("Enviar");
		
		boton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// Método que se ejecuta cuando hagamos click
				enviar();
			}

		});

		prompt.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					enviar();
				}

			}

		});

		add(panel1, BorderLayout.NORTH);
		add(prompt, BorderLayout.CENTER);
		add(boton, BorderLayout.SOUTH);

		pack();

		setTitle("Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void enviar() {

		String mensaje = prompt.getText();

		// Mostrar mensaje en el área de texto
		mensajes.append("Yo: " + mensaje.substring(mensaje.indexOf(" ") + 1) + "\n");
		// Borrar el mensaje enviado del prompt
		prompt.setText("");

		// TODO CÓDIGO DE ENVÍO DE MENSAJE

		// String mensajeFinal = mensaje.substring(mensaje.indexOf(0, mensaje.indexOf("
		// ") + 1)) + mensaje.substring(mensaje.indexOf(" ") + 1); // Creamos el mensaje
		// final donde indicamos el nombre del pc y el
		// mensaje a enviar, ambos separados por un espacio.

		try {
			dos.writeUTF(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Enviamos el mensaje final al servidor
	}

	public static void escribirVentana(String mensaje) {

		mensajes.append(mensaje);
	}

}
