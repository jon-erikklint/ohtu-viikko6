package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class HasFewerThan implements Matcher{
    
    private int value;
    private String fieldName;
    
    public HasFewerThan(int value, String category){
        this.value = value;
        
        fieldName = "get"+category.substring(0, 1).toUpperCase()+category.substring(1);
    }

    @Override
    public boolean matches(Player p) {
        try{
            Method toCall = p.getClass().getMethod(fieldName);
            int arvo = (Integer)toCall.invoke(p);
            
            return arvo < value;
        }catch(Exception e){
            System.out.println(e);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }
    }
    
    
    
}
