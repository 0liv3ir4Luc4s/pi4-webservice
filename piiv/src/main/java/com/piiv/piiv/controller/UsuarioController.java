package com.piiv.piiv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piiv.piiv.entities.Usuario;
import com.piiv.piiv.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UsuarioController {

  @Autowired
  UsuarioRepository usuarioRepository;

  @GetMapping("/users")
  public ResponseEntity<List<Usuario>> getAllUsers() {
    try {
      List<Usuario> users = new ArrayList<Usuario>();

      usuarioRepository.findAll().forEach(users::add);
     
      if (users.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(users, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Usuario> getUserById(@PathVariable("id") long id) {
    Optional<Usuario> userData = usuarioRepository.findById(id);

    if (userData.isPresent()) {
      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/users")
  public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
    try {
      Usuario _user = usuarioRepository
          .save(new Usuario(user.getLogin(), user.getSenha(), user.getNome(), true, user.getDataNascimento(), user.getDataCadastro(), false));
      return new ResponseEntity<>(_user, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario user) {
    Optional<Usuario> userData = usuarioRepository.findById(id);

    if (userData.isPresent()) {
    	Usuario _user = userData.get();
    	_user.setLogin(user.getLogin());
    	_user.setSenha(user.getSenha());
    	_user.setNome(user.getNome());
    	_user.setAtivo(user.getAtivo());
    	_user.setDataNascimento(user.getDataNascimento());
    	_user.setDataCadastro(user.getDataCadastro());
      return new ResponseEntity<>(usuarioRepository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @PatchMapping("/users/{id}/admin")
  public ResponseEntity<Usuario> toggleOnUserAsAdmin(@PathVariable("id") long id) {
    Optional<Usuario> userData = usuarioRepository.findById(id);

    if (userData.isPresent()) {
    	Usuario _user = userData.get();
    	_user.setIsAdmin(true);
      return new ResponseEntity<>(usuarioRepository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/users/{id}/admin")
  public ResponseEntity<Usuario> toggleOffUserAsAdmin(@PathVariable("id") long id) {
    Optional<Usuario> userData = usuarioRepository.findById(id);

    if (userData.isPresent()) {
    	Usuario _user = userData.get();
    	_user.setIsAdmin(false);
      return new ResponseEntity<>(usuarioRepository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @PatchMapping("/users/{id}/activate")
  public ResponseEntity<Usuario> activateUser(@PathVariable("id") long id) {
    Optional<Usuario> userData = usuarioRepository.findById(id);

    if (userData.isPresent()) {
    	Usuario _user = userData.get();
    	_user.setAtivo(true);
      return new ResponseEntity<>(usuarioRepository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/users/{id}/activate")
  public ResponseEntity<Usuario> deactivateUser(@PathVariable("id") long id) {
    Optional<Usuario> userData = usuarioRepository.findById(id);

    if (userData.isPresent()) {
    	Usuario _user = userData.get();
    	_user.setAtivo(false);
      return new ResponseEntity<>(usuarioRepository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
    try {
      usuarioRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/users")
  public ResponseEntity<HttpStatus> deleteAllUsers() {
    try {
      usuarioRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}