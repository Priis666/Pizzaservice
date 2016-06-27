package Robin;


/**
 * Created by Robin on 01.06.2016.
 */
public class Customer {

    private String name;
    private String surname;
    private String city;
    private String street;
    private int housenumber;
    private int zipcode;

    public Customer(String name, String surname, String city, String street, int housenumber, int zipcode) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
    }

    public String getName(){
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public int getZipcode(){ return zipcode;}
}
