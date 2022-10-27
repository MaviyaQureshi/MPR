import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UserInterface extends JFrame implements ActionListener {

    JLabel label1, label2, number;
    Container c;
    JComboBox cb;
    JTextField area, rc1, rc2;
    JButton button, solve, enter;
    JTextArea answer;
    JCheckBox check;

    UserInterface() {

        setTitle("Numerical Techniques");

        c = getContentPane();
        setSize(1200, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setBackground(Color.GRAY);
        c.setLayout(null);

        number = new JLabel("Enter the number of rows and columns");
        number.setSize(400, 30);
        number.setLocation(380, 240);
        number.setFont(new Font("arial", Font.PLAIN, 23));
        number.setForeground(Color.BLACK);
        number.setVisible(false);
        c.add(number);

        rc1 = new JTextField();
        rc1.setSize(175, 40);
        rc1.setLocation(480, 300);
        rc1.setFont(new Font("arial", Font.PLAIN, 20));
        rc1.setVisible(false);
        c.add(rc1);

        rc2 = new JTextField();
        rc2.setSize(175, 40);
        rc2.setLocation(480, 350);
        rc2.setFont(new Font("arial", Font.PLAIN, 20));
        rc2.setVisible(false);
        c.add(rc2);

        enter = new JButton("Enter");
        enter.setSize(80, 30);
        enter.setLocation(528, 420);
        enter.setFont(new Font("arial", Font.PLAIN, 17));
        enter.setVisible(false);
        enter.addActionListener(this);
        c.add(enter);

        // label1 = new JLabel("MATRIX VALUES");
        // label1.setBounds(80, 200, 200, 30);
        // label1.setFont(new Font("arial", Font.BOLD, 20));
        // label1.setVisible(false);
        // c.add(label1);

        String[] operations = { "", "Gauss Elimination", "Gauss Seidel", "Newtons forward and backward Interpolation",
                "Inverse using Gauss Elimination" };
        cb = new JComboBox<>(operations);
        cb.setSize(270, 30);
        cb.setLocation(911, 0);
        cb.setFont(new Font("roboto", Font.PLAIN, 17));
        cb.addActionListener(this);
        c.add(cb);

        label2 = new JLabel("a11");
        label2.setLocation(80, 245);
        label2.setSize(40, 30);
        label2.setFont(new Font("arial", Font.PLAIN, 22));
        label2.setVisible(false);
        c.add(label2);

        area = new JTextField();
        area.setLocation(120, 240);
        area.setFont(new Font("arial", Font.PLAIN, 22));
        area.setSize(150, 40);
        area.setVisible(false);
        c.add(area);

        answer = new JTextArea();
        answer.setSize(700, 600);
        answer.setFont(new Font("arial", Font.PLAIN, 20));
        answer.setLocation(430, 240);
        answer.setVisible(false);
        c.add(answer);

        solve = new JButton("Solve");
        solve.setBounds(750, 875, 80, 30);
        solve.setFont(new Font("arial", Font.PLAIN, 15));
        solve.setVisible(false);
        solve.addActionListener(this);
        c.add(solve);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String ele = cb.getSelectedItem() + "";

        if (ele.matches("")) {
            enter.setVisible(false);
            number.setVisible(false);
            rc1.setVisible(false);
            rc2.setVisible(false);
            answer.setVisible(true);
            answer.setText("Please select an operation");
        }

        if (ele.matches("Gauss Elimination")) {
            answer.setVisible(false);
            enter.setVisible(true);
            number.setVisible(true);
            rc1.setVisible(true);
            rc2.setVisible(true);
            if (e.getSource() == enter) {
                number.setVisible(false);
                rc1.setVisible(false);
                rc2.setVisible(false);
                enter.setVisible(false);
                answer.setVisible(true);
                answer.setText("Gaussian Elimination Algorithm Test \n");
                // label1.setVisible(true);
                solve.setVisible(true);
                area.setVisible(true);
                label2.setVisible(true);
            }
        }

        if (ele.matches("Gauss Seidel")) {
            answer.setVisible(true);
            answer.setText("Enter the coefficients of 3 variables and constants for 3 equations: \n");
            label1.setVisible(true);
            solve.setVisible(true);
            area.setVisible(true);
            label2.setVisible(true);
        }

        // if (ele.matches("")) {
        // answer.setText("Please select an operation!");
        // label1.setVisible(false);
        // solve.setVisible(false);
        // area.setVisible(false);
        // label2.setVisible(false);
        // }
        // if (ele.matches("Gauss Elimination")) {
        // answer.setText("Gaussian Elimination Algorithm Test \n");
        // label1.setVisible(true);
        // solve.setVisible(true);
        // area.setVisible(true);
        // label2.setVisible(true);
        // }
        // if (ele.matches("Newtons forward and backward Interpolation")) {
        // answer.setText("Enter no. of rows of data: ");
        // label1.setVisible(true);
        // solve.setVisible(true);
        // area.setVisible(true);
        // label2.setVisible(true);
        // }
        // if (ele.matches("Inverse using Gauss Elimination")) {
        // answer.setText("Inverse of a matrix using Gauss-elimination: \n");
        // label1.setVisible(true);
        // solve.setVisible(true);
        // area.setVisible(true);
        // label2.setVisible(true);
        // }
        // }
    }
}

public class Swings {
    public static void main(String[] args) {
        new UserInterface();
    }
}
