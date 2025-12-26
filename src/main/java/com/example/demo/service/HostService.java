package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Host;

public interface HostService {

    Host save(Host host);

    List<Host> getAll();

    Host getById(Long id);

    // ===== test methods =====
    Host createHost(Host host);

    Host getHost(Long id);

    List<Host> getHosts();
}
