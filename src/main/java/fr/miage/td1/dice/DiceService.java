package fr.miage.td1.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
class DiceService {
    private Dice dice;
    private DiceRollLogRepository repository;

    public DiceService(Dice dice, DiceRollLogRepository repository) {
        this.dice = dice;
        this.repository = repository;
    }

    public List<Integer> rollDices(int count) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll());
        }
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(count);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        repository.save(log);
        return results;
    }

    public List<DiceRollLog> getAllLogs() {
        return repository.findAll();
    }
}