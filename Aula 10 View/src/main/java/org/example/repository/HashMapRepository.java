package org.example.repository;

import org.example.entities.Entity;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapRepository<T extends Entity> implements EntityRepository<T> {

    private HashMap<UUID, T> dataStore = new HashMap<>();

    @Override
    public void save(T entity) {
        this.dataStore.put(entity.getUuid(), entity);
    }

    @Override
    public Optional<T> findById(UUID id) {
        return Optional.ofNullable(this.dataStore.get(id));
    }

    @Override
    public List<T> findAll() {
        return this.dataStore.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.dataStore.remove(id);
    }
}
