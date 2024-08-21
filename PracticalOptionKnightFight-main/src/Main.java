
public class Main extends Object {
    private static String gamedata = "gamedata.csv";
    private static String saveData = "knights.csv";

    public static void main(String[] args){
        processArgs(args); // method that parses the args, optional but cleaned up the code
        GameData data = new CSVGameData(gamedata, saveData);
        GameView view  = new ConsoleView();
        CombatEngine engine = new CombatEngine(data, view);
        GameController controller = new GameController(data, view, engine);
        controller.start();

    }
    private static void processArgs(String[] args){
    String[] lst;
    
    for(String testArgs : args){
        if (testArgs.startsWith("--data")){
            lst = testArgs.split("=");
            gamedata = lst[1];
        }
        else{
            saveData = testArgs;
            
        }
    }
    }
}   
    
