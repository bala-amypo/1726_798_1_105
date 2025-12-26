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

    // ===== test wrappers =====
    @Override
    public Visitor createVisitor(Visitor visitor) {
        return save(visitor);
    }

    @Override
    public Visitor getVisitor(Long id) {
        return getById(id);
    }

    @Override
    public List<Visitor> getVisitors() {
        return getAll();
    }
}
