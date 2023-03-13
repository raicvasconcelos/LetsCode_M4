package br.com.letscode.zoo.controller;

import br.com.letscode.zoo.dto.CategoryDTO;
import br.com.letscode.zoo.dto.FactoryDTO;
import br.com.letscode.zoo.exception.NotFoundException;
import br.com.letscode.zoo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category-db")
@AllArgsConstructor
public class CategoryDBController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDBController.class);
    private CategoryService categoryService;

    @Operation(summary = "Lista todas das categorias da base de dados.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Dados de todas as categorias encontradas."
            )
    })
    @GetMapping("/list")
    public List<CategoryDTO> list() {
        return categoryService.all().stream()
                .map(FactoryDTO::entityToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{uid}")
    public ResponseEntity<CategoryDTO> getByUid(@PathVariable(value = "uid") String uid) {
        try {
            return ResponseEntity.ok(FactoryDTO.entityToDTO(
                    categoryService.findByUid(uid)
            ));
        } catch (NotFoundException e) {
            LOGGER.warn(e.toString());
            return ResponseEntity.notFound().build();
        }
    }
}
