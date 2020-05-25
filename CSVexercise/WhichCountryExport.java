
/**
 * Write a description of WhichCountryExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
public class WhichCountryExport {
    public void listExporters(CSVParser parser, String exportOfInterest){
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public void whoExportCoffee(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    listExporters(parser,"coffee");
    }
}   