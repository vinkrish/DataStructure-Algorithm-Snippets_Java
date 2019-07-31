package java8;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class PersonL {
	public enum Sex {
        MALE, FEMALE
    }
  
    String name; 
    LocalDate birthday;
    Sex gender;
    String emailAddress;
  
    PersonL(String nameArg, LocalDate birthdayArg,
        Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }  

    public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }

    public void printPerson() {
      System.out.println(name + ", " + this.getAge());
    }
    
    public Sex getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public static int compareByAge(PersonL a, PersonL b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<PersonL> createRoster() {
        
        List<PersonL> roster = new ArrayList<>();
        roster.add(
            new PersonL(
            "Fred",
            IsoChronology.INSTANCE.date(1980, 6, 20),
            PersonL.Sex.MALE,
            "fred@example.com"));
        roster.add(
            new PersonL(
            "Jane",
            IsoChronology.INSTANCE.date(1990, 7, 15),
            PersonL.Sex.FEMALE, "jane@example.com"));
        roster.add(
            new PersonL(
            "George",
            IsoChronology.INSTANCE.date(1991, 8, 13),
            PersonL.Sex.MALE, "george@example.com"));
        roster.add(
            new PersonL(
            "Bob",
            IsoChronology.INSTANCE.date(2000, 9, 12),
            PersonL.Sex.MALE, "bob@example.com"));
        
        return roster;
    }
    
}
