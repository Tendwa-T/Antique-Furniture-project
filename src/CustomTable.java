import javax.swing.*;
import java.awt.event.*;

public class CustomTable extends Table{
    int numOfDrawers;
    public CustomTable(float width, float length, String woodType, int numOfDrawers){
        super(width, length, woodType);
        this.numOfDrawers = numOfDrawers;
        if (numOfDrawers>6){
            throw new RuntimeException("Too many drawers. Only a maximum of 6 is allowed. You entered: "+numOfDrawers);
        }
        if (numOfDrawers>0){
            float drawerPrice =((2500)+(2000*(numOfDrawers-1)));
            super.setCustomPrice(drawerPrice);
        }
        super.setWoodPrice();

    }
    public int getNumOfDrawers(){
        return numOfDrawers;
    }

}

