package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Host;

public interface HostService {

    Host createHost(Host host);

    Host getHost(Long id);

    List<Host> getAllHosts();
}
