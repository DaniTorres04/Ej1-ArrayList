import java.util.ArrayList;

public class TelefonoMovil {
    String myNumber;
    private static ArrayList<Contacto> myContacts = new ArrayList<>();
    private static boolean act;
    private static int i;
    private static int pos;
    private static int pos2 = 0;
    private static boolean exists;
    private static int ind;
    private static boolean rem;
    Contacto contacto;

    public TelefonoMovil(String myNumber, ArrayList myContacts){
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    private static int findContact(Contacto contacto){
        if (myContacts.contains(contacto)){
            pos = 0;
        }else {
            pos = -1;
        }
        return pos;
    }

    private static int findContact(String nombre){
        for (i = 0; i < myContacts.size(); i++){
            if (myContacts.get(i).getName().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean addNewContact(Contacto contacto){
        findContact(contacto);
        exists = false;
        if (pos == -1){
            myContacts.add(contacto);
            exists = true;
        }
        return exists;
    }

    public static boolean updateContact(Contacto viejo, Contacto nuevo) {
        findContact(viejo);
        act = false;
        if (pos == 0){
            myContacts.set(i, nuevo);
            act = true;
    }
        return act;
    }

    public static boolean removeContact(Contacto remove){
        findContact(remove);
        rem = false;
        if (pos == 0){
            myContacts.remove(remove);
            rem = true;
        }
        return rem;
    }

    public static Contacto queryContact(String nom){
        int c = findContact(nom);
        if (c >= 0){
            return myContacts.get(c);
        }else {
            return null;
        }
    }
    public static void printContact(){
        System.out.println("Lista de contactos:" + "\n");
        for (int i = 0; i < myContacts.size(); i++){
            System.out.println((i + 1) + " " + myContacts.get(i).getName() + " " + myContacts.get(i).getPhoneNumber());
        }
    }

}


