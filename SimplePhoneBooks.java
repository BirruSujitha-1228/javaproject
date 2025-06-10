import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class SimplePhoneBooks {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Menu
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.println("5. Sort and Display Contacts");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    if (phoneBook.containsKey(name)) {
                        System.out.println("This contact already exists. Overwriting...");
                    }

                    System.out.print("Enter phone number: ");
                    String number = scanner.nextLine();
                    phoneBook.put(name, number);
                    System.out.println("Contact added.");
                    break;

                case 2:
                    // Display contacts
                    if (phoneBook.isEmpty()) {
                        System.out.println("Phone book is empty.");
                    } else {
                        System.out.println("Contacts:");
                        for (String contactName : phoneBook.keySet()) {
                            System.out.println(contactName + ": " + phoneBook.get(contactName));
                        }
                    }
                    break;

                case 3:
                    // Delete contact
                    System.out.print("Enter name of contact to delete: ");
                    String deleteName = scanner.nextLine();

                    if (phoneBook.containsKey(deleteName)) {
                        phoneBook.remove(deleteName);
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the phone book.");
                    break;

                case 5:
                    // Sort and display contacts
                    if (phoneBook.isEmpty()) {
                        System.out.println("Phone book is empty. Nothing to sort.");
                    } else {
                        String[] contactNames = phoneBook.keySet().toArray(new String[0]);
                        Arrays.sort(contactNames); // Alphabetical sort

                        System.out.println("Sorted Contacts:");
                        for (String contact : contactNames) {
                            System.out.println(contact + ": " + phoneBook.get(contact));
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
