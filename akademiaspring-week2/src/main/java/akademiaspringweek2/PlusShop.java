package akademiaspringweek2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("PLUS")
@Component
public class PlusShop extends Shop {

    @Override
    protected void printSummaryPrice() {
        System.out.println(getPlusSummaryPrice());
    }

}
