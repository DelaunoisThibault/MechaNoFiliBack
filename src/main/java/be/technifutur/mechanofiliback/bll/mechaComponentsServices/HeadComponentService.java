package be.technifutur.mechanofiliback.bll.mechaComponentsServices;

import be.technifutur.mechanofiliback.dl.entities.MechaEquipment;
import be.technifutur.mechanofiliback.dl.entities.mechacomponents.HeadComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HeadComponentService {
    HeadComponent createHeadComponentNoImage(HeadComponent headComponent);

    HeadComponent createHeadComponentNoComment(HeadComponent headComponent);

    HeadComponent createHeadComponent(HeadComponent headComponent);

    HeadComponent saveHeadComponent(HeadComponent headComponent);

    HeadComponent findHeadComponentById(Long id);

    Page<HeadComponent> findAllHeadComponent(Pageable pageable);

    void updateHeadComponentNoImage(Long id, HeadComponent headComponent);

    void updateHeadComponentNoComment(Long id, HeadComponent headComponent);

    void updateHeadComponent(Long id, HeadComponent headComponent);

    void deleteHeadComponentById(Long id);
}
