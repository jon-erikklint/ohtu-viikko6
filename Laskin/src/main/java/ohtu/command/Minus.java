package ohtu.command;

import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Minus extends IOCommand{

    public Minus(JTextField syotekentta, JTextField tuloskentta, Sovelluslogiikka sovellus, JButton reset) {
        super(syotekentta, tuloskentta, sovellus, reset);
    }

    @Override
    protected void actWith(int luku) {
        sovellus.miinus(luku);
    }
    
}
