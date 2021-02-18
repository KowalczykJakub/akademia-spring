package akademiaspringweek2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("PRO")
@Component
public class ProShop extends Shop {

    @Override
    protected void printSummaryPrice() {
        System.out.println(getProSummaryPrice());
    }

}
