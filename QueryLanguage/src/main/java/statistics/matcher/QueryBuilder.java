package statistics.matcher;

import java.util.LinkedList;
import java.util.List;

public class QueryBuilder {
    
    private List<Matcher> matchers;
    
    public QueryBuilder(){
        this.matchers = new LinkedList();
    }
    
    public Matcher build(){
        Matcher[] matchers = new Matcher[this.matchers.size()];
        for(int i = 0 ; i < matchers.length ; i++){
            matchers[i] = this.matchers.get(i);
        }
        
        this.matchers = new LinkedList<>();
        
        return new And(matchers);
    }
    
    public QueryBuilder playsIn(String place){
        matchers.add(new PlaysIn(place));
        
        return this;
    }
    
    public QueryBuilder hasFewerThan(int amount, String category){
        matchers.add(new HasFewerThan(amount, category));
        
        return this;
    }
    
    public QueryBuilder hasAtLeast(int amount, String category){
        matchers.add(new HasAtLeast(amount, category));
        
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... ors){
        matchers.add(new Or(ors));
        
        return this;
    }
    
    public QueryBuilder not(Matcher not){
        matchers.add(new Not(not));
        
        return this;
    }
}
