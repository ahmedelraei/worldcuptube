package client;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton selectButton;
    private JTextField videoPathTextField;
    private JTextField videoTitleTextField;
    private JTextField videoTagsTextField;
    private JTextArea videoDescTextArea;
    private JButton uploadButton;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("World Cup Tube");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 720));
        pack();
        setVisible(true);

        selectButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Video Files", "mp4", "avi", "mkv");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Select Video");
            int res = fileChooser.showOpenDialog(this);
            if (res == JFileChooser.APPROVE_OPTION) {
                videoPathTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
    }
}
