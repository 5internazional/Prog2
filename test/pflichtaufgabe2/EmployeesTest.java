package pflichtaufgabe2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {
    Workers worker1, worker2, worker3;
    Interns intern;

    @BeforeEach
    void setUp() {
        worker1 = new Workers("Frank", "Walser", 1600.00, 2, false);
        worker2 = new Workers("Eva", "Flink", 1750.00, 10, false);
        worker3 = new Workers("Hans", "Boss", 4000.00, 21, true);
        intern = new Interns("Sven", "Vögel",450.00,21, "Lagerlogistik");}
    //Employees class tests
    @Test
    public void setNameTest(){ //normallfall
        String name = "Alan";
        try {
            worker1.setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(name, worker1.getName());
    }

    @Test
    public void setNameNullTest(){ //exceptionfall - leere name
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> {
            worker2.setName(name);
        });
    }

    @Test
    public void setSurnameTest(){ //normallfall
        String surname = "Windsor";
        try {
            worker2.setSurname(surname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(surname, worker2.getSurname());
    }

    @Test
    public void setSurnameNullTest(){ //exceptionfall - leere name
        String surname = "";
        assertThrows(IllegalArgumentException.class, () -> {
            worker3.setSurname(surname);
        });
    }

    @Test
    public void setWageNullTest(){ //exceptionfall - wage is null
        double wage = 0.0;
        assertThrows(IllegalArgumentException.class, () -> {
            worker1.setWage(wage);
        });
    }

    @Test
    public void setWageNegativeTest(){ //exceptionfall - negative zahl
        double wage = -1200.0;
        assertThrows(IllegalArgumentException.class, () -> {
            worker2.setWage(wage);
        });
    }

    @Test
    public void raiseWageTest(){ //normallfall
        try {
            worker1.raiseWage(300.00);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1900.00, worker1.getWage());
    }

    @Test
    public void raiseWageNegativeTest(){ // exceptionfall - negative zahl
        double summe = -300.00;
        assertThrows(IllegalArgumentException.class, () -> {
            worker3.raiseWage(summe);
        });
    }

    //Worker Class tests
    //set experience tests
    @Test
    public void setExperienceTest(){ //normalfall
        int experience = 4;
        try {
            worker1.setExperience(experience);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(experience, worker1.getExperience());
    }

    @Test
    public void setExperienceNegativeTest(){ //exceptionfall - negative zahl
        int experience = -2;
        assertThrows(IllegalArgumentException.class, () -> {
            worker2.setExperience(experience);
        });
    }

    // premium tests
    @Test
    public void countRewardNoneLeadingTest(){//normalfall ohne fuehrungposition
        assertEquals(500.00, worker2.countReward());
    }

    @Test
    public void countRewardLeadingTest(){ //normalfall mit fuehrungposition

        assertEquals(1250.00, worker3.countReward());
    }

    //Intern Class tests

    @Test
    public void setAgeTest(){ //normallfall
        int age = 23;
        try {
            intern.setAge(age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(age, intern.getAge());
    }

    @Test
    public void setAgeNullTest(){ //eexceptionfall - age is null
        int age = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            intern.setAge(age);
        });
    }

    @Test
    public void setAgeNegativeTest(){ //exceptionfall - age is negative
        int age = -17;
        assertThrows(IllegalArgumentException.class, () -> {
            intern.setAge(age);
        });
    }
    //field of study tests
    @Test
    public void setFieldOfStudyTest(){ //normallfall
        String fieldOfStudy = "Fahrradmonteur";
        try {
            intern.setFieldOfStudy(fieldOfStudy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(fieldOfStudy, intern.getFieldOfStudy());
    }

    @Test
    public void setFieldOfStudyEmptyTest(){ //exceptionfall - leere eingabe
        String fieldOfStudy = "";
        assertThrows(IllegalArgumentException.class, () -> {
            intern.setFieldOfStudy(fieldOfStudy);
        });
    }

    //normallfall fur premium
    @Test
    public void countRewardTest(){
        assertEquals(210.00,intern.countReward());
    }


}