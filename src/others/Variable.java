
package others;


public class Variable {
    public double n1;
    public double n2;
    public int sinal;
    public int str = 1;
    public String str1= "";
    public String str2 = "";

    
    
    public String toString(int x,String s){
        if(str % 2 == 1){
           str1 = s + x;  
        }
        else{
           str2 += x;   
        }
        return(s + x);
    }
    public String n1(String s,String sig){    
        n1 =Double.parseDouble(s);

        if(sig == " + "){
            sinal = 1;
        }else if(sig == " - "){
            sinal = 2; 
        }
        else if(sig == " / "){
            sinal = 3; 
        }else if(sig == " * "){
            sinal = 4;
        }
        else{}
        
        ++str;
        return (s+sig);
    }
    
    public String result(String s){
        s += " = ";
        String ns = "";
        n2 = Double.parseDouble(str2);
        switch(sinal){
            case 1:
                ns = s+(n1+n2);
            break;
            case 2: 
                ns = s+(n1 - n2);
            break;           
            case 3:
                ns = s+(n1/n2);
            break;
            case 4:
                ns = s+(n1*n2);
            break;
            default:
                ns = " 0 ";
            break;
        }
            
        return ns;
                
    }
    
}
