package lab;

/**
 * Class describes the entity Department
 */
class Department {

    /**
     * Department ID
     */
    private final int id;

    /**
     * Department name
     */
    private final String title;

    /**
     * Class Constructor
     * @param title Department name
     * @param id_dep Department ID
     */
    public Department(String title, int id_dep)
    {
        this.title = title;
        this.id = id_dep;
    }

    /**
     * Method to obtain the ID of department
     * @return Department ID
     */
    public int getId() { return id; }

    /**
     * Method to obtain the name of department
     * @return Department name
     */
    public String getTitle() { return title; }
}

/**
 * Class contains information about a person
 */
public class Person {

    /**
     * Person ID
     */
    private final String id;

    /**
     * Person name
     */
    private final String name;

    /**
     * Person sex
     */
    private final String sex;

    /**
     * Person salary
     */
    private final String salary;

    /**
     * Person birthday
     */
    private final String birthDate;

    /**
     * Person department
     */
    private final Department dep;

    /**
     * Default Class Constructor
     */
    public Person() {
        id = "";
        name = "";
        sex = "";
        salary = "";
        birthDate = "";
        dep = new Department("", 0);
    }

    /**
     * Class Constructor
     * @param id Person ID
     * @param name Person name
     * @param sex Person sex
     * @param salary Person salary
     * @param birthDate Person birthday
     * @param title_dep Person department name
     * @param id_dep Person department id
     */
    Person(String id, String name, String sex, String salary, String birthDate, String title_dep, int id_dep)
    {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.birthDate = birthDate;
        dep = new Department(title_dep, id_dep);
    }

    public String getName(){
        return name;
    }

    public String getSex(){
        return sex;
    }

    public String getPerson() {
        String person = "";
        return person = person + id + " " + name + " " + sex + " " + salary + " " + birthDate + " " + dep.getTitle() + " " + String.valueOf(dep.getId());
    }
}
