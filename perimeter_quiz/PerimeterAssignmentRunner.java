 

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {   //given a shape, return the perimeter of the shape
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int countnum = 0;
        for (Point pt : s.getPoints()){
            countnum +=1;
        }
        return countnum;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        
        double perimeter = getPerimeter (s);
        int num = getNumPoints (s);
        double avg = perimeter / num;
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
      
        double side = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt); //calculate current dis
            if (currDist > side){
                side = currDist;          
            }
            prevPt = currPt;    //update pointer for prevPt
        }
        return side;
    }

    public double getLargestX(Shape s) {
        // Put code here
        // we can use .getX() method for any Point
        Point initPt = s.getLastPoint();
        double larX = initPt.getX();  // set larX as the first point X
        for (Point p : s.getPoints()){
            if (p.getX() > larX){
                larX = p.getX();
            }
        }
        return larX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();//to select multiple files
        double largeP = 0.0;
        for (File f : dr.selectedFiles()){ // iterate all selected files
            FileResource file = new FileResource(f); // use FileResource to read data
            Shape s = new Shape(file);
            double curPerimeter = getPerimeter(s);
            if (curPerimeter > largeP){
                largeP = curPerimeter;
            }
        }
        return largeP;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largeP = 0.0;
        File largeF = null;
        for (File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape s = new Shape(file);
            double curPerimeter = getPerimeter(s);
            if (curPerimeter > largeP){
                largeP = curPerimeter;
                largeF = f;
            }
        }
        return largeF.getName();
    }

    public void testPerimeter () { 
        FileResource fr = new FileResource();  // select a data file
        Shape s = new Shape(fr);    // create a shape based on the file
        double length = getPerimeter(s);  // calculate the perimeter of the shape
        System.out.println("perimeter = " + length); // print out the output
        
        int num = getNumPoints(s); // calculate the numbers of Shape s
        System.out.println("Number = " + num);
        
        double avg = getAverageLength(s); //calculate average length
        System.out.println("Average length = " + avg);
        
        double largest_side = getLargestSide(s); //calculate the largest side
        System.out.println("Largest side = " + largest_side);
        
        double larX = getLargestX(s);
        System.out.println("Largest X value is "+ larX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double LargestP = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter among selected files is: " + LargestP);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name = getFileWithLargestPerimeter();
        System.out.println("File name with largest perimeter is: " + name);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {//make an object and run above method
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();             
        pr.testPerimeterMultipleFiles(); //largest perimeter of multi selected files
        pr.testFileWithLargestPerimeter();//Name of largest perimeter among multi selected files
    }
}
