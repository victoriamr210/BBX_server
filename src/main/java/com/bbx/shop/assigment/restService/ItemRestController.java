package com.bbx.shop.assigment.restService;

import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3000" )
@RestController
@RequestMapping("/api/item")
public class ItemRestController {
    private final Logger log = LoggerFactory.getLogger(ItemRestController.class);
    private final ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    List<ItemDTO> findAll(){
        log.info("List Items");
        return itemService.findAll();
    }

    @DeleteMapping("/delete/{idItem}")
    ResponseEntity<HttpStatus> deleteItem(@PathVariable Long idItem) throws Exception {
        try{
            itemService.deteleItem(idItem);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO) {
        log.info("Update Item id: " + itemDTO.getItemCode());
        try{
            ItemDTO item = itemService.updateItem(itemDTO);
            return ResponseEntity.ok(item);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}


    @PostMapping("/new")
    ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO itemDTO) {

        log.info("Add Item: " + itemDTO.getItemCode());
        try{
            ItemDTO item = itemService.createItem(itemDTO);
            return ResponseEntity.created(new URI("/api/item/" + item.getIdItem()))
                    .body(item);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{idItem}")
    ResponseEntity<ItemDTO> getItem(@PathVariable Long idItem) {
        log.info("Get Item: " + idItem);
        try{
            ItemDTO itemDTO = itemService.getItem(idItem);
            return ResponseEntity.ok(itemDTO);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByCode/{itemCode}")
    ResponseEntity<ItemDTO> getItemByCode(@PathVariable String itemCode){
        log.info("Get Item by Code: " + itemCode);
        try{
            ItemDTO itemDTO = itemService.getItemByCode(itemCode);
            return ResponseEntity.ok(itemDTO);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("isCodeAvailable/{itemCode}")
    ResponseEntity<Boolean> isCodeAvailable(@PathVariable String itemCode){
        log.info("Check if itemCode" + itemCode + " is available: ");
        try{
            Boolean isCodeAvailable = itemService.isCodeAvailable(itemCode);
            return ResponseEntity.ok(isCodeAvailable);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deactivateItem/{idItem}")
    ResponseEntity<?> deactivateItem(@PathVariable Long idItem, @RequestBody String reasonDeactivation){
        log.info("Deactivate item: " + idItem);
        try{
            ItemDTO itemDTO = itemService.deactivateItem(idItem, reasonDeactivation);
            return ResponseEntity.ok(itemDTO);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/checkDatePrices")
    ResponseEntity<Boolean> checkDatePrices(@RequestBody ItemDTO itemDTO){
        log.info("Check Dates");
        try{
            Boolean isPricesOk = itemService.isPricesValid(itemDTO);
            return ResponseEntity.ok(isPricesOk);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
