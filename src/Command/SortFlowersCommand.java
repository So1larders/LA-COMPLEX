package Command;
import flower.*;


public class SortFlowersCommand implements Command {
    private Bouquet bouquet;

    public SortFlowersCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        bouquet.sortFlowersByFreshness();
    }

    @Override
    public String getDesc(){
        return "Посортувати квітки за свіжістю";
    }
}
