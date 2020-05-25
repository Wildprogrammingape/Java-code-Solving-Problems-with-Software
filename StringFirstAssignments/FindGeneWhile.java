
/**
 * Write a description of FindGeneWhile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneWhile {
    public String findGene(String dna){ // find all genes
        int startIndex = dna.indexOf("ATG");
        int currentIndex = dna.indexOf("TAA",startIndex + 3);
        while (currentIndex != -1){
            int diff = currentIndex - startIndex;
            if (diff % 3 == 0){ //print the substring
                return dna.substring(startIndex,currentIndex + 3);
            }
            else{ //upgrad currentIndex
                currentIndex = dna.indexOf("TAA", currentIndex + 1);
            }
        }
        return "Null"; // dont have gene
    }
    public void testFindGene(){
        String DNA1 = "NNATGBBBTAA";
        String DNA2 = "MMATGCTAACCTAA";
        System.out.println("gene is " + findGene(DNA2));
        
    }
}
