package application.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LivroController {

    @GetMapping("/livros/insert")
    public String showInsertPage(Model model) {
        return "insert"; // Mapeia para /webapp/livro/insert.jsp
    }

    @GetMapping("/livros/delete")
    public String showDeletePage(Model model) {
        return "delete"; // Mapeia para /webapp/livro/delete.jsp
    }

    @GetMapping("/livros/list")
    public String showListPage(Model model) {
        return "list"; // Mapeia para /webapp/livro/list.jsp
    }

    @GetMapping("/livros/update")
    public String showUpdatePage(Model model) {
        return "update"; // Mapeia para /webapp/livro/update.jsp
    }
}
