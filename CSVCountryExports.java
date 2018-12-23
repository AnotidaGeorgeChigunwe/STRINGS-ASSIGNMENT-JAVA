
/**
 *This is the assignment for week 3 of course 2.
 * 
 * @author (Anotida George Chigunwe) 
 * @version (12/19/20-18)
 */
import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

public class CSVCountryExports {
         
    public void countryInfo(CSVParser parser, String country) {
      String result = "NOT FOUND";
        for (CSVRecord record : parser) {
            String currCountry = record.get("Country"); 
                if (currCountry.equals(country)) {
                    result = record.get("Country") + " :"+ record.get("Exports") + " :"+ record.get("Value (dollars)"); 
                    System.out.println(result);
                }
      }
        
    }
        
     public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2 ) {
      String result = "NO COUNTRY FOUND";
        for (CSVRecord record : parser) {
            String currCountry = record.get("Exports"); 
                if (currCountry.contains(exportItem1) && currCountry.contains(exportItem2)) {
                    result = record.get("Country"); 
                    System.out.println(result);
                }
      }
        
    }
    
     public void numberOfExporters (CSVParser parser, String exportItem) {
      String result = "NO COUNTRY FOUND";
      int count = 0;
        for (CSVRecord record : parser) {
            String currCountry = record.get("Exports"); 
                if (currCountry.contains(exportItem)) {
                    count +=1 ;                     
                }
         }
        System.out.println("Number of countries exporting " + exportItem + " are : " + count);
    }
    
    public void bigExporters (CSVParser parser, String amount) {
      String result = "NO BIG EXPORTER";
      int count = 0;
        for (CSVRecord record : parser) {
            String currAmount = record.get("Value (dollars)"); 
                if ((currAmount.length()) > (amount.length())) {
                    result = record.get("Country") + " :"+ record.get("Exports") + " :"+ record.get("Value (dollars)"); 
                    System.out.println(result);
                }
         }
        
    }
    
    public void testcountryInfo() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Nauru");
               
    }
        
     public void testlistExportersTwoProducts() {
        FileResource fr2 = new FileResource();
        CSVParser parser = fr2.getCSVParser();
        listExportersTwoProducts(parser, "flowers","cotton");
    }
    
      public void testnumberOfExporters() {
        FileResource fr3 = new FileResource();
        CSVParser parser = fr3.getCSVParser();
        numberOfExporters(parser, "cocoa");
    }
    
      public void testbigExporters() {
        FileResource fr3 = new FileResource();
        CSVParser parser = fr3.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }

}
