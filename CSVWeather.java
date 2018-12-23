

/**
 *This is the assignment for week 3 of course 2 about CSV on weather information .
 * 
 * @author (Anotida George Chigunwe) 
 * @version (12/19/20-18)
 */
import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
public class CSVWeather {
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        //set temp sum  0 &  recordCount to 0 
        double tempSum = 0;
        int recordCount = 0;
        //for each record in the parse 
        for ( CSVRecord record : parser) {
            // get temp value
            double currTemp = Double.parseDouble(record.get("TemperatureF"));
            double humidity  = getHumidity(record);
            // count of recordCount =+1
            // temp sum = temp sum + currtemp 
            if (currTemp != -9999 && humidity >= value ) {
                tempSum = tempSum + currTemp;
                recordCount +=1;
            }
        
        }
        //aveTemp = tempSum/countRecord
        if ( recordCount == 0) {
            tempSum = Double.NEGATIVE_INFINITY;
            recordCount = 1;
        }
        double aveTemp = tempSum/recordCount;
        //aveTemp
        return aveTemp;                   
    }  
    
    public double getHumidity(CSVRecord record) { 
        double humidity =0;
        String stringHumidity = record.get("Humidity");
        if (stringHumidity != "N/A") {
             humidity = Double.parseDouble(stringHumidity);
        }
         else {
             humidity = Double.NEGATIVE_INFINITY; 
        }
        return humidity;     
    }
    
    public double averageTemperatureInFile(CSVParser parser) {
        //set temp sum  0 &  recordCount to 0 
        double tempSum = 0;
        int recordCount = 0;
        //for each record in the parse 
        for ( CSVRecord record : parser) {
            // get temp value
            double currTemp = Double.parseDouble(record.get("TemperatureF"));
            // count of recordCount =+1
            recordCount +=1;
            // temp sum = temp sum + currtemp 
            if (currTemp != -9999 ) {
                tempSum = tempSum + currTemp;
            }
        
        }
        //aveTemp = tempSum/countRecord
        double aveTemp = tempSum/recordCount;
        //aveTemp
        return aveTemp;
    }
    
    public void lowestHumidityInYear() {
        DirectoryResource dr = new DirectoryResource();
        double lowestHumidity = Double.POSITIVE_INFINITY;
        CSVRecord lowestHum = null;
        for (File F : dr.selectedFiles()){
            FileResource fr = new FileResource(F);
            CSVParser parser = fr.getCSVParser();
            CSVRecord record = lowestHumidityInFile(parser);
            double currHumidity = Double.parseDouble(record.get("Humidity"));
            if (lowestHumidity > currHumidity) {
                lowestHumidity = currHumidity;
                lowestHum = record;
            }
        } 
        System.out.println("Lowest humidity was : " + lowestHumidity + "time was" + lowestHum.get("DateUTC"));
    }
        
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
      // set recod and lowest humidity 
      CSVRecord lowestSoFar = null;
      Double currlowestHumidity = Double.POSITIVE_INFINITY; 
      for (CSVRecord currentRow : parser) {
        if (lowestSoFar==null){
                lowestSoFar=currentRow;
                String  humidity = currentRow.get("Humidity"); 
                if (humidity != "N/A") {
                    currlowestHumidity = Double.parseDouble(humidity);
                }
        }
        
        else{ String currhumidity = currentRow.get("Humidity"); 
              double currRowHumidity = 0;
                if ( currhumidity.equals("N/A")) {
                    currRowHumidity = Double.POSITIVE_INFINITY; 
                }
                
               else {currRowHumidity = Double.parseDouble(currhumidity);
                   if (currRowHumidity < currlowestHumidity) {
                    currlowestHumidity = currRowHumidity; 
                    lowestSoFar=currentRow;
                    }
                   
                }
                
         }      
       }
       return lowestSoFar;
    }
    
    
    public void fileWithColdestTemperature() {
      // lowest temp = null
      File coldestSoFar = null;
      File lowestTempFile =null;
      CSVParser coldestParser = null;
      double ColdestTemp = 0;
      DirectoryResource dr = new DirectoryResource();       
      // upload file one at a time
      for (File F : dr.selectedFiles()){
            // if coldestSoFar null 
            FileResource fr = new FileResource(F);
            CSVParser parser = fr.getCSVParser();
            if ( coldestSoFar == null) {
                // file withlowest temp = current file 
                lowestTempFile = F;
                ColdestTemp = coldestTempInFile(parser);
                coldestParser = parser;
            }
            else {
                // for each file get the lowest temp
                double currFileTemp = coldestTempInFile(parser);
                // compare the temp of current file with prev file temp to see which has lowest temp 
                if ( ColdestTemp > currFileTemp) {
                    // updated file with lowest temp accordingly 
                    lowestTempFile = F;
                    ColdestTemp = currFileTemp;
                    coldestParser = parser;
                }
              
            }
                      
      }
       // return file with lowest temp 
      String fileWithLowestTemp = lowestTempFile.getName();
      System.out.println("The lowest temp was in file : " + fileWithLowestTemp );
      System.out.println("The lowest temp on the day was : " + ColdestTemp );
      allTempForOneDay( coldestParser,"TemperatureF");
    }
    
    
    
     public double coldestTempInFile(CSVParser parser){ 
     
      CSVRecord largestSoFar = null;
      
      for (CSVRecord currentRow : parser) {
        if (largestSoFar==null){
            largestSoFar=currentRow;
        }
        else{ double currRowTemp = Double.parseDouble(currentRow.get("TemperatureF"));
               double  currColdestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if ( currColdestTemp > currRowTemp && currRowTemp!= -9999) {
                largestSoFar=currentRow;
            }
       }
      }
      return Double.parseDouble(largestSoFar.get("TemperatureF"));
    }
    
     
        public CSVRecord coldestHourInFile(CSVParser parser) {
      CSVRecord largestSoFar = null;
      
      for (CSVRecord currentRow : parser) {
        if (largestSoFar==null){
            largestSoFar=currentRow;
        }
        else{ double currColdestTemp = Double.parseDouble(currentRow.get("TemperatureF"));
               double currRowTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if ( currColdestTemp > currRowTemp && currRowTemp!= -9999) {
                largestSoFar=currentRow;
            }
       }
      }
      return largestSoFar;
    }
   
    
     public void allTempForOneDay (CSVParser parser, String header ) {
      System.out.println("tina b");
      String result = "NO TEMP FOUND";
        for (CSVRecord record : parser) {
                    result = record.get(header); 
                    System.out.println(result);
                
      }
        
    }    
      
    
    
    //TESTERS     
    public void testaverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        int value = 80;
        double averageTemperatureWithHighHumidityInFile = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), value);
        if (averageTemperatureWithHighHumidityInFile == Double.NEGATIVE_INFINITY) {
            System.out.println("NO HUMIDITY WITH THAT VALUE ");
        }
        else {
            System.out.println("Average temperature in file with Humidiy as specified is " + averageTemperatureWithHighHumidityInFile );
        }                             
    }
    
    public void testaverageTemperatureInFile() {
        FileResource fr = new FileResource();
        double averageTempInFile = averageTemperatureInFile(fr.getCSVParser()); 
        System.out.println("Average temperature in file is " + averageTempInFile);                      
    }
    
    
    public void testlowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVRecord lowestHumidityRecord = lowestHumidityInFile(fr.getCSVParser());
        String lowesetHumidity = lowestHumidityRecord.get("Humidity"); 
        String time = lowestHumidityRecord.get("DateUTC");  
        System.out.println(lowestHumidityRecord);
        System.out.println("The lowest Humidity was : " + lowesetHumidity + " & was recorded @ " + time );
               
    }
    
    public void testfileWithColdestTemperature() {
        FileResource fr = new FileResource("weather-2014-01-08.csv");
        CSVRecord coldestHour= coldestHourInFile(fr.getCSVParser());
        System.out.println(coldestHour);
               
    }
    
    public void testcoldestTempInFile() {
        FileResource fr = new FileResource();
        double coldestTemp= coldestTempInFile(fr.getCSVParser());
        System.out.println(coldestTemp);
               
    }
    
    public void testcoldestHourInFile() {
        FileResource fr = new FileResource("weather-2014-01-08.csv");
        CSVRecord coldestHour= coldestHourInFile(fr.getCSVParser());
        System.out.println(coldestHour);
               
    }    
    
    public void testallTempForOneDay() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        allTempForOneDay(parser, "TemperatureF");
               
    }
    
}



