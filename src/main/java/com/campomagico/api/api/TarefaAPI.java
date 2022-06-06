package com.campomagico.api.api;

import com.campomagico.api.methods.TarefaMethod;
import com.campomagico.api.model.TarefaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefaAPI {

    @Autowired
    private TarefaMethod tarefaMethod;

    @PostMapping
    @ResponseBody
    public TarefaModel create(@RequestBody TarefaModel tarefaModel){
        return tarefaMethod.create(tarefaModel);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaModel update(@PathVariable("tarefaId") Long tarefaId, @RequestBody TarefaModel tarefaModel){
        return tarefaMethod.update(tarefaModel, tarefaId);
    }

    @GetMapping
    @ResponseBody
    public List<TarefaModel> getAll(){
        return tarefaMethod.getAll();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String delete(@PathVariable("tarefaId") Long tarefaId){
        return tarefaMethod.delete(tarefaId);
    }
}
