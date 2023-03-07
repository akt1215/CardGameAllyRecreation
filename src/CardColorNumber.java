import java.util.Random;

public class CardColorNumber {
    private int color;
    private int number;
    private int space;
    Random rand = new Random();
    CardColorNumber(){
        color = rand.nextInt(5);
        number = rand.nextInt(10) + 1;

        switch (color) {
            case 0:
                //purple
                space = -1;
                break;
            case 1:
                //green
                space = -1;
                break;
            case 2:
                //red
                space = number;
                break;
            case 3:
                //orange
                space = number;
                break;
            case 4:
                //yello
                space = number;
                break;
            default:
                space = 0;
                break;
        }
    }
    public int getSpace(){
        return space;
    }
}
