package utfpr.ct.dainf.if62c.avaliacao;

import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class AvisoFinal extends Aviso {

    public AvisoFinal(Compromisso compromisso) {
        super(compromisso);
    }
    
    public void run() {
        
        System.out.println(compromisso.getDescricao() + " começa agora");
        
        for(Aviso av : compromisso.getAvisos())
            av.cancel();

    }
    
}
