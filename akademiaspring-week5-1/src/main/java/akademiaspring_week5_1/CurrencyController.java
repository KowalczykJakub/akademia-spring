package akademiaspring_week5_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyController {

    private Currency getData() {

        RestTemplate restTemplate = new RestTemplate();

        Currency currency = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=USD", Currency.class);

        return currency;

    }

    @GetMapping
    public String getView(Model model) {

        model.addAttribute("currency", getData());

        return "view";

    }

}
