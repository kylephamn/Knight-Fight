import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;
public class CSVGameData extends GameData{

    public CSVGameData(String gamedata, String saveData) {
        loadGameData(gamedata);
        loadSaveData(saveData);
    }

    private Scanner readFile(String fileName) {
        try {
            FileInputStream inp = new FileInputStream(fileName);
            Scanner scnr = new Scanner(inp);
            return scnr;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public void loadSaveData(String saveData) {
        int num = 0;
        Scanner scnr = readFile(saveData);
        if (scnr == null) return;
        while (scnr.hasNextLine()) {
            Scanner line = new Scanner(scnr.nextLine());
            line.useDelimiter(",");
            knights.add(new Knight(++num, line.next().trim(), line.nextInt(), line.nextInt(), line.nextInt(), DiceType.valueOf(line.next()), line.nextInt()));
        }

    }


    private void loadGameData(String gameData) {
        Scanner scnr = readFile(gameData);
        if (scnr == null) return;

        while (scnr.hasNextLine()) {
            Scanner line = new Scanner(scnr.nextLine());
            line.useDelimiter(",");

            String type = line.next().trim();
            String name = line.next().trim();
            int hp = line.nextInt();
            int armor = line.nextInt();
            int hitModifier = line.nextInt();
            String diceType1 = line.next();
            DiceType diceType = null;

            if (!diceType1.equals("-")) {
                diceType = DiceType.valueOf(diceType1);
            }
            if (type.equals("MOB")) {
                MOB scary = new MOB(name, hp, armor, hitModifier, diceType);
                monsters.add(scary);
            }
            if (type.equals("FORTUNE")) {
                Fortune nextFortune = new Fortune(name, hp, armor, hitModifier, diceType);
                fortunes.add(nextFortune);
            }
        }
    }

    @Override
    public void save(String filename) {
        try {
            FileWriter file = new FileWriter(filename);

            for (Knight nextKnight : knights) {
                file.write(nextKnight.toCSV() + "\n");
            }
            file.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


}
