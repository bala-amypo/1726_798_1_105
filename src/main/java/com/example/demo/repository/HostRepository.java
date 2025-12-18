package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
