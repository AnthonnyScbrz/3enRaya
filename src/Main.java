import input.Input;
import output.Output;
import validator.Validator;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    protected static char [][] tableGame;
    public static int firstPosition;
    public static int secondPosition;
    public static boolean humanPlays = true;
    public static int playCounter = 0;
    public static void main(String[] args) {

        tableGame = new char[3][3];
        tableStart();
        showTable();
        boolean endGame = true;
        do {
            boolean slotUnavailable = false;
            do {
                slotUnavailable = slotValidator();
            }while(slotUnavailable);
            tableGame[firstPosition][secondPosition] = humanPlays ? 'x' : 'o';
            showTable();
            humanPlays = !humanPlays;
            playCounter++;
            endGame = endGameValitation();
        }while(!endGame);

    }

    private static boolean slotValidator() {
        boolean slotUnavailable;
        firstPosition = playerSelectSlot(humanPlays);
        secondPosition = playerSelectSlot(humanPlays);
        slotUnavailable = !Validator.slotValidator(firstPosition,secondPosition,tableGame);
        if (slotUnavailable) {
            Output.slotBusy();
        }
        return slotUnavailable;
    }

    private static void tableStart(){
        for (int i = 0; i < tableGame.length; i++){
            for (int j = 0; j < tableGame[i].length;j++){
                tableGame[i][j]= '-';
            }
        }
    }

    private static void showTable(){
        Output.start();
        for (int i = 0; i < tableGame.length; i++){
            for (int j = 0; j < tableGame[i].length;j++){
                System.out.print(tableGame[i][j]);
            }
            Output.lineJump();
        }
    }

    private static int playerSelectSlot(boolean humansTurn){
        int getPosition;
        if (humansTurn) {
            Output.selectSlot();
            getPosition = Input.returnPosition();
        }else {
            getPosition = (int)(Math.random() * 3);
        }
        return getPosition;
    }

    private static boolean endGameValitation() {
        return Validator.endGameValidator(playCounter);
    }
}


