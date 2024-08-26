package application.controller;

import application.model.Autor;
import application.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public String listarAutores(Model model) {
        model.addAttribute("autores", autorService.listarTodos());
        return "list"; // Página JSP para listar autores
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("autor", new Autor());
        return "form"; // Página JSP para adicionar/editar autores
    }

    @PostMapping("/salvar")
    public String salvarAutor(@ModelAttribute Autor autor) {
        autorService.salvar(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Autor autor = autorService.encontrarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("autor", autor);
        return "form"; // Página JSP para adicionar/editar autores
    }

    @GetMapping("/deletar/{id}")
    public String deletarAutor(@PathVariable("id") Long id) {
        autorService.deletar(id);
        return "redirect:/autores";
    }
}
