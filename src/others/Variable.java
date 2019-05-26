
package others;


public class Variable {
    public double n1;
    public double n2;
    public int sinal;
    public int str = 1;
    public String str1= "";
    public String str2 = "";
    public boolean f = false;

    
    
    public String toString(int x,String s){
        System.out.println(n1);
        System.out.println(n2);
    if(f == true){
        s = "";
        str1 = "";
        str2 = "";
        f = false;
    }
        if(str % 2 == 1){
           str1 = s + x;  
        }
        else{
           str2 += x;   
        }
        return(s + x);
    }
    //---------------------------------------------------------------------------
    public String n1(String s,String sig){    
        if(f == true){
            str1="";
            str2 = "";
            n1 = n1+n2;
            s = Double.toString(n1);
            str1 = n1+sig;
            f = false;
        }
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
 //-----------------------------------------------------------------------------    
    public String result(String s){
        s += " = ";
        n2 = Double.parseDouble(str2);      
        ++str;
        f = true;    
        return s+conta(); 
    }
 //-----------------------------------------------------------------------------   
    
    
    public String conta(){
        String ns = "";
         switch(sinal){
            case 1:
                ns += n1+n2;
            break;
            case 2: 
                ns += (n1 - n2);
            break;           
            case 3:
                ns += (n1/n2);
            break;
            case 4:
                ns += n1*n2;
            break;
            default:
                ns = " 0 ";
            break;
        }
         return ns;
    }
    
}
