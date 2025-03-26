import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Cidade1Peixaria extends JFrame{
    ImageIcon logo = new ImageIcon("transparente.png");
    Font font1 = new Font("Courier", Font.BOLD,15);
    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();
    Color CorPadraoPanel = new Color(220,220,200);
    Color  CorPadraoButton= new Color(176,176,160);

    PadraoPanelMapaLocalizacao ComprarPeixePequenoPanel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao Saida = new PadraoPanelMapaLocalizacao();

    Cidade1Peixaria(){

        JLabel ComprarPeixePequenoLabel = new JLabel();
        ComprarPeixePequenoLabel.setText("1Cc");
        ComprarPeixePequenoLabel.setBounds(90,90,20,20);

        ComprarPeixePequenoPanel.LocalizacaoButton.setText("Peixe Pequeno(3)");
        ComprarPeixePequenoPanel.setBounds(140,170,120,70);
        ComprarPeixePequenoPanel.add(ComprarPeixePequenoLabel);
        ComprarPeixePequenoPanel.setLayout(new GridLayout(2,1));

        Saida.setBounds (170,290,100,50);
        Saida.LocalizacaoButton.setText("Saída");

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setTitle("O Boto Rosa");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.add(ComprarPeixePequenoPanel);
        this.add(Saida);
        this.setVisible(false);
    }
}
