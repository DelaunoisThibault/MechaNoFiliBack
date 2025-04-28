package be.technifutur.mechanofiliback.bll.mechaComponentsServices;

import be.technifutur.mechanofiliback.dl.entities.mechacomponents.ExtensionComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExtensionComponentService {

    ExtensionComponent saveExtensionComponent(ExtensionComponent extensionComponent);

    ExtensionComponent createExtensionComponentNoComment(ExtensionComponent extensionComponent);

    ExtensionComponent createExtensionComponent(ExtensionComponent extensionComponent);

    ExtensionComponent findExtensionComponentById(Long id);

    Page<ExtensionComponent> findAllExtensionComponent(Pageable pageable);

    void updateExtensionComponentNoComment(Long id, ExtensionComponent extensionComponent);

    void updateExtensionComponent(Long id, ExtensionComponent extensionComponent);

    void deleteExtensionComponentById(Long id);
}
