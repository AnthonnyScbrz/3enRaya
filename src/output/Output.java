package output;

import org.w3c.dom.ls.LSOutput;

public class Output {
    public static void selectSlot(){
        System.out.println(" Ingrese la posición s jugar en el tablero: ");
    }
    public static void slotBusy(){
        System.err.println("La casilla elegida no es valida");
    }

    public static void lineJump(){
        System.out.println();
    }

    public static void endGame(){
        System.out.println("Game over! <(*,*)/ ");
    }
    public static void start(){
        System.out.println("""
                *************************************************************************
                ************** < Bienvenidos al juego del tres en raya > ****************
                *************************************************************************
                """);
    }

    public static void hola() {
        System.out.println("Que tal llevas el 3 en raya?");
    }

}
