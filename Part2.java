
/**
 * Write a description of Part1 here.
 * 
 * @author (Anotida George Chigunwe ) 
 * @version (12/09/2018)
 */
 import edu.duke.*;
 import java.io.File;
public class Part2 {
    public String findSimpleGene (String dna,String startCodon, String stopCodon ){
        //find ATG         
        String result = "";        
        String upperCaseDna = dna.toUpperCase();
             if (upperCaseDna == dna) {
                   int startIndex = dna.indexOf(startCodon);
                   if (startIndex == -1){
                     return "";
                   }
                   int endIndex = dna.indexOf(stopCodon,startIndex+3);
                     if (endIndex== -1){
                      return "";
                   }
                      result = dna.substring(startIndex,endIndex+3); 
                     int length = result.length();
                      if (length % 3 != 0){
                        return "";
                  }
       
               }
               
               if (upperCaseDna != dna) {
                   int startIndex = upperCaseDna.indexOf(startCodon);
                   if (startIndex == -1){
                     return "";
                   }
                   int endIndex = upperCaseDna.indexOf(stopCodon,startIndex+3);
                     if (endIndex== -1){
                      return "";
                   }
                    String resultUpperCase = upperCaseDna.substring(startIndex,endIndex+3); 
                     int length = resultUpperCase.length();
                      if (length % 3 != 0){
                        return "";
                  }
                  
                  result = resultUpperCase.toLowerCase();
       
               }
          return result;
     }
     
    public void testSimpleGene(){
       String dna = "ATDTATDSAUSHATGSTDFYSVVCSTGTAATAFTSDTASFATT";//as gene 
       String startCodon = "ATG";
       String stopCodon = "TAA";  
       System.out.println("DNA IS :" + dna);
       String gene = findSimpleGene(dna, startCodon, stopCodon);
       System.out.println("GENE IS :" + gene);
       
       dna = "ATDTATDSAUSHAGSTDFYSVVCSTGTAATAFTSDTASFATT";//has no ATG
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna , startCodon, stopCodon);
       System.out.println("GENE IS :" + gene);
       
       dna = "ATDTATDSAUSHATGSTDFYSVVCSTGTATAFTSDTASFATT";//has no TAA
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna , startCodon, stopCodon);
       System.out.println("GENE IS :" + gene);
       
       dna = "ATDTATDSAUSHATSTDFYSVVCSTGTATAFTSDTASFATT";//has no TAA & TAG
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna , startCodon, stopCodon);
       System.out.println("GENE IS :" + gene);
       
       dna = "ajvsjjgaskatgkgskfkajskakshktaahfjasjdg";//lower case
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna , startCodon, stopCodon);
       System.out.println("GENE IS :" + gene);
       
       
       dna = "ajvsjjgaskagkgskfkajskakshktaahfjasjdg";//lower case no atg
       System.out.println("DNA IS :" + dna);
       gene = findSimpleGene(dna , startCodon, stopCodon);
       System.out.println("GENE IS :" + gene);
       }
}
