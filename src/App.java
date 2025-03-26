import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App{
    public static void main (String[] args) {

        ImageIcon GoblinImagem1 = new ImageIcon("Personagem3.png");
        ImageIcon GoblinImagem2 = new ImageIcon("teste2.png");
        ImageIcon Orc = new ImageIcon("Orc.png");

        MenuPrincipal menuPrincipal = new MenuPrincipal();

        StatusInimigo statusInimigo = new StatusInimigo();

        AtaqueInimigo ataqueInimigo = new AtaqueInimigo();
        ataqueInimigo.setDaemon(true);
        ataqueInimigo.start();

        ActionListener MochilaEvento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==menuPrincipal.mochila.Cantil.ItemInventarioButton){
                    menuPrincipal.mochila.CantilQuantAgua--;
                    menuPrincipal.mochila.Cantil.ItemInventarioButton.setText("Beber do cantil("+menuPrincipal.mochila.CantilQuantAgua+"/"+menuPrincipal.mochila.CantilLimiteAgua+"💧)");
                    menuPrincipal.statusJogador.EnergiaJogador = menuPrincipal.statusJogador.EnergiaJogador + 5;
                    ataqueInimigo.statusJogador.EnergiaJogador = ataqueInimigo.statusJogador.EnergiaJogador + 5;
                    menuPrincipal.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
                }
                if(e.getSource()==menuPrincipal.mochila.PeixePequeno.ItemInventarioButton){
                    menuPrincipal.mochila.PeixePequenoQuant--;
                    menuPrincipal.mochila.PeixePequeno.ItemInventarioButton.setText("Comer peixe pequeno("+menuPrincipal.mochila.PeixePequenoQuant+")");
                    menuPrincipal.statusJogador.VidaJogador = menuPrincipal.statusJogador.VidaJogador + 10;
                    ataqueInimigo.statusJogador.VidaJogador = ataqueInimigo.statusJogador.VidaJogador + 10;
                    menuPrincipal.barraDeVidaJogador.setValue(menuPrincipal.statusJogador.VidaJogador);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaJogador.setValue(menuPrincipal.statusJogador.VidaJogador);
                }
            }
        };
        menuPrincipal.mochila.Cantil.ItemInventarioButton.addActionListener(MochilaEvento);
        menuPrincipal.mochila.PeixePequeno.ItemInventarioButton.addActionListener(MochilaEvento);

        ActionListener BatalhaIniciar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int InimigoChances = random.nextInt(100)+1;
                if(InimigoChances>=50){
                    ataqueInimigo.statusInimigo.VidaInimigo = 80;
                    ataqueInimigo.statusInimigo.AtaqueInimigo = 20;
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setMaximum(ataqueInimigo.statusInimigo.VidaInimigo);
                    statusInimigo.VidaInimigo = ataqueInimigo.statusInimigo.VidaInimigo;
                    statusInimigo.VidaInimigo = ataqueInimigo.statusInimigo.VidaInimigo;
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setValue(ataqueInimigo.statusInimigo.VidaInimigo*2);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setString(statusInimigo.VidaInimigo+"/"+ataqueInimigo.statusInimigo.VidaInimigo);
                    menuPrincipal.PortoMolhado.menuBatalha.LabelInimigo.setIcon(GoblinImagem1);
                    menuPrincipal.PortoMolhado.menuBatalha.LabelInimigo.setText("Goblin Nv.1");
                }
                else{
                    ataqueInimigo.statusInimigo.VidaInimigo = 100;
                    ataqueInimigo.statusInimigo.AtaqueInimigo = 25;
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setMaximum(ataqueInimigo.statusInimigo.VidaInimigo);
                    statusInimigo.VidaInimigo = ataqueInimigo.statusInimigo.VidaInimigo;
                    statusInimigo.VidaInimigo = ataqueInimigo.statusInimigo.VidaInimigo;
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setValue(ataqueInimigo.statusInimigo.VidaInimigo*2);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setString(statusInimigo.VidaInimigo+"/"+ataqueInimigo.statusInimigo.VidaInimigo);
                    menuPrincipal.PortoMolhado.menuBatalha.LabelInimigo.setIcon(GoblinImagem2);
                    menuPrincipal.PortoMolhado.menuBatalha.LabelInimigo.setText("Goblin Nv.2");
                }
                menuPrincipal.setEnabled(false);
                ataqueInimigo.statusJogador.EmBatalha = 1;
                System.out.println(ataqueInimigo.statusJogador.EmBatalha);
            }
        };
        menuPrincipal.PortoMolhado.CriptaPanel.LocalizacaoButton.addActionListener(BatalhaIniciar);

        ActionListener BatalhaResponder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource()==menuPrincipal.PortoMolhado.menuBatalha.BotaoAtacar){
                    if(statusInimigo.VidaInimigo>0){
                        menuPrincipal.statusJogador.EnergiaJogador = menuPrincipal.statusJogador.EnergiaJogador-10;
                        menuPrincipal.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
                        menuPrincipal.PortoMolhado.menuBatalha.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
                        if(menuPrincipal.statusJogador.EnergiaJogador<20){
                            menuPrincipal.PortoMolhado.menuBatalha.BotaoAtacar.setEnabled(false);
                        }
                        statusInimigo.VidaInimigo = statusInimigo.VidaInimigo-(menuPrincipal.statusJogador.DanoJogador);
                        menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setValue(statusInimigo.VidaInimigo);
                        menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setString(statusInimigo.VidaInimigo+"/"+ataqueInimigo.statusInimigo.VidaInimigo);
                    }
                if(statusInimigo.VidaInimigo<=0){
                    menuPrincipal.setEnabled(true);
                    ataqueInimigo.statusJogador.EmBatalha = 0;
                    System.out.println(ataqueInimigo.statusJogador.EmBatalha);
                    menuPrincipal.PortoMolhado.menuBatalha.dispose();
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setValue(statusInimigo.VidaInimigo);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setString(statusInimigo.VidaInimigo+"/"+ataqueInimigo.statusInimigo.VidaInimigo);
                    JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.CriptaPanel.LocalizacaoButton, "<html>A criatura solta um grito extridente e deixa cair um peixe pequeno e uma moeda enquanto foge.");
                    menuPrincipal.statusJogador.DinheiroJogador++;
                    menuPrincipal.statusDinheiroLabel.setText("Dinheiro: "+menuPrincipal.statusJogador.DinheiroJogador);
                    menuPrincipal.mochila.PeixePequenoQuant++;
                    menuPrincipal.mochila.PeixePequeno.ItemInventarioButton.setText("Comer peixe pequeno("+menuPrincipal.mochila.PeixePequenoQuant+")");
                    menuPrincipal.mochila.PeixePequeno.ItemInventarioButton.setEnabled(true);
                    menuPrincipal.mochila.PeixePequeno.setVisible(true);
                }
                }
                if(ae.getSource()==menuPrincipal.PortoMolhado.menuBatalha.ButtonFugir){
                    menuPrincipal.setEnabled(true);
                    ataqueInimigo.statusJogador.EmBatalha = 0;
                    System.out.println(ataqueInimigo.statusJogador.EmBatalha);
                    menuPrincipal.PortoMolhado.menuBatalha.dispose();
                    statusInimigo.VidaInimigo=100;
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setValue(statusInimigo.VidaInimigo);
                }
            }
        };
        menuPrincipal.PortoMolhado.menuBatalha.BotaoAtacar.addActionListener(BatalhaResponder);
        menuPrincipal.PortoMolhado.menuBatalha.ButtonFugir.addActionListener(BatalhaResponder);

        ActionListener Cidade1FerreiroEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent be){
                if(be.getSource() == menuPrincipal.PortoMolhado.FerreiroPanel.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Ferreiro.setVisible(true);
                    menuPrincipal.setEnabled(false);
                }
                else if(be.getSource()==menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarEspadaButton){
                    if(menuPrincipal.statusJogador.DinheiroJogador>=10){
                        menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarEspadaButton.setEnabled(false);
                        menuPrincipal.statusJogador.DinheiroJogador = menuPrincipal.statusJogador.DinheiroJogador-10;
                        menuPrincipal.statusDinheiroLabel.setText("Dinheiro: "+menuPrincipal.statusJogador.DinheiroJogador);
                        menuPrincipal.mochila.ArmasComboBox.insertItemAt("Espada de Aço", 2);
                        menuPrincipal.mochila.ArmasComboBox.setSelectedIndex(2);
                        menuPrincipal.mochila.Espada.ItemInventarioButton.setText("Espada de aço");
                    }
                    else{
                        JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarEspadaButton, "'Volte quando tiver mais dinheiro, jovem.'");
                    }
                }
                else if(be.getSource()==menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarArmaduraButton){
                    if(menuPrincipal.statusJogador.DinheiroJogador>10){
                        menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarArmaduraButton.setEnabled(false);
                        menuPrincipal.statusJogador.DinheiroJogador = menuPrincipal.statusJogador.DinheiroJogador-10;
                        menuPrincipal.statusDinheiroLabel.setText("Dinheiro: "+menuPrincipal.statusJogador.DinheiroJogador);
                        menuPrincipal.statusJogador.ArmaduraJogador = 10;
                        ataqueInimigo.statusJogador.ArmaduraJogador = 10;
                        menuPrincipal.statusArmaduraLabel.setText("Armadura: "+(menuPrincipal.statusJogador.ArmaduraJogador));
                        menuPrincipal.mochila.Armadura.ItemInventarioButton.setText("Armadura de couro");
                    }
                    else{
                        JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarArmaduraButton, "'Volte quando tiver mais dinheiro, jovem.'");
                    }
                }
                else if(be.getSource()==menuPrincipal.PortoMolhado.cidade1Ferreiro.Saida.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Ferreiro.setVisible(false);
                    menuPrincipal.setEnabled(true);
                }
            }
        };
        menuPrincipal.PortoMolhado.FerreiroPanel.LocalizacaoButton.addActionListener(Cidade1FerreiroEvent);
        menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarEspadaButton.addActionListener(Cidade1FerreiroEvent);
        menuPrincipal.PortoMolhado.cidade1Ferreiro.ComprarArmaduraButton.addActionListener(Cidade1FerreiroEvent);
        menuPrincipal.PortoMolhado.cidade1Ferreiro.Saida.LocalizacaoButton.addActionListener(Cidade1FerreiroEvent);

        ActionListener Cidade1PeixariaEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ce) {
                if(ce.getSource() == menuPrincipal.PortoMolhado.PeixariaPanel.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Peixaria.setVisible(true);
                    menuPrincipal.setEnabled(false);
                }
                else if (ce.getSource() == menuPrincipal.PortoMolhado.cidade1Peixaria.ComprarPeixePequenoPanel.LocalizacaoButton) {
                    if(menuPrincipal.statusJogador.DinheiroJogador > 0){
                        menuPrincipal.statusJogador.DinheiroJogador--;
                        menuPrincipal.statusDinheiroLabel.setText("Dinheiro: " + menuPrincipal.statusJogador.DinheiroJogador);
                        menuPrincipal.mochila.PeixePequenoQuant = menuPrincipal.mochila.PeixePequenoQuant + 3;
                        menuPrincipal.mochila.PeixePequeno.ItemInventarioButton.setEnabled(true);
                        menuPrincipal.mochila.PeixePequeno.setVisible(true);
                        menuPrincipal.mochila.PeixePequeno.ItemInventarioButton.setText("Comer peixe pequeno(" + menuPrincipal.mochila.PeixePequenoQuant + ")");
                    }
                    else{
                        JOptionPane.showMessageDialog(
                                menuPrincipal.PortoMolhado.cidade1Peixaria.ComprarPeixePequenoPanel.LocalizacaoButton,
                                "'Não fazemos caridade.'", "Peixaria", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else if(ce.getSource() == menuPrincipal.PortoMolhado.cidade1Peixaria.Saida.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Peixaria.setVisible(false);
                    menuPrincipal.setEnabled(true);
                }
            }
        };
        menuPrincipal.PortoMolhado.PeixariaPanel.LocalizacaoButton.addActionListener(Cidade1PeixariaEvent);
        menuPrincipal.PortoMolhado.cidade1Peixaria.ComprarPeixePequenoPanel.LocalizacaoButton.addActionListener(Cidade1PeixariaEvent);
        menuPrincipal.PortoMolhado.cidade1Peixaria.Saida.LocalizacaoButton.addActionListener(Cidade1PeixariaEvent);

        ActionListener Cidade1PracaInteraction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent de) {
                if(de.getSource() == menuPrincipal.PortoMolhado.PracaPanel.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Praca.setVisible(true);
                    menuPrincipal.setEnabled(false);
                }
                if(de.getSource() == menuPrincipal.PortoMolhado.cidade1Praca.BancoVazio.LocalizacaoButton){
                    JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Praca.BancoVazio.LocalizacaoButton,
                     "<html>Você se senta no banco e adormece. Suas<br/>costas te fazem sentir 40 anos mais velho.","Banco vazio", JOptionPane.PLAIN_MESSAGE);
                     menuPrincipal.statusJogador.EnergiaJogador = 0;
                     ataqueInimigo.statusJogador.EnergiaJogador = 0;
                     menuPrincipal.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
                    menuPrincipal.statusJogador.VidaJogador = 80;
                    ataqueInimigo.statusJogador.VidaJogador = 80;
                    menuPrincipal.barraDeVidaJogador.setValue(menuPrincipal.statusJogador.VidaJogador);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaJogador.setValue(menuPrincipal.statusJogador.VidaJogador);
                }
                if(de.getSource() == menuPrincipal.PortoMolhado.cidade1Praca.Fonte.LocalizacaoButton){
                    JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Praca.Fonte.LocalizacaoButton, "Você se aproxima da fonte.", "Fonte", JOptionPane.PLAIN_MESSAGE);
                    menuPrincipal.PortoMolhado.cidade1Praca.FonteInteracaoFrame.setVisible(true);
                    menuPrincipal.PortoMolhado.cidade1Praca.setEnabled(false);
                }
                String string8568 ="<html>Você abre o seu cantil e o afunda na água turva da fonte.<br/>Espero que você tenha um forte sistema imune.";
                if(de.getSource() == menuPrincipal.PortoMolhado.cidade1Praca.FonteEncherCantil.LocalizacaoButton){
                    if(menuPrincipal.mochila.CantilQuantAgua<menuPrincipal.mochila.CantilLimiteAgua){
                        JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Praca.FonteEncherCantil.LocalizacaoButton, string8568,"Fonte", JOptionPane.PLAIN_MESSAGE);
                        menuPrincipal.mochila.CantilQuantAgua=menuPrincipal.mochila.CantilLimiteAgua;
                        menuPrincipal.mochila.Cantil.ItemInventarioButton.setEnabled(true);
                        menuPrincipal.mochila.Cantil.ItemInventarioButton.setText("Beber do cantil("+menuPrincipal.mochila.CantilQuantAgua+"/"+menuPrincipal.mochila.CantilLimiteAgua+"💧)");
                    }
                    else{
                        JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Praca.FonteEncherCantil.LocalizacaoButton,
                         "Seu cantil já está cheio","Fonte", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                String string8569 = "<html>Você enfia a mão na fonte e pega todas as moedas. Com<br/>sorte isso não terá consequências negativas no futuro.";
                string8569 =  string8569 + "Os<br/>idosos distraídos alimentando as gaivotas não notam o ato.";
                if(de.getSource() == menuPrincipal.PortoMolhado.cidade1Praca.FontePegarMoeda.LocalizacaoButton){
                    JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Praca.FontePegarMoeda.LocalizacaoButton,
                     string8569, null, JOptionPane.PLAIN_MESSAGE);
                    menuPrincipal.statusJogador.DinheiroJogador+=4;
                    menuPrincipal.statusDinheiroLabel.setText("Dinheiro: "+menuPrincipal.statusJogador.DinheiroJogador);
                    menuPrincipal.PortoMolhado.cidade1Praca.FontePegarMoeda.LocalizacaoButton.setEnabled(false);
                }
                if(de.getSource() == menuPrincipal.PortoMolhado.cidade1Praca.FonteAfastar.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Praca.FonteInteracaoFrame.setVisible(false);
                    menuPrincipal.PortoMolhado.cidade1Praca.setEnabled(true);
                }
                if(de.getSource() == menuPrincipal.PortoMolhado.cidade1Praca.PortaoSair.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Praca.dispose();
                    menuPrincipal.setEnabled(true);
                }
            }
        };
        menuPrincipal.PortoMolhado.PracaPanel.LocalizacaoButton.addActionListener(Cidade1PracaInteraction);
        menuPrincipal.PortoMolhado.cidade1Praca.PortaoSair.LocalizacaoButton.addActionListener(Cidade1PracaInteraction);
        menuPrincipal.PortoMolhado.cidade1Praca.Fonte.LocalizacaoButton.addActionListener(Cidade1PracaInteraction);
        menuPrincipal.PortoMolhado.cidade1Praca.FonteEncherCantil.LocalizacaoButton.addActionListener(Cidade1PracaInteraction);
        menuPrincipal.PortoMolhado.cidade1Praca.FontePegarMoeda.LocalizacaoButton.addActionListener(Cidade1PracaInteraction);
        menuPrincipal.PortoMolhado.cidade1Praca.FonteAfastar.LocalizacaoButton.addActionListener(Cidade1PracaInteraction);
        menuPrincipal.PortoMolhado.cidade1Praca.BancoVazio.LocalizacaoButton.addActionListener(Cidade1PracaInteraction);

        ActionListener IgrejaInteraction = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ee) {
                if(ee.getSource() == menuPrincipal.PortoMolhado.IgrejaPanel.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Igreja.setVisible(true);
                    menuPrincipal.setEnabled(false);
                }
                if(ee.getSource() == menuPrincipal.PortoMolhado.cidade1Igreja.PadreConversar.LocalizacaoButton){
                    JOptionPane.showMessageDialog(menuPrincipal.PortoMolhado.cidade1Igreja.PadreConversar.LocalizacaoButton,
                    "Bom dia filho, tudo bem?", "Igreja São Bernardo", JOptionPane.PLAIN_MESSAGE);
                }
                if(ee.getSource() == menuPrincipal.PortoMolhado.cidade1Igreja.Entrada.LocalizacaoButton){
                    menuPrincipal.setEnabled(true);
                    menuPrincipal.PortoMolhado.cidade1Igreja.dispose();
                }
            }
        };
        menuPrincipal.PortoMolhado.IgrejaPanel.LocalizacaoButton.addActionListener(IgrejaInteraction);
        menuPrincipal.PortoMolhado.cidade1Igreja.PadreConversar.LocalizacaoButton.addActionListener(IgrejaInteraction);
        menuPrincipal.PortoMolhado.cidade1Igreja.Entrada.LocalizacaoButton.addActionListener(IgrejaInteraction);

        ActionListener EquiparArma = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent fe) {
                if(fe.getSource() == menuPrincipal.mochila.ArmasComboBox){
                if(menuPrincipal.mochila.ArmasComboBox.getSelectedIndex() == 0){
                    menuPrincipal.statusJogador.DanoJogador = 5;
                    menuPrincipal.statusAtaqueLabel.setText("Ataque: "+(menuPrincipal.statusJogador.DanoJogador));
                }
                else if(menuPrincipal.mochila.ArmasComboBox.getSelectedIndex() == 1){
                    menuPrincipal.statusJogador.DanoJogador = 10;
                    menuPrincipal.statusAtaqueLabel.setText("Ataque: "+(menuPrincipal.statusJogador.DanoJogador));
                }
                else if(menuPrincipal.mochila.ArmasComboBox.getSelectedIndex() == 2){
                    menuPrincipal.statusJogador.DanoJogador = 20;
                    menuPrincipal.statusAtaqueLabel.setText("Ataque: "+(menuPrincipal.statusJogador.DanoJogador));
                }
                }
            }
        };
        menuPrincipal.mochila.ArmasComboBox.addActionListener(EquiparArma);

        ActionListener AbrigoBatalha = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ge) {
                if(ge.getSource() == menuPrincipal.PortoMolhado.AbrigoPanel.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Abrigo.setVisible(true);
                    menuPrincipal.setEnabled(false);
                }
                else if(ge.getSource() == menuPrincipal.PortoMolhado.cidade1Abrigo.Porta1.LocalizacaoButton){
                    ataqueInimigo.statusInimigo.VidaInimigo = 120;
                    ataqueInimigo.statusInimigo.AtaqueInimigo = 50;
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setMaximum(ataqueInimigo.statusInimigo.VidaInimigo);
                    statusInimigo.VidaInimigo = ataqueInimigo.statusInimigo.VidaInimigo;
                    statusInimigo.VidaInimigo = ataqueInimigo.statusInimigo.VidaInimigo;
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setValue(ataqueInimigo.statusInimigo.VidaInimigo*2);
                    menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaInimigo.setString(statusInimigo.VidaInimigo+"/"+ataqueInimigo.statusInimigo.VidaInimigo);
                    menuPrincipal.PortoMolhado.menuBatalha.LabelInimigo.setIcon(Orc);
                    menuPrincipal.PortoMolhado.menuBatalha.LabelInimigo.setText("Orc");
                    ataqueInimigo.statusJogador.EmBatalha = 1;
                    menuPrincipal.PortoMolhado.menuBatalha.setVisible(true);
                }
                else if(ge.getSource() == menuPrincipal.PortoMolhado.cidade1Abrigo.Saida.LocalizacaoButton){
                    menuPrincipal.PortoMolhado.cidade1Abrigo.setVisible(false);
                    menuPrincipal.setEnabled(true);
                }
            }
        };
        menuPrincipal.PortoMolhado.AbrigoPanel.LocalizacaoButton.addActionListener(AbrigoBatalha);
        menuPrincipal.PortoMolhado.cidade1Abrigo.Porta1.LocalizacaoButton.addActionListener(AbrigoBatalha);
        menuPrincipal.PortoMolhado.cidade1Abrigo.Saida.LocalizacaoButton.addActionListener(AbrigoBatalha);

        //-------------------------------------------------

        Timer EnergiaRegenTimer = new Timer();

        TimerTask EnergiaRegen = new TimerTask() {
            public void run(){
                menuPrincipal.statusJogador.EnergiaJogador = menuPrincipal.statusJogador.EnergiaJogador + 10;
                if(menuPrincipal.statusJogador.EnergiaJogador>100){
                    menuPrincipal.statusJogador.EnergiaJogador=100;
                }
                menuPrincipal.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
                menuPrincipal.PortoMolhado.menuBatalha.barraDeEnergiaJogador.setValue(menuPrincipal.statusJogador.EnergiaJogador);
            }
        };
        EnergiaRegenTimer.scheduleAtFixedRate(EnergiaRegen, 0, 4000);

        VoceMorreuFrame voceMorreuFrame = new VoceMorreuFrame();

        Timer ReceberDanoTimer = new Timer();
        TimerTask ReceberDano = new TimerTask() {
            public void run(){
                menuPrincipal.statusJogador.VidaJogador = ataqueInimigo.statusJogador.VidaJogador;
                if(menuPrincipal.statusJogador.VidaJogador <= 0){
                    menuPrincipal.setEnabled(false);
                    menuPrincipal.PortoMolhado.menuBatalha.setEnabled(false);
                    voceMorreuFrame.setVisible(true);
                }
                menuPrincipal.PortoMolhado.menuBatalha.barraDeVidaJogador.setValue(menuPrincipal.statusJogador.VidaJogador);
                menuPrincipal.barraDeVidaJogador.setValue(menuPrincipal.statusJogador.VidaJogador);
                if(menuPrincipal.statusJogador.EnergiaJogador>=20){
                    menuPrincipal.PortoMolhado.menuBatalha.BotaoAtacar.setEnabled(true);
                }
            }
        };
        ReceberDanoTimer.scheduleAtFixedRate(ReceberDano, 0, 500);
    }
}