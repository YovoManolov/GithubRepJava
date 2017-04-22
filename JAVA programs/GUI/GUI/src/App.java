import javax.swing.*;

public class App  implements ActionListener {

JButton button;
int count = 0;

public static void main (String[] args)
{
    App gui = new App();
    gui.go();
}

public void go()
{
    button = new JButton("Click me!");
    JFrame frame = new JFrame();
    frame.getContentPane().add(button);
    frame.setSize(500,500);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent event)
        {
            count++;
            button.setText("I've been clicked "+count+" times");
        }
    });
}

}
