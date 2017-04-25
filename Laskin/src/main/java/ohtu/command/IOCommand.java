package ohtu.command;

import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public abstract class IOCommand implements Command{

    private JTextField syotekentta;
    private JTextField tuloskentta;
    protected Sovelluslogiikka sovellus;
    private JButton resetButton;

    public IOCommand(JTextField syotekentta, JTextField tuloskentta, Sovelluslogiikka sovellus, JButton reset) {
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.sovellus = sovellus;
        this.resetButton = reset;
    }
    
    @Override
    public void execute() {
        int luku;
        try{
            luku = Integer.parseInt(syotekentta.getText());
        }catch(Exception e){
            return;
        }
        
        actWith(luku);
        refreshState();
    }
    
    @Override
    public void undo(){
        
    }
    
    protected abstract void actWith(int luku);
    
    protected void refreshState(){
        int tulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText(""+tulos);
        resetButton.setEnabled(sovellus.tulos() != 0);
    }
    
}
