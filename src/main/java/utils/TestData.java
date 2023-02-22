package utils;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestData {

    private Faker faker;
    private String firstname;
    private String lastname;
    private Address address;

    public TestData(){
        faker = new Faker(new Locale("en-US"));
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        address = faker.address();
    }

    public String getStreet() {
        return address.streetAddress();
    }

    public String getFullName() { return firstname+" "+lastname; }

    public String getId() {
        int randomInt = new Random().nextInt(999);
        return "SBI"+randomInt;
    }

    public String getEmailId() { return firstname.toLowerCase(Locale.ROOT)+ "."+ lastname.toLowerCase(Locale.ROOT)+ "@gmail.com"; }

    public String getPhoneNumber(){ return faker.phoneNumber().cellPhone();}

    public String getAccountType(){
        String accountType[] = {"savings", "loan", "salary"};
        int index = new Random().nextInt(accountType.length);
        return accountType[index];
    }

    public String getCountry(){
        return address.country();
    }

    public String getCurrency(){
        return faker.currency().name();
    }
    public String getGender(){
        String gender[] = {"male", "female"};
        int index = new Random().nextInt(gender.length);
        return gender[index];
    }

    public String getBirthDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        return sdf.format(faker.date().birthday(10,70));
    }

    public String getTimeStamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM:dd:yy:hh:mm:ss");
        Date date = new Date();
        return sdf.format(date.getTime());
    }
}
