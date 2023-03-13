package br.com.letscode.zoo.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryComponent {
    private static List<String> list = Collections.synchronizedList(
            new ArrayList() {{
                add("Mamífero");
                add("Peixe");
                add("Ave");
            }}
    );

    public CategoryComponent() {
    }

    public List<String> getList() {
        return list.stream().collect(Collectors.toList());
    }
}
