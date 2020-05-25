
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGine(String dna,String start, String stop){
        int startIndex = dna.indexOf(start);
        if (startIndex == -1){ // no ATG
        return "";
        }
        
        int stopIndex = dna.indexOf(stop,startIndex + 3);
        if (stopIndex == -1){ //no TAA
        return "";
        }
        
        String subString = dna.substring(startIndex,stopIndex+3);
        if (subString.length() % 3 ==0){ // have gene
            return subString;
        }
        
        return ""; // don't have gene
    }
    
    public void testSimpleGene(){
    String DNA1 = "BBATGCCCTAA";
    String DNA2 = "BBATBCCCTAA";
    String DNA3 = "BBATBCCCTAE";
    String DNA4 = "BBATBCCCTAE";
    String DNA5 = "BBATGCCCETAA";
    System.out.println("DNA1 is " + DNA1);
    System.out.println("DNA2 is " + DNA2);
    System.out.println("DNA3 is " + DNA3);
    System.out.println("DNA4 is " + DNA4);
    System.out.println("DNA5 is " + DNA5);
    
    //test method findSimpleGine()
    String gene = findSimpleGine(DNA1,"ATG","TAA");
    System.out.println("Gene is " + gene);
    }

}
