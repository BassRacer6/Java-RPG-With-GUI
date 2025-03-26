import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Cidade3 extends JPanel{
    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();

    Cidade3(){

        PadraoPanelMapaLocalizacao GrutaPanel = new PadraoPanelMapaLocalizacao();
        GrutaPanel.LocalizacaoButton.setText("Gruta");
        GrutaPanel.setBounds(20,20,100,50);

        PadraoPanelMapaLocalizacao CavernaPanel = new PadraoPanelMapaLocalizacao();
        CavernaPanel.LocalizacaoButton.setText("Caverna");
        CavernaPanel.setBounds(20,80,100,50);

        PadraoPanelMapaLocalizacao FlorestaPanel = new PadraoPanelMapaLocalizacao();
        FlorestaPanel.LocalizacaoButton.setText("Floresta");
        FlorestaPanel.setBounds(20,140,100,50);

        PadraoPanelMapaLocalizacao CasaAbandonadaPanel = new PadraoPanelMapaLocalizacao();
        CasaAbandonadaPanel.LocalizacaoButton.setText("<html>Casa<br/>Abandonada");
        CasaAbandonadaPanel.setBounds(20,200,100,50);

        PadraoPanelMapaLocalizacao RiachoPanel = new PadraoPanelMapaLocalizacao();
        RiachoPanel.LocalizacaoButton.setText("Riacho");
        RiachoPanel.setBounds(130,20,100,50);

        PadraoPanelMapaLocalizacao RioPanel = new PadraoPanelMapaLocalizacao();
        RioPanel.LocalizacaoButton.setText("Rio");
        RioPanel.setBounds(130,80,100,50);
        
        this.setBounds(10,10,245,310);
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(new Color(150,125,100));
        this.setBorder(border1);
        this.setVisible(false);
        this.add(GrutaPanel);
        this.add(CavernaPanel);
        this.add(FlorestaPanel);
        this.add(CasaAbandonadaPanel);
        this.add(RiachoPanel);
        this.add(RioPanel);
    }
}
