import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class user extends JFrame implements ActionListener {

    int i = 3, j = 3;
    JLabel label1;
    Container c;
    JComboBox cb;
    JButton Enter, enter, m, b, d, h, f, g, z, select, end;
    JTextArea answer;

    user() {

        /* Frame Creation */

        c = getContentPane();
        setSize(1000, 800);
        setLocationRelativeTo(null);
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(null);

        /* Label Creation */

        label1 = new JLabel("Select a type of traversal");
        label1.setBounds(85, 200, 300, 30);
        label1.setFont(new Font("arial", Font.PLAIN, 25));
        label1.setVisible(true);
        c.add(label1);

        /* Drop-down menu creation */

        String[] operations = { "", "Column-wise", "Row-wise" };
        cb = new JComboBox<>(operations);
        cb.setSize(270, 30);
        cb.setLocation(80, 260);
        cb.setFont(new Font("roboto", Font.PLAIN, 22));
        cb.addActionListener(this);
        c.add(cb);

        /* Answer area creation */

        answer = new JTextArea();
        answer.setSize(230, 100);
        answer.setFont(new Font("arial", Font.PLAIN, 22));
        answer.setLocation(560, 240);
        answer.setVisible(true);
        c.add(answer);

        /* Buttons creation */

        Enter = new JButton("Enter");
        Enter.setSize(80, 30);
        Enter.setLocation(170, 320);
        Enter.setFont(new Font("arial", Font.PLAIN, 17));
        Enter.setVisible(true);
        Enter.addActionListener(this);
        c.add(Enter);

        enter = new JButton("Enter");
        enter.setSize(80, 30);
        enter.setLocation(170, 320);
        enter.setFont(new Font("arial", Font.PLAIN, 17));
        enter.setVisible(false);
        enter.addActionListener(this);
        c.add(enter);

        m = new JButton("Enter");
        m.setSize(80, 30);
        m.setLocation(170, 320);
        m.setFont(new Font("arial", Font.PLAIN, 17));
        m.setVisible(false);
        m.addActionListener(this);
        c.add(m);

        b = new JButton("Enter");
        b.setSize(80, 30);
        b.setLocation(170, 320);
        b.setFont(new Font("arial", Font.PLAIN, 17));
        b.setVisible(false);
        b.addActionListener(this);
        c.add(b);

        d = new JButton("Enter");
        d.setSize(80, 30);
        d.setLocation(170, 320);
        d.setFont(new Font("arial", Font.PLAIN, 17));
        d.setVisible(false);
        d.addActionListener(this);
        c.add(d);

        h = new JButton("Enter");
        h.setSize(80, 30);
        h.setLocation(170, 320);
        h.setFont(new Font("arial", Font.PLAIN, 17));
        h.setVisible(false);
        h.addActionListener(this);
        c.add(h);

        f = new JButton("Enter");
        f.setSize(80, 30);
        f.setLocation(170, 320);
        f.setFont(new Font("arial", Font.PLAIN, 17));
        f.setVisible(false);
        f.addActionListener(this);
        c.add(f);

        g = new JButton("Enter");
        g.setSize(80, 30);
        g.setLocation(170, 320);
        g.setFont(new Font("arial", Font.PLAIN, 17));
        g.setVisible(false);
        g.addActionListener(this);
        c.add(g);

        z = new JButton("Enter");
        z.setSize(80, 30);
        z.setLocation(170, 320);
        z.setFont(new Font("arial", Font.PLAIN, 17));
        z.setVisible(false);
        z.addActionListener(this);
        c.add(z);

        end = new JButton("Enter");
        end.setSize(80, 30);
        end.setLocation(170, 320);
        end.setFont(new Font("arial", Font.PLAIN, 17));
        end.setVisible(false);
        end.addActionListener(this);
        c.add(end);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        String ele = cb.getSelectedItem() + "";

        /* Sparse matrix Creation */

        int a[][] = new int[i][j];
        a[0][0] = 0;
        a[0][1] = 2;
        a[0][2] = 0;
        a[1][0] = 5;
        a[1][1] = 0;
        a[1][2] = 0;
        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 1;

        /* Action allotment */

        /* for blank option seletion */

        if (ele.matches("")) {

            answer.setText("Please select an option");

        }

        /* for Row-wise traversal */

        if (ele.matches("Row-wise")) {
            answer.setText("");
            if (e.getSource() == Enter) {
                answer.setText(a[0][0] + " ");
                Enter.setVisible(false);
                enter.setVisible(true);
            }
            if (e.getSource() == enter) {
                answer.setText(a[0][0] + " " + a[0][1] + " ");
                enter.setVisible(false);
                m.setVisible(true);
            }
            if (e.getSource() == m) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n");
                m.setVisible(false);
                b.setVisible(true);
            }
            if (e.getSource() == b) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " ");
                b.setVisible(false);
                d.setVisible(true);
            }
            if (e.getSource() == d) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + " ");
                d.setVisible(false);
                h.setVisible(true);
            }
            if (e.getSource() == h) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + " " + a[1][2]
                        + "\n");
                h.setVisible(false);
                f.setVisible(true);
            }
            if (e.getSource() == f) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + " " + a[1][2]
                        + "\n" + a[2][0] + " ");
                f.setVisible(false);
                g.setVisible(true);
            }
            if (e.getSource() == g) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + " " + a[1][2]
                        + "\n" + a[2][0] + " " + a[2][1] + " ");
                g.setVisible(false);
                z.setVisible(true);
            }
            if (e.getSource() == z) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + " " + a[1][2]
                        + "\n" + a[2][0] + " " + a[2][1] + " " + a[2][2] + " ");
                z.setVisible(false);
                end.setVisible(true);
            }
            if (e.getSource() == end) {

                enter.setVisible(false);
                m.setVisible(false);
                b.setVisible(false);
                d.setVisible(false);
                h.setVisible(false);
                f.setVisible(false);
                g.setVisible(false);
                z.setVisible(false);
                end.setVisible(false);
                Enter.setVisible(true);

            }
        }

        /* for Column-wise traversal */

        if (ele.matches("Column-wise")) {
            answer.setText("");
            if (e.getSource() == Enter) {
                answer.setText(a[0][0] + "\n");
                Enter.setVisible(false);
                enter.setVisible(true);
            }
            if (e.getSource() == enter) {
                answer.setText(a[0][0] + "\n" + a[1][0] + "\n");
                enter.setVisible(false);
                m.setVisible(true);
            }
            if (e.getSource() == m) {
                answer.setText(a[0][0] + "\n" + a[1][0] + "\n" + a[2][0] + "\n");
                m.setVisible(false);
                b.setVisible(true);
            }
            if (e.getSource() == b) {
                answer.setText(a[0][0] + " " + a[0][1] + "\n" + a[1][0] + "\n" + a[2][0] + "\n");
                b.setVisible(false);
                d.setVisible(true);
            }
            if (e.getSource() == d) {
                answer.setText(a[0][0] + " " + a[0][1] + "\n" + a[1][0] + " " + a[1][1] + "\n" + a[2][0] + "\n");
                d.setVisible(false);
                h.setVisible(true);
            }
            if (e.getSource() == h) {
                answer.setText(a[0][0] + " " + a[0][1] + "\n" + a[1][0] + " " + a[1][1] + "\n" + a[2][0] + " " + a[2][1]
                        + "\n");
                h.setVisible(false);
                f.setVisible(true);
            }
            if (e.getSource() == f) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + "\n" + a[2][0]
                        + " " + a[2][1] + "\n");
                f.setVisible(false);
                g.setVisible(true);
            }
            if (e.getSource() == g) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + " " + a[1][2]
                        + "\n" + a[2][0] + " " + a[2][1] + "\n");
                g.setVisible(false);
                z.setVisible(true);
            }
            if (e.getSource() == z) {
                answer.setText(a[0][0] + " " + a[0][1] + " " + a[0][2] + "\n" + a[1][0] + " " + a[1][1] + " " + a[1][2]
                        + "\n" + a[2][0] + " " + a[2][1] + " " + a[2][2] + "\n");
                z.setVisible(false);
                end.setVisible(true);
            }
            if (e.getSource() == end) {

                enter.setVisible(false);
                m.setVisible(false);
                b.setVisible(false);
                d.setVisible(false);
                h.setVisible(false);
                f.setVisible(false);
                g.setVisible(false);
                z.setVisible(false);
                end.setVisible(false);
                Enter.setVisible(true);

            }
        }
    }
}

public class Sparse {
    public static void main(String[] args) {

        /* Calling of class */

        new user();
    }
}
