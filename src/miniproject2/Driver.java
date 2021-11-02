package miniproject2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Driver {

    public static ContactList store = new ContactList();

    public static void main(String[] args) {

        seedFakeData();
        String optionInput = "";

        while (true) {
            System.out.println(
                "+≡≡≡   Contact App  ≡≡≡+" + '\n' +
                "| 1. List all Contacts |" + '\n' +
                "| 2. Add new Contact   |" + '\n' +
                "| 3. Remove Contact    |" + '\n' +
                "| 4. Update Contact    |" + '\n' +
                "| 5. Quit              |" + '\n' +
                "+======================+" + '\n'
            );

            optionInput = InputCollector.getUserInput("Enter your option");

            System.out.println("Option: " + optionInput);

            try {

                if (optionInput.equals("1")) {
                    store.printContactList();
                } else if (optionInput.equals("2")) {
                    Contact item = addValuesTo(new Contact());
                    store.addContact(item);

                } else if (optionInput.equals("3")) {
                    String inputUser = InputCollector.getUserInput(
                "Enter the index of the contact to remove: "
                    );
                    int index = Integer.parseInt(inputUser);
                    store.removeContact(index);

                } else if (optionInput.equals("4")) {
                    String inputUser = InputCollector.getUserInput(
                "Enter the index of the contact to update: "
                    );
                    int index = Integer.parseInt(inputUser);
                    Contact contact = store.getContact(index);
                    addValuesTo(contact);

                } else if (optionInput.equals("5")) {
                    break;
                } else {
                    System.out.println("Invalid Input. Enter number between 1 and 5");
                }

            }
            catch (IllegalArgumentException e) {
                System.out.printf("\u001B[33m" + e + "\u001B[0m");
            }
        }

        System.out.println("Bye!");
    }

    public static Contact addValuesTo(Contact item) {
        String inputUser;
        boolean repeat;
        String[] attributes = {"Name", "Mobile", "Work", "Home", "City"};
        String[] required   = {"Name", "Mobile"};

        for (String attribute : attributes) {

            do {
                inputUser = InputCollector.getUserInput("Enter " + attribute);
                if (isEmptyString(inputUser) && Arrays.asList(required).contains(attribute)) {
                    repeat = true;
                    System.out.printf("\u001B[33m" + "You must enter this field" + "\u001B[0m" + '\n');
                } else {
                    repeat = false;
                }
            } while (repeat);

            String methodName = "set" + attribute; // setName ...

            try {
                Method method = Contact.class.getDeclaredMethod(methodName, String.class);
                method.setAccessible(true);
                method.invoke(item, inputUser);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        return item;
    }

    public static boolean isEmptyString(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static void seedFakeData() {
        Contact fake1 = new Contact("Mauricio", "123-456-789", "123-123", "Vancouver");
        Contact fake2 = new Contact("Alberto", "666-555-789", "555-123", "LA");
        store.addContact(fake1);
        store.addContact(fake2);
    }

}
