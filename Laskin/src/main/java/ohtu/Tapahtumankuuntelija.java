package ohtu;

import ohtu.command.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    
    private Sovelluslogiikka sovellus;
    private JButton undo;
    private Map<JButton, Command> komennot;
    
    private Command edellinen;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        sovellus = new Sovelluslogiikka();
        this.undo = undo;
        
        edellinen = null;
        
        komennot = new HashMap<>();
        komennot.put(nollaa, new Reset(syotekentta, tuloskentta, sovellus, nollaa));
        komennot.put(plus, new Sum(syotekentta, tuloskentta, sovellus, nollaa));
        komennot.put(miinus, new Minus(syotekentta, tuloskentta, sovellus, nollaa));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Command komento = komennot.get(ae.getSource());
                
        if(komento != null){
            komento.execute();
            edellinen = komento;
        }else if(edellinen != null){
            edellinen.undo();
            edellinen = null;
        }
       
        undo.setEnabled(edellinen!=null);
    }
 
}