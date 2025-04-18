package be.technifutur.mechanofiliback.api.controllers;

import be.technifutur.mechanofiliback.api.models.CustomPage;
import be.technifutur.mechanofiliback.api.models.mechas.dtos.MechaDTO;
import be.technifutur.mechanofiliback.bll.MechaService;
import be.technifutur.mechanofiliback.dl.entities.Mecha;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mecha")
public class MechaController {

    private final MechaService mechaService;

    @GetMapping
    public ResponseEntity<CustomPage<MechaDTO>> getAllMecha(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        Page<Mecha> capabilities = mechaService.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id")));
        List<MechaDTO> capabilitiesDTOs = capabilities.getContent().stream()
                .map(MechaDTO::fromMecha)
                .toList();
        CustomPage<MechaDTO> result = new CustomPage<>(capabilitiesDTOs, capabilities.getTotalPages(), capabilities.getNumber() + 1);
        return ResponseEntity.ok(result);
    }
}
