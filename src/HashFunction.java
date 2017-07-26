import java.util.Arrays;


public class HashFunction {

    String[] theArrary;
    int arraySize;
    int intemsInArrary = 0;


    public static void main(String[] args) {

        HashFunction theFunc = new HashFunction(30);

        String[] elementsToAdd = { "1", "5", "17","21", "27" };
        theFunc.hashFunction1(elementsToAdd, theFunc.theArrary);
        theFunc.displayTheStack();

        String[] elementsToAdd2 = {"100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321","660"};
        theFunc.hashFunction2(elementsToAdd2, theFunc.theArrary);
        theFunc.displayTheStack();

        //Locate the index of value "660" in hash table

        theFunc.findkey("660");
        theFunc.displayTheStack();
    }
    // Hash function that puts values in the same index that maths their values.

    public void hashFunction1(String[] stringForArray, String[] theArrary){
        for (int n =0; n < stringForArray.length; n++){
            String newElementVal = stringForArray[n];
            theArrary[Integer.parseInt(newElementVal)] = newElementVal;

        }
    }

    public void hashFunction2(String[] stringForArray, String[] theArrary){

        for (int m = 0; m< stringForArray.length; m++){
            String newElementVal = stringForArray[m];

            int arrayIndex = Integer.parseInt(newElementVal) % 29;
            System.out.println("Module Index "+ arrayIndex +"Valule "+ newElementVal );

            while(theArrary[arrayIndex] != "-1"){
                arrayIndex ++;
                System.out.println("Collision try " + arrayIndex + "instead");
                arrayIndex %= arraySize;
            }
            theArrary[arrayIndex] = newElementVal;
        }

    }


    public String findkey(String key){
        // Find the keys original hash key
        int arrayIndexHash = Integer.parseInt(key) % 29;
        while(theArrary[arrayIndexHash] != "-1"){

            if (theArrary[arrayIndexHash] == key){
                System.out.println( arrayIndexHash +" was found in index " + theArrary[arrayIndexHash] );
                return theArrary[arrayIndexHash];
            } else
            // Look in the next index
            {
                arrayIndexHash++;
                // If we get to the end of the array go back to index 0
                arrayIndexHash %= arraySize;
            }

        }

// Couldn't locate the key
        return null;
    }



   public HashFunction(int size){
        arraySize = size;
        theArrary = new String[arraySize];
        Arrays.fill(theArrary, "-1");

    }

    public void displayTheStack() {

        int increment = 0;
        for (int m = 0; m < 3; m++) {

            increment += 10;

            for (int n = 0; n < 71; n++)

                System.out.print("-");
            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                System.out.format("| %3s " + " ", n);

            }
            System.out.println("|");
            for (int n = 0; n < 71; n++)

                System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {

                if (theArrary[n].equals("-1"))

                    System.out.print("|      ");

                else{

                    System.out.print(String.format("| %3s " + " ", theArrary[n]));
                }

            }
            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();

        }

    }


}
