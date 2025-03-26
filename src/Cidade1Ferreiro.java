import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class Cidade1Ferreiro extends JFrame {
    ImageIcon logo = new ImageIcon("transparente.png");

    Font font1 = new Font("Courier", Font.BOLD,15);
    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();
    Color CorPadraoPanel = new Color(220,220,200);
    Color  CorPadraoButton= new Color(176,176,160);
    
    JButton ConversarButton = new JButton();
    JButton ComprarArmaduraButton = new JButton();
    JButton ComprarEspadaButton = new JButton();
    PadraoPanelMapaLocalizacao Saida = new PadraoPanelMapaLocalizacao();

    Cidade1Ferreiro(){

        ConversarButton.setText("Conversar");
        ConversarButton.setFocusable(false);
        ConversarButton.setBounds(15,25,100,50);
        ConversarButton.setBorder(border2);
        ConversarButton.setBackground(CorPadraoButton);

        JLabel PrecoArmamento = new JLabel();
        PrecoArmamento.setText("<html><span style:font color=#8B8000>10Cc<span style=font color=blue>(20 Ataque)");
        PrecoArmamento.setBounds(45,37,100,20);

        JLabel PrecoArmadura = new JLabel();
        PrecoArmadura.setText("<html><span style:font color=#8B8000>10Cc<span style=font color=black>(10 Armadura)");
        PrecoArmadura.setBounds(50,37,120,20);

        ComprarEspadaButton.setText("Comprar Espada de Aço");
        ComprarEspadaButton.setLayout(null);
        ComprarEspadaButton.setFont(font1);
        ComprarEspadaButton.setFocusable(false);
        ComprarEspadaButton.setBounds(5,5,180,35);
        ComprarEspadaButton.setBorder(border2);
        ComprarEspadaButton.setBackground(CorPadraoButton);

        ComprarArmaduraButton.setText("Comprar Armadura de Couro");
        ComprarArmaduraButton.setFont(font1);
        ComprarArmaduraButton.setFocusable(false);
        ComprarArmaduraButton.setBounds(5,5,210,35);
        ComprarArmaduraButton.setBorder(border2);
        ComprarArmaduraButton.setBackground(CorPadraoButton);

        JPanel ConversarPanel = new JPanel();
        ConversarPanel.setOpaque(true);
        ConversarPanel.setBackground(CorPadraoPanel);
        ConversarPanel.setBounds(40,170,130,100);
        ConversarPanel.add(ConversarButton);
        ConversarPanel.setLayout(null);
        ConversarPanel.setBorder(border1);

        JPanel ComprarEspadaPanel = new JPanel();
        ComprarEspadaPanel.setOpaque(true);
        ComprarEspadaPanel.setBackground(CorPadraoPanel);
        ComprarEspadaPanel.setBounds(10,50,190,60);
        ComprarEspadaPanel.add(ComprarEspadaButton);
        ComprarEspadaPanel.add(PrecoArmamento);
        ComprarEspadaPanel.setLayout(null);
        ComprarEspadaPanel.setBorder(border1);

        JPanel ComprarArmaduraPanel = new JPanel();
        ComprarArmaduraPanel.setOpaque(true);
        ComprarArmaduraPanel.setBackground(CorPadraoPanel);
        ComprarArmaduraPanel.setBounds(205,50,220,60);
        ComprarArmaduraPanel.add(PrecoArmadura);
        ComprarArmaduraPanel.add(ComprarArmaduraButton);
        ComprarArmaduraPanel.setLayout(null);
        ComprarArmaduraPanel.setBorder(border1);

        JLabel AmolarEspadaLabel = new JLabel();
        AmolarEspadaLabel.setText("(Ataque+10)");
        AmolarEspadaLabel.setForeground(Color.blue);
        AmolarEspadaLabel.setBounds(50,30,160,30);

        JButton AmolarEspadaButton = new JButton();
        AmolarEspadaButton.setText("<html>Amolar Espada Atual");
        AmolarEspadaButton.setLayout(null);
        AmolarEspadaButton.setFont(font1);
        AmolarEspadaButton.setFocusable(false);
        AmolarEspadaButton.setBounds(5,5,160,30);
        AmolarEspadaButton.setBorder(border2);
        AmolarEspadaButton.setBackground(CorPadraoButton);
        AmolarEspadaButton.addActionListener(e -> JOptionPane.showMessageDialog(this,
         "<html>Meu amolador quebrou. Talvez você possa me<br/>ajudar a consertar-lo. Mas estou ocupado agora.", null, JOptionPane.PLAIN_MESSAGE));

        JPanel AmolarEspadaPanel = new JPanel();
        AmolarEspadaPanel.setOpaque(true);
        AmolarEspadaPanel.setBackground(CorPadraoPanel);
        AmolarEspadaPanel.setBounds(200,230,170,60);
        AmolarEspadaPanel.setLayout(null);
        AmolarEspadaPanel.setBorder(border1);
        AmolarEspadaPanel.add(AmolarEspadaButton);
        AmolarEspadaPanel.add(AmolarEspadaLabel);

        Saida.setBounds (250,220,100,50);
        Saida.LocalizacaoButton.setText("Saída");

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setTitle("Ferraria Pai e Filho");
        this.setResizable(false);
        this.setSize(450,350);
        this.setLocationRelativeTo(null);
        this.setIconImage(logo.getImage());
        this.setVisible(false);
        this.setLayout(null);
        this.add(ConversarPanel);
        this.add(ComprarEspadaPanel);
        this.add(ComprarArmaduraPanel);
        this.add(Saida);
        //this.add(AmolarEspadaPanel);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
    }
}
