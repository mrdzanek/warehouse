package pl.myro.warehouse.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(Item item, long id) {
        if (item.getId() == 0) item.setId(id);
        itemRepository.save(item);
    }

    public Item getItem(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }
}
