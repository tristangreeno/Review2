
/**
 * Created by tristangreeno on 4/11/16.
 */
public class Person implements Comparable<Person> {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    Integer id;
    String firstName;
    String lastName;
    String eMail;
    String country;
    String ipAddress;

    public Person(Integer id, String firstName, String lastName, String eMail, String country, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.eMail = eMail;
        this.ipAddress = ipAddress;
    }

    public Person() {}

    @Override
    public int compareTo(Person o) {
        if(!this.lastName.equals(o.lastName)){ return this.lastName.compareTo( o.lastName ); }
        else { return this.firstName.compareTo( o.firstName ); }
    }

    @Override
    public String toString(){
        return (firstName + " " + lastName + " from " + country);
    }
}
