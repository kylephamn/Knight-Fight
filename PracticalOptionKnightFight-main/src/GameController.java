
public class GameController extends Object{
    private final GameData data;
    private final GameView view;
    private final CombatEngine engine;

    public GameController(GameData data, GameView view, CombatEngine engine){
        this.data = data;
        this.view = view;
        this.engine = engine;
    }
    public void start(){
        view.splashScreen(); 
        while (processCommand( view.displayMainMenu())){}
        view.endGame(); 
    }
    protected boolean processCommand(String command){
        if((command.toLowerCase().equals("exit")) || (command.toLowerCase().contains("bye"))){
            return false;
        }
        else if((command.toLowerCase().equals("ls")) || command.toLowerCase().equals("list all")){
            view.listKnights(data.getKnights());
        }
        else if(command.toLowerCase().equals("list active")){
            view.listKnights(data.getActiveKnights());
        }
        else if(command.startsWith("show")){
            String[] split = command.split(" ");
            processShowKnight(split[1]);
        }
        else if (command.startsWith("set active")){
            String[] split = command.split(" ");
            processSetActive(split[2]);
        }
        else if(command.startsWith("remove")){
            String[] split = command.split(" ");
            processRemoveActive(split[1]);
        }
        else if(command.startsWith("save")){
            String fileName = null;
            if (command.equals("save")){
                fileName = "saveData.csv";
            }
            else{
                String[] split = command.split(" ");
                fileName = split[1];
            }
            data.save(fileName);
        }
        else if((command.toLowerCase().equals("explore")) || (command.toLowerCase().equals("adventure")) || (command.toLowerCase().equals("quest"))){
            engine.initialize();
            engine.runCombat();
            engine.clear();
        }
        else{ 
            view.printHelp();
        }
        return true;
    }
    private void processRemoveActive(String remove){
        Knight knight = data.getActive(remove); 
        if (knight != null){
            data.removeActive(knight);
        }
        else{
            view.knightNotFound();
        }
    }    
    private void processSetActive(String active){
        Knight knight = data.getKnight(active); 
        
        if (knight != null){
            if (!data.setActive(knight)){
                view.setActiveFailed();
            }
        }
        else{
            view.knightNotFound();
        }
    }
    private void processShowKnight(String nameOrId){
        Knight knight = data.getKnight(nameOrId); 
        if (knight != null){
            view.showKnight(knight);
        }
        else{
            view.knightNotFound();
        }
    }
}
