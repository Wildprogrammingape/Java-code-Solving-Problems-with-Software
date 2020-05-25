
/**
 * Write a description of AllCodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllCodons {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        // find stop Index of any strings 
        int currentIndex = dnaStr.indexOf(stopCodon,startIndex + 3);
        while (currentIndex != -1){
            int diff = currentIndex - startIndex;
            if (diff % 3 == 0){
                return currentIndex;
            }
            else{
                currentIndex = dnaStr.indexOf(stopCodon,currentIndex + 1);                
            }
        }
        return dnaStr.length(); // dont have gene
    }
    
    public String findGene(String dna){ //find genes with 3 stopCodons, print the First gene
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        
        int taaIndex = findStopCodon(dna,startIndex,"TAA"); // 3 stopcodon index
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        
        int minIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex)); 
        // find the smallest stopcodon index
        if (minIndex  == dna.length()){// have no genes for all "TAA", "TAG" and "TGA"
            return "";
        }
        
        return dna.substring(startIndex,minIndex+3);
   
    }
    public void testfindGene(){// test print gene with 3 stopcodons
        String test1 = "ATGBBBCCCTAG123TAA321TGA";
        System.out.println("gene of test1 is " + findGene(test1)); // should be : ATGBBBCCCTAG
        
        String test2 = "ATGBBBCCCTGA123TAA321TAG";
        System.out.println("gene of test1 is " + findGene(test2)); // should be : ATGBBBCCCTGA
        
        String test3 = "ATGBCTGA123TAA321TAG";
        System.out.println("gene of test1 is " + findGene(test3)); // no gene
        System.out.println("stopcodon is length of test3: " + findStopCodon(test3, test3.indexOf("ATG"), "TAA")); // 20
        //System.out.println("stopcodon is length of test3" + findStopCodon(test3, startIndex, "TAA"));   startIndex is in other method which is an private variable
    }
    
    public void testFindStop(){ 
        String DNA1 = "NNATGBBBCCCTAA";
        String DNA2 = "MMATGCTAACCTAA";
        System.out.println("Stopcodon index is " + findStopCodon(DNA1,2,"TAA"));
        
    }
}
