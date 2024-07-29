import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz5 {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton submitButton;
    private ButtonGroup[] buttonGroups;
    private JRadioButton[][] options;
    private JLabel[] questions;
    private String[] questionTexts = {
            "Kapan Hari Kemerdekaan Indonesia diperingati?",
            "Pada tahun berapa Indonesia merdeka??",
            "Siapa yang membacakan teks Proklamasi Kemerdekaan Indonesia?",
            "Dimana teks Proklamasi Kemerdekaan Indonesia dibacakan?",
            "Apa nama lagu kebangsaan Indonesia?"
    };
    private String[][] optionTexts = {
            {"17 Agustus", "17 Juli", "17 September", "17 Oktober"},
            {"1945", "1954", "1950", "1955"},
            {"Soekarno", "Mohammad Hatta", "Soeharto", "Sutan Sjahrir"},
            {"Jakarta", "Yogyakarta", "Bali", "Surabaya"},
            {"Indonesia Raya", "Tanah Airku", "Garuda Pancasila", "Satu Nusa Satu Bangsa"}
    };
    private int[] correctAnswers = {0, 0, 0, 0, 0};

    public Quiz5() {
        frame = new JFrame("Quiz Five - email : agusvarchar@gmail.com (Boxlayout)");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        buttonGroups = new ButtonGroup[5];
        options = new JRadioButton[5][4];
        questions = new JLabel[5];

        for (int i = 0; i < 5; i++) {
            questions[i] = new JLabel((i + 1) + ". " + questionTexts[i]);
            mainPanel.add(questions[i]);

            buttonGroups[i] = new ButtonGroup();
            JPanel optionPanel = new JPanel();
            optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));

            for (int j = 0; j < 4; j++) {
                options[i][j] = new JRadioButton(optionTexts[i][j]);
                buttonGroups[i].add(options[i][j]);
                optionPanel.add(options[i][j]);
            }

            mainPanel.add(optionPanel);
        }

        submitButton = new JButton("Post");
        submitButton.addActionListener(new SubmitListener());
        mainPanel.add(submitButton);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700); // Atur ukuran frame di sini
        frame.setVisible(true);
    }

    private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int score = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    if (options[i][j].isSelected() && j == correctAnswers[i]) {
                        score++;
                    }
                }
            }
            JOptionPane.showMessageDialog(frame, "Nilai Anda Adalah: " + score + " dari 5");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Quiz5());
    }
}
