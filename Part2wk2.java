

/**
 * Write a description of Part2wk2 This is any assignment on mastering strings .
 * 
 * @author (Anotida George Chigunwe) 
 * @version (01)
 */import edu.duke.*;
 import java.io.File;
 
public class Part2wk2 {
    
 public int howMany(String a, String b) {
    
     int startIndex = 0;
     int count = 0;
     while (true ) {
        
        int bLenght = b.length();
        int currIndex = a.indexOf(b, startIndex);
        if ( currIndex == -1) {
            break;
        }
        count = count + 1;
        startIndex = currIndex + bLenght;
        
        }   
        return count;
    }    
    
   
    
    public void testHowMany () {
        String a = "asdbabcabcabsnabcabcanddbabca";
        String b ="abca";
        System.out.println(a);
        int howMany = howMany(a,b);
        System.out.println("abca appreas :" + howMany +"times");
        
        a = "asdbaabacaabacabsnabacabacanddbabaca";
        b ="abca";
        System.out.println(a);
        howMany = howMany(a,b);
        System.out.println("abca appreas :" + howMany +"times");
    
    
    }

}
