package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.Model_SecurityJv.model.forms;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/v1/forms")
public class formsController {

    /*
     * GET= obtener datos o consultar
     * POST = crear un registro
     * PUT = actualizacion total
     * PATCH = actualizacion parcial 
     * DELETE = eliminar
     */

     @Autowired
     private com.sena.Model_SecurityJv.service.formsServices formsServices;
     
     @GetMapping("/")
     public ResponseEntity<Object> findAllForms() {
        var ListForms=formsServices.findAllForms();
         return new ResponseEntity<Object>(ListForms,HttpStatus.OK);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Object> findByIdForms(@PathVariable int id) {
        var form=formsServices.findByIdForms(id);
        return new ResponseEntity<>(form,HttpStatus.OK);
     }
     
     @PostMapping("/")
     public String save(@RequestBody forms form) {
         formsServices.save(form);
         
         return "Registrar OK";
     }

   @PutMapping("/{id}")
   public String update(@PathVariable int id, @RequestBody forms form) {
       formsServices.update(id, form);
       return "Update OK";
   }
     
     @DeleteMapping("/{id}")
     public String delete(@PathVariable int id) {
        formsServices.delete(id);
        return "DELETE OK";
     }
     
}
