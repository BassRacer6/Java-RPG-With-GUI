import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Inventario{
    StatusJogador statusJogador = new StatusJogador();

    Border borderRaised = BorderFactory.createRaisedBevelBorder();
    Border borderLowered = BorderFactory.createLoweredBevelBorder();
    Color  CorPadraoEscura= new Color(176,176,160);
    Color CorPadraoClara = new Color(220,220,200);
    Font FontePadrao = new Font("Courier", Font.BOLD,13);

    JPanel Inventario = new JPanel();
    JScrollPane Mochila = new JScrollPane(Inventario, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    PadraoItemInventario Cantil = new PadraoItemInventario();
    int CantilLimiteAgua = 5;
    int CantilQuantAgua = 4;
    PadraoItemInventario PeixePequeno = new PadraoItemInventario();
    int PeixePequenoQuant = 2;
    PadraoItemInventario Escudo = new PadraoItemInventario();
    PadraoItemInventario Armadura = new PadraoItemInventario();
    PadraoItemInventario Espada = new PadraoItemInventario();
    String[] armas = {"(nada)", "Espada de Ferro"};
    JComboBox<String> ArmasComboBox = new JComboBox<>(armas);

    Inventario(){

        Cantil.ItemInventarioButton.setText("Beber do cantil("+CantilQuantAgua+"/"+CantilLimiteAgua+"💧)");

        PeixePequeno.ItemInventarioButton.setText("Comer peixe pequeno("+PeixePequenoQuant+")");

        ArmasComboBox.setBounds(5,5,170,40);
        ArmasComboBox.setBackground(CorPadraoEscura);
        ArmasComboBox.setFocusable(false);
        ArmasComboBox.setFont(FontePadrao);
        ArmasComboBox.setBorder(borderRaised);
        ArmasComboBox.setSelectedIndex(1);

        JPanel Arma = new JPanel();
        Arma.setBounds(5,(5+(80*2)),180,70);
        Arma.setPreferredSize(new Dimension(180,50));
        Arma.setBorder(borderLowered);
        Arma.setOpaque(true);
        Arma.setBackground(new Color(150,125,100));
        Arma.add(ArmasComboBox);
        Arma.setLayout(null);

        Escudo.ItemInventarioButton.setText("Escudo de madeira");

        Armadura.ItemInventarioButton.setText("Armadura de feno");

        Inventario.setOpaque(true);
        Inventario.setBackground(CorPadraoClara);
        Inventario.add(Cantil);
        Inventario.add(PeixePequeno);
        Inventario.add(Arma);
        Inventario.add(Escudo);
        Inventario.add(Armadura);
        Inventario.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        Inventario.setPreferredSize(new Dimension(215,320));

        Mochila.setBounds(10,10,215,310);
        Mochila.setVisible(false);
    }
}