import java.util.List;
import java.util.Scanner;

public class ConsoleView extends Object implements GameView {
    private final Scanner in = new Scanner(System.in); 

    @Override
    public void splashScreen(){
        System.out.println("Welcome to the Game!!"); 
    }
    @Override  
    public void endGame(){
        System.out.println("Thank You for playing my game!");
    }
    @Override
    public String displayMainMenu(){
        System.out.print("What would you like to do? ");
        String ans = in.nextLine();
        return ans;
    }
    @Override
    public void printHelp(){
        // String msg = " Unsure what to do, here are some options:\n";
        // msg += "ls or list all  - listing the knights\n";
        // msg += "list active  - list the active knights knights only\n";
        // msg += "show name or id - show the knight details card\n";
        // msg += "set active name or id - set knight as active (note: only 4 knights can be active)\n";
        // msg += "remove active name or id - remove a knight from active status (heals knight)\n";
        // msg += "explore or adventure or quest - find random monsters to fight\n";
        // msg += "save filename - save the game to the file name (default: saveData.csv)\n";
        // msg += "exit or goodbye - to leave the game\n";
        // msg += "\n";
        // msg += "Game rules: You can have four active knights. As long as they are active, they won't heal,\n"; 
        // msg += "but they can gain XP by going on adventures.\n";
        // msg += "When you make a knight inactive, they will heal. How many monsters can you defeat\n"; 
        // msg += "before, you have to heal?\n";

        // System.out.println(msg);

        StringBuilder msg = new StringBuilder();
        msg.append("Unsure what to do, here are some options:\n");
        msg.append("ls or list all  - listing the knights\n");
        msg.append("list active  - list the active knights knights only\n");
        msg.append("set active name or id - set knight as active (note: only 4 knights can be active)\n");
        msg.append("remove active name or id - remove a knight from active status (heals knight)\n");
        msg.append("explore or adventure or quest - find random monsters to fight\n");
        msg.append("save filename - save the game to the file name (default: saveData.csv)\n");
        msg.append("exit or goodbye - to leave the game\n");
        msg.append("\n");
        msg.append("Game rules: You can have four active knights. As long as they are active, they won't heal,\n");
        msg.append("but they can gain XP by going on adventures.\n");
        msg.append("When you make a knight inactive, they will heal. How many monsters can you defeat\n");
        msg.append("before, you have to heal?\n");

        System.err.println(msg);


    }
    @Override
    public void listKnights(List<Knight> knights){
        if ((knights == null) || (knights.isEmpty())){
            System.out.println(" No knights to list");
            return;
        }
        for (Knight test : knights){
            System.out.println(test.getID() + ": " + test.getName());
        }
    }
    @Override
    public void knightNotFound(){
        System.out.println("Knight not found!");
    }
    @Override
    public void showKnight(Knight knight){
        System.out.println(knight);
        System.out.println("");
    }
    @Override
    public void setActiveFailed(){
        System.out.println("Unable to set active knight. Only four can be active at a time.");
        System.out.println("");
    }
    @Override
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights){
        System.out.println("Our heroes come across the following monsters. Prepare for battle!");
        System.out.println("Knights                     Foes");

        for (int index=0; index<activeKnights.size(); index++) {
            String nextKnightName = activeKnights.get(index).getName();
            String nextMonsterName = "";
            if (monsters.size() - 1 >= index) { 
            nextMonsterName = monsters.get(index).getName();
            }
            
            System.out.println(String.format("%s %27s",nextKnightName, nextMonsterName));
            
        }
    }
    
    @Override
    public void printBattleText(MOB dead){
        System.out.println(dead + " was defeated!");
    }
    @Override
    public void printFortunes(List<Knight> activeKnights){
        System.out.println(" For this quest, our knights drew the following fortunes!");

        for (Knight testKnight : activeKnights){
            System.out.println(testKnight.getName() + " drew");
            System.out.println(testKnight.getActiveFortune().toString());
        }
    }
    @Override
    public boolean checkContinue(){
        System.out.println("Would you like to continue on your quest (y/n)?");
        String input = in.nextLine();
        
        if ((input.toLowerCase().equals("yes")) || (input.toLowerCase().equals("y"))){
            return true;
        }
        return false;
    }
    @Override
    public void printDefeated(){
        System.out.println("All active knights have been defeated!");
    }

}
