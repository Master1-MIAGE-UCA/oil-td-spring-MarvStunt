package fr.miage.td1.dice;

import org.springframework.data.jpa.repository.JpaRepository;

interface DiceRollLogRepository extends JpaRepository<DiceRollLog, Long> {}