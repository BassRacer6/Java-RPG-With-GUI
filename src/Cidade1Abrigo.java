import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Cidade1Abrigo extends JFrame{
    ImageIcon logo = new ImageIcon("transparente.png");
    Font font1 = new Font("Courier", Font.BOLD,15);
    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();
    Color CorPadraoPanel = new Color(220,220,200);
    Color  CorPadraoButton= new Color(176,176,160);

    PadraoPanelMapaLocalizacao Porta1 = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao Saida = new PadraoPanelMapaLocalizacao();

    Cidade1Abrigo(){

        Saida.LocalizacaoButton.setText("Saída");
        Saida.setBounds(100,250,70,50);

        Porta1.LocalizacaoButton.setText("Porta#1");
        Porta1.setBounds(170,170,70,60);

        PadraoPanelMapaLocalizacao Porta2 = new PadraoPanelMapaLocalizacao();
        Porta2.LocalizacaoButton.setText("Porta#2");
        Porta2.setBounds(170,100,70,60);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setTitle("Casa Depredada");
        this.setResizable(false);
        this.setSize(300,350);
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.add(Porta1);
        this.add(Porta2);
        this.add(Saida);
        this.setVisible(false);
    }
}
