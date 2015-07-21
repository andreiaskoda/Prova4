package utfpr.ct.dainf.if62c.avaliacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import utfpr.ct.dainf.if62c.avaliacao.Compromisso;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Agenda {
    private final String descricao;
    private final List<Compromisso> compromissos = new ArrayList<>();
    private final Timer timer;

    public Agenda(String descricao) {
        this.descricao = descricao;
        timer = new Timer(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }
    
    public void novoCompromisso(Compromisso compromisso) {
        compromissos.add(compromisso);
        Aviso aviso = new AvisoFinal(compromisso);
        compromisso.registraAviso(aviso);
        // com a classe Aviso devidamente implementada, o erro de compilação
        // deverá desaparecer
        timer.schedule(aviso, compromisso.getData());
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia) {

        compromisso.registraAviso(new Aviso(compromisso));
        Timer timer = new Timer(compromisso.getDescricao());
        timer.schedule(new Aviso(compromisso), new Date(compromisso.getData().getTime() - antecedencia*1000));
        timer.schedule(new AvisoFinal(compromisso), compromisso.getData());
        
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia, int intervalo) {
        compromisso.registraAviso(new Aviso(compromisso));
        Timer timer = new Timer(compromisso.getDescricao());
        timer.schedule(new Aviso(compromisso), new Date(compromisso.getData().getTime()
                - antecedencia*1000), intervalo*1000);
        timer.schedule(new AvisoFinal(compromisso), compromisso.getData());
    }
    
    public void cancela(Compromisso compromisso) {
        for(Aviso a: compromisso.getAvisos())
            cancela(a);
    }
    
    public void cancela(Aviso aviso) {
        
        aviso.cancel();
        aviso.getCompromisso().removeAviso(aviso);
        
        
    }
    
    public void destroi() {
        for(Compromisso comp: compromissos){
            cancela(comp);
        }
    }
}
