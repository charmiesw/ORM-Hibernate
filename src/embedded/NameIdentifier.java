package embedded;

import javax.persistence.Embeddable;

@Embeddable
public class NameIdentifier {
    private String firstName;
    private String lastName;

    public NameIdentifier(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public NameIdentifier() {
    }

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

    @Override
    public String toString() {
        return "NameIdentifier{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
