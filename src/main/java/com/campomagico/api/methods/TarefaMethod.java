package com.campomagico.api.methods;

import com.campomagico.api.model.TarefaModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefaMethod {
    private static final Map<Long, TarefaModel> tarefa = new HashMap<>();

    public TarefaModel create (TarefaModel tarefaModel){
        Long nextId = tarefa.keySet().size() + 1L;
        tarefaModel.setId(nextId);
        tarefa.put(nextId, tarefaModel);
        return tarefaModel;
    }

    public TarefaModel update (TarefaModel tarefaModel, Long tarefaId){
        tarefa.put(tarefaId, tarefaModel);
        return tarefaModel;
    }

    public TarefaModel getById (Long tarefaId){
        return tarefa.get(tarefaId);
    }

    public List<TarefaModel> getAll(){
        return new ArrayList<>(tarefa.values());
    }

    public String delete(Long tarefaId){
        tarefa.remove(tarefaId);
        return "SUCESSFULLY DELETED";
    }
}
