import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Cidade2 extends JPanel{

    Border border1 = BorderFactory.createRaisedBevelBorder();

    Cidade2(){

        PadraoPanelMapaLocalizacao IgrejaPanel = new PadraoPanelMapaLocalizacao();
        IgrejaPanel.LocalizacaoButton.setText("Igreja");
        IgrejaPanel.setBounds(20,20,100,50);

        PadraoPanelMapaLocalizacao HipodromoPanel = new PadraoPanelMapaLocalizacao();
        HipodromoPanel.LocalizacaoButton.setText("Hipodromo");
        HipodromoPanel.setBounds(20,80,100,50);

        PadraoPanelMapaLocalizacao FazendaPanel = new PadraoPanelMapaLocalizacao();
        FazendaPanel.LocalizacaoButton.setText("Fazenda");
        FazendaPanel.setBounds(20,140,100,50);

        PadraoPanelMapaLocalizacao RanchoPanel = new PadraoPanelMapaLocalizacao();
        RanchoPanel.LocalizacaoButton.setText("Rancho");
        RanchoPanel.setBounds(20,200,100,50);

        PadraoPanelMapaLocalizacao ChacaraPanel = new PadraoPanelMapaLocalizacao();
        ChacaraPanel.LocalizacaoButton.setText("Chácara");
        ChacaraPanel.setBounds(130,20,100,50);

        PadraoPanelMapaLocalizacao PomarPanel = new PadraoPanelMapaLocalizacao();
        PomarPanel.LocalizacaoButton.setText("Pomar");
        PomarPanel.setBounds(130,80,100,50);

        this.setBounds(10,10,245,310);
        this.setOpaque(true);
        this.setBackground(new Color(150,125,100));
        this.setBorder(border1);
        this.setVisible(false);
        this.add(IgrejaPanel);
        this.add(HipodromoPanel);
        this.add(FazendaPanel);
        this.add(RanchoPanel);
        this.add(ChacaraPanel);
        this.add(PomarPanel);
        this.setLayout(null);
    }
}
