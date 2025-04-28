package be.technifutur.mechanofiliback.dal.initializers;

import be.technifutur.mechanofiliback.dal.repositories.MechaEquipmentRepository;
import be.technifutur.mechanofiliback.dal.repositories.MechaRepository;
import be.technifutur.mechanofiliback.dal.repositories.UserRepository;
import be.technifutur.mechanofiliback.dal.repositories.mechaComponentsRepositories.*;
import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.User;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ComponentSize;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.LegsComponent;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.MechaComponent;
import be.technifutur.mechanofiliback.dl.enums.EquipmentType;
import be.technifutur.mechanofiliback.dl.enums.MechaType;
import be.technifutur.mechanofiliback.dl.enums.UserRole;
import be.technifutur.mechanofiliback.dl.enums.WeightCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MechaRepository mechaRepository;
    private final MechaEquipmentRepository mechaEquipmentRepository;
    private final ArmsComponentRepository armsComponentRepository;
    private final LegsComponentRepository legsComponentRepository;
    private final HeadComponentRepository headComponentRepository;
    private final TorsoComponentRepository torsoComponentRepository;
    private final TorsoFunctionalityRepository torsoFunctionalityRepository;
    private final GeneratorComponentRepository generatorComponentRepository;
    private final ExtensionComponentRepository extensionComponentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        saveDefaultUsers();
        saveDefaultLegsComponents();
        saveDefaultMechaEquipments();
        saveDefaultMechas();
    }

    private void saveDefaultMechas() {
        if (mechaRepository.count() == 0) {

            Optional<User> normalUser = userRepository.findByUsername("user");
            Optional<User> moderatorUser = userRepository.findByUsername("modo");
            Optional<User> adminUser = userRepository.findByUsername("admin");
            if(normalUser.isPresent() && moderatorUser.isPresent() && adminUser.isPresent()) {
                User user = normalUser.get();
                User moderator = moderatorUser.get();
                User admin = adminUser.get();
                List<Mecha> mechas = List.of(
                        new Mecha(
                                "Zorgilator Le null Bugué Error 404",
                                MechaType.FIGHTER,
                                user
                        ),
                        new Mecha(
                                "XXXG-01W",
                                MechaType.FIGHTER,
                                moderator
                        ),
                        new Mecha(
                                "Jean-René",
                                MechaType.WORKER,
                                moderator
                        ),
                        new Mecha(
                                "Optimus Prime",
                                MechaType.FIGHTER,
                                admin
                        ),
                        new Mecha(
                                "Robotron",
                                MechaType.FIGHTER,
                                user
                        ),
                        new Mecha(
                                "Valvare the vampirator",
                                MechaType.WORKER,
                                moderator
                        ),
                        new Mecha(
                                "Zero Two",
                                MechaType.WORKER,
                                user
                        )
                );
                mechaRepository.saveAll(mechas);
            }
        }
    }

    private void saveDefaultUsers() {
        if (userRepository.count() == 0) {

            String password = passwordEncoder.encode("Test1234=");

            List<User> users = List.of(
                    new User("admin@admin.be",  "admin", UserRole.ADMIN, password),
                    new User("user@user.be", "user", UserRole.USER, password),
                    new User("modo@modo.be", "modo", UserRole.MODERATOR, password)
            );
            userRepository.saveAll(users);
        }
    }

    private void saveDefaultLegsComponents() {
        if (legsComponentRepository.count() == 0) {
            ComponentSize ligthLegSize = new ComponentSize(
                100,
                600,
                100
            );
            ComponentSize mediumLegSize = new ComponentSize(
                    200,
                    500,
                    200
            );
            ComponentSize heavyLegSize = new ComponentSize(
                    300,
                    300,
                    300
            );

            List<LegsComponent> legsComponents = List.of(
                    new LegsComponent(
                            "AA-J-123 BASHO",
                            20520,
                            "https://armoredcore6.wiki.fextralife.com/file/Armored-Core-6/al-j-121-basho-legs-frame-armored-core-6-wiki-guide-257px-min.png",
                            300,
                            4160,
                            62600,
                            "Jambes humanoides",
                            WeightCategory.MEDIUM,
                            mediumLegSize
                    ),
                    new LegsComponent(
                            "LG-033M VERRILL",
                            36200,
                            "https://armoredcore6.wiki.fextralife.com/file/Armored-Core-6/lg-003m-verrill-legs-frame-armored-core-6-wiki-guide-257px-min.png",
                            675,
                            6850,
                            76200,
                            "Jambes quadrupèdes",
                            WeightCategory.HEAVY,
                            heavyLegSize
                    ),
                    new LegsComponent(
                            "EL-TL-10",
                            11200,
                            "https://armoredcore6.wiki.fextralife.com/file/Armored-Core-6/el-tl-10-firmeza-legs-frame-armored-core-6-wiki-guide-257px-min.png",
                            378,
                            3600,
                            52100,
                            "Jambes humanoides",
                            WeightCategory.LIGHT,
                            ligthLegSize
                    )
            );
            legsComponentRepository.saveAll(legsComponents);
        }
    }

    private void saveDefaultMechaEquipments() {
        if (mechaEquipmentRepository.count() == 0) {

            List<MechaEquipment> mechaEquipments = List.of(
                    new MechaEquipment(
                            "PB-033m ASHMEAD",
                            "https://armoredcore6.wiki.fextralife.com/file/Armored-Core-6/pb-033m-ashmead-arm-unit-armored-core-6-wiki-guide-257px.png",
                            3000,
                            EquipmentType.WEAPON,
                            50,
                            5000
                    ),
                    new MechaEquipment(
                            "MA-J-200 RANSETSU-RF",
                            "https://armoredcore6.wiki.fextralife.com/file/Armored-Core-6/ma-j-200-ransetsu-rf-arm-unit-armored-core-6-wiki-guide-257px.png",
                            4000,
                            EquipmentType.WEAPON,
                            80,
                            3000
                    ),
                    new MechaEquipment(
                            "Perceuse MokitaBzz 20-15",
                            "https://ronixtools.com/fr/blog/wp-content/uploads/2021/12/Hilti-cordless-drill.jpg",
                            2000,
                            EquipmentType.WORKINGTOOL,
                            200,
                            2500
                    ),
                    new MechaEquipment(
                            "Marteau-piqueur Bosch XV-09",
                            "https://cdn.sw.fixami.com/media/ea/93/04/1726653112/0192048b9d897251b45b33f326e667cf.webp?ts=1726653112",
                            4500,
                            EquipmentType.WORKINGTOOL,
                            520,
                            6000
                    )
            );
            mechaEquipmentRepository.saveAll(mechaEquipments);
        }
    }
}
