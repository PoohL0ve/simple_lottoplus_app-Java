
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Creates a lotto app, where a using can generate
 * random numbers between 1 and 35, as well as a
 * power ball with numbers between 1 and 10 inclusive.
 * The user has 4 options to choose from: 5, 10, 15, and 20
 * @author PoohL0ve (SWH)
 */
public class AppLotto  extends JFrame {
    private int[][] mixedRows;
    private List<Integer> power = new ArrayList<>();

    public AppLotto() {
        super("Play The Lotto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        //setVisible(true);

        windowComponents();
        setVisible(true);
    }

    /**
     * Adds the relative components to the Frame.
     */
    private void windowComponents() {

        // Container to hold objects
        JPanel panel = new JPanel();
        panel.setBounds(50, 35, 400, 300);
        panel.setBackground(Color.decode("#256FFF"));
        panel.setLayout(null);

        // Text to inform the user
        JLabel label = new JLabel("How many numbers to generate?");
        label.setFont(new Font("Monaco", Font.BOLD, 18));
        label.setBounds(40, 10, 350, 100);
        label.setForeground(Color.decode("#C0C0C0"));

        // Container for the buttons that contains the options
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(25, 125, 350, 100);
        //buttonPanel.setBackground(Color.decode("#483728"));
        buttonPanel.setLayout(new GridLayout(0, 5, 2, 5));

        // Buttons for the options
        JButton numberFive = new JButton("5");
        numberFive.setFont(new Font("Monaco", Font.BOLD, 16));
        numberFive.setForeground(Color.decode("#C0C0C0"));
        numberFive.setBackground(Color.decode("#483728"));
        numberFive.setSize(25, 50);
        numberFive.setOpaque(true);
        numberFive.setBorderPainted(false);
        numberFive.setFocusPainted(true);
        numberFive.setFocusable(true);
        numberFive.addActionListener(e -> generateNumbers(1));

        JButton numberTen = new JButton("10");
        numberTen.setFont(new Font("Monaco", Font.BOLD, 16));
        numberTen.setForeground(Color.decode("#C0C0C0"));
        numberTen.setBackground(Color.decode("#555555"));
        numberTen.setSize(25, 50);
        numberTen.setOpaque(true);
        numberTen.setBorderPainted(false);
        numberTen.setFocusPainted(true);
        numberTen.setFocusable(true);
        numberTen.addActionListener(e -> generateNumbers(2));

        JButton numberFifteen = new JButton("15");
        numberFifteen.setFont(new Font("Monaco", Font.BOLD, 16));
        numberFifteen.setForeground(Color.decode("#C0C0C0"));
        numberFifteen.setBackground(Color.decode("#FFFFFF"));
        numberFifteen.setSize(25, 50);
        numberFifteen.setOpaque(true);
        numberFifteen.setBorderPainted(false);
        numberFifteen.setFocusPainted(true);
        numberFifteen.setFocusable(true);
        numberFifteen.addActionListener(e -> generateNumbers(3));

        JButton numberTwenty = new JButton("20");
        numberTwenty.setFont(new Font("Monaco", Font.BOLD, 16));
        numberTwenty.setForeground(Color.decode("#C0C0C0"));
        numberTwenty.setBackground(Color.decode("#222222"));
        numberTwenty.setSize(25, 50);
        numberTwenty.setOpaque(true);
        numberTwenty.setBorderPainted(false);
        numberTwenty.setFocusPainted(true);
        numberTwenty.setFocusable(true);
        numberTwenty.addActionListener(e -> generateNumbers(4));

        JButton numberTwoFive = new JButton("25");
        numberTwoFive.setFont(new Font("Monaco", Font.BOLD, 16));
        numberTwoFive.setForeground(Color.decode("#555555"));
        numberTwoFive.setBackground(Color.decode("#D1AF78"));
        numberTwoFive.setSize(25, 50);
        numberTwoFive.setOpaque(true);
        numberTwoFive.setBorderPainted(false);
        numberTwoFive.setFocusPainted(true);
        numberTwoFive.setFocusable(true);
        numberTwoFive.addActionListener(e -> generateNumbers(5));

        buttonPanel.add(numberTwoFive);
        buttonPanel.add(numberTwenty);
        buttonPanel.add(numberFifteen);
        buttonPanel.add(numberTen);
        buttonPanel.add(numberFive);
        buttonPanel.setBackground(Color.decode("#483728"));

        panel.add(buttonPanel);
        panel.add(label);
        add(panel);
    }

    /**
     * Generates the 5 random number per row
     * and the power ball.
     * @param number determines the sets of numbers.
     */
    public void generateNumbers(int number) {
        Random random = new Random();
        int rows = 5 * number;
        mixedRows = new int[rows][];

        for (int i = 0; i < rows; i++) {
            mixedRows[i] = new int[5];
            for (int j = 0; j < 5; j++) {
                mixedRows[i][j] = random.nextInt(1, 35);
            }
            // Generate power ball number for each row
            power.add(random.nextInt(1, 11));
        }

        // Call the method to display the numbers
        printNumbers();
    }

    /**
     * Displays the lotto numbers using JOptionPane.
     */
    public void printNumbers() {
        StringBuilder obtainNumbers = new StringBuilder();

        for (int i = 0; i < mixedRows.length; i++) {
            for (int j = 0; j < 5; j++) {
                obtainNumbers.append(" " + mixedRows[i][j]);
            }
            obtainNumbers.append("-").append(power.get(i)).append("\n");
        }

        JOptionPane.showMessageDialog(this, obtainNumbers.toString(), "Lucky Numbers",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
