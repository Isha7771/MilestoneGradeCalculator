import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MilestoneUI extends JFrame implements ActionListener {
    private JTextField txtM1, txtM2, txtTA, txtTotal;
    private JButton btnCalculate;

    public MilestoneUI() {
        super("Milestone Grade Calculator");
        setLayout(new GridLayout(5, 2, 10, 10));

        // Input Labels and Text Fields
        add(new JLabel("Milestone 1 (0–25):"));
        txtM1 = new JTextField();
        add(txtM1);

        add(new JLabel("Milestone 2 (0–40):"));
        txtM2 = new JTextField();
        add(txtM2);

        add(new JLabel("Terminal Assessment (0–35):"));
        txtTA = new JTextField();
        add(txtTA);

        add(new JLabel("Total Grade:"));
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        add(txtTotal);

        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this);
        add(new JLabel()); // Empty cell
        add(btnCalculate);

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            float m1 = Float.parseFloat(txtM1.getText());
            float m2 = Float.parseFloat(txtM2.getText());
            float ta = Float.parseFloat(txtTA.getText());

            Milestone milestone = new Milestone();
            milestone.setMilestone1(m1);
            milestone.setMilestone2(m2);
            milestone.setTerminalAssessment(ta);

            float total = milestone.calculateTotal();
            txtTotal.setText(String.format("%.2f", total));

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(this, iae.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MilestoneUI();
    }
}
