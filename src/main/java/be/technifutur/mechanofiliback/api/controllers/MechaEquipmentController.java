package be.technifutur.mechanofiliback.api.controllers;

import be.technifutur.mechanofiliback.api.models.CustomPage;
import be.technifutur.mechanofiliback.api.models.mechaEquipements.dtos.MechaEquipementCreateDTO;
import be.technifutur.mechanofiliback.api.models.mechaEquipements.dtos.MechaEquipementDetailsDTO;
import be.technifutur.mechanofiliback.bll.MechaEquipementService;
import be.technifutur.mechanofiliback.bll.exceptions.MechaNotFoundException;
import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
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
@RequestMapping("/api/mechaEquipment")
@CrossOrigin("*")
public class MechaEquipmentController {

    private final MechaEquipementService mechaEquipementService;

    @Operation(summary = "Returns all mechas equipments")
    @GetMapping
    public ResponseEntity<CustomPage<MechaEquipementCreateDTO>> getAllMechaEquipment(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<MechaEquipment> mechaEquipements = mechaEquipementService.findAllMechaEquipement(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<MechaEquipementCreateDTO> mechaEquipementCreateDTOS = mechaEquipements.getContent().stream()
                .map(MechaEquipementCreateDTO::fromMechaEquipement)
                .toList();
        CustomPage<MechaEquipementCreateDTO> result = new CustomPage<>(mechaEquipementCreateDTOS, mechaEquipements.getTotalPages(), mechaEquipements.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns a mecha equipment with specified id (if exists)")
    @GetMapping("/{id}")
    public ResponseEntity<MechaEquipementDetailsDTO> getMechaEquipmentById(@PathVariable("id") Long id) {
        try {
            MechaEquipment mechaEquipment = mechaEquipementService.findMechaEquipementById(id);
            return new ResponseEntity<>(MechaEquipementDetailsDTO.fromMechaEquipement(mechaEquipment), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
