public class AtaqueInimigo extends Thread{
    StatusJogador statusJogador = new StatusJogador();
    StatusInimigo statusInimigo = new StatusInimigo();

    @Override
    public void run(){
        while(true){
            if(statusJogador.EmBatalha == 1){
                System.out.println("Inimigo ataca!");
                if(statusJogador.ArmaduraJogador < statusInimigo.AtaqueInimigo){
                    statusJogador.VidaJogador=statusJogador.VidaJogador-(statusInimigo.AtaqueInimigo-(statusJogador.ArmaduraJogador));
                }
                else{
                    statusJogador.VidaJogador=statusJogador.VidaJogador-5;
                }
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if(statusJogador.EmBatalha == 0){
                System.out.println("Inimigo nao ataca!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
