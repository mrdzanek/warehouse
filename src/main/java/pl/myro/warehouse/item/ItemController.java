package pl.myro.warehouse.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping("/items/{id}")
    public Item getItem(@PathVariable long id) {
        return itemService.getItem(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/items")
    public void addItem(Item item) {
        itemService.addItem(item);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
    public void updateItem(Item item, @PathVariable long id) {
        itemService.updateItem(item, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
    public void deleteItem(@PathVariable long id) {
        itemService.deleteItem(id);
    }


}
