import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.BorderFactory;;

public class MenuBatalha extends JFrame{
    ImageIcon logo = new ImageIcon("transparente.png");
    ImageIcon Jogador = new ImageIcon("personagem4.png");
    ImageIcon inimigo = new ImageIcon("personagem3.png");

    Border border = BorderFactory.createRaisedBevelBorder();

    StatusJogador statusJogador = new StatusJogador();
    StatusInimigo statusInimigo = new StatusInimigo();

    JProgressBar barraDeVidaJogador= new JProgressBar(0,100);
    JProgressBar barraDeVidaInimigo= new JProgressBar(0,100);
    JProgressBar barraDeEnergiaJogador = new JProgressBar(0,100);
    
    JButton BotaoAtacar = new JButton();
    JButton ButtonFugir = new JButton();

    JLabel LabelInimigo = new JLabel();

    MenuBatalha(){
        JLabel LabelPainelDoPersonagem = new JLabel();
        LabelPainelDoPersonagem.setText("Eu:");
        LabelPainelDoPersonagem.setIcon(Jogador);
        LabelPainelDoPersonagem.setVerticalAlignment(JLabel.CENTER);
        LabelPainelDoPersonagem.setHorizontalAlignment(JLabel.CENTER);
        LabelPainelDoPersonagem.setVerticalTextPosition(JLabel.NORTH);
        LabelPainelDoPersonagem.setHorizontalTextPosition(JLabel.CENTER);

        JPanel PainelDoPersonagem = new JPanel();
        PainelDoPersonagem.setOpaque(true);
        PainelDoPersonagem.setBackground(new Color(220,220,200));
        PainelDoPersonagem.setBorder(border);
        PainelDoPersonagem.setBounds(20,0,150,150);
        PainelDoPersonagem.add(LabelPainelDoPersonagem);

        barraDeVidaJogador.setValue(statusJogador.VidaJogador);
        barraDeVidaJogador.setStringPainted(true);
        barraDeVidaJogador.setString("Vida");
        barraDeVidaJogador.setFont(new Font("Courier", Font.BOLD,20));
        barraDeVidaJogador.setForeground(Color.red);
        barraDeVidaJogador.setBackground(Color.black);
        barraDeVidaJogador.setBounds(0,150,400,50);

        barraDeVidaInimigo.setValue(100);
        barraDeVidaInimigo.setStringPainted(true);
        barraDeVidaInimigo.setString("x/y");
        barraDeVidaInimigo.setFont(new Font("Courier", Font.BOLD,20));
        barraDeVidaInimigo.setForeground(Color.red);
        barraDeVidaInimigo.setBackground(Color.black);
        barraDeVidaInimigo.setBounds(0,150,400,50);

        JPanel PainelVidaJogador = new JPanel();
        PainelVidaJogador.setBorder(border);
        PainelVidaJogador.setOpaque(true);
        PainelVidaJogador.setBackground(new Color(220,220,200));
        PainelVidaJogador.setBounds(0,150,200,50);
        PainelVidaJogador.add(barraDeVidaJogador);

        barraDeEnergiaJogador.setValue(statusJogador.EnergiaJogador);
        barraDeEnergiaJogador.setStringPainted(true);
        barraDeEnergiaJogador.setString("Energia");
        barraDeEnergiaJogador.setFont(new Font("Courier", Font.BOLD,20));
        barraDeEnergiaJogador.setForeground(new Color(0,100,0));
        barraDeEnergiaJogador.setBackground(Color.black);
        barraDeEnergiaJogador.setBounds(0,150,400,50);

        JPanel PainelEnergiaJogador = new JPanel();
        PainelEnergiaJogador.setBorder(border);
        PainelEnergiaJogador.setBackground(new Color(220,220,200));
        PainelEnergiaJogador.setBounds(0,200,200,40);
        PainelEnergiaJogador.add(barraDeEnergiaJogador);

        JPanel PainelVidaInimigo = new JPanel();
        PainelVidaInimigo.setBorder(border);
        PainelVidaInimigo.setOpaque(true);
        PainelVidaInimigo.setBackground(new Color(220,220,200));
        PainelVidaInimigo.setBounds(200,150,200,50);
        PainelVidaInimigo.add(barraDeVidaInimigo);

        LabelInimigo.setText("Goblin:");
        LabelInimigo.setIcon(inimigo);
        LabelInimigo.setVerticalTextPosition(JLabel.NORTH);
        LabelInimigo.setHorizontalTextPosition(JLabel.CENTER);
        LabelPainelDoPersonagem.setVerticalAlignment(JLabel.CENTER);
        LabelPainelDoPersonagem.setHorizontalAlignment(JLabel.CENTER);

        JPanel PainelDoInimigo = new JPanel();
        PainelDoInimigo.setBorder(border);
        PainelDoInimigo.setOpaque(true);
        PainelDoInimigo.setBackground(new Color(220,220,200));
        PainelDoInimigo.setBounds(215,0,150,150);
        PainelDoInimigo.add(LabelInimigo);

        BotaoAtacar.setText("Atacar");
        BotaoAtacar.setFocusable(false);
        BotaoAtacar.setFont(new Font("Courier", Font.BOLD,20));
        BotaoAtacar.addActionListener(e -> BotaoAtacar.setEnabled(false));

        ButtonFugir.setText("Fugir");
        ButtonFugir.setFocusable(false);
        ButtonFugir.setFont(new Font("Courier", Font.BOLD,20));

        JLabel LabelReacoes = new JLabel();
        LabelReacoes.add(BotaoAtacar);
        LabelReacoes.add(ButtonFugir);

        JPanel ReacoesLuta = new JPanel();
        ReacoesLuta.setBorder(border);
        ReacoesLuta.setOpaque(true);
        ReacoesLuta.setBackground(new Color(220,220,200));
        ReacoesLuta.setBounds(0,240,400,70);
        ReacoesLuta.add(BotaoAtacar);
        ReacoesLuta.add(ButtonFugir);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setTitle("Cripta São Sebastião");
        this.setResizable(false);
        this.setSize(400,350);
        this.setIconImage(logo.getImage());
        this.setVisible(false);
        this.setLayout(null);
        this.setAlwaysOnTop(true);
        this.add(PainelDoPersonagem);
        this.add(PainelVidaJogador);
        this.add(PainelEnergiaJogador);
        this.add(PainelVidaInimigo);
        this.add(PainelDoInimigo);
        this.add(ReacoesLuta);
        this.setLocationRelativeTo(null);
    }
}