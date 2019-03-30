package com.reactive.controller;

import com.reactive.model.Funcionario;
import com.reactive.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FuncionarioController.class);

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Funcionario> findAll() {
        LOGGER.info("findAll");
        return Flux.fromIterable(funcionarioService.getAll()).delayElements(Duration.ofMillis(500));
    }
   /*
    @GetMapping("/{id}")
    public Mono findById(@PathVariable("id") Integer id) {
        LOGGER.info("findById: ", id);
        return funcionarioService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.info("deleteById: ", id);
        funcionarioService.deleteById(id);
    }

    @PostMapping
    public Mono create(@RequestBody Funcionario funcionario) {
        LOGGER.info("create: ", funcionario);
        return funcionarioService.create(funcionario);
    }
*/
}
