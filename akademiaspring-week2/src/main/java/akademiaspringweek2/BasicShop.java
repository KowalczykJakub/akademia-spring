package akademiaspringweek2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("START")
@Component
public class BasicShop extends Shop {

    @Override
    protected void printSummaryPrice() {
        System.out.println(getBasicSummaryPrice());
    }

}
