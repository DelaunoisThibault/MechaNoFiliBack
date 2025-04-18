package be.technifutur.mechanofiliback.dal.initializers;

import be.technifutur.mechanofiliback.dal.repositories.MechaRepository;
import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.enums.MechaType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MechaRepository mechaRepository;

    @Override
    public void run(String... args) throws Exception {
        saveDefaultMechas();
    }

    private void saveDefaultMechas() {
        if (mechaRepository.count() == 0) {
            List<Mecha> mechas = List.of(
                    new Mecha(
                            "Zorgilator Le null Bugué Error 404",
                            MechaType.FIGHTER
                    ),
                    new Mecha(
                            "XXXG-01W",
                            MechaType.FIGHTER
                    ),
                    new Mecha(
                            "Jean-René",
                            MechaType.WORKER
                    ),
                    new Mecha(
                            "Optimus Prime",
                            MechaType.FIGHTER
                    ),
                    new Mecha(
                            "Robotron",
                            MechaType.FIGHTER
                    ),
                    new Mecha(
                            "Valvare the vampirator",
                            MechaType.WORKER
                    ),
                    new Mecha(
                            "Zero Two",
                            MechaType.WORKER
                    )
            );
            mechaRepository.saveAll(mechas);
        }
    }
}
