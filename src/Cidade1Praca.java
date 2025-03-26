import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Cidade1Praca extends JFrame{

    ImageIcon logo = new ImageIcon("transparente.png");
    Font font1 = new Font("Courier", Font.BOLD,15);
    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();
    Color CorPadraoPanel = new Color(220,220,200);
    Color  CorPadraoButton= new Color(176,176,160);

    PadraoPanelMapaLocalizacao Fonte = new PadraoPanelMapaLocalizacao();
    JFrame FonteInteracaoFrame = new JFrame();

    PadraoPanelMapaLocalizacao FontePegarMoeda = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao FonteEncherCantil = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao FonteAfastar = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao PortaoSair = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao BancoVazio = new PadraoPanelMapaLocalizacao();

    Cidade1Praca(){

        PortaoSair.LocalizacaoButton.setText("Portão");
        PortaoSair.setBounds(10,10,100,40);

        FonteEncherCantil.LocalizacaoButton.setText("Encher cantil");
        FonteEncherCantil.setBounds(70,10,100,40);

        FontePegarMoeda.LocalizacaoButton.setText("Pegar Moedas");
        FontePegarMoeda.setBounds(70,80,100,40);

        FonteAfastar.LocalizacaoButton.setText("Se afastar");
        FonteAfastar.setBounds(70,130,100,40);

        FonteInteracaoFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        FonteInteracaoFrame.setAlwaysOnTop(true);
        FonteInteracaoFrame.setTitle("Fonte");
        FonteInteracaoFrame.setResizable(false);
        FonteInteracaoFrame.setSize(250,250);
        FonteInteracaoFrame.setIconImage(logo.getImage());
        FonteInteracaoFrame.setLayout(null);
        FonteInteracaoFrame.add(FonteEncherCantil);
        FonteInteracaoFrame.add(FontePegarMoeda);
        FonteInteracaoFrame.add(FonteAfastar);
        FonteInteracaoFrame.setVisible(false);
        FonteInteracaoFrame.setLocationRelativeTo(Fonte.LocalizacaoButton);

        Fonte.LocalizacaoButton.setText("Fonte");
        Fonte.setBounds(170,70,70,70);

        BancoVazio.LocalizacaoButton.setText("Banco Vazio");
        BancoVazio.setBounds(40,170,80,50);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setTitle("Praça São Bernardo");
        this.setResizable(false);
        this.setSize(450,300);
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.add(Fonte);
        this.add(BancoVazio);
        this.add(PortaoSair);
        this.setVisible(false);

    }
}
