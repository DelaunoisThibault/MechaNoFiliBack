package be.technifutur.mechanofiliback.api.controllers;

import be.technifutur.mechanofiliback.api.models.CustomPage;
import be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.dtos.ArmsComponentCreateDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.armsComponents.dtos.ArmsComponentDetailsDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.extensionComponents.dtos.ExtensionComponentCreateDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.extensionComponents.dtos.ExtensionComponentDetailsDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.generatorComponents.dtos.GeneratorComponentCreateDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.generatorComponents.dtos.GeneratorComponentDetailsDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.headComponents.dtos.HeadComponentCreateDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.headComponents.dtos.HeadComponentDetailsDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.dtos.LegsComponentCreateDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.legsComponents.dtos.LegsComponentDetailsDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.torsoComponents.dtos.TorsoComponentCreateDTO;
import be.technifutur.mechanofiliback.api.models.mechaComponents.torsoComponents.dtos.TorsoComponentDetailsDTO;
import be.technifutur.mechanofiliback.bll.exceptions.MechaNotFoundException;
import be.technifutur.mechanofiliback.bll.mechaComponentsServices.*;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mechaComponent")
@CrossOrigin("*")
public class MechaComponentController {

    private final ArmsComponentService armsComponentService;
    private final LegsComponentService legsComponentService;
    private final TorsoComponentService torsoComponentService;
    private final HeadComponentService headComponentService;
    private final GeneratorComponentService generatorComponentService;
    private final ExtensionComponentService extensionComponentService;

    //All components
    /*
    @Operation(summary = "Returns all components")
    @GetMapping("/arms")
    public ResponseEntity<CustomPage<ArmsComponentCreateDTO>> getAllComponents(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<ArmsComponent> armsComponents = armsComponentService.findAllArmsComponent(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<ArmsComponentCreateDTO> armsComponentCreateDTOS = armsComponents.getContent().stream()
                .map(ArmsComponentCreateDTO::fromArmsComponent)
                .toList();
        CustomPage<ArmsComponentCreateDTO> result = new CustomPage<>(armsComponentCreateDTOS, armsComponents.getTotalPages(), armsComponents.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

     */

    //Arms Component

    @Operation(summary = "Returns all arms components")
    @GetMapping("/arms")
    public ResponseEntity<CustomPage<ArmsComponentCreateDTO>> getAllArmsComponents(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<ArmsComponent> armsComponents = armsComponentService.findAllArmsComponent(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<ArmsComponentCreateDTO> armsComponentCreateDTOS = armsComponents.getContent().stream()
                .map(ArmsComponentCreateDTO::fromArmsComponent)
                .toList();
        CustomPage<ArmsComponentCreateDTO> result = new CustomPage<>(armsComponentCreateDTOS, armsComponents.getTotalPages(), armsComponents.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns an arms component with specified id (if exists)")
    @GetMapping("/arms/{id}")
    public ResponseEntity<ArmsComponentDetailsDTO> getArmsComponentById(@PathVariable("id") Long id) {
        try {
            ArmsComponent armsComponent = armsComponentService.findArmsComponentById(id);
            return new ResponseEntity<>(ArmsComponentDetailsDTO.fromArmsComponent(armsComponent), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Legs Component

    @Operation(summary = "Returns all legs component")
    @GetMapping("/legs")
    public ResponseEntity<CustomPage<LegsComponentCreateDTO>> getAllLegsComponents(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<LegsComponent> legsComponents = legsComponentService.findAllLegsComponent(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<LegsComponentCreateDTO> legsComponentCreateDTOS = legsComponents.getContent().stream()
                .map(LegsComponentCreateDTO::fromLegsComponent)
                .toList();
        CustomPage<LegsComponentCreateDTO> result = new CustomPage<>(legsComponentCreateDTOS, legsComponents.getTotalPages(), legsComponents.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns a legs component with specified id (if exists)")
    @GetMapping("/legs/{id}")
    public ResponseEntity<LegsComponentDetailsDTO> getLegsComponentById(@PathVariable("id") Long id) {
        try {
            LegsComponent legsComponent = legsComponentService.findLegsComponentById(id);
            return new ResponseEntity<>(LegsComponentDetailsDTO.fromLegsComponent(legsComponent), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Head Component

    @Operation(summary = "Returns all heads Component")
    @GetMapping("/heads")
    public ResponseEntity<CustomPage<HeadComponentCreateDTO>> getAllHeadComponents(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<HeadComponent> headComponents = headComponentService.findAllHeadComponent(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<HeadComponentCreateDTO> headComponentCreateDTOS = headComponents.getContent().stream()
                .map(HeadComponentCreateDTO::fromHeadComponent)
                .toList();
        CustomPage<HeadComponentCreateDTO> result = new CustomPage<>(headComponentCreateDTOS, headComponents.getTotalPages(), headComponents.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns a head component with specified id (if exists)")
    @GetMapping("/heads/{id}")
    public ResponseEntity<HeadComponentDetailsDTO> getHeadComponentById(@PathVariable("id") Long id) {
        try {
            HeadComponent headComponent = headComponentService.findHeadComponentById(id);
            return new ResponseEntity<>(HeadComponentDetailsDTO.fromHeadComponent(headComponent), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Torso Component

    @Operation(summary = "Returns all torso components")
    @GetMapping("/torsos")
    public ResponseEntity<CustomPage<TorsoComponentCreateDTO>> getAllTorsoComponents(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<TorsoComponent> torsoComponents = torsoComponentService.findAllTorsoComponent(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<TorsoComponentCreateDTO> torsoComponentCreateDTOS = torsoComponents.getContent().stream()
                .map(TorsoComponentCreateDTO::fromTorsoComponent)
                .toList();
        CustomPage<TorsoComponentCreateDTO> result = new CustomPage<>(torsoComponentCreateDTOS, torsoComponents.getTotalPages(), torsoComponents.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns a mecha equipment with specified id (if exists)")
    @GetMapping("/torsos/{id}")
    public ResponseEntity<TorsoComponentDetailsDTO> getTorsoComponentById(@PathVariable("id") Long id) {
        try {
            TorsoComponent torsoComponent = torsoComponentService.findTorsoComponentById(id);
            return new ResponseEntity<>(TorsoComponentDetailsDTO.fromTorsoComponent(torsoComponent), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Generator Component

    @Operation(summary = "Returns all generator components")
    @GetMapping("/generators")
    public ResponseEntity<CustomPage<GeneratorComponentCreateDTO>> getAllGeneratorComponents(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<GeneratorComponent> generatorComponents = generatorComponentService.findAllGeneratorComponent(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<GeneratorComponentCreateDTO> generatorComponentCreateDTOS = generatorComponents.getContent().stream()
                .map(GeneratorComponentCreateDTO::fromGeneratorComponent)
                .toList();
        CustomPage<GeneratorComponentCreateDTO> result = new CustomPage<>(generatorComponentCreateDTOS, generatorComponents.getTotalPages(), generatorComponents.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns a generator component with specified id (if exists)")
    @GetMapping("/generators/{id}")
    public ResponseEntity<GeneratorComponentDetailsDTO> getGeneratorComponentById(@PathVariable("id") Long id) {
        try {
            GeneratorComponent generatorComponent = generatorComponentService.findGeneratorComponentById(id);
            return new ResponseEntity<>(GeneratorComponentDetailsDTO.fromGeneratorComponent(generatorComponent), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Extension Component

    @Operation(summary = "Returns all extension components")
    @GetMapping("/extension")
    public ResponseEntity<CustomPage<ExtensionComponentCreateDTO>> getAllExtensionComponents(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<ExtensionComponent> extensionComponents = extensionComponentService.findAllExtensionComponent(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<ExtensionComponentCreateDTO> extensionComponentCreateDTOS = extensionComponents.getContent().stream()
                .map(ExtensionComponentCreateDTO::fromExtensionComponent)
                .toList();
        CustomPage<ExtensionComponentCreateDTO> result = new CustomPage<>(extensionComponentCreateDTOS, extensionComponents.getTotalPages(), extensionComponents.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns an extension component with specified id (if exists)")
    @GetMapping("/extension/{id}")
    public ResponseEntity<ExtensionComponentDetailsDTO> getExtensionComponentById(@PathVariable("id") Long id) {
        try {
            ExtensionComponent extensionComponent = extensionComponentService.findExtensionComponentById(id);
            return new ResponseEntity<>(ExtensionComponentDetailsDTO.fromExtensionComponent(extensionComponent), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
