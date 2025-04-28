package be.technifutur.mechanofiliback.api.controllers;

import be.technifutur.mechanofiliback.api.models.CustomPage;
import be.technifutur.mechanofiliback.api.models.mechas.dtos.MechaDTO;
import be.technifutur.mechanofiliback.api.models.mechas.dtos.MechaEmptyDTO;
import be.technifutur.mechanofiliback.api.models.mechas.forms.MechaEmptyForm;
import be.technifutur.mechanofiliback.api.models.mechas.forms.MechaForm;
import be.technifutur.mechanofiliback.bll.MechaService;
import be.technifutur.mechanofiliback.bll.exceptions.MechaNotFoundException;
import be.technifutur.mechanofiliback.dl.entities.Mecha;
import be.technifutur.mechanofiliback.dl.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mecha")
@CrossOrigin("*")
public class MechaController {

    private final MechaService mechaService;

    //Empty Mechas
    @Operation(summary = "Returns all empty mechas")
    @GetMapping("/empty")
    public ResponseEntity<CustomPage<MechaEmptyDTO>> getAllEmptyMecha(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<Mecha> emptyMechas = mechaService.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<MechaEmptyDTO> mechaEmptyDTOs = emptyMechas.getContent().stream()
                .map(MechaEmptyDTO::fromEmptyMecha)
                .toList();
        CustomPage<MechaEmptyDTO> result = new CustomPage<>(mechaEmptyDTOs, emptyMechas.getTotalPages(), emptyMechas.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns an empty mecha with specified id (if exists)")
    @GetMapping("/empty/{id}")
    public ResponseEntity<MechaEmptyDTO> getEmptyMechaById(@PathVariable("id") Long id) {
        try {
            Mecha mecha = mechaService.findMechaById(id);
            return new ResponseEntity<>(MechaEmptyDTO.fromEmptyMecha(mecha), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("isAuthenticated()")
    @Operation(summary = "Returns empty mechas from specific user")
    @GetMapping("/empty/user")
    public ResponseEntity<List<MechaEmptyDTO>> getEmptyMechasByUser(

            @AuthenticationPrincipal User user
    ) {
        List<Mecha> mechas = mechaService.getMechasByUser(user.getId());
        List<MechaEmptyDTO>dtos = mechas.stream()
                .map(MechaEmptyDTO::fromEmptyMecha).toList();
        return ResponseEntity.ok(dtos);
    }

    @PreAuthorize("isAuthenticated()")
    @Operation(summary = "Returns empty mecha with specific id from specific user")
    @GetMapping("/empty/user/{id}")
    public ResponseEntity<List<MechaEmptyDTO>> getSpecificEmptyMechaByUser(
            @PathVariable("id") Long id,
            @AuthenticationPrincipal User user
    ) {
        List<Mecha> mechas = mechaService.getMechasByUser(user.getId());
        List<MechaEmptyDTO>dtos = mechas.stream()
                .map(MechaEmptyDTO::fromEmptyMecha).toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Creates a new empty mecha")
    @PostMapping("/empty")
    public ResponseEntity<MechaEmptyDTO> createEmptyMecha(
            @RequestBody MechaEmptyForm form
    ) {
        Mecha mecha = form.toEmptyMecha();
        mechaService.createMecha(mecha);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Updates an empty mecha with specified id (if exists)")
    @PutMapping("/empty/{id}")
    public ResponseEntity<MechaEmptyDTO> updateEmptyMecha(
            @PathVariable Long id,
            @Valid @RequestBody MechaEmptyForm form
    ) {
        Mecha mecha = form.toEmptyMecha();
        mechaService.updateMecha(id, mecha);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deletes an empty mecha with specified id (if exists)")
    @DeleteMapping("/empty/{id}")
    public ResponseEntity<Void> deleteEmptyMecha(@PathVariable Long id) {
        mechaService.deleteMechaById(id);
        return ResponseEntity.noContent().build();
    }

    //Complete Mechas
    @Operation(summary = "Returns all mechas")
    @GetMapping
    public ResponseEntity<CustomPage<MechaDTO>> getAllMecha(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<Mecha> mechas = mechaService.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<MechaDTO> mechaDTOS = mechas.getContent().stream()
                .map(MechaDTO::fromMecha)
                .toList();
        CustomPage<MechaDTO> result = new CustomPage<>(mechaDTOS, mechas.getTotalPages(), mechas.getNumber() + 1);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Returns a mecha with specified id (if exists)")
    @GetMapping("/{id}")
    public ResponseEntity<MechaDTO> getMechaById(@PathVariable("id") Long id) {
        try {
            Mecha mecha = mechaService.findMechaById(id);
            return new ResponseEntity<>(MechaDTO.fromMecha(mecha), HttpStatus.OK);
        } catch (MechaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Creates a new mecha")
    @PostMapping
    public ResponseEntity<MechaDTO> createMecha(
            @RequestBody MechaForm form
    ) {
        Mecha mecha = form.toMecha();
        mechaService.createMecha(mecha);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Updates a mecha with specified id (if exists)")
    @PutMapping("/{id}")
    public ResponseEntity<MechaDTO> updateMecha(
            @PathVariable Long id,
            @Valid @RequestBody MechaForm form
    ) {
        Mecha mecha = form.toMecha();
        mechaService.updateMecha(id, mecha);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deletes a mecha with specified id (if exists)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMecha(@PathVariable Long id) {
        mechaService.deleteMechaById(id);
        return ResponseEntity.noContent().build();
    }

}
