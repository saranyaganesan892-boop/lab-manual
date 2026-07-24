import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener
{
    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button b1, b2, b3, b4;

    SimpleCalculator()
    {
        l1 = new Label("First Number");
        l2 = new Label("Second Number");
        l3 = new Label("Result");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();

        b1 = new Button("Add");
        b2 = new Button("Subtract");
        b3 = new Button("Multiply");
        b4 = new Button("Divide");

        l1.setBounds(50, 50, 100, 30);
        t1.setBounds(170, 50, 100, 30);

        l2.setBounds(50, 100, 100, 30);
        t2.setBounds(170, 100, 100, 30);

        l3.setBounds(50, 150, 100, 30);
        t3.setBounds(170, 150, 100, 30);

        b1.setBounds(50, 220, 60, 30);
        b2.setBounds(120, 220, 70, 30);
        b3.setBounds(200, 220, 70, 30);
        b4.setBounds(280, 220, 60, 30);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setTitle("Simple Calculator");
        setSize(400, 350);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        double n1 = Double.parseDouble(t1.getText());
        double n2 = Double.parseDouble(t2.getText());
        double result = 0;

        if (e.getSource() == b1)
            result = n1 + n2;

        else if (e.getSource() == b2)
            result = n1 - n2;

        else if (e.getSource() == b3)
            result = n1 * n2;

        else if (e.getSource() == b4)
            result = n1 / n2;

        t3.setText(String.valueOf(result));
    }

    public static void main(String args[])
    {
        new SimpleCalculator();
    }
}
