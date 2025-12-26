package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Visitor;

public interface VisitorService {

    Visitor save(Visitor visitor);

    Visitor getById(Long id);

    List<Visitor> getAllVisitors();   // REQUIRED
}
