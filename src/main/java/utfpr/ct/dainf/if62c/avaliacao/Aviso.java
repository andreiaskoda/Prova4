package utfpr.ct.dainf.if62c.avaliacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Aviso extends TimerTask {
    
    protected final Compromisso compromisso;
    private final Date currentTime = new Date();
    private final Date antecedencia = new Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("'Hora:' HH:mm:ss");

    public Aviso(Compromisso compromisso) {
       this.compromisso = compromisso;
    }

    
    @Override
    public void run() {
        currentTime.setTime(System.currentTimeMillis());
        long segundos = 0;

        segundos = (compromisso.getData().getTime() - System.currentTimeMillis())/1000;

        System.out.println(compromisso.getDescricao() + " começa em " +
                segundos + "s");
        }

    public Compromisso getCompromisso() {
        return compromisso;
    }
    
    
    
        
}
