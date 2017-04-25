package ohtu.command;

import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Sum extends IOCommand{

    public Sum(JTextField syotekentta, JTextField tuloskentta, Sovelluslogiikka sovellus, JButton reset) {
        super(syotekentta, tuloskentta, sovellus, reset);
    }

    @Override
    protected void actWith(int luku) {
        sovellus.plus(luku);
    }
    
}
