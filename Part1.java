
/**
 * Write a description of Part1 here.
 * 
 * @author (Anotida George Chigunwe ) 
 * @version (12/08/2018)
 */
 import edu.duke.*;
 import java.io.File;
public class Part1 {
    public String findSimpleGene (String dna){
        //find ATG         
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf("TAA",startIndex+3);
        if (endIndex== -1){
             return "";
            }
        result = dna.substring(startIndex,endIndex+3); 
        int length = result.length();
        if (length % 3 != 0){
            return "";
        }
       
        return result;
     }
     
          
    public void testSimpleGene(){
       String dna = "ATDTATDSAUSHATGSTDFYSVVCSTGTAATAFTSDTASFATT";//as gene 
       System.out.println("DNA IS :" + dna);
       String gene = findSimpleGene(dna);
       System.out.println("GENE IS :" + gene);
       
       dna = "ATDTATDSAUSHAGSTDFYSVVCSTGTAATAFTSDTASFATT";//has no ATG
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna);
       System.out.println("GENE IS :" + gene);
       
       dna = "ATDTATDSAUSHATGSTDFYSVVCSTGTATAFTSDTASFATT";//has no TAA
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna);
       System.out.println("GENE IS :" + gene);
       
       dna = "ATDTATDSAUSHATSTDFYSVVCSTGTATAFTSDTASFATT";//has no TAA & TAG
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna);
       System.out.println("GENE IS :" + gene);
       }
}
