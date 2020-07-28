package annotation.database;

/**
 * @author zx
 */
@DBTable(name = "Member")
public class Member {
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;
    @SQLInteger(20)
    Integer age;
    @SQLString(value = 30,constrains = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    @Override
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", handle='" + handle + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }
}
