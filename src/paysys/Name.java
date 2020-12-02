package paysys;

/**
 * @author Rory Young
 */
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    /**
     * @param fName
     * @param mName
     * @param lName
     */
    public Name(String fName, String mName, String lName) {
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
    }

    /**
     * @param fName
     */
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    /**
     * @param mName
     */
    public void setMiddleName(String mName) {
        this.middleName = mName;
    }

    /**
     * @param lName
     */
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @return
     */
    public String getMiddleName() {
        return this.middleName;
    }

    /**
     * @return
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @return
     */
    public String toString() {
        return this.firstName + " " + this.middleName + " " + this.lastName;
    }
}
