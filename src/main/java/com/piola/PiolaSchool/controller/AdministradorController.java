package com.piola.PiolaSchool.controller;

import com.piola.PiolaSchool.DAO.IAdministrador;
import com.piola.PiolaSchool.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Administrador")
public class AdministradorController  {

    @Autowired
    private IAdministrador dao;
    @GetMapping
    public List<Administrador> administradorList (){
return (List<Administrador>)dao.findAll();
    }
    @PostMapping
    public Administrador criarAdministrador(@RequestBody Administrador admiministrador){
        Administrador administradorCreate =dao.save(admiministrador);
        return administradorCreate;}
    @DeleteMapping("/{matricula}")
    public Optional<Administrador> deletarAdministrador(@PathVariable Integer matricula){
            Optional<Administrador> administrador =dao.findById(matricula);
            dao.deleteById(matricula);
            return administrador;
    }

}

