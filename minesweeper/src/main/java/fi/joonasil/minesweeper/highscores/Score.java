package fi.joonasil.minesweeper.highscores;

/**
 *Luokka huipputuloksen tallentamista varten.
 * 
 * @author Joonas Ilvonen
 */
public class Score implements Comparable<Score> {
    private String position;
    private String name;
    private String time;
    
    /**
     * Konstruktori uuden huipputuloksen luomist avarten.
     * 
     * @param name Pelaajan nimi.
     * @param time Pelin aika.
     */
    public Score(String name, String time) {
        this.name = name;
        this.time = time;
        this.position = 0 + ".";
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position + ".";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        String out = name + time;
        return out;
    }
    
    @Override
    public int compareTo(Score score) {
        int time1 = toTime(this.getTime());
        int time2 = toTime(score.getTime());
        if (time1 < time2) {
            return -1;
        }
        if (time1 > time2) {
            return 1;
        }
        return 0;
    }
    
    private int toTime(String s) {
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int sec = Integer.parseInt(time[2]);
        int output = ((hour * 60 + min) * 60 + sec);
        return output;
    }
}
