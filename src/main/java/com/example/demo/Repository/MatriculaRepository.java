package com.example.demo.Repository;

import com.example.demo.Model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}

