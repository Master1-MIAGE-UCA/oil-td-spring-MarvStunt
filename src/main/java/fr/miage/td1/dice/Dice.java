package fr.miage.td1.dice;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;

@Data
@Component
class Dice {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }
}

