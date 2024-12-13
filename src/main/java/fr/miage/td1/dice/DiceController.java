package fr.miage.td1.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class DiceController {
    @Autowired
    private DiceService diceService;

    @GetMapping("/rollDice")
    public List<Integer> rollSingleDice() {
        return diceService.rollDices(1);
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        return diceService.rollDices(count);
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceLogs() {
        return diceService.getAllLogs();
    }
}
