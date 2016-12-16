package ro.accenture.codingbat;

/**
 * Created by andreicontan on 13/12/16.
 */
public class ParrotTrouble {

    public boolean parrotTrouble(boolean talking, int hour) {
        if (hour < 24)
        {
            return (talking && (hour < 7 || hour > 20));
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

}
