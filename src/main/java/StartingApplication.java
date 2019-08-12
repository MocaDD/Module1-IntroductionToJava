import java.util.List;
import java.util.Scanner;

public class StartingApplication {

        private static final Contact andrei = new Contact("Dragos", "0757601734", "Andrei@gmail.com");
        private static final Contact cristi = new Contact("Cristi", "0000000000", "Cristi@gmail.com");
        private static final Contact ana = new Contact("Ana", "1111111111", "Ana@gmail.com");
        private PhoneBook myFirstPhoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);


        public void display_menu() {
            System.out.println ( "1) Add a contact\n2) Remove a contact\n3) Edit a contact\n4) Export list of contacts\n" +
                    "5) Search a contact by name\n6) Search a contact by number\n7) Exit\n");
            System.out.print ( "Selection: " );
        }

        public StartingApplication() {
            Scanner in = new Scanner(System.in);
            boolean mainLoop = true;
            int choice;
            Integer searchResult;
            Scanner scanner = new Scanner(System.in);

            myFirstPhoneBook.addContact(andrei);
            myFirstPhoneBook.addContact(cristi);
            myFirstPhoneBook.addContact(ana);

            while (true) {
                display_menu();
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You picked option 1");
                        addContact();
                        break;
                    case 2:
                        System.out.println("You picked option 2");
                        removeContact();
                        break;
                    case 3:
                        System.out.println("You picked option 3");
                        editContact();
                        break;
                    case 4:
                        System.out.println("You picked option 4");
                        exportList();
                        break;
                    case 5:
                        System.out.println("You picked option 5");
                        searchContactByName();
                        break;
                    case 6:
                        System.out.println("You picked option 6");
                        searchContactByNumber();
                        break;
                    case 7:
                        System.out.println("Exiting Program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Unrecognized option ! Please select another.");
                        break;
                }
            }
        }

        private void addContact()   {
            System.out.println("Please introduce the following details about the contact:");
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("Phone number:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Email:");
            String email = scanner.nextLine();
            myFirstPhoneBook.addContact(new Contact(name, phoneNumber, email));
            System.out.println("New contact has been created.");
            System.out.println("\n");
        }

        private void removeContact()    {
            System.out.println("Please introduce the name of the contact:");
            String detailAboutTheContact = scanner.nextLine();
            if (myFirstPhoneBook.removeContact(new Contact(detailAboutTheContact, "1", "a")))
                System.out.println("The contact has been removed.");
            System.out.println("\n");
        }

        private void editContact()  {
            System.out.println("Please introduce the name of the contact you want to edit:");
            String oldName = scanner.nextLine();
            System.out.println("Please introduce the following details about the new contact:");
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("Phone number:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Email:");
            String email = scanner.nextLine();
            if (myFirstPhoneBook.editContact(new Contact(name, phoneNumber, email), new Contact(oldName, "1", "a")))
                System.out.println("The contact has been edited.");
            System.out.println("\n");
        }

        private void exportList()   {
            List<Contact> exportedList = myFirstPhoneBook.exportContacts();
            System.out.println("Your contacts are:");
            for (int i = 0; i < exportedList.size(); i++)
                System.out.println(i + 1 + ": " + exportedList.get(i).getName());
            System.out.println("\n");
        }

        private void searchContactByName()  {
            System.out.println("Please introduce the name of the contact you want to search:");
            String name = scanner.nextLine();
            Integer searchResult = myFirstPhoneBook.searchContactByName(name);
            if (searchResult == null)
                System.out.println("A contact with this name does not exist.");
            else
                System.out.println("The number of this contact is: " +
                        myFirstPhoneBook.exportContacts().get(searchResult).getPhoneNumber());
            System.out.println("\n");
        }


        private void searchContactByNumber()    {
            System.out.println("Please introduce the number of the contact you want to search:");
            String phoneNumber = scanner.nextLine();
            Integer searchResult = myFirstPhoneBook.searchContactByNumber(phoneNumber);
            if (searchResult == null)
                System.out.println("A contact with this number does not exist.");
            else
                System.out.println("The contact with this number is: " +
                        myFirstPhoneBook.exportContacts().get(searchResult).getName());
            System.out.println("\n");
        }
}