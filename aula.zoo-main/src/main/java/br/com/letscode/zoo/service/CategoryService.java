package br.com.letscode.zoo.service;

import br.com.letscode.zoo.exception.NotFoundException;
import br.com.letscode.zoo.model.Animal;
import br.com.letscode.zoo.model.Category;
import br.com.letscode.zoo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> all() {
        return categoryRepository.findSortedHQL();
    }

    public Category findByUid(String uid) throws NotFoundException {
        List<Category> categories = categoryRepository.findByUid(uid);
        var dbCategory = categories.stream().findFirst();
        return dbCategory.orElseThrow(() -> new NotFoundException("Categoria "+ uid +" não encontrada."));
    }

}
