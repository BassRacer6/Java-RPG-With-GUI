import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cidade1 extends JPanel {

    int taverna1Check = 0;
    int ferreiro1Check = 0;
    int emBatalhaCheck;

    Cidade1Ferreiro cidade1Ferreiro = new Cidade1Ferreiro();
    Cidade1Abrigo cidade1Abrigo = new Cidade1Abrigo();
    Cidade1Praca cidade1Praca = new Cidade1Praca();
    Cidade1Peixaria cidade1Peixaria = new Cidade1Peixaria();
    Cidade1Igreja cidade1Igreja = new Cidade1Igreja();
    MenuBatalha menuBatalha = new MenuBatalha();

    Border border1 = BorderFactory.createRaisedBevelBorder();
    Border border2 = BorderFactory.createLoweredBevelBorder();
    Color  CorPadraoEscura = new Color(176,176,160);
    GridLayout grid = new GridLayout();

    PadraoPanelMapaLocalizacao FerreiroPanel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao PeixariaPanel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao AbrigoPanel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao IgrejaPanel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao PracaPanel = new PadraoPanelMapaLocalizacao();
    PadraoPanelMapaLocalizacao CriptaPanel = new PadraoPanelMapaLocalizacao();

    Cidade1(){

        FerreiroPanel.LocalizacaoButton.setText("Ferreiro");
        FerreiroPanel.setBounds(40,70,80,50);

        PadraoPanelMapaLocalizacao TavernaPanel = new PadraoPanelMapaLocalizacao();
        TavernaPanel.LocalizacaoButton.setText("Taverna");
        TavernaPanel.setBounds(20,10,100,50);

        PeixariaPanel.LocalizacaoButton.setText("Peixaria");
        PeixariaPanel.setBounds(30,130,90,50);

        AbrigoPanel.LocalizacaoButton.setText("Abrigo");
        AbrigoPanel.setBounds(20,190,100,50);

        IgrejaPanel.LocalizacaoButton.setText("Igreja");
        IgrejaPanel.setBounds(30,250,90,50);

        PadraoPanelMapaLocalizacao NavioPanel = new PadraoPanelMapaLocalizacao();
        NavioPanel.LocalizacaoButton.setText("Navio");
        NavioPanel.setBounds(140,90,60,90);

        PracaPanel.LocalizacaoButton.setText("Praça");
        PracaPanel.setBounds(130,200,100,40);

        CriptaPanel.LocalizacaoButton.setText("Cripta");
        CriptaPanel.setBounds(130,250,90,50);
        CriptaPanel.LocalizacaoButton.addActionListener(e -> menuBatalha.setVisible(true));

        this.setBounds(10,10,245,310);
        this.setOpaque(true);
        this.setBackground(new Color(150,125,100));
        this.setBorder(border1);
        this.setLayout(null);
        this.setVisible(false);
        this.add(FerreiroPanel);
        this.add(TavernaPanel);
        this.add(PeixariaPanel);
        this.add(AbrigoPanel);
        this.add(IgrejaPanel);
        this.add(NavioPanel);
        this.add(PracaPanel);
        this.add(CriptaPanel);

            ActionListener Cidade1Event = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object event1 = e.getSource();
                    if(event1 == TavernaPanel.LocalizacaoButton){
                    taverna1Check++;
                        if(taverna1Check==1){
                            JOptionPane.showMessageDialog(TavernaPanel.LocalizacaoButton,"<html>Você se senta no balcão para escutar as histórias de<p>alguns moradores locais, cujo falar elevado é intercalado<p>por partículas de saliva e goles de pinga.");
                        }
                        else if(taverna1Check==2){
                            JOptionPane.showMessageDialog(TavernaPanel.LocalizacaoButton,"<html>O grupo extridente de anciões comenta incessantemente sobre<p>barulhos assustadores ao anoitecer e criações de gado<p>desaparecidas.");
                        }
                        else if(taverna1Check==3){
                            JOptionPane.showMessageDialog(TavernaPanel.LocalizacaoButton,"<html>O Taberneiro dialoga com você sobre os dano contundentes e<p>intrínsecos causado pelo consumo indelével de álcool.");
                        }
                        else if(taverna1Check==4){
                            JOptionPane.showMessageDialog(TavernaPanel.LocalizacaoButton,"<html>O clima sem intercorrências da taverna se estabiliza ao passo<p>que o taberneiro retorna a esfregar canelas com um pano sujo e<p>fedorento e a conversa dos anciões se acalma ao passo que<p>muda para pontuações agrícolas e as estações do ano.");
                        }
                        else if(taverna1Check>=5){
                            JOptionPane.showMessageDialog(TavernaPanel.LocalizacaoButton, "<html>Você nota como o antes vivo e agitado ambiente agora se<p>encontra estagnado e vazio.");
                        }
                    }
                    if(event1 == cidade1Ferreiro.ConversarButton){
                        ferreiro1Check++;
                        if(ferreiro1Check==1){
                            JOptionPane.showMessageDialog(cidade1Ferreiro.ConversarButton,"<html>Você se aproxima do ferreiro e o sauda. Ele responde o comprimento<p>e adiciona que diz que não é bom de conversa.");
                        }
                        else if(ferreiro1Check==2){
                            JOptionPane.showMessageDialog(cidade1Ferreiro.ConversarButton, "<html>Você tenta puxar assunto com o velho ferreiro e diz que se sente solitário<p>desde que sua mulher desapareceu.");
                        }
                        else if(ferreiro1Check>=3){
                            JOptionPane.showMessageDialog(cidade1Ferreiro.ConversarButton, "<html>O semblante do ferreiro está fechado e ele ignora suas tentativas de aproximação");
                        }
                    }
                }
            };
        cidade1Ferreiro.ConversarButton.addActionListener(Cidade1Event);
        TavernaPanel.LocalizacaoButton.addActionListener(Cidade1Event);
    }
}
