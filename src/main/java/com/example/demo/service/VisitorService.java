package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Visitor;

public interface VisitorService {
    Visitor save(Visitor visitor);
    List<Visitor> getAll();
    Visitor getById(Long id);
}

