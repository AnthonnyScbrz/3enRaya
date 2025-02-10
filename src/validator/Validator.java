package validator;

public class Validator {
    public static boolean slotValidator(int fila, int columna, char[][] tableGame) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tableGame[fila][columna] == '-';
    }
    public static boolean endGameValidator(int playCounter){
        return playCounter == 9;
    }
}
