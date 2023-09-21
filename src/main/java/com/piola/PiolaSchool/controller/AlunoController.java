package com.piola.PiolaSchool.controller;

import com.piola.PiolaSchool.DAO.IAluno;
import com.piola.PiolaSchool.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Aluno")
public class AlunoController {

    @Autowired
    private IAluno dao;
    @GetMapping
    public List<Aluno> AlunoList (){
        return (List<Aluno>)dao.findAll();
    }
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno){
        Aluno alunoCreate =dao.save(aluno);
        return alunoCreate;}
    @DeleteMapping("/{matricula}")
    public Optional<Aluno> deletarAluno(@PathVariable Integer matricula){
        Optional<Aluno> Aluno =dao.findById(matricula);
        dao.deleteById(matricula);
        return Aluno;}}