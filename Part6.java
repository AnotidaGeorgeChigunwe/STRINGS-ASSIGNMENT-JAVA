
/**
 * Write a description of Part1wk2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */import edu.duke.*;
 import java.io.File;
 
public class Part6 {
    
    public String youTube(URLResource ur ) {
                                                       
        for (String word : ur.words()) {
            
            if ( word.contains("https://www.youtube.com") || word.contains("http://www.youtube.com")) {
                System.out.println(word);                        
           }
           
        }
         return"";
   }
   
   public void testyoutube () {
       
     URLResource ur = new URLResource ("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
     String result = youTube(ur);
         
    }
}
