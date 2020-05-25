
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser){
            if (largestSoFar == null){
                largestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp > largestTemp){
                    largestSoFar = currentRow;
                }
            }
        }
        return largestSoFar;  // return the CSV record row with highest temperature
    }
    public void testHottestInDay(){
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        //we get the CSV record in hottestHourInFile() method, the record is a row
        System.out.println("Hottest temperature was "+ largest.get("TemperatureF") + " at " + largest.get("TimeEST")+" With Weather condition "+largest.get("Conditions"));
    }

}
