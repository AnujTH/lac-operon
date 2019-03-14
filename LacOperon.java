import java.util.Scanner;

public class testt {
    public static void main(String[] args) {
        //IPOZY problem setup
        boolean lacZ; //Beta-galactosidase enzyme that will metabolize lactose molecule
        String lacZString;
        boolean lacY; //Permease transport channel on membrane
        String lacYString;
        boolean lacO; //Operator
        String lacOString;
        boolean lacP; //Promoter
        String lacPString;
        char lacI; //Repressor Protein
        String lacIString;
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the status of the repressor protein? (+, -, or s) ");
        String lacIPlaceholder = sc.next();
        lacI = lacIPlaceholder.charAt(0);
        if (lacI == '+') {
            lacIString = "I(+)";
        } else if (lacI == '-') {
            lacIString = "I(-)";
        } else if (lacI == 's') {
            lacIString = "I(s)";
        } else {
            lacIString = "I(error)";
        }
        System.out.print("Is the promoter gene wild-type? (true or false) ");
        lacP = sc.nextBoolean();
        if (lacP == true) {
            lacPString = "P(+)";
        } else {
            lacPString = "P(-)";
        }
        System.out.print("What is the status of the operator? (true for functioning, false for constitutive) ");
        lacO = sc.nextBoolean();
        if (lacO == true) {
            lacOString = "O(+)";
        } else {
            lacOString = "O(c)";
        }
        System.out.print("Is the lacZ gene wild-type? (true or false) ");
        lacZ = sc.nextBoolean();
        if (lacZ == true) {
            lacZString = "Z(+)";
        } else {
            lacZString = "Z(-)";
        }
        System.out.print("Is the lacY gene wild-type? (true or false) ");
        lacY = sc.nextBoolean();
        if (lacY == true) {
            lacYString = "Y(+)";
        } else {
            lacYString = "Y(-)";
        }
        System.out.println("\n             " + lacIString + " " + lacPString + " " + lacOString + " " + lacZString + " " + lacYString);
        //Regulation mechanics
        boolean bGalProducedLactose;
        boolean bGalProducedNoLactose;
        boolean permeaseProducedLactose;
        boolean permeaseProducedNoLactose;

        if (lacP == false) {
            bGalProducedLactose = false;
            bGalProducedNoLactose = false;
            permeaseProducedLactose = false;
            permeaseProducedNoLactose = false;
        } else if (lacO == false) {
            bGalProducedLactose = true;
            bGalProducedNoLactose = true;
            permeaseProducedLactose = true;
            permeaseProducedNoLactose = true;
        } else if (lacI == 's') {
            bGalProducedLactose = false;
            bGalProducedNoLactose = false;
            permeaseProducedLactose = false;
            permeaseProducedNoLactose = false;
        } else if (lacI == '+') {
            if (lacZ == true) {
                bGalProducedLactose = true;
                bGalProducedNoLactose = false;
                if (lacY == true) {
                    permeaseProducedLactose = true;
                    permeaseProducedNoLactose = false;
                } else {
                    permeaseProducedLactose = false;
                    permeaseProducedNoLactose = false;
                }
            } else {
                bGalProducedLactose = false;
                bGalProducedNoLactose = false;
                if (lacY == true) {
                    permeaseProducedLactose = true;
                    permeaseProducedNoLactose = false;
                } else {
                    permeaseProducedLactose = false;
                    permeaseProducedNoLactose = false;
                }
            }
        } else if (lacI == '-') {
            bGalProducedLactose = true;
            bGalProducedNoLactose = true;
            permeaseProducedLactose = true;
            permeaseProducedNoLactose = true;
        } else {
            bGalProducedLactose = true;
            bGalProducedNoLactose = true;
            permeaseProducedLactose = true;
            permeaseProducedNoLactose = true;
        }

        //convert boolean values to '+' and '-' values for output

        char bGalProducedLactoseChar;
        char bGalProducedNoLactoseChar;
        char permeaseProducedLactoseChar;
        char permeaseProducedNoLactoseChar;

        if (bGalProducedLactose == true) {
            bGalProducedLactoseChar = '+';
        } else {
            bGalProducedLactoseChar = '-';
        }

        if (bGalProducedNoLactose == true) {
            bGalProducedNoLactoseChar = '+';
        } else {
            bGalProducedNoLactoseChar = '-';
        }

        if (permeaseProducedLactose == true) {
            permeaseProducedLactoseChar = '+';
        } else {
            permeaseProducedLactoseChar = '-';
        }

        if (permeaseProducedNoLactose == true) {
            permeaseProducedNoLactoseChar = '+';
        } else {
            permeaseProducedNoLactoseChar = '-';
        }

        System.out.println("\n    β-galactosidase              Permease"); //10 spaces
        System.out.println("Lactose     No Lactose     Lactose     No Lactose");
        System.out.println("   " + bGalProducedLactoseChar + "             " + bGalProducedNoLactoseChar + "             " 
                           + permeaseProducedLactoseChar + "            " + permeaseProducedNoLactoseChar + "\n\n"); // 6 spaces
    }
}
