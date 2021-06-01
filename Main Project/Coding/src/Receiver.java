import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Receiver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2L;

	JPanel p = new JPanel();

	JTextArea ta = new JTextArea();
	JScrollPane pane = new JScrollPane();

	public Font f4 = new Font("Times new roman", Font.BOLD, 15);

	Receiver() {

		p.setLayout(null);
		p.setBackground(new Color(150, 5, 150));

		Border b = BorderFactory.createBevelBorder(0);
		JLabel l = new JLabel();
		l.setBorder(b);
		l.setBounds(50, 35, 400, 250);

		TitledBorder border = new TitledBorder("Received File");
		JLabel brd = new JLabel();
		brd.setBorder(border);

		brd.setBounds(50, 300, 400, 350);

		ta.setRows(10);
		ta.setColumns(10);
		ta.setFont(f4);
		pane.setViewportView(ta);
		pane.setBounds(60, 320, 375, 300);
		
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("Receiver.jpeg"));
		JLabel title=new JLabel();
		title.setIcon(banner);
		title.setBounds(100, 80, 300, 200);
		

		p.add(pane);
		p.add(l);
		p.add(brd);
		p.add(title);
		add(p);

		int[] ports = new int[] { 1009 };

		for (int i = 0; i < 1; i++) {

			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();

		}
	}

	public static void main(String[] args) {

		Receiver rr = new Receiver();
		rr.setSize(500, 700);
		rr.setTitle("Receiver::An Efficient Online Algorithm for Dynamic SDN Controller Assignment in Data Center Networks");
		rr.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	class PortListener implements Runnable {

		int port;

		public PortListener(int port) {
			this.port = port;

		}

		public void run() {

			if (this.port == 1009) {

				try {

					ServerSocket server = new ServerSocket(1009);
					Socket socket;

					while (true) {

						socket = server.accept();

						DataInputStream dis = new DataInputStream(
								socket.getInputStream());
						String fname = dis.readUTF();
						String ct = dis.readUTF();

						ta.setText(ct);

						new FileOutputStream("Receiver/" + fname).write(ct
								.getBytes());

						JOptionPane.showMessageDialog(null, "Data Received Successfully");
						
					}

				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		}
	}

}
