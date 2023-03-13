package br.com.letscode.zoo.controller;

import br.com.letscode.zoo.component.CategoryComponent;
import br.com.letscode.zoo.dto.CategoryDTO;
import br.com.letscode.zoo.dto.FactoryDTO;
import br.com.letscode.zoo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category-component")
@AllArgsConstructor
public class CategoryComponentController {
    private CategoryComponent categoryComponent;

    @GetMapping("/list")
    public List<String> list() {
        return categoryComponent.getList();
    }
}
