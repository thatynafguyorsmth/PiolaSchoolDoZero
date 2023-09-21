package com.piola.PiolaSchool.controller;

import com.piola.PiolaSchool.DAO.IProfessor;
import com.piola.PiolaSchool.model.Professor;
import com.piola.PiolaSchool.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Professor")
public class ProfessorController {

    @Autowired
    private IProfessor dao;
    @GetMapping
    public List<Professor> ProfessorList (){
        return (List<Professor>)dao.findAll();
    }
    @PostMapping
    public Professor criarProfessor(@RequestBody Professor professor){
        Professor ProfessorCreate =dao.save(professor);
        return ProfessorCreate;}
    @DeleteMapping("/{matricula}")
    public Optional<Professor> deletarProfessor(@PathVariable Integer matricula){
        Optional<Professor> Professor =dao.findById(matricula);
        dao.deleteById(matricula);
        return Professor;}}