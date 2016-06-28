package sample;


/**
 * Created by Robin on 01.06.2016.
 */
public class Customer {
    public static Customer CUSTOMER = new Customer(null, null, null, 0, 0, null);

    private String name;
    private String surname;
    private String street;
    private int housenumber;
    private int areacode;
    private String city;


    public Customer(String name, String surname, String street, int housenumber, int areacode, String city) {
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.housenumber = housenumber;
        this.areacode = areacode;
        this.city = city;

    }

    public void setCustomer(String name, String surname, String street, int housenumber, int areacode, String city) {
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.housenumber = housenumber;
        this.areacode = areacode;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStreet() {
        return street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public int getAreacode(){return areacode;}

    public String getCity() {
        return city;
    }
}
