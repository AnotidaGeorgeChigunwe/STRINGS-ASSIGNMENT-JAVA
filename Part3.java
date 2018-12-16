
/**
 * Write a description of Part3 here.
 * 
 * @author (Anotida George Chigunwe) 
 * @version (2018/09/12)
 */
import edu.duke.*;
import java.io.File;

public class Part3 {
    
    
    public boolean twoOccarances (String a, String b){
        int startIndex = a.indexOf(b);
        boolean boo;
                if (startIndex ==-1){
             boo=(startIndex>0);          
        }
        int startIndex2 = a.indexOf(b,startIndex+b.length());
        
        boo = startIndex2>=0;
        
       return boo; 

      }
      
    public String lastPart (String a, String b){
        String result = "";
        int startIndex = a.indexOf(b);
        if (startIndex ==-1){
            result = a;
        }
        int stopIndex = a.length()-1;
        result = a.substring(startIndex +b.length(),stopIndex);
       
        return result; 

      }
      
      
      public void testlastPart (){
          
          String a = "anotida chigunwe and marcia nyika ";
          String b = "gu";
          String result = lastPart(a,b);
          System.out.println("theLast Part:" + result);         
          
        }
        
        public void testwoOccarances (){
          
          String a = "anotida chigunwe and marcia nyika ";
          String b = "gu";
          boolean result = twoOccarances(a,b);
          System.out.println(result);
          
          a = "anotida chigunwe and marcia gu nyika ";
          result = twoOccarances(a,b);
          System.out.println(result);
          
          a = "anotida chigunwe and marcia gu nyika gu";
          result = twoOccarances(a,b);
          System.out.println(result);
          
          a = "anotida chignwe and marcia u nyika u";
          result = twoOccarances(a,b);
          System.out.println(result);
          
        }
}

