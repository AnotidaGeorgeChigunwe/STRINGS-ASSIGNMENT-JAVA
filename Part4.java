
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
 import java.io.File;
public class Part4 {
    
    public String youTube(URLResource ur ){
    
        ur =new URLResource ("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String result ="";
        int count = 0;
                        
        for (String word : ur.words()){
            
        int checkIndex = word.indexOf("youtube.com");
        if ( checkIndex == -1){
            result ="";                         
        }
        else {
        int startIndex = word.indexOf("\""); 
        int stopIndex = word.indexOf("\"", startIndex + 1);
        result = word.substring(startIndex,stopIndex +1);
        System.out.println(result);
        }
         
        
    }
    return result;
   }
   
   public void testyoutube (){
       
     URLResource ur = new URLResource ("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
     String result = youTube(ur);
         
    }
}
