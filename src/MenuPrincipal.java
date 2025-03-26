import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

public class MenuPrincipal extends JFrame implements InterfaceItemInventario{
    ImageIcon logo = new ImageIcon("transparente.png");

    Color CorPadraoEscura= new Color(176,176,160);
    Color CorPadraoClara = new Color(220,220,200);

    Mapa mapa = new Mapa();
    Inventario mochila = new Inventario();

    Cidade1 PortoMolhado = new Cidade1();
    Cidade2 TerraFertil = new Cidade2();
    Cidade3 MinasEspecificas = new Cidade3();

    StatusJogador statusJogador = new StatusJogador();

    Border borderRaised = BorderFactory.createRaisedBevelBorder();
    Border borderLowered = BorderFactory.createLoweredBevelBorder();

    JProgressBar barraDeVidaJogador= new JProgressBar(0,100);
    JProgressBar barraDeEnergiaJogador= new JProgressBar(0,100);

    JLabel statusDinheiroLabel = new JLabel();
    JLabel statusAtaqueLabel = new JLabel();
    JLabel statusArmaduraLabel = new JLabel();
    JFrame personagemFrame = new JFrame();

    public MenuPrincipal(){
        mochila.Cantil.ItemInventarioButton.addActionListener(e -> UsarCantil());
        mochila.PeixePequeno.ItemInventarioButton.addActionListener(e -> PeixePequeno());

        PortoMolhado.PracaPanel.LocalizacaoButton.addActionListener(e -> PortoMolhado.cidade1Ferreiro.setVisible(false));
        PortoMolhado.FerreiroPanel.LocalizacaoButton.addActionListener(e -> PortoMolhado.cidade1Praca.setVisible(false));

        mapa.cidade1Panel.LocalizacaoButton.addActionListener(e -> PortoMolhado.setVisible(true));
        mapa.cidade1Panel.LocalizacaoButton.addActionListener(e -> TerraFertil.setVisible(false));
        mapa.cidade1Panel.LocalizacaoButton.addActionListener(e -> MinasEspecificas.setVisible(false));

        mapa.cidade2Panel.LocalizacaoButton.addActionListener(e -> PortoMolhado.setVisible(false));
        mapa.cidade2Panel.LocalizacaoButton.addActionListener(e -> TerraFertil.setVisible(true));
        mapa.cidade2Panel.LocalizacaoButton.addActionListener(e -> MinasEspecificas.setVisible(false));

        mapa.cidade3Panel.LocalizacaoButton.addActionListener(e -> PortoMolhado.setVisible(false));
        mapa.cidade3Panel.LocalizacaoButton.addActionListener(e -> TerraFertil.setVisible(false));
        mapa.cidade3Panel.LocalizacaoButton.addActionListener(e -> MinasEspecificas.setVisible(true));
        
    JLabel statusTituloLabel= new JLabel();
    statusTituloLabel.setText("Status");
    statusTituloLabel.setFont(new Font("Courier", Font.BOLD,30));
    statusTituloLabel.setVerticalAlignment(JLabel.CENTER);
    statusTituloLabel.setHorizontalAlignment(JLabel.CENTER);

    JPanel statusTituloPanel= new JPanel();
    statusTituloPanel.add(statusTituloLabel);
    statusTituloPanel.setOpaque(true);
    statusTituloPanel.setBackground(new Color(220,220,200));
    statusTituloPanel.setBorder(borderRaised);
    statusTituloPanel.setLayout(new GridLayout());

    barraDeVidaJogador.setValue(statusJogador.VidaJogador);
    barraDeVidaJogador.setStringPainted(true);
    barraDeVidaJogador.setString("Vida");
    barraDeVidaJogador.setFont(new Font("Courier", Font.BOLD,20));
    barraDeVidaJogador.setForeground(Color.red);
    barraDeVidaJogador.setBackground(Color.black);
    barraDeVidaJogador.setBounds(25,8,200,25);

    JPanel vidaPanel = new JPanel();
    vidaPanel.add(barraDeVidaJogador);
    vidaPanel.setOpaque(true);
    vidaPanel.setBackground(new Color(220,220,200));
    vidaPanel.setBorder(borderRaised);
    vidaPanel.setLayout(null);

    barraDeEnergiaJogador.setValue(statusJogador.EnergiaJogador);
    barraDeEnergiaJogador.setStringPainted(true);
    barraDeEnergiaJogador.setString("Energia");
    barraDeEnergiaJogador.setFont(new Font("Courier", Font.BOLD,20));
    barraDeEnergiaJogador.setForeground(new Color(0,100,0));
    barraDeEnergiaJogador.setBackground(Color.black);
    barraDeEnergiaJogador.setBounds(25,8,200,25);

    JPanel statusEnergiaPanel = new JPanel();
    statusEnergiaPanel.add(barraDeEnergiaJogador);
    statusEnergiaPanel.setOpaque(true);
    statusEnergiaPanel.setBackground(new Color(220,220,200));
    statusEnergiaPanel.setBorder(borderRaised);
    statusEnergiaPanel.setLayout(null);

    statusAtaqueLabel.setText("Ataque: "+statusJogador.DanoJogador);
    statusAtaqueLabel.setFont(new Font("Courier", Font.BOLD,20));
    statusAtaqueLabel.setForeground(Color.blue);

    statusArmaduraLabel.setText("Armadura: "+statusJogador.ArmaduraJogador);
    statusArmaduraLabel.setFont(new Font("Courier", Font.BOLD,20));
    statusArmaduraLabel.setForeground(Color.black);

    statusDinheiroLabel.setText("Dinheiro: "+statusJogador.DinheiroJogador);
    statusDinheiroLabel.setFont(new Font("Courier", Font.BOLD,20));
    statusDinheiroLabel.setForeground(new Color(150,150,0));

    JPanel statusAtaquePanel = new JPanel();
    statusAtaquePanel.add(statusAtaqueLabel);
    statusAtaquePanel.setOpaque(true);
    statusAtaquePanel.setBackground(new Color(220,220,200));
    statusAtaquePanel.setBorder(borderRaised);
        
    JPanel statusArmaduraPanel = new JPanel();
    statusArmaduraPanel.add(statusArmaduraLabel);
    statusArmaduraPanel.setOpaque(true);
    statusArmaduraPanel.setBackground(new Color(220,220,200));
    statusArmaduraPanel.setBorder(borderRaised);

    JPanel statusDinheiroPanel = new JPanel();
    statusDinheiroPanel.add(statusDinheiroLabel);
    statusDinheiroPanel.setOpaque(true);
    statusDinheiroPanel.setBackground(new Color(220,220,200));
    statusDinheiroPanel.setBorder(borderRaised);

    JPanel PanelStatus = new JPanel();
    PanelStatus.setBounds(250,0,250,250);
    PanelStatus.add(statusTituloPanel);
    PanelStatus.add(vidaPanel);
    PanelStatus.add(statusEnergiaPanel);
    PanelStatus.add(statusAtaquePanel);
    PanelStatus.add(statusArmaduraPanel);
    PanelStatus.add(statusDinheiroPanel);
    PanelStatus.setLayout(new GridLayout(6,1));
    PanelStatus.setBorder(borderRaised);

    JPanel PanelMochilaDentro = new JPanel();
    PanelMochilaDentro.setBounds(10,10,230,330);
    PanelMochilaDentro.setOpaque(true);
    PanelMochilaDentro.setBackground(CorPadraoEscura);
    PanelMochilaDentro.setBorder(borderRaised);
    PanelMochilaDentro.setLayout(null);
    PanelMochilaDentro.add(mochila.Mochila);
    PanelMochilaDentro.add(mapa);

    JPanel PanelMochilaContorno = new JPanel();
    PanelMochilaContorno.setBounds(0,0,250,350);
    PanelMochilaContorno.setOpaque(true);
    PanelMochilaContorno.setBackground(CorPadraoClara);
    PanelMochilaContorno.setBorder(borderRaised);
    PanelMochilaContorno.add(PanelMochilaDentro);
    PanelMochilaContorno.setLayout(null);

    JButton abrirMochilaButton = new JButton();
    abrirMochilaButton.setText("Mochila");
    abrirMochilaButton.setBounds(35,5,180,40);
    abrirMochilaButton.setFocusable(false);
    abrirMochilaButton.setFont(new Font("Courier", Font.BOLD,24));
    abrirMochilaButton.setBorder(borderLowered);
    abrirMochilaButton.setBackground(CorPadraoEscura);
    abrirMochilaButton.addActionListener(e -> mochila.Mochila.setVisible(true));
    abrirMochilaButton.addActionListener(e -> mapa.setVisible(false));

    JButton abrirMapaButton = new JButton();
    abrirMapaButton.setText("Mapa");
    abrirMapaButton.setBounds(35,50,180,40);
    abrirMapaButton.addActionListener(null);
    abrirMapaButton.setFocusable(false);
    abrirMapaButton.setFont(new Font("Courier", Font.BOLD,24));
    abrirMapaButton.setBorder(borderLowered);
    abrirMapaButton.setBackground(CorPadraoEscura);
    abrirMapaButton.addActionListener(e -> mapa.setVisible(true));
    abrirMapaButton.addActionListener(e -> mochila.Mochila.setVisible(false));

    JPanel PanelMenu = new JPanel();
    PanelMenu.setBounds(250,250,250,100);
    PanelMenu.setLayout(null);
    PanelMenu.setOpaque(true);
    PanelMenu.setBackground(CorPadraoClara);
    PanelMenu.setBorder(borderRaised);
    PanelMenu.add(abrirMochilaButton);
    PanelMenu.add(abrirMapaButton);

    JPanel MapaAberto = new JPanel();
    MapaAberto.setBounds(10,10,265,330);
    MapaAberto.setOpaque(true);
    MapaAberto.setBackground(CorPadraoEscura);
    MapaAberto.setBorder(borderLowered);
    MapaAberto.setLayout(null);
    MapaAberto.add(PortoMolhado);
    MapaAberto.add(TerraFertil);
    MapaAberto.add(MinasEspecificas);

    JPanel PanelMapaContorno = new JPanel();
    PanelMapaContorno.setBounds(500,0,283,350);
    PanelMapaContorno.setOpaque(true);
    PanelMapaContorno.setBackground(CorPadraoClara);
    PanelMapaContorno.setBorder(borderRaised);
    PanelMapaContorno.add(MapaAberto);
    PanelMapaContorno.setLayout(null);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(logo.getImage());
    this.setSize(800,390);
    this.setTitle("Menu de Personagem");
    this.setResizable(false);
    this.add(PanelMochilaContorno);
    this.add(PanelStatus);
    this.add(PanelMenu);
    this.add(PanelMapaContorno);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.setAlwaysOnTop(true);
    this.setVisible(true);
    }
    
    @Override
    public void UsarCantil() {
        mochila.Cantil.ItemInventarioButton.setEnabled(false);
        Timer BotaoCooldownTimer = new Timer();
        TimerTask BotaoCooldown = new TimerTask() {
            @Override
            public void run() {
                if(mochila.CantilQuantAgua>0){
                mochila.Cantil.ItemInventarioButton.setEnabled(true);
                }
            }
        };
        BotaoCooldownTimer.schedule(BotaoCooldown, 1000);
    }
    @Override
    public void PeixePequeno() {
        mochila.PeixePequeno.ItemInventarioButton.setEnabled(false);
        Timer BotaoCooldownTimer = new Timer();
        TimerTask BotaoCooldown = new TimerTask() {
            @Override
            public void run() {
                if(mochila.PeixePequenoQuant>0){
                mochila.PeixePequeno.ItemInventarioButton.setEnabled(true);
                }
                else{
                    mochila.PeixePequeno.setVisible(false);;
                }
            }
        };
        BotaoCooldownTimer.schedule(BotaoCooldown, 1000);
    }
}
