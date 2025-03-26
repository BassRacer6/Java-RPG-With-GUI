import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PadraoPanelMapaLocalizacao extends JPanel{
    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();
    Color  CorPadraoButton= new Color(176,176,160);
    Color CorPadraoPanel = new Color(200,220,200);

    JButton LocalizacaoButton = new JButton();
    
    PadraoPanelMapaLocalizacao(){
        LocalizacaoButton.setText("Lugar");
        LocalizacaoButton.setFocusable(false);
        LocalizacaoButton.setBorder(border2);
        LocalizacaoButton.setBackground(CorPadraoButton);

        this.setBounds(0,0,120,70);
        this.setOpaque(true);
        this.setBackground(new Color(200,220,200));
        this.setBorder(border1);
        this.add(LocalizacaoButton);
        this.setLayout(new GridLayout());
    }
}
