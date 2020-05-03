package com.example.baconator.api;

import com.example.baconator.model.Item;
import com.example.baconator.service.ItemService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/give-me-bacon")
@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping
    public List<Item> addItem(@Valid Item item){
        itemService.getItems(item);
        return itemService.getItem();
    }

    @GetMapping(path = "{howMuch}")
    public List<Item> addItem(@Valid Item item, @PathVariable("howMuch") int howMuch){
        itemService.getItemsByNum(item, howMuch);
        return itemService.getItem();
    }


    @GetMapping(path = "/item/{id}")
    public Item getItemByRunId(@PathVariable("id") UUID id){
        return itemService.getItemByRunID(id)
                .orElse(null);
    }

}
