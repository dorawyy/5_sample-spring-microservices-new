package pl.piomin.services.organization;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;



public class Logger {
    
    public Logger() {}

    public void info(String str){
        try{
            if(str.startsWith("${") && str.endsWith("}")){ 
                int sInd = 2;
                int eInd = str.length()-1;
                String str2 = str.substring(sInd, eInd);
                if (str2.startsWith("java:")) {
                    // check corresponding java value 
                }
                else if (str2.startsWith("docker:")) {
                    // check corresponding docker value 
                }
                else if (str2.startsWith("jndi:")) {  
                    String str3 = str2.substring(5);
                    Context ctx = new InitialContext();
                    Object obj = ctx.lookup(str3); // sink, leak
                }else {
                    // do something else 
                }
            }else {
                // pass 
            }
    
        }catch(NamingException e) {
            e.printStackTrace();
        }
    }
        
}


