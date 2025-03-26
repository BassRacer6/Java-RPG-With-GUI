import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PadraoItemInventario extends JPanel{

    Color  CorPadraoEscura= new Color(176,176,160);
    Color CorPadraoClara = new Color(220,220,200);
    Border borderRaised = BorderFactory.createRaisedBevelBorder();
    Border borderLowered = BorderFactory.createLoweredBevelBorder();
    Font FontePadrao = new Font("Courier", Font.BOLD,13);

    JButton ItemInventarioButton = new JButton();

    PadraoItemInventario(){

    ItemInventarioButton.setText("Item 1");
    ItemInventarioButton.setBounds(5,5,170,40);
    ItemInventarioButton.setBackground(CorPadraoEscura);
    ItemInventarioButton.setFocusable(false);
    ItemInventarioButton.setFont(FontePadrao);
    ItemInventarioButton.setBorder(borderRaised);

    this.setPreferredSize(new Dimension(180,50));
    this.setBorder(borderLowered);
    this.setOpaque(true);
    this.setBackground(new Color(150,125,100));
    this.add(ItemInventarioButton);
    this.setLayout(null);
    }
}
