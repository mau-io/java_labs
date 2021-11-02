package miniproject2;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private static List<Contact> contacts;

    ContactList() {
        this.contacts = new ArrayList<>();
    }

    public boolean isValidItem(Contact item) {
        for (Contact c: contacts) {
            if(
                c.getName().equalsIgnoreCase(item.getName())  &&
                c.getMobile().equalsIgnoreCase(item.getMobile())
            ) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSize(int index) {
        return index >= 0 && index < contacts.size();
    }

    public void addContact(Contact newContact) {
        if (isValidItem(newContact)) {
            contacts.add(newContact);
            System.out.println("Successfully added a new contact!");
        } else {
            throw new IllegalArgumentException("Invalid addContact. The contact already exists!. \n");
        }
    }

    public Contact getContact(int index) {
        if(isValidSize(index)){
            return contacts.get(index);
        }
        else {
            throw new IllegalArgumentException("Invalid getContact. The value must be " + 0 + " to "+ (contacts.size() - 1) + " characters. \n");
        }
    }

    public void removeContact(int index) {
        if(isValidSize(index)){
            String name = contacts.get(index).getName();
            contacts.remove(index);
            System.out.println("Successfully removed " + name);
        }
        else {
            throw new IllegalArgumentException("Invalid removeContact. The value must be " + 0 + " to "+ (contacts.size() - 1) + " characters. \n");
        }
    }

    public void printContactList() {

        for (Contact c: contacts) {
            // #: <full name> (mobile, etc)
            System.out.printf("\u001B[36m %d. <%s> (%s %s %s %s) \u001B[0m \n",
                    contacts.indexOf(c),
                    c.getName(),
                    printIfExists(c.getMobile()),
                    printIfExists(c.getWork()),
                    printIfExists(c.getHome()),
                    printIfExists(c.getCity())
            );
        }
    }

    public String printIfExists(String value) {
        return value == null || value.trim().isEmpty()
            ? ""
            :  value + ",";
    }
}
