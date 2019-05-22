
package others;


public class Variable {
    public double n1;
    public double n2;
    public int sinal;
    
    public String toString(int x,String s){
        return(s + x);
    }
    public String n1(String s,String sig){    
        n1 =Integer.parseInt(s);
        if(sig == " + "){
            sinal = 1;
        }else if(sig == " - "){
            sinal = 2; 
        }
        else if(sig == " / "){
            sinal = 3; 
        }else{
            sinal = 4;
        }
        
        return (s+sig);     
    }
    
}
