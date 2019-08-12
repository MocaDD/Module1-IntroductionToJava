


import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Contact> contacts;

    public PhoneBook()  {

        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(final Contact contact)    {
        contacts.add(contact);
    }

    public boolean removeContact(final Contact contact)    {

        Integer index = searchContact(contact);

        if (index == null) {
            System.out.println("This contact doesn't exist.");
            return false;
        } else {
            contacts.remove((int)index);
            return true;
        }
    }

    public boolean editContact (Contact newContact, Contact oldContact)   {

        Integer index = searchContact(oldContact);

        if (index == null)  {
            System.out.println("This contact doesn't exist.");
            return false;
        } else  {

            oldContact.setName(newContact.getName());
            oldContact.setPhoneNumber(newContact.getPhoneNumber());
            oldContact.setEmail(newContact.getEmail());
            contacts.set(index, oldContact);
            return true;
        }
    }

    public Integer searchContact(final Contact contact) {
        Integer index = null;

        index = searchContactByName(contact.getName());

        if (index == null)  {
            index = searchContactByNumber(contact.getPhoneNumber());
        }

        if (index == null) {
            return null;
        } else {
            return index;
        }
    }

    public Integer searchContactByName(final String name) {

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name))
                return i;
        }
        return null;
    }

    public Integer searchContactByNumber(final String phoneNumber) {

        for (int i = 0; i < contacts.size(); i++)  {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber))
                return i;
        }
        return null;
    }

    public List<Contact> exportContacts()   {

        List<Contact> clone = new ArrayList<Contact>(contacts.size());

        for (int i = 0; i < contacts.size(); i++)
            clone.add(i, contacts.get(i));

        return clone;
    }
}