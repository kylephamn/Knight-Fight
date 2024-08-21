import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public abstract class GameData extends Object{
    private static final int MAX_ACTIVE = 4;
    private static final Random random = new Random();
    protected final List<Fortune> fortunes = new ArrayList<>();
    protected final List<MOB> monsters = new ArrayList<>();
    protected final List<Knight> knights = new ArrayList<>();
    protected final List<Knight> activeKnights = new ArrayList<>();

        public List <Knight> getKnights(){
            return knights;
        }
        public List<Knight> getActiveKnights(){
            return activeKnights;
        }
        protected Knight findKnight(String nameOrId, List<Knight> list){


            for(Knight nextKnight : list){
                String nextName = nextKnight.getName();
                Integer nextId = nextKnight.getID();

                if (nextName.toLowerCase().contains(nameOrId.toLowerCase())){
                    return nextKnight;
                }
                if(nextId.toString().equals(nameOrId)){
                    return nextKnight;
                }
            }
            return null;
        }
        public Knight getActive(String nameOrId){
            return findKnight(nameOrId , getActiveKnights());
            
        }
        public Knight getKnight(String nameOrId){
            return findKnight(nameOrId, getKnights());

        }
        public boolean setActive(Knight kt){
            if (activeKnights.size() < MAX_ACTIVE){
                activeKnights.add(kt);
                return true;
            }
            return false;
        }
        public void removeActive(Knight kt){
            if (activeKnights.remove(kt)){
                kt.resetDamage();
            }
        }
        public Fortune getRandomFortune(){
           int fortuneSize = fortunes.size();
           int rnd = random.nextInt(fortuneSize);
           return fortunes.get(rnd);
        }
        
        public List<MOB> getRandomMonster() {
            if (monsters.isEmpty()) {
                return null; 
            }
            List<MOB> mobList = new ArrayList<>();
                for (int i = 0; i <= activeKnights.size(); i++) {
                int randomIndex = random.nextInt(monsters.size());
                mobList.add(monsters.get(randomIndex).copy());
            }
            return mobList;
        }
        
        public List<MOB> getRandomMonsters(int number){
            List <MOB> newLst = new ArrayList<>();
            
            for (int index = 0; index < number; index++){
                newLst.add(monsters.get(random.nextInt(monsters.size())).copy());
            }
            return newLst;   
        }


        public abstract void save(String filename);


    public MOB getRandomMonsters(int size, List<Knight> activeKnights) {
        int minReturn = Math.min(monsters.size(), activeKnights.size());
        int rnd = random.nextInt(minReturn);

        return (MOB) getRandomMonsters(rnd);
    }
}