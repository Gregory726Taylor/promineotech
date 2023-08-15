package pet.store.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreCustomer {

    private final PetStoreService petStoreService;

    @Autowired
    public PetStoreCustomer(PetStoreService petStoreService) {
        this.petStoreService = petStoreService;
    }

    @PostMapping("/contributor")
    public PetStoreData insertContributor(@RequestBody PetStoreData petStoreData) {
        log.info("Creating contributor: {}", petStoreData);
        return petStoreService.savePetStore(petStoreData);
    }
}
