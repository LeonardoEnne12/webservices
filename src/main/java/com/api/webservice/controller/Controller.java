package com.api.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.webservice.models.sis_grupo;
import com.api.webservice.models.sis_usuario;
import com.api.webservice.repository.sis_grupo_repository;
import com.api.webservice.repository.sis_usuario_repository;

@RestController
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    private sis_usuario_repository userRepository; 

    @Autowired
    private sis_grupo_repository groupRepository;

    java.util.Date now = new java.util.Date();

    @RequestMapping(value = "/login", method = RequestMethod.POST )
    public void login(@RequestBody sis_usuario user)
    {
        
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST )
    public void Criar(@RequestBody sis_usuario user)
    {
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        user.setDataalteracao(sqlDate);
        user.setDatacriacao(sqlDate); 
        user.setGrupos(groupRepository.findAll());
        userRepository.save(user);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET )
    public List<sis_usuario> listar()
    {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET )
    public sis_usuario usuarioID(@PathVariable("id")int id)
    {

        for (sis_usuario user : userRepository.findAll()) {
            if (user.getId() == id) {
                return user;
            }
        } 
        
        return null;
    }

    @RequestMapping(value = "/grupo", method = RequestMethod.POST )
    public void Criar(@RequestBody sis_grupo group)
    {
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        group.setDataalteracao(sqlDate);
        group.setDatacriacao(sqlDate); 
        groupRepository.save(group);
    }

    @RequestMapping(value = "/grupo", method = RequestMethod.GET )
    public List<sis_grupo> listarGrupo()
    {
        return groupRepository.findAll();
    }

    @RequestMapping(value = "/grupo/{id}", method = RequestMethod.GET )
    public sis_grupo grupoID(@PathVariable("id")int id)
    {

        for (sis_grupo user : groupRepository.findAll()) {
            if (user.getId() == id) {
                return user;
            }
        } 
        
        return null;
    }
}
