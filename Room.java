import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private int number;
    private boolean isOccupied;
    

    public Room(int number) {
        this.number = number;        
    }

    public int getNumber() {
        return number;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }    
}
