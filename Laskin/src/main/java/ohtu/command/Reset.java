package ohtu.command;

import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Reset extends IOCommand{

    public Reset(JTextField syotekentta, JTextField tuloskentta, Sovelluslogiikka sovellus, JButton reset) {
        super(syotekentta, tuloskentta, sovellus, reset);
    }

    @Override
    protected void actWith(int luku) {
        sovellus.nollaa();
    }
    
}
