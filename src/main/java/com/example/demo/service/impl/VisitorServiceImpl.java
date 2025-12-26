package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    // =========================
    // EXISTING METHODS (KEEP)
    // =========================

    @Override
    public Visitor save(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getAll() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getById(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
    }

    // =========================
    // METHODS REQUIRED BY TESTS
    // =========================

    // Test calls: createVisitor(visitor)
    public Visitor createVisitor(Visitor visitor) {
        return save(visitor);
    }

    // Test calls: getVisitor(id)
    public Visitor getVisitor(Long id) {
        return getById(id);
    }
}
