package com.bbx.shop.assigment;


import com.bbx.shop.assigment.model.Supplier;
import com.bbx.shop.assigment.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssigmentApplication {

	private static final Logger log = LoggerFactory.getLogger(AssigmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AssigmentApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner findAllSuppliers(SupplierRepository repository) {
//		return (args) -> {
//
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Supplier supplier : repository.findAll()) {
//				log.info(supplier.toString());
//			}
//			log.info("");
//		};
//	}
//
//
//	@Bean
//	public CommandLineRunner findAllPrices(PriceReductionRepository repository) {
//		return (args) -> {
//
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (PriceReduction priceReduction : repository.findAll()) {
//				log.info(priceReduction.toString());
//			}
//			log.info("");
//		};
//	}
//
//
//
//	@Bean
//	public CommandLineRunner findAllItems(ItemRepository repository) {
//		return (args) -> {
//
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Item item : repository.findAll()) {
//				log.info(item.toString());
//			}
//			log.info("");
//		};
//	}
}
