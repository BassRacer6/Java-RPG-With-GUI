import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Mapa extends JPanel {

    Border borderRaised = BorderFactory.createRaisedBevelBorder();
    Border borderLowered = BorderFactory.createLoweredBevelBorder();

    PadraoPanelMapaLocalizacao cidade1Panel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao cidade2Panel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao cidade3Panel = new PadraoPanelMapaLocalizacao();

    Mapa(){

        cidade1Panel.LocalizacaoButton.setText("Porto Molhado");
        cidade1Panel.setBounds(20,10,120,70);

        cidade2Panel.LocalizacaoButton.setText("Terra Fértil");
        cidade2Panel.setBounds(10,110,120,70);

        cidade3Panel.LocalizacaoButton.setText("Minas Específicas");
        cidade3Panel.setBounds(70,200,120,70);

        this.setBounds(10,10,210,310);
        this.setBorder(borderRaised);
        this.setOpaque(true);
        this.setBackground(new Color(150,125,100));
        this.add(cidade1Panel);
        this.add(cidade2Panel);
        this.add(cidade3Panel);
        this.setLayout(null);
        this.setVisible(false);
    }
}
