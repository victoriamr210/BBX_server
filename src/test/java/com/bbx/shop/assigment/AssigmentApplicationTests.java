package com.bbx.shop.assigment;

import com.bbx.shop.assigment.auth.token.JwtTokenUtil;
import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.mapper.ItemMapper;
import com.bbx.shop.assigment.model.Item;
import com.bbx.shop.assigment.repository.ItemRepository;
import com.bbx.shop.assigment.restService.ItemRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AssigmentApplicationTests {

	private final Logger log = LoggerFactory.getLogger(AssigmentApplicationTests.class);

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserDetailsService myUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Test
	void contextLoads() {
	}

	@Test
	void generateToken(){
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername("VMR");
		final String token = jwtTokenUtil.generateToken(userDetails);
		assertNotNull(token);
	}



	@Test
	void testQuery(){
		Item items = itemRepository.cheapestItemBySupplier("1");
		ItemDTO itemDTO = ItemMapper.pojo2Dto(items);
//		List<ItemDTO> itemsDTO = ItemMapper.pojo2Dto(items);
//		log.info(itemsDTO.toString());
	}

}
