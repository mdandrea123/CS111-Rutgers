/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author: Michael Dandrea, mjd463, mjd463@scarletmail.rutgers.edu
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        listOfPatients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;
        
        // WRITE YOUR CODE HERE
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {

        // WRITE YOUR CODE HERE
        if (arrayIndex >= listOfPatients.length -1) {
            return -1;
        }
        for(int i = (listOfPatients.length -1); i > arrayIndex; i--){
            listOfPatients[i] = listOfPatients[i - 1];
        }
        listOfPatients[arrayIndex] = p;
        return 0;
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {

        // WRITE YOUR CODE HERE
        int i;
        listOfPatients = new Person[numberOfLines];
        for (i = 0; i < numberOfLines && StdIn.hasNextLine(); i++){
            int ID;
            int Ethinicity;
            int Gender;
            int Age;
            int Cause;
            int Urgency;
            int State;
            ID = StdIn.readInt();
            Ethinicity = StdIn.readInt();
            Gender = StdIn.readInt();
            Age = StdIn.readInt();
            Cause = StdIn.readInt();
            Urgency = StdIn.readInt();
            State = StdIn.readInt();
            listOfPatients[i] = new Person(ID, Ethinicity, Gender, Age, Cause, Urgency, State);
        }
        return(i);
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {

        // WRITE YOUR CODE HERE
        survivabilityByAge = new SurvivabilityByAge[numberOfLines];
        int i;
        for (i = 0; i < numberOfLines && StdIn.hasNextLine(); i++){
            int a;
            int b;
            double c;
            a = StdIn.readInt();
            b = StdIn.readInt();
            c = StdIn.readDouble();
            survivabilityByAge[i] = new SurvivabilityByAge(a, b, c);
        }
        return(i);
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {

        // WRITE YOUR CODE HERE
        survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        int i;
        for (i = 0; i < numberOfLines && StdIn.hasNextLine(); i++){
            int a;
            int b;
            double c;
            a = StdIn.readInt();
            b = StdIn.readInt();
            c = StdIn.readDouble();
            survivabilityByCause[i] = new SurvivabilityByCause(a, b, c);
        }
        return(i);
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {

        // WRITE YOUR CODE HERE
        int count = 0;
        for (int i = 0; i < listOfPatients.length; i++){
            if (listOfPatients[i].getAge() > age){
                count++;
            }
        }
        if (count == 0){
            return null;
        }

        Person[] aboveAge = new Person[count];
        for (int i = 0, x = 0; i < listOfPatients.length; i++){
            if (listOfPatients[i].getAge() > age){
                aboveAge[x]=listOfPatients[i];
                x++;
            }
        }
        return aboveAge;
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {

        // WRITE YOUR CODE HERE
        // WRITE YOUR CODE HERE
        int count = 0;
        for (int i = 0; i < listOfPatients.length; i++){
            if (listOfPatients[i].getStateOfHealth() == state){
                count++;
            }

        }

        if (count == 0){
            return null;
        }

        Person[] byState = new Person[count];
        for (int i = 0, x = 0; i < listOfPatients.length; i++){
            if (listOfPatients[i].getStateOfHealth() == state){
                byState[x] = listOfPatients[i];
                x++;
            }
        }
        return byState;
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {

        // WRITE YOUR CODE HERE
        int count = 0;
        for (int i = 0; i < listOfPatients.length; i++){
            if (listOfPatients[i].getCause() == cause){
                count++;
            }
        }
        if (count == 0){
            return null;
        }

        Person[] byCause = new Person[count];
        for (int i = 0, x = 0; i < listOfPatients.length; i++){
            if (listOfPatients[i].getCause() == cause){
                byCause[x] = listOfPatients[i];
                x++;
            }
        }
        return byCause;
    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {

        // WRITE YOUR CODE HERE
        if (numberOfHearts < listOfPatients.length){
            Person[] people = new Person[numberOfHearts];
            for (int i = 0; i < numberOfHearts; i++){
                people[i] = listOfPatients[i];
            }
            return people;
        }else{
            return listOfPatients;
        }
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }

    }
}
