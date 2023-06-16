package week4project;
import java.util.Arrays;
public class week4 {
	    public static void main(String[] args) {
	        // 1. Create an array of int called ages
	        int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};

	        // 2. Subtract the first element from the last element
	        int result = ages[ages.length - 1] - ages[0];
	        System.out.println("1. Result: " + result);

	        // 3. Add a new age to the array and repeat the previous step
	        int newAge = 45;
	        ages = Arrays.copyOf(ages, ages.length + 1);
	        ages[ages.length - 1] = newAge;
	        result = ages[ages.length - 1] - ages[0];
	        System.out.println("2. Result: " + result);

	        // 4. Calculate the average age using a loop
	        int sum = 0;
	        for (int age : ages) {
	            sum += age;
	        }
	        double averageAge = (double) sum / ages.length;
	        System.out.println("3. Average Age: " + averageAge);

	        // 5. Create an array of String called names
	        String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};

	        // 6. Calculate the average number of letters per name using a loop
	        int totalLetters = 0;
	        for (String name : names) {
	            totalLetters += name.length();
	        }
	        double averageLetters = (double) totalLetters / names.length;
	        System.out.println("4. Average Letters per Name: " + averageLetters);

	        // 7. Concatenate all the names using a loop
	        String allNames = "";
	        for (String name : names) {
	            allNames += name + " ";
	        }
	        System.out.println("5. All Names: " + allNames.trim());

	        // 8. Access the last element of any array
	        int lastElement = ages[ages.length - 1];
	        System.out.println("6. Last Element of ages: " + lastElement);

	        // 9. Access the first element of any array
	        int firstElement = ages[0];
	        System.out.println("7. First Element of ages: " + firstElement);

	        // 10. Create a new array of int called nameLengths
	        int[] nameLengths = new int[names.length];
	        for (int i = 0; i < names.length; i++) {
	            nameLengths[i] = names[i].length();
	        }

	        // 11. Calculate the sum of all elements in the nameLengths array
	        int sumNameLengths = 0;
	        for (int length : nameLengths) {
	            sumNameLengths += length;
	        }
	        System.out.println("8. Sum of Name Lengths: " + sumNameLengths);

	        // 12. Method that concatenates a word to itself n number of times
	        System.out.println("9. Concatenated Word: " + concatenateWord("Hello", 3));

	        // 13. Method that returns a full name from first and last name
	        System.out.println("10. Full Name: " + getFullName("John", "Doe"));

	        // 14. Method that checks if the sum of array elements is greater than 100
	        int[] array1 = {40, 30, 20, 15};
	        int[] array2 = {10, 20, 30, 40};
	        System.out.println("11. Array 1 Sum > 100? " + isSumGreaterThan100(array1));
	        System.out.println("   Array 2 Sum > 100? " + isSumGreaterThan100(array2));

	        // 15. Method that calculates the average of elements in a double array
	        double[] values = {10.5, 20.5, 30.5, 40.5};
	        System.out.println("12. Array Average: " + calculateAverage(values));

	        // 16. Method that compares the averages of two double arrays
	        double[] array3 = {10.5, 20.5, 30.5};
	        double[] array4 = {5.5, 15.5, 25.5};
	        System.out.println("13. Array 3 Average > Array 4 Average? " + isAverageGreater(array3, array4));

	        // 17. Method that determines whether to buy a drink based on conditions
	        System.out.println("14. Will Buy Drink? " + willBuyDrink(true, 12.5));
	    }

	    // Custom Method: Concatenates a word to itself n number of times
	    public static String concatenateWord(String word, int n) {
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < n; i++) {
	            result.append(word);
	        }
	        return result.toString();
	    }

	    // Custom Method: Returns a full name from first and last name
	    public static String getFullName(String firstName, String lastName) {
	        return firstName + " " + lastName;
	    }

	    // Custom Method: Checks if the sum of elements in an int array is greater than 100
	    public static boolean isSumGreaterThan100(int[] array) {
	        int sum = 0;
	        for (int num : array) {
	            sum += num;
	        }
	        return sum > 100;
	    }

	    // Custom Method: Calculates the average of elements in a double array
	    public static double calculateAverage(double[] array) {
	        double sum = 0;
	        for (double num : array) {
	            sum += num;
	        }
	        return sum / array.length;
	    }

	    // Custom Method: Compares the averages of two double arrays
	    public static boolean isAverageGreater(double[] array1, double[] array2) {
	        double avg1 = calculateAverage(array1);
	        double avg2 = calculateAverage(array2);
	        return avg1 > avg2;
	    }

	    // Custom Method: Determines whether to buy a drink based on conditions
	    public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
	        return isHotOutside && moneyInPocket > 10.50;
	    }
	}