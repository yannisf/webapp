package fraglab.webapp.axis.client

/**
 * Created by yannis on 2/9/14.
 */
class Person {

    String firstName
    String lastName

    Person(String firstName, String lastName) {
        this.firstName = firstName
        this.lastName = lastName
    }

    String getFullName() {
        firstName + " " + lastName
    }

}
