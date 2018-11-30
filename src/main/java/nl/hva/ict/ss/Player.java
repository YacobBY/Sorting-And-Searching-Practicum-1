package nl.hva.ict.ss;

/**
 * Player keeps track of the name and the highscore for a player.
 * Once created the name can't be changed. The best score for this player
 * can be changed during the lifetime of an instance.
 */
public class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private long highScore;


    public Player(String firstName, String lastName, long highScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.highScore = highScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getHighScore() {
        return highScore;
    }

    public void setHighScore(long highScore) {
        this.highScore = highScore;
    }

    @Override
    public int compareTo(Player other) {
        if (compareHighScore(other.getHighScore()) != 0) {
            return compareHighScore(other.getHighScore());
        } else if (lastName.compareTo(other.getLastName()) != 0) {
            return lastName.compareTo(other.getLastName());
        } else {
            return firstName.compareTo(other.getFirstName());
        }
    }

    // Should arraySorter accending on highscore
    // If high score is equal arraySorter by lastname
    // If lastnameis equal arraySorter by firstname


    public int compareHighScore(long otherHighscore) {
        if (highScore < otherHighscore) {
            return -1;
        } else if (highScore > otherHighscore) {
            return 1;
        }

        return 0;
    }

}

