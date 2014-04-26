package br.com.aprendendospringmvc.controllers;

import br.com.aprendendospringmvc.entity.Tarefa;
import br.com.aprendendospringmvc.repository.impl.ListInMemoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by ellison on 24/04/14.
 */
@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    @RequestMapping(value = "new")
    public String form() {
        return "tarefa/form";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@Valid Tarefa tarefa, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "redirect:new";
        }

        tarefa.salvar();

        model.addAttribute("tarefa", tarefa);

        return "tarefa/confirm";
    }

    @RequestMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("tarefas", ListInMemoryRepository.getInstance().listAll());

        return "tarefa/list";
    }

    @RequestMapping(value = "remover", method = RequestMethod.GET)
    public String remover(Tarefa tarefa) {
        ListInMemoryRepository.getInstance().remove(tarefa);
        return "forward:list";
    }

}
