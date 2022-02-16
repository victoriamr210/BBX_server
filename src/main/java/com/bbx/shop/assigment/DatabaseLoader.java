package com.bbx.shop.assigment;

import com.bbx.shop.assigment.model.Item;
import com.bbx.shop.assigment.model.PriceReduction;
import com.bbx.shop.assigment.model.Supplier;
import com.bbx.shop.assigment.model.User;
import com.bbx.shop.assigment.model.enums.ItemStateEnum;
import com.bbx.shop.assigment.model.enums.UserRoleEnum;
import com.bbx.shop.assigment.repository.ItemRepository;
import com.bbx.shop.assigment.repository.PriceReductionRepository;
import com.bbx.shop.assigment.repository.SupplierRepository;
import com.bbx.shop.assigment.repository.UserRepository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class DatabaseLoader  implements CommandLineRunner {

    private final SupplierRepository supplierRepository;
    private final PriceReductionRepository priceReductionRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(SupplierRepository supplierRepository, PriceReductionRepository priceReductionRepository,
                          ItemRepository itemRepository, UserRepository userRepository) {
        this.supplierRepository = supplierRepository;
        this.priceReductionRepository = priceReductionRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Supplier ikea = new Supplier("IKEA", "SPAIN");
        Item item = new Item("1", "desc", 12D, ItemStateEnum.ACTIVE, LocalDateTime.now());

        supplierRepository.save(new Supplier("LEROY MERLIN", "SPAIN"));
        supplierRepository.save(new Supplier("ALCAMPO", "SPAIN"));
        supplierRepository.save(new Supplier("DECATHLON", "SPAIN"));
        supplierRepository.save(new Supplier("KIABI", "SPAIN"));

        priceReductionRepository.save(new PriceReduction(12D, LocalDate.parse("01/02/2022", dateTimeFormatter), LocalDate.parse("20/02/2022", dateTimeFormatter)));
        priceReductionRepository.save(new PriceReduction(3D, LocalDate.parse("12/02/2022", dateTimeFormatter), LocalDate.parse("21/02/2022", dateTimeFormatter)));


        //password == pass
        User user = new User("Victoria Manrique", "VMR", "$2a$04$WeHJ5LT.hm2.n.7u8lKaVeRU.jTMMmwkhag0ea0Rbd7iECrfmzNZS", Arrays.asList(UserRoleEnum.ROLE_USER));
        User user1 = new User("BITBOX", "BITBOX", "$2a$04$WeHJ5LT.hm2.n.7u8lKaVeRU.jTMMmwkhag0ea0Rbd7iECrfmzNZS", Arrays.asList(UserRoleEnum.ROLE_ADMIN));

        userRepository.save(user1);
        item.setCreator(user);

        item.addSupplier(ikea);
        itemRepository.save(item);

    }
}
