package com.perry.rest;

import java.util.List;
import java.util.UUID;

public interface GeneralRest<T, D> {
    List<T> findAll();
    T findById( UUID uuid);
    T create(D d);
    T update(UUID uuid, D d);
    void delete(UUID uuid);
}
