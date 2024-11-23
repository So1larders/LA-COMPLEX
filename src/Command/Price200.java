package Command;
import com.sun.deploy.ui.AboutDialog;
import flower.*;

public class Price200 implements Command {
    private Bouquet bouquet;

    public Price200(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {

        double totalPrice = bouquet.totalPrice();
        if (totalPrice > 200) {
            System.out.println("Вартість = " + totalPrice + "\nЩо є більше 200");
        }
        else {
            System.out.println("Вартість = "+ totalPrice + "\nЩо є менше 200");
        }
    }

    @Override
    public String getDesc() {
        return "Перевірити на більше 200";
    }
}
