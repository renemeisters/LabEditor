import controller.Controller;

public class Main {

    public static void main(String[] args) {
        int hoehe = Integer.parseInt(args[0]);
        int breite = Integer.parseInt(args[1]);
        Controller c = new Controller();
        c.startCreation(hoehe, breite);
    }
}
