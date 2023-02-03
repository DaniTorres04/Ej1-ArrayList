import java.util.Scanner;

public class Main {

    public static void imprimirMenu() {
        System.out.println("Eliga una opción:");
        System.out.println("0 - Para salir del programa");
        System.out.println("1 - Para imprimir los contactos");
        System.out.println("2 - Para añadir contacto");
        System.out.println("3 - Para modificar/actualizar un contacto");
        System.out.println("4 - Para eliminar el contacto que desee");
        System.out.println("5 - Para buscar un contacto");
        System.out.println("6 - Para volver al menú");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        do{
            imprimirMenu();
            int opcion = sc.nextInt();
            sc.nextLine();
            String nombre;
            String num;
            switch (opcion) {
                case 0:
                    salir = false;
                    break;
                case 1:
                    TelefonoMovil.printContact();
                    break;
                case 2:
                    System.out.println("Añada un contacto:");
                    System.out.println("Primero, introduzca un nombre para su contacto:");
                    nombre = sc.nextLine();
                    System.out.println("Ahora, introduzca el número del contacto:");
                    num = sc.nextLine();
                    Contacto nuvcon = new Contacto(nombre, num);
                    TelefonoMovil.addNewContact(nuvcon);
                    break;
                case 3:
                    System.out.println("Escriba el nombre del contacto que quiere actualizar:");
                    String viejo = sc.nextLine();
                    Contacto old = TelefonoMovil.queryContact(viejo);
                    if (old == null) {
                        System.out.println("El contacto introducido no existe.");
                    } else {
                        System.out.println("Ahora, escriba el nuevo nombre del contacto:");
                        String nuevo = sc.nextLine();
                        System.out.println("Escriba el nuevo número del contacto:");
                        String numNuevo = sc.nextLine();
                        Contacto connuev = new Contacto(nuevo, numNuevo);
                        TelefonoMovil.updateContact(old, connuev);
                    }
                    break;
                case 4:
                    System.out.println("Escriba el nombre del contacto que desea eliminar:");
                    String rem = sc.nextLine();
                    Contacto elim = TelefonoMovil.queryContact(rem);
                    if (elim == null){
                        System.out.println("El contacto no existe.");
                    }else {
                        TelefonoMovil.removeContact(elim);
                        System.out.println("Contacto eliminado");
                    }
                    break;
                case 5:
                    System.out.println("Escriba el contacto que quiere buscar:");
                    String bus = sc.nextLine();
                    Contacto buscar = TelefonoMovil.queryContact(bus);
                    if (buscar != null){
                        System.out.println("Los datos de su contacto son: " + buscar.getName() + "/ " + buscar.getPhoneNumber());
                    }
                    break;
                case 6:
                    imprimirMenu();
                    break;
            }
        }while (salir == true);
    }
}

