import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class VoceMorreuFrame extends JFrame{
    ImageIcon logo = new ImageIcon("transparente.png");
    Color CorPadraoEscura= new Color(176,176,160);
    Color CorPadraoClara = new Color(220,220,200);
    Border borderRaised = BorderFactory.createRaisedBevelBorder();
    Border borderLowered = BorderFactory.createLoweredBevelBorder();
    Font FontePadrao = new Font("Courier", Font.BOLD,30);

    JButton JButtonVoceMorreu = new JButton();
    VoceMorreuFrame(){

            JLabel JLabelVoceMorreu = new JLabel();
            JLabelVoceMorreu.setText("Você morreu!");
            JLabelVoceMorreu.setFont(FontePadrao);
            JLabelVoceMorreu.setBorder(borderLowered);
            JLabelVoceMorreu.setBounds(10,10,315,50);
            JLabelVoceMorreu.setBackground(CorPadraoEscura);
            JLabelVoceMorreu.setOpaque(true);

            JButtonVoceMorreu.setBounds(200,65,100,40);
            JButtonVoceMorreu.setText("Ok");
            JButtonVoceMorreu.setFocusable(false);
            JButtonVoceMorreu.addActionListener(e -> System. exit(0));

            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.setTitle("X__X");
            this.setLocationRelativeTo(null);
            this.setIconImage(logo.getImage());
            this.setResizable(false);
            this.setAlwaysOnTop(true);
            this.setBackground(CorPadraoClara);
            this.setLayout(null);
            this.setSize(350,150);
            this.add(JLabelVoceMorreu);
            this.add(JButtonVoceMorreu);
    }
}
