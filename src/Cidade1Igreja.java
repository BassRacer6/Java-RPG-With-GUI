import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Cidade1Igreja extends JFrame{
    ImageIcon logo = new ImageIcon("transparente.png");
    Font font1 = new Font("Courier", Font.BOLD,15);
    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();
    Color CorPadraoPanel = new Color(220,220,200);
    Color  CorPadraoButton= new Color(176,176,160);

    PadraoPanelMapaLocalizacao PadreConversar = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao Entrada = new PadraoPanelMapaLocalizacao();

    Cidade1Igreja(){

        Entrada.LocalizacaoButton.setText("Saída");
        Entrada.setBounds(170,170,100,40);

        PadreConversar.LocalizacaoButton.setText("Padre");
        PadreConversar.setBounds(170,10,70,70);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setTitle("Igreja São Bernardo");
        this.setResizable(false);
        this.setSize(450,300);
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.add(PadreConversar);
        this.add(Entrada);
        this.setVisible(false);
    }
}
