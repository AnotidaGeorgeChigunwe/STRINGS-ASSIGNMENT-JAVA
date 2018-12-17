
/**
 * Write a description of Part1wk2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */import edu.duke.*;
 import java.io.File;
 
public class Part1wk2 {
    
    public int findStopCodon(String dna, int startIndex, String stopCodon ) {
        int stopIndex = dna.indexOf(stopCodon, startIndex+3); 
        int currStartIndex = stopIndex;
                     
            while ( currStartIndex != -1) {
                int geneLength = stopIndex -startIndex;
                if (geneLength %3==0) {
                   return stopIndex;
                }
                
                if (geneLength%3!=0) {
                    currStartIndex = stopIndex+1;
                    stopIndex = dna.indexOf(stopCodon, currStartIndex);
                    if (stopIndex == -1) {
                      stopIndex = dna.length();
                      return stopIndex;
                    }
                }
                             
            }
            
            return dna.length();
        }
        
    public String findGene(String dna, int startHere) {
        String gene ="";
        String startCodon = "ATG";
        int startIndex = dna.indexOf(startCodon, startHere);
        if (startIndex == -1){
            return gene;
        }
        String stopCodon = "TAA";
        int TAAstopIndex = findStopCodon(dna,startIndex,stopCodon);
        stopCodon = "TAG";
        int TAGstopIndex = findStopCodon(dna,startIndex,stopCodon);
        stopCodon = "TGA";
        int TGAstopIndex = findStopCodon(dna,startIndex,stopCodon);
        
        int minIndex = Math.min( TAAstopIndex, (Math.min(TAGstopIndex,TGAstopIndex)));
        int testStopIndex = minIndex + 3;
                
            if (minIndex==dna.length()){
                gene ="";
                return gene;
            }
            
        gene = dna.substring(startIndex, minIndex + 3);   
               
         if (gene.length()==dna.length()) {
            
             if (gene.length()==6) {
                if (gene.endsWith("TAA")) {
                    return gene;
                }
                
                if (gene.endsWith("TAG")) {
                    return gene;
                }
                
                if (gene.endsWith("TGA")) {
                    return gene;
                }
            
            }           
            
            gene ="";
            return gene;
        }
        return gene;
    }
      
    
        public void printAllGenes(String dna ){
        
        int startIndex =0;
        int count = 0; 
         while ( true ){
           String currGene = findGene(dna, startIndex);
           if ( currGene=="") { 
               break;
            }
           System.out.println(currGene);
           count = count +1;
           startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
        }
        System.out.println("there are :" + count + " genes");
    }

    
      
    
    public void testfindStopCodon(){
              
        String dna = "ATGATGABCATGTGABCCX";
        String startCodon = "ATG";
        int startIndex =dna.indexOf(startCodon);
        String stopCodon = "TAA";
        int stopIndex = findStopCodon(dna,startIndex,stopCodon);
        System.out.println("The stop index is :" + stopIndex);
        
        dna = "ATGATGABCATGTGABCCX";
        startCodon = "ATG";
        startIndex =dna.indexOf(startCodon);
        stopCodon = "TAG";
        stopIndex = findStopCodon(dna,startIndex,stopCodon);
        System.out.println("The stop index is :" + stopIndex);
    }
    
    public void testfindGene(){
               
        String dna = "ATGATGABCATGTGABCCX"; //FIRST TGA NOT VALIDA
        System.out.println(dna);
        int startHere = 0;
        String gene = findGene(dna, startHere);
        System.out.println("The Gene is :" + gene); 
        
        dna = "ATGATGABCATGTFABCCX"; //NO GENE NO ENECODON
        System.out.println(dna);
        gene = findGene(dna, startHere);
        System.out.println("The Gene is :" + gene);
        
        dna = "AGATGABCATGTGABCCX"; //NO START CODON 
        System.out.println(dna);
        gene = findGene(dna, startHere);
        System.out.println("The Gene is :" + gene);
        
        dna = "DSAFJHADSATGATGABCATGTGABCCX"; //START CODON INSIDE
        System.out.println(dna);
         gene = findGene(dna, startHere);
        System.out.println("The Gene is :" + gene);
        
        dna = "ATGATGABCATGGABCCXTAAHSADG"; //FIRST TGA NOT VALIDA
        System.out.println(dna);
        gene = findGene(dna, startHere);
        System.out.println("The Gene is :" + gene);
        
        dna = "JHGDAGATGHDTSHUDTAAHSGTGANTAGNSUARGFTAGGAUHGFS"; //FIRST TGA NOT VALIDA
        System.out.println(dna);
        gene = findGene(dna, startHere);
        System.out.println("The Gene is :" + gene);
    }
    
    public void testPrintAllGenes(){
       String dna = "ATGGDFTAAAATGBSRTAAJHGDAGATGHDTSHUDTAAHSGTGANTAGNSUARGFTAGGAUHGFSATGATGABCATGGABCCXTAAHSADGDSAFJHADSATGATGABCATGTGABCCXATGATGABCATGTGABCCX";
       printAllGenes(dna);      
    
    }
        
 }
