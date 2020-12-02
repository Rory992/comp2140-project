package paysys;

/**
 * @author Rory Young
 */
public class Address {
    private String country;
    private String parish;
    private String town;
    private String street;

    /**
     * @param country
     * @param parish
     * @param town
     * @param street
     */
    public Address(String country, String parish, String town, String street){
        this.country = country;
        this.parish = parish;
        this.town = town;
        this.street = street;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @param parish
     */
    public void setParish(String parish){
        this.parish = parish;
    }

    /**
     * @param town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return gives a string which is the country of a given address address.
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @return gives a string which is the parish of a given address address.
     */
    public String getParish() {
        return parish;
    }

    /**
     *
     * @return gives a string which is the town of a given address address.
     */
    public String getTown() {
        return town;
    }

    /**
     *
     * @return gives a string which is the street of a given address address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return
     */
    public String toString() {
        return street + ", " + town + "\n" + parish + ", " + country;
    }
}
