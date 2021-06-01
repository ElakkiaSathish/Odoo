import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewBandwidth extends JFrame

{

	private static final long serialVersionUID = 1L;

	JScrollPane pane;

	JPanel c;

	JLabel imglabel;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	ViewBandwidth() {

		c = new JPanel();
		c.setLayout(null);

		c.setBackground(Color.LIGHT_GRAY);

		try {

			Vector heading = new Vector();

			heading.addElement("NodeName");
			heading.addElement("Bandwidth");

			Vector data = new Vector();

			ResultSet rs = DBCon.getConnection().createStatement()
					.executeQuery("Select * from Bandwidth");

			while (rs.next()) {

				Vector row = new Vector();

				String name = rs.getString(1);
				String x1 = rs.getString(2);

				row.addElement(name);
				row.addElement(x1);

				data.addElement(row);
			}

			JTable table = new JTable(data, heading);

			pane = new JScrollPane(table);

			pane.setBounds(25, 10, 450, 250);
			c.add(pane);

			add(c);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}