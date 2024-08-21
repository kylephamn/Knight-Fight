import java.util.List;
import java.util.Random;

public class CombatEngine extends Object{
    private GameData data;
    private DiceSet dice = new DiceSet();
    private Random rnd = new Random();
    private GameView view;

    public CombatEngine(GameData data, GameView View) {
        this.data = data;
        this.view = view;
    }

    public void clear() {
        for (Knight nextKnight : data.getKnights()) {
            nextKnight.setActiveFortune(null);
        }
    }

    private int doBattle (List<MOB> Attackers, List<MOB> defenders) {
        return 0;
    }

    public void initialize() {
        for (Knight nextKnight : data.getActiveKnights()) {
            nextKnight.setActiveFortune(data.getRandomFortune());
        }
        view.printFortunes(data.getActiveKnights());
    }

    public void runCombat() {
        view.printBattleText(data.getRandomMonsters(data.getActiveKnights().size(), data.getActiveKnights()));
        data.getActiveKnights();
        System.out.println("Not implemented.");
    }
}
