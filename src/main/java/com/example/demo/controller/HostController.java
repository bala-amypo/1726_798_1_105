package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hosts")
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping
    public Host createHost(@RequestBody Host host) {
        return hostService.save(host);
    }

    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAll();
    }

    @GetMapping("/{id}")
    public Host getHost(@PathVariable Long id) {
        return hostService.getById(id);
    }
}
