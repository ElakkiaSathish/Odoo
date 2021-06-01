import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Router1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel p = new JPanel();

	ImageIcon sn, gsn, bn1, bn2, bn3, bn4, bn5, bn6, bn7, bn8, dn, bst;

	JButton refresh = new JButton("REFRESH ROUTER");

	JLabel src = new JLabel(), node1 = new JLabel(), node2 = new JLabel(),
			node3 = new JLabel(), node4 = new JLabel(), node5 = new JLabel(),
			node6 = new JLabel(), node7 = new JLabel(), node8 = new JLabel(),
			dest = new JLabel();

	ImageIcon bl, n1, n3, n7, n57, n68, n7d, n8d;

	JLabel bln1 = new JLabel(), bln2 = new JLabel(), bln3 = new JLabel(),
			bln4 = new JLabel(), bln5 = new JLabel(), bln6 = new JLabel(),
			bln7 = new JLabel(), bln8 = new JLabel(), sn1 = new JLabel(),
			sn3 = new JLabel(), bln47 = new JLabel(), bln57 = new JLabel(),
			bln68 = new JLabel(), bln7d = new JLabel(), bln8d = new JLabel(),
			n12 = new JLabel(), n23 = new JLabel(), n45 = new JLabel(),
			n56 = new JLabel(), n78 = new JLabel();

	ImageIcon rbl, rn1, rn3, rn7, rn57, rn68, rn7d, rn8d, rst, rdn;
	ImageIcon gbl, gn1, gn3, gn7, gn57, gn68, gn7d, gn8d, gst, gdn;

	ImageIcon gnode1, gnode2, gnode3, gnode4, gnode5, gnode6, gnode7, gnode8;

	ImageIcon r1, r2, r3, r4, r5, r6, r7, r8;

	JMenuBar mbr = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem item1 = new JMenuItem("AsssignBandwidth");
	JMenuItem item2 = new JMenuItem("Exit");

	JButton view = new JButton("View Bandwidth");
	JButton route = new JButton("Default RoutingPath");
	JButton sub = new JButton("View Sybil Routing");

	Router1() {

		p.setLayout(null);

		p.setBackground(Color.LIGHT_GRAY);

		setJMenuBar(mbr);
		mbr.add(file);
		file.add(item1);
		file.add(item2);

		refresh.setBounds(650, 50, 150, 35);

		sn = new ImageIcon("image/src.png");
		bn1 = new ImageIcon("image/N1.png");
		bn2 = new ImageIcon("image/N2.png");
		bn3 = new ImageIcon("image/N3.png");
		bn4 = new ImageIcon("image/N4.png");
		bn5 = new ImageIcon("image/N5.png");
		bn6 = new ImageIcon("image/N6.png");
		bn7 = new ImageIcon("image/N7.png");
		bn8 = new ImageIcon("image/N8.png");
		dn = new ImageIcon("image/dest.png");

		gdn = new ImageIcon("image/gdest.png");
		rdn = new ImageIcon("image/rdest.png");

		r1 = new ImageIcon("image/rn1.png");
		r2 = new ImageIcon("image/rn2.png");
		r3 = new ImageIcon("image/rn3.png");
		r4 = new ImageIcon("image/rn4.png");
		r5 = new ImageIcon("image/rn5.png");
		r6 = new ImageIcon("image/rn6.png");
		r7 = new ImageIcon("image/rn7.png");
		r8 = new ImageIcon("image/rn8.png");

		gnode1 = new ImageIcon("image/gn1.png");
		gnode2 = new ImageIcon("image/gn2.png");
		gnode3 = new ImageIcon("image/gn3.png");
		gnode4 = new ImageIcon("image/gn4.png");
		gnode5 = new ImageIcon("image/gn5.png");
		gnode6 = new ImageIcon("image/gn6.png");
		gnode7 = new ImageIcon("image/gn7.png");
		gnode8 = new ImageIcon("image/gn8.png");

		bst = new ImageIcon("image/bst.png");
		rst = new ImageIcon("image/rst.png");
		gst = new ImageIcon("image/gst.png");

		gsn = new ImageIcon("image/gsrc.png");

		n1 = new ImageIcon("image/ton1.png");
		n3 = new ImageIcon("image/ton3.png");
		n7 = new ImageIcon("image/n4n7.png");
		n68 = new ImageIcon("image/n68.png");
		n7d = new ImageIcon("image/n7d.png");
		n57 = new ImageIcon("image/n57.png");
		n8d = new ImageIcon("image/n8d.png");
		bl = new ImageIcon("image/bl2.png");

		rn1 = new ImageIcon("image/rton1.png");
		rn3 = new ImageIcon("image/rton3.png");
		rn7 = new ImageIcon("image/rn4n7.png");
		rn68 = new ImageIcon("image/rn68.png");
		rn7d = new ImageIcon("image/rn7d.png");
		rn57 = new ImageIcon("image/rn57.png");
		rn8d = new ImageIcon("image/rn8d.png");
		rbl = new ImageIcon("image/rl2.png");

		gn1 = new ImageIcon("image/gton1.png");
		gn3 = new ImageIcon("image/gton3.png");
		gn7 = new ImageIcon("image/gn4n7.png");
		gn68 = new ImageIcon("image/gn68.png");
		gn7d = new ImageIcon("image/gn7d.png");
		gn57 = new ImageIcon("image/gn57.png");
		gn8d = new ImageIcon("image/gn8d.png");
		gbl = new ImageIcon("image/gl2.png");

		src.setIcon(sn);
		dest.setIcon(dn);

		node1.setIcon(bn1);
		node2.setIcon(bn2);
		node3.setIcon(bn3);
		node4.setIcon(bn4);
		node5.setIcon(bn5);
		node6.setIcon(bn6);
		node7.setIcon(bn7);
		node8.setIcon(bn8);

		bln1.setIcon(bl);
		bln2.setIcon(bl);
		bln3.setIcon(bl);
		bln4.setIcon(bl);
		bln5.setIcon(bl);

		n12.setIcon(bst);
		n23.setIcon(bst);
		n45.setIcon(bst);
		n56.setIcon(bst);
		n78.setIcon(bst);

		bln47.setIcon(n7);
		bln57.setIcon(n57);
		bln7d.setIcon(n7d);
		bln8d.setIcon(n8d);

		bln68.setIcon(n68);

		sn1.setIcon(n1);
		sn3.setIcon(n3);

		src.setBounds(50, 250, 100, 100);
		dest.setBounds(750, 250, 100, 100);

		node1.setBounds(225, 100, 100, 100);
		node2.setBounds(225, 250, 100, 100);
		node3.setBounds(225, 400, 100, 100);

		node4.setBounds(400, 100, 100, 100);
		node5.setBounds(400, 250, 100, 100);
		node6.setBounds(400, 400, 100, 100);

		node7.setBounds(575, 210, 100, 100);
		node8.setBounds(575, 350, 100, 100);

		n12.setBounds(250, 185, 25, 80);
		n23.setBounds(250, 335, 25, 80);
		n45.setBounds(422, 185, 25, 80);
		n56.setBounds(422, 335, 25, 80);
		n78.setBounds(600, 295, 25, 70);

		bln1.setBounds(120, 290, 100, 15);
		bln2.setBounds(300, 150, 100, 15);
		bln3.setBounds(300, 290, 100, 15);
		bln4.setBounds(300, 435, 100, 15);

		bln47.setBounds(455, 155, 120, 110);
		bln57.setBounds(460, 220, 110, 110);

		bln68.setBounds(460, 365, 110, 110);
		bln7d.setBounds(640, 230, 110, 110);
		bln8d.setBounds(640, 290, 110, 110);

		sn1.setBounds(95, 150, 140, 130);
		sn3.setBounds(95, 315, 140, 135);

		view.setBounds(150, 500, 150, 30);
		route.setBounds(320, 500, 150, 30);
		sub.setBounds(490, 500, 150, 30);

		p.add(src);
		p.add(dest);

		p.add(node1);
		p.add(node2);
		p.add(node3);
		p.add(node4);
		p.add(node5);
		p.add(node6);
		p.add(node7);
		p.add(node8);

		p.add(n12);
		p.add(n23);
		p.add(n45);
		p.add(n56);
		p.add(n78);

		p.add(refresh);

		p.add(bln1);
		p.add(bln2);
		p.add(bln3);
		p.add(bln4);

		p.add(bln5);
		p.add(bln6);
		p.add(bln7);
		p.add(bln8);

		p.add(bln47);
		p.add(bln57);
		p.add(bln68);
		p.add(bln7d);
		p.add(bln8d);

		p.add(sn1);
		p.add(sn3);

		p.add(view);
		p.add(route);
		p.add(sub);

		add(p);

		item1.addActionListener(this);
		item2.addActionListener(this);

		view.addActionListener(this);
		route.addActionListener(this);
		sub.addActionListener(this);

		refresh.addActionListener(this);

		int[] ports = new int[] { 8009, 9009 };

		for (int i = 0; i < 2; i++) {

			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();
		}

	}

	public static void main(String[] args) {
		Router1 r = new Router1();
		r.setSize(1000, 700);
		r.setTitle("Router");
		r.setVisible(true);
		r.setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view) {

			ViewBandwidth vw = new ViewBandwidth();
			vw.setTitle("Bandwidth");
			vw.setSize(500, 400);
			vw.setVisible(true);
			vw.setResizable(false);

		}

		if (e.getSource() == route) {

			DefultRoutingPath vw = new DefultRoutingPath();
			vw.setTitle("Defualt-RoutingPath");
			vw.setSize(500, 400);
			vw.setVisible(true);
			vw.setResizable(false);

		}

		if (e.getSource() == sub) {

			ViewSybilTable vw = new ViewSybilTable();
			vw.setTitle("Defualt-RoutingPath");
			vw.setSize(500, 400);
			vw.setVisible(true);
			vw.setResizable(false);

		}

		if (e.getSource() == refresh) {

			rn1 = new ImageIcon("image/rton1.png");
			rn3 = new ImageIcon("image/rton3.png");
			rn7 = new ImageIcon("image/rn4n7.png");
			rn68 = new ImageIcon("image/rn68.png");
			rn7d = new ImageIcon("image/rn7d.png");
			rn57 = new ImageIcon("image/rn57.png");
			rn8d = new ImageIcon("image/rn8d.png");
			rbl = new ImageIcon("image/rl2.png");

			src.setIcon(sn);
			dest.setIcon(dn);

			node1.setIcon(bn1);
			node2.setIcon(bn2);
			node3.setIcon(bn3);
			node4.setIcon(bn4);
			node5.setIcon(bn5);
			node6.setIcon(bn6);
			node7.setIcon(bn7);
			node8.setIcon(bn8);

			bln1.setIcon(bl);
			bln2.setIcon(bl);
			bln3.setIcon(bl);
			bln4.setIcon(bl);
			bln5.setIcon(bl);

			n12.setIcon(bst);
			n23.setIcon(bst);
			n45.setIcon(bst);
			n56.setIcon(bst);
			n78.setIcon(bst);

			bln47.setIcon(n7);
			bln57.setIcon(n57);
			bln7d.setIcon(n7d);
			bln8d.setIcon(n8d);

			bln68.setIcon(n68);

			sn1.setIcon(n1);
			sn3.setIcon(n3);

		}

		if (e.getSource() == item1) {

			AssignBandwidth as = new AssignBandwidth();
			as.setSize(500, 670);

			as.setVisible(true);
		}

	}

	class PortListener implements Runnable {

		int port;

		public PortListener(int port) {
			this.port = port;

		}

		@SuppressWarnings("unused")
		public void run() {

			if (this.port == 8009) {

				try {

					ServerSocket serverSocket = new ServerSocket(8009);
					Socket socket;

					while (true) {

						socket = serverSocket.accept();

						DataInputStream dis = new DataInputStream(
								socket.getInputStream());

						String node = dis.readUTF();
						String fname = dis.readUTF();
						String cont = dis.readUTF();

						new FileOutputStream("Router/modified/" + fname)
								.write(cont.getBytes());

						SimpleDateFormat sdfDate = new SimpleDateFormat(
								"dd/MM/yyyy");
						SimpleDateFormat sdfTime = new SimpleDateFormat(
								"HH:mm:ss");

						Date now = new Date();

						String strDate = sdfDate.format(now);
						String strTime = sdfTime.format(now);

						String dt = strDate + "   " + strTime;

						MessageDigest md = MessageDigest.getInstance("SHA1");
						FileInputStream in1 = new FileInputStream(
								"Router/modified/" + fname);

						DigestInputStream dis2 = new DigestInputStream(in1, md);

						BufferedInputStream bd = new BufferedInputStream(dis2);

						while (true) {
							int b2 = bd.read();
							if (b2 == -1)
								break;
						}

						BigInteger bi2 = new BigInteger(md.digest());
						String mac = bi2.toString(16);

						String status = "Yes";

						DBConnection
								.getConnection()
								.createStatement()
								.executeUpdate(
										"update SybilAttack set MacAddress = '"
												+ mac + "' , Message = '"
												+ cont + "', Attacker = '"
												+ status
												+ "' where NodeName = '" + node
												+ "'  ");

						DBConnection.getConnection().createStatement()
								.executeUpdate("");

					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}

			if (this.port == 9009) {

				try {

					ServerSocket server = new ServerSocket(9009);
					Socket socket;

					while (true) {

						socket = server.accept();

						DataInputStream dis = new DataInputStream(
								socket.getInputStream());

						String action = dis.readUTF();

						String fname = dis.readUTF();
						String mac = dis.readUTF();
						String content = dis.readUTF();

						DBConnection
								.getConnection()
								.createStatement()
								.executeUpdate(
										"insert into Router values('" + fname
												+ "', '" + mac + "' ) ");

						new FileOutputStream("Router/" + fname).write(content
								.getBytes());

						src.setIcon(gsn);

						Thread.sleep(1000);

						if (action.equals("Jamming")) {

							int nb = content.getBytes("utf8").length;

							String nod1, nod2, nod3, nod4, nod5, nod6, nod7, nod8;
							int bw1 = 0, bw2 = 0, bw3 = 0, bw4 = 0, bw5 = 0, bw6 = 0, bw7 = 0, bw8 = 0;

							String sql = "select * from Bandwidth";

							ResultSet rs = DBConnection.getConnection()
									.createStatement().executeQuery(sql);

							while (rs.next() == true) {

								String node = rs.getString(1);
								int bw = Integer.parseInt(rs.getString(2));

								if (node.equals("Node1")) {
									nod1 = "Node1";
									bw1 = bw;
								}

								if (node.equals("Node2")) {
									nod2 = "Node2";
									bw2 = bw;
								}

								if (node.equals("Node3")) {
									nod3 = "Node3";
									bw3 = bw;
								}

								if (node.equals("Node4")) {
									nod4 = "Node4";
									bw4 = bw;
								}

								if (node.equals("Node5")) {
									nod5 = "Node5";
									bw5 = bw;
								}

								if (node.equals("Node6")) {
									nod6 = "Node6";
									bw6 = bw;
								}

								if (node.equals("Node7")) {
									nod7 = "Node7";
									bw7 = bw;
								}

								if (node.equals("Node8")) {
									nod8 = "Node8";
									bw8 = bw;
								}
							}

							String jam = "Jamming";

							SimpleDateFormat sdfDate = new SimpleDateFormat(
									"dd/MM/yyyy");

							SimpleDateFormat sdfTime = new SimpleDateFormat(
									"HH:mm:ss");

							Date now = new Date();

							String strDate = sdfDate.format(now);
							String strTime = sdfTime.format(now);

							String dt = strDate + "   " + strTime;

							if (bw1 < nb) {

								Thread.sleep(1000);

								sn1.setIcon(rn1);

								Thread.sleep(1000);

								String node = "Node1";

								int x = JOptionPane
										.showConfirmDialog(null,
												"Jamming occurs in Node1 \n Do you want Alter the Path  ");

								if (x == 0) {

									node1.setIcon(r1);

									bln1.setIcon(gbl);
									Thread.sleep(1000);

									if (bw2 < nb) {

										bln1.setIcon(rbl);

										Thread.sleep(1000);

										int x1 = JOptionPane
												.showConfirmDialog(null,
														"Jamming occurs in Node2 \n Do you want Alter the Path  ");

										if (x1 == 0) {

											node2.setIcon(r2);

											if (bw3 < nb) {

												int approv = JOptionPane
														.showConfirmDialog(
																null,
																"Jamming occurs in Node-3");

											} else {

												sn3.setIcon(gn3);
												Thread.sleep(1000);

												node3.setIcon(gnode3);

												Thread.sleep(1000);

												bln4.setIcon(gbl);
												Thread.sleep(1000);

												node6.setIcon(gnode6);

												Thread.sleep(1000);

												bln68.setIcon(gn68);

												Thread.sleep(1000);

												node8.setIcon(gnode8);

												Thread.sleep(1000);

												bln8d.setIcon(gn8d);

												Thread.sleep(1000);

												dest.setIcon(gdn);

												Socket socket2 = new Socket(
														"localhost", 1009);

												DataOutputStream dos = new DataOutputStream(
														socket2.getOutputStream());
												dos.writeUTF(fname);
												dos.writeUTF(content);

											}

										}

										if (x1 == 1) {

											node2.setIcon(r2);
											JOptionPane.showMessageDialog(null,
													"Packets Dropped");

										}

									} else {

										bln1.setIcon(gbl);
										Thread.sleep(1000);

										node2.setIcon(gnode2);

										if (bw5 < nb) {

											Thread.sleep(1000);
											bln3.setIcon(rbl);

											int app = JOptionPane
													.showConfirmDialog(null,
															"Jamming occurs in Node-5");

											if (app == 0) {

												node5.setIcon(r5);

												n23.setIcon(gst);

												node3.setIcon(gnode3);

												Thread.sleep(1000);

												bln4.setIcon(gbl);
												Thread.sleep(1000);

												node6.setIcon(gnode6);

												Thread.sleep(1000);

												bln68.setIcon(gn68);

												Thread.sleep(1000);

												node8.setIcon(gnode8);

												Thread.sleep(1000);

												bln8d.setIcon(gn8d);

												Thread.sleep(1000);

												dest.setIcon(gdn);

												Socket socket2 = new Socket(
														"localhost", 1009);

												DataOutputStream dos = new DataOutputStream(
														socket2.getOutputStream());
												dos.writeUTF(fname);
												dos.writeUTF(content);

											}

											if (app == 1) {

												node5.setIcon(r5);
												JOptionPane
														.showMessageDialog(
																null,
																"Packets Dropped");
											}

										} else {

											bln3.setIcon(gbl);

											Thread.sleep(1000);
											node5.setIcon(gnode5);

											Thread.sleep(1000);

											if (bw7 < nb) {

												bln57.setIcon(rn57);

												Thread.sleep(1000);

												int option = JOptionPane
														.showConfirmDialog(
																null,
																"Jamming occurs in Node7 \n Do you want to Alter the path ");

												if (option == 0) {

													node7.setIcon(r7);

													n56.setIcon(gst);
													Thread.sleep(1000);

													node6.setIcon(gnode6);

													Thread.sleep(1000);

													bln68.setIcon(gn68);

													Thread.sleep(1000);

													node8.setIcon(gnode8);

													Thread.sleep(1000);

													bln8d.setIcon(gn8d);

													Thread.sleep(1000);

													dest.setIcon(gdn);

													Socket socket2 = new Socket(
															"localhost", 1009);

													DataOutputStream dos = new DataOutputStream(
															socket2.getOutputStream());
													dos.writeUTF(fname);
													dos.writeUTF(content);

												}

												if (option == 1) {

													node7.setIcon(r7);
													JOptionPane
															.showMessageDialog(
																	null,
																	"Packets Dropped");

												}

											}

											else {

												Thread.sleep(1000);
												bln57.setIcon(gn57);

												Thread.sleep(1000);
												node7.setIcon(gnode7);

												Thread.sleep(1000);

												bln7d.setIcon(gn7d);

												Thread.sleep(1000);

												dest.setIcon(gdn);

												Socket socket2 = new Socket(
														"localhost", 1009);

												DataOutputStream dos = new DataOutputStream(
														socket2.getOutputStream());
												dos.writeUTF(fname);
												dos.writeUTF(content);

											}
										}
									}

								}

							} else {

								Thread.sleep(1000);

								sn1.setIcon(gn1);

								Thread.sleep(1000);

								node1.setIcon(gnode1);

								if (bw2 < nb) {

									n12.setIcon(rst);

									Thread.sleep(1000);

									int x1 = JOptionPane
											.showConfirmDialog(null,
													"Jamming occurs in Node2 \n Do you want Alter the Path  ");

									if (x1 == 0) {

										node2.setIcon(r2);

										if (bw4 < nb) {

											int approv = JOptionPane
													.showConfirmDialog(null,
															"Jamming occurs in Node-4");

										} else {

											bln2.setIcon(gbl);
											Thread.sleep(1000);

											node4.setIcon(gnode4);

											Thread.sleep(1000);

											bln47.setIcon(gn7);
											Thread.sleep(1000);

											node7.setIcon(gnode7);

											Thread.sleep(1000);

											bln7d.setIcon(gn7d);

											Thread.sleep(1000);

											dest.setIcon(gdn);

											Socket socket2 = new Socket(
													"localhost", 1009);

											DataOutputStream dos = new DataOutputStream(
													socket2.getOutputStream());
											dos.writeUTF(fname);
											dos.writeUTF(content);

										}

									}

								} else {

									n12.setIcon(gst);

									Thread.sleep(1000);
									node2.setIcon(gnode2);

									if (bw5 < nb) {

										Thread.sleep(1000);
										bln3.setIcon(rbl);

										int app = JOptionPane
												.showConfirmDialog(null,
														"Jamming occurs in Node-5");

										if (app == 0) {

											Thread.sleep(1000);
											node5.setIcon(r5);

											Thread.sleep(1000);

											n23.setIcon(gst);

											node3.setIcon(gnode3);

											Thread.sleep(1000);

											bln4.setIcon(gbl);
											Thread.sleep(1000);

											node6.setIcon(gnode6);

											Thread.sleep(1000);

											bln68.setIcon(gn68);

											Thread.sleep(1000);

											node8.setIcon(gnode8);

											Thread.sleep(1000);

											bln8d.setIcon(gn8d);

											Thread.sleep(1000);

											dest.setIcon(gdn);

											Socket socket2 = new Socket(
													"localhost", 1009);

											DataOutputStream dos = new DataOutputStream(
													socket2.getOutputStream());
											dos.writeUTF(fname);
											dos.writeUTF(content);

										}

									}

									else {

										bln3.setIcon(gbl);

										Thread.sleep(1000);
										node5.setIcon(gnode5);

										Thread.sleep(1000);

										if (bw7 < nb) {

											bln57.setIcon(rn57);

											Thread.sleep(1000);

											int option = JOptionPane
													.showConfirmDialog(null,
															"Jamming occurs in Node7 \n Do you want to Alter the path ");

											if (option == 0) {

												node7.setIcon(r7);

												Thread.sleep(1000);

												n56.setIcon(gst);

												Thread.sleep(1000);

												node6.setIcon(gnode6);

												Thread.sleep(1000);

												bln68.setIcon(gn68);

												Thread.sleep(1000);

												node8.setIcon(gnode8);

												Thread.sleep(1000);

												bln8d.setIcon(gn8d);

												Thread.sleep(1000);

												dest.setIcon(gdn);

												Socket socket2 = new Socket(
														"localhost", 1009);

												DataOutputStream dos = new DataOutputStream(
														socket2.getOutputStream());
												dos.writeUTF(fname);
												dos.writeUTF(content);

											}
										}

										else {

											Thread.sleep(1000);
											bln57.setIcon(gn57);

											Thread.sleep(1000);
											node7.setIcon(gnode7);

											Thread.sleep(1000);

											bln7d.setIcon(gn7d);

											Thread.sleep(1000);

											dest.setIcon(gdn);

											Socket socket2 = new Socket(
													"localhost", 1009);

											DataOutputStream dos = new DataOutputStream(
													socket2.getOutputStream());
											dos.writeUTF(fname);
											dos.writeUTF(content);

										}
									}

								}

							}

						}

						if (action.equals("Sybil")) {

							String attack = "Yes";

							String sql = "update SybilAttack set MacAddress = '"
									+ mac + "' ";

							DBConnection.getConnection().createStatement()
									.executeUpdate(sql);

							String query = " select * from SybilAttack ";

							ResultSet rs = DBConnection.getConnection()
									.createStatement().executeQuery(query);

							while (rs.next() == true) {

								String node = rs.getString(1);
								String hash = rs.getString(2);
								String msg = rs.getString(3);
								String atk = rs.getString(4);

								if (node.equals("N2")
										&& atk.equalsIgnoreCase("No")) {

									bln1.setIcon(gbl);
									Thread.sleep(1000);
									node2.setIcon(gnode2);

								}

								else if (node.equals("N2")
										&& atk.equalsIgnoreCase("Yes")) {

									n12.setIcon(rst);
									Thread.sleep(1000);

									node2.setIcon(r2);

									int x = JOptionPane
											.showConfirmDialog(null,
													"The Sybil Attacker found in the network , \n Do you want to Secure the file");

									if (x == 0) {

										resolve("N2", mac);

										n12.setIcon(gst);
										Thread.sleep(1000);
										node2.setIcon(gnode2);

										Thread.sleep(1000);

									}

									if (x == 1) {

										n12.setIcon(rst);
										Thread.sleep(1000);

										node2.setIcon(r2);

										content = content + msg;
									}
								}

								else if (node.equals("N3")
										&& atk.equalsIgnoreCase("No")) {

									n23.setIcon(gst);
									Thread.sleep(1000);
									node3.setIcon(gnode3);

									Thread.sleep(1000);

								} else if (node.equals("N3")
										&& atk.equalsIgnoreCase("Yes")) {

									n23.setIcon(rst);

									int x = JOptionPane
											.showConfirmDialog(null,
													"The Sybil Attacker found in the network , \n Do you want to Secure the file");

									if (x == 0) {

										resolve("N3", mac);

										n23.setIcon(gst);
										Thread.sleep(1000);
										node3.setIcon(gnode3);

										Thread.sleep(1000);

									}
									if (x == 1) {

										n23.setIcon(rst);
										Thread.sleep(1000);
										node3.setIcon(r3);

										Thread.sleep(1000);

										content = content + msg;

									}

								}

								else if (node.equals("N6")
										&& atk.equalsIgnoreCase("No")) {

									bln4.setIcon(gbl);
									Thread.sleep(1000);

									node6.setIcon(gnode6);
									Thread.sleep(1000);

								}

								else if (node.equals("N6")
										&& atk.equalsIgnoreCase("Yes")) {

									bln4.setIcon(rbl);

									int x = JOptionPane
											.showConfirmDialog(null,
													"The Sybil Attacker found in the network , \n Do you want to Secure the file");

									if (x == 0) {

										resolve("N6", mac);

										bln4.setIcon(gbl);
										Thread.sleep(1000);

										node6.setIcon(gnode6);
										Thread.sleep(1000);

									}

									if (x == 1) {

										bln4.setIcon(rbl);
										Thread.sleep(1000);

										node6.setIcon(r6);

										content = content + msg;

									}

								}

								else if (node.equals("N8")
										&& atk.equalsIgnoreCase("No")) {

									Thread.sleep(1000);

									bln68.setIcon(gn68);
									Thread.sleep(1000);

									node8.setIcon(gnode8);

									Thread.sleep(1000);
									bln8d.setIcon(gn8d);

									Thread.sleep(1000);

									dest.setIcon(gdn);

									Socket socket2 = new Socket("localhost",
											1009);

									DataOutputStream dos = new DataOutputStream(
											socket2.getOutputStream());
									dos.writeUTF(fname);
									dos.writeUTF(content);

								}

								else if (node.equals("N8")
										&& atk.equalsIgnoreCase("Yes")) {

									bln68.setIcon(rn68);

									int x = JOptionPane
											.showConfirmDialog(null,
													"The Sybil Attacker found in the network , \n Do you want to Secure the file");

									if (x == 0) {

										resolve("N8", mac);

										bln68.setIcon(gn68);
										Thread.sleep(1000);

										node8.setIcon(gnode8);

										Thread.sleep(1000);
										bln8d.setIcon(gn8d);

										Thread.sleep(1000);

										dest.setIcon(gdn);

										Socket socket2 = new Socket(
												"localhost", 1009);

										DataOutputStream dos = new DataOutputStream(
												socket2.getOutputStream());
										dos.writeUTF(fname);
										dos.writeUTF(content);

									}
									if (x == 1) {

										Thread.sleep(1000);
										bln68.setIcon(rn68);
										Thread.sleep(1000);

										node8.setIcon(r8);

										content = content + msg;

										Thread.sleep(1000);
										bln8d.setIcon(gn8d);

										Thread.sleep(1000);

										dest.setIcon(gdn);

										Socket socket2 = new Socket(
												"localhost", 1009);

										DataOutputStream dos = new DataOutputStream(
												socket2.getOutputStream());
										dos.writeUTF(fname);
										dos.writeUTF(content);

									}
								}
							}
						}
					}

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		}
	}

	void resolve(String node, String mac) {

		try {

			String status = "No";

			String sql = " update SybilAttack set MacAddress = '" + mac
					+ "',  Message = '" + status + "' ,Attacker ='" + status
					+ "' where NodeName = '" + node + "'  ";

			DBConnection.getConnection().createStatement().executeUpdate(sql);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
