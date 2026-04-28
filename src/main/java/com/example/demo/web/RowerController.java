package com.example.demo.web;

import com.example.demo.model.Rower;
import com.example.demo.repo.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class RowerController {

    private final ItemRepository itemRepository;

    // CREATE
    @PostMapping
    public Rower createItem(@RequestBody Rower item) {
        return itemRepository.save(item);
    }

    // READ ALL
    @GetMapping
    public List<Rower> getAllItems() {
        return itemRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Rower> getItemById(@PathVariable Long id) {
        Optional<Rower> item = itemRepository.findById(id);
        return item.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Rower> updateItem(@PathVariable Long id, @RequestBody Rower newItem) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    itemRepository.save(item);
                    return ResponseEntity.ok(item);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/instance")
    public String instance(){
        return  System.getenv("HOSTNAME");
    }
}