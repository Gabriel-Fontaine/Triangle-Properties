import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
/**
* TriangleApp
* Task - TriangleApp: The purpose of this unit was to further exemplify and showcase how GUIs and graphics user interfaces can be used in relation to programming concepts such as stepwise refinement, with this assignment requiring you to calculate various properties of a triangle based on three side length values that a user inputs into the GUI that had been created
* U6A2
* @author Gabriel Fontaine
* @version May 6 Monday 2024
*/
public class TriangleApp extends JFrame {
   JTextField firstSideLength, secondSideLength, thirdSideLength, describeStats; // variables that are JTextFields that should be accessible as global variables throughout the code
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  // allows access to screen size
	JLabel area, height, perimeter, triType, firstAngle, secondAngle, thirdAngle, canFormTriangle; // variables that are JLabels that should be accessible as global variables
  
   DecimalFormat roundBetter = new DecimalFormat("#.##"); // is used so that decimal values can be rounded to two decimal places for ease
	double triangleArea = 0; // the value that corresponds with the area of the triangle
   String stats = ""; // should represent all of the qualities of the triangle
	
	
   /**
    * TriangleApp is a method which runs the initial construction and formation of the GUI and the associated GUI elements that it is able to implement
    *
    */
  
   public TriangleApp() {
   	
   	setTitle ("Triangle Properties"); //sets the title of the window
		setSize (800, 500); //sets the window size: 800 pixels wide by 500 pixels high
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //exits program when the window is closed
		Container contentPane = getContentPane(); //declares a contentPane in which objects can be added
		contentPane.setBackground(Color.PINK); //sets background to the color blue
		contentPane.setLayout(new FlowLayout()); //sets the layout of the content pane to flowLayout
		
		JLabel insertFirstSide = new JLabel("First Side Length:"); //creates a label to tell the user to input the first side length
		insertFirstSide.setBackground(Color.GRAY);
		contentPane.add(insertFirstSide); //adds label to the content pane
		
		firstSideLength = new JTextField(10); //creates a text field of 20 characters
		firstSideLength.setBackground(Color.WHITE);
		contentPane.add(firstSideLength); //adds the text field to the content pane
		
		JLabel insertSecondSide = new JLabel("Second Side Length:"); //creates a label for the description
		insertSecondSide.setBackground(Color.GRAY);
		contentPane.add(insertSecondSide); //adds label to the content pane
		
		secondSideLength = new JTextField(10); // creates a text area with 10 lines and 20 characters per line
		secondSideLength.setBackground(Color.WHITE);
		contentPane.add(secondSideLength);
		
		JLabel insertThirdSide = new JLabel("Third Side Length:"); //creates a label for the description
		insertThirdSide.setBackground(Color.GRAY);
		contentPane.add(insertThirdSide); // adds label to the content pane
		
		thirdSideLength = new JTextField(10); // creates a text area with 10 lines and 20 characters per line
		thirdSideLength.setBackground(Color.WHITE);
		contentPane.add(thirdSideLength);
		
		JButton calculateStats = new JButton("Perform Stats");
		calculateStats.addActionListener(new PerformStats()); // calls the performStats class so that the action listener library can be referenced to identify how the program should react in response to having had a button response act in regard to being clicked
       add(calculateStats);
      
       JLabel triangleStats = new JLabel("Triangle Stats:"); // creates a label for the description
       triangleStats.setBackground(Color.GRAY);
		contentPane.add(triangleStats); // adds label to the content pane
		
		// NOTE: since this does not function properly, displaying the stats to the screen, the program still displays the information to the console appropriately
		describeStats = new JTextField(stats); // should have inputted the value of stats if the code was smart enough to actually get the updated value of stats, as it should have been updated prior to reaching this line due to the fact that when the ActionListener class was referenced, it should have referenced and called other methods to update this variable, however the program is extraordinarily obstinate and stubborn, choosing to not comply and simply do as it is told for an unexplained reason
		describeStats.setBackground(Color.WHITE);
		contentPane.add(describeStats); // adds this description to the content pane
		describeStats.setText(stats);
      
      
       setVisible(true); // sets the JFrame as visible for the users to see
   }
  
   /**
    * checkIfTriangleIsTriangle is a method which is calld to check the validity of if any particular side length is greater than or less than the total of the other two side lengths
    * @param sideA
    * @param sideB
    * @param sideC
    * @return provides that which called this method with the factuality of if
    */
  
   public Boolean checkIfTriangleIsTriangle(double sideA, double sideB, double sideC){
   	
		Boolean triangleConfirmed = false; // by default the side lengths should not be guaranteed to form a triangle
		if (sideA < (sideB + sideC)){ // a triangle can be formed if each of the sides is less than the total of the other two corresponding side lengths
			if (sideB < (sideA + sideC)){
				if (sideC < (sideA + sideB)){
					triangleConfirmed = true; // the program has realized that the side lengths do indeed form a triangle
				}
			}
		}
		return triangleConfirmed; // gives the user a true or false fact of the triangle being able to form a triangle or not being able to make one
	}
  
  
   /**
	 *
	 * findArea is a method which is called so that the area of the triangle can be calculated
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	
	public void findArea(double sideA, double sideB, double sideC){
		double semiPerimeter; // the concept of half of the sum of all of the side lengths
		
		semiPerimeter = (sideA + sideB + sideC) / 2; // formula for calculating the area of the triangle using only side lengths
		triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC)); // calculates the total area of the triangle using the formula of Area being equal to the square root of (s(s-a)(s-b)(s-c))
	
		stats += "The Area of the Triangle is: " + roundBetter.format(triangleArea) + ", "; // should update the following information to be displayed in the JTextField for the triangle's properties
		System.out.println("The Area of the Triangle is: " + roundBetter.format(triangleArea)); // prints the final value of the area of the triangle
	}
	
	
	/**
	 *
	 * findPerimeter is a method which is called to calculate all of the total side lengths of the triangle
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	
	public void findPerimeter(double sideA, double sideB, double sideC) {
		double perimeter = sideA + sideB + sideC;
		stats += "The Perimeter is: " + roundBetter.format(perimeter) + ", "; // should update the following information to be displayed in the JTextField for the triangle's properties
		System.out.println("The Perimeter is: " + roundBetter.format(perimeter)); // prints the total
	}
	
	
	/**
	 *
	 * determineAngles is a method which can be used so that all angles can be given to the findAngle method by reassigning the order of the variable values given to the method, so that the same formula can be used to identify each angle
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	
	public void determineAngles(double sideA, double sideB, double sideC) {
		
		double firstAngle = Double.parseDouble(roundBetter.format(findAngle(sideA, sideB, sideC)));
		double secondAngle = Double.parseDouble(roundBetter.format(findAngle(sideA, sideC, sideB)));
		double thirdAngle = Double.parseDouble(roundBetter.format(findAngle(sideC, sideB, sideA)));
		
		System.out.println("First angle: " + firstAngle); // note that the last side length that is given corresponds to what angle is being solved for
		System.out.println("Second angle: " + secondAngle); // solving for angle opposing side length B
		System.out.println("Third angle: " + thirdAngle); // solving for the angle opposing the side length A
		
		
		stats += "First angle: " + firstAngle + ", Second angle: " + secondAngle + ", Third angle: " + thirdAngle + ", "; // should update the following information to be displayed in the JTextField for the triangle's properties
		
		determineTypeOfTriangle(firstAngle, secondAngle, thirdAngle); // calculates the the three angles for the method determining the type of triangle it is
	}
	
	
	/**
	 *
	 * findAngle is a method which is called for the purpose of identifying a specified angle based on rearranging the formula for the cosine law, so that each of the associated angles can be found from analyzing and rearranging it from the format of the SSS case scenario
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 * @return provides the determineAngles method with all of the associated angle values, so that the program can utilize them later throughout the code
	 */
	
	public double findAngle(double sideA, double sideB, double sideC) {
		
		double angle = Math.acos((Math.pow(sideC, 2) - Math.pow(sideA, 2) - Math.pow(sideB, 2)) / (-2 * sideA * sideB)); // rearranged cosine law formula cos^-1 ((c^2 - a^2 - b^2) / -2ab) = C, from the original formula of c = a^2 +b^2 -2(a)(b)cosC
		angle = angle * 180 / Math.PI; // java is weird and chooses to automatically have their angles assigned in radians, so I must convert to degrees by multiplying by 180 degrees and dividing by PI through the proficiency in knowledge learned from taking Advanced Functions
		
		return angle; // returns the angle back to the main program, based on the specified angles
	}
	
	
	/**
	 *
	 * determineTypeOfTriangle is a method which is called for the purpose of identifying the specific type of triangle it is based on the associations that the control structures below can learn based on the triangle's angles
	 * @param firstAngle
	 * @param secondAngle
	 * @param thirdAngle
	 */
	
	public void determineTypeOfTriangle(double firstAngle, double secondAngle, double thirdAngle) {
		if (firstAngle == secondAngle && secondAngle == thirdAngle) { // is equilateral since all sides are equal
			stats += "Is an Equilateral Triangle, "; // should update the following information to be displayed in the JTextField for the triangle's properties
			System.out.println("Is an Equilateral Triangle");
		} else if (firstAngle == secondAngle || secondAngle == thirdAngle || firstAngle == thirdAngle) { // is isosceles triangle since only two of the side lengths have to be the same
			stats += "Is an Isosceles Triangle, "; // should update the following information to be displayed in the JTextField for the triangle's properties
			System.out.println("Is an Isosceles Triangle");
		} else { // is scalene triangle since none of the side lengths are the same and are equivalent
			stats += "Is a Scalene Triangle, "; // should update the following information to be displayed in the JTextField for the triangle's properties
			System.out.println("Is a Scalene Triangle");
		}
		if (firstAngle == 90 || secondAngle == 90 || thirdAngle == 90) { // checks additionally to see if the triangle is a right triangle with a 90 degree angle
			stats += "Is a Right Triangle, "; // should update the following information to be displayed in the JTextField for the triangle's properties
			System.out.println("Is a Right Triangle");
		}
	}
	
	
	/**
	 *
	 * findTriangleHeight is a method which is called to identify all of the possible heights for the triangle
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	
	public void findTriangleHeight(double sideA, double sideB, double sideC) {
		System.out.println(); // note that there are three heights based on what you define your base of your triangle as
		System.out.println("Height relative to side A: " + roundBetter.format(2 * triangleArea / sideA)); // assume that side A is your base in this scenario which represents the height in relation to this side
		System.out.println("Height relative to side B: " + roundBetter.format(2 * triangleArea / sideB)); // assume that side B is your base in this scenario which represents the height in relation to this side
		System.out.println("Height relative to side C: " + roundBetter.format(2 * triangleArea / sideC)); // assume that side C is your base in this scenario which represents the height in relation to this side
	
		 // should update the following information to be displayed in the JTextField for the triangle's properties
		stats += "Height relative to side A: " + roundBetter.format(2 * triangleArea / sideA) + ", "; // telling the stats variable this info so that it can display it
		stats += "Height relative to side B: " + roundBetter.format(2 * triangleArea / sideB) + ", ";
		stats += "Height relative to side C: " + roundBetter.format(2 * triangleArea / sideC) + ", ";
	}
	
	
	
	/**
	 * Class PerformStats
	 * Purpose: to perform the various requirements and responses that should be taken once the perform stats button has been clicked on the first JFrame
	 * @author 89125fon
	 * @version May 6th 2024
	 */
  
   private class PerformStats implements ActionListener {
      
      
       /**
        *
        * actionPerformed is a method which is called to have a reactionary result from having the user click a JButton
        */
   	
       @Override
       public void actionPerformed(ActionEvent e) {
           double sideA = Double.parseDouble(firstSideLength.getText()); // converts the following side lengths from JTextField strings to doubles
           double sideB = Double.parseDouble(secondSideLength.getText());
           double sideC = Double.parseDouble(thirdSideLength.getText());
           if (checkIfTriangleIsTriangle(sideA, sideB, sideC) == true) { // checks to see if the triangle is actually capable of forming a triangle
           	stats += "Can form triangle, "; // tells the GUI it can make a triangle based on the validity of it being confirmed
           	System.out.println("Can form triangle\n"); // is a triangle based on the algorithm used to calculate it
               determineAngles(sideA, sideB, sideC); // calls the various methods for each of the following calculations to be performed
               findPerimeter(sideA, sideB, sideC);
               findArea(sideA, sideB, sideC);
               findTriangleHeight(sideA, sideB, sideC);
               JFrame newFrame = new JFrame(); // creates a new JFrame for the purpose of sketching the triangle on top of
               newFrame.setTitle("Triangle Sketch");
               newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               newFrame.setSize(1000, 1000); // sets size large enough that the user should hopefully be able to make a triangle any size they want
               newFrame.setLocationRelativeTo(null); // creates an initial location for the JFrame to be generated to jsut be relative to the centre of the screen for the user
               TrianglePanel trianglePanel = new TrianglePanel(sideA, sideB, sideC);
               newFrame.add(trianglePanel);
               newFrame.setVisible(true);
           } else {
           	stats += "The side lengths provided cannot form a triangle";
               System.out.println("The side lengths provided cannot form a triangle");
           }
          
   		describeStats.setText(stats); // should try altering the JTextField of describeStats again to see if it will alter the text within based on the updated value of stats that has been calculated and changed throughout
       }
   }
  
   /**
	 * Class TrianglePanel
	 * Purpose: To display the triangle that is drawn through utilizing the Graphics component for the GUI, along with having it draw a line, based on the data gathered from the three side lengths that were provided to this class
	 * @author 89125fon
	 * @version May 6th 2024
	 */
  
   public class TrianglePanel extends JPanel {
   	double sideA = Double.parseDouble(firstSideLength.getText()); // converts the following side lengths from JTextField strings to doubles
       double sideB = Double.parseDouble(secondSideLength.getText());
       double sideC = Double.parseDouble(thirdSideLength.getText());
      
      
       /**
        *
        * TrianglePanel is a constructor method which is called for the purpose of initializing the class and confirming the fact that the side lengths obtained can be converted from doubles to integer values, as when sketching pixel measurements, it is impossible to sketch and draw fractions of pixels on a screen
        * @param sideA
        * @param sideB
        * @param sideC
        */
      
       public TrianglePanel(double sideA, double sideB, double sideC) {
      // 	sideA = Math.ceil(sideA); // forces the triangle to round to eradicate decimals in case it gets frustrated with the int cast
      //  	sideB = Math.ceil(sideB);
      // 	sideC = Math.ceil(sideC);
       	
           this.sideA = (int) sideA; // a cast is also added to force the side lengths into integers from doubles
           this.sideB = (int) sideB;
           this.sideC = (int) sideC;
       }
      
      
       /**
        *
        * paintComponent is a method which is called to have the triangle draw a line from each of the side lengths via acknowledging that they can act as coordinate points if arranged correctly in an orderly manner
        */
       @Override
       public void paintComponent(Graphics g) {
           super.paintComponent(g); // overrides the paint function to ensure that we want a constant and singular sketch for the triangle, with a new triangle sketch requiring three new side lengths rather than just using the previous JFrame, but rather needing an entire new subsequent JFrame for having more triangles drawn in surplus
          
        
   		
           // The shift horizontally is displayed with a shift right of 300 pixels from the left edge of the JFrame generated, and the value of 600 represents 600 pixels that have been shifted down from the top, as if we do not add an initial shift for the GUI triangle sketch, then the triangle will simply be drawn starting from the top left corner of the JFrame that had been generated
           // NOTE: the values of 300 and 600 correspond to the original position of the triangle, as to draw lines that force each other to go back to its origin point are used, as to draw a line using the drawLine formula it is necessary to have a line sketched from two points each possessing an x and y value, with the following code being (x1, y1, x2, y2)
           // the casts are to convert the calculated values to make them all integers from their obtained values as doubles
           g.drawLine(300, 600, (int) (300 + sideA), 600); // represents the base of the triangle (note that the y-axis should not change in relation to the second point, only the second x-coordinate as seen in the line drawn)
           g.drawLine((int) (300 + sideA), 600, (int) (300 + sideB / 2), (int) (600 - sideC)); // represents the side to the right of the triangle, (note that the subtraction of the subsequent point values of sideC and such are utilized for the purpose of having an offset for the triangle's lines, as this allows for the lines to travel back to the original location of the point designated)
           g.drawLine((int) (300 + sideB / 2), (int) (600 - sideC), 300, 600); // represents the side of the triangle to the left of it, returning back to its original position
       }
   }
   /**
    *
    * main runs the program via calling TriangleApp class which is capable of creating the GUI programmed above
    * @param args
    */
   public static void main(String[] args) {
       new TriangleApp();
   }
}


