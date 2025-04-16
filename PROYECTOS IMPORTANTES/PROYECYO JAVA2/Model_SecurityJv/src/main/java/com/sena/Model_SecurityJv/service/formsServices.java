package com.sena.Model_SecurityJv.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IForms;
import com.sena.Model_SecurityJv.model.forms;

@Service
public class formsServices {

    @Autowired
    private IForms FormsData;

    public List<forms> findAllForms(){
        return FormsData.findAll();
        
    }

    public Optional<forms> findByIdForms(int id){
        return FormsData.findById(id); 
    }

    public void save(forms form){
        FormsData.save(form);
    }

    public void update(int id, forms formUpdate){
        var form = findByIdForms(id);
        if (form.isPresent()){
             form.get().setName(formUpdate.getName());//Con eso se cambia el nombre, por el que tiene
             FormsData.save(form.get());
            }
    }
 
    public void delete(int id){
        var form = findByIdForms(id);
        if (form.isPresent/*trae un boleano*/()) { 
            FormsData.delete(form.get());
        }
    }
   
}
