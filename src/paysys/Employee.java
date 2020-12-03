package paysys;

/**
 * @author Rory Young
 */
public class Employee extends Person {
    private final Name name;
    private Address address;
    private int employeeID;
    private Position position;
    public float hours = 0;

    /**
     * @param trn
     * @param nis
     * @param yob
     * @param gender
     * @param empID
     * @param fName
     * @param mName
     * @param lName
     * @param country
     * @param parish
     * @param town
     * @param street
     * @param pos
     * @param hrs
     */
    public Employee(int trn, int nis, int yob, char gender, int empID, String fName, String mName, String lName, String country, String parish, String town, String street,int pos, float hrs) {
        super(trn, nis, yob, gender);
        name = new Name(fName, mName, lName);
        address = new Address(country, parish, town, street);
        employeeID = empID;
        setPosition(pos);
        hours = hrs;
    }

    /**
     * @param trn
     * @param nis
     * @param yob
     * @param gender
     * @param fName
     * @param mName
     * @param lName
     * @param pos
     */
    public Employee(int trn, int nis, int yob, char gender, String fName, String mName, String lName, int pos) {
        super(trn, nis, yob, gender);
        name = new Name(fName, mName, lName);
        setPosition(pos);
    }

    public void setAddress (Address addr) {
        this.address = addr;
    }

    /**
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @return name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param val
     */
    public void setHours(float val) {
        hours+=val;
    }

    /**
     *
     * @return hours
     */
    public float getHours() {
        return hours;
    }

    public void resetHours () {
        hours = 0;
    }

    /**
     * @param val
     */
    public void takeHours(float val) {
        hours-=val;
    }

    /**
     *
     * @param val
     */
    public void setEmployeeID (int val){
        this.employeeID = val;
    }

    /**
     * @return employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    public void setPosition(int val) {
        if(val==1){
            position = Position.JUNIORSTAFF;
        }
        else if (val==0) {
            position = Position.SENIORSTAFF;
        }
    }

    public Position getPosition() {
        return position;
    }

    public String toString(){
        return name.toString() + "\n" + getEmployeeID() + "\n" + getPosition() + "\n" + getHours();
    }

    public static void main(String[] args){
        Employee testEmp = new Employee(123456789,1986,2000,'M',7,"Jack","John","Smith","Jamaica","Trelawny","A-Town","Kings Street",1, (float) 12.25);
        System.out.println(testEmp.getName().toString());
        System.out.println(testEmp.getAddress().toString());
        System.out.println(testEmp.getPosition());
        System.out.println(testEmp.getGender());
        System.out.println(testEmp.getYOB());
        System.out.println(testEmp.getTRN());
        System.out.println(testEmp.getNIS());
        System.out.println(testEmp.getEmployeeID());
        System.out.println(testEmp.getHours()*250);
    }
}