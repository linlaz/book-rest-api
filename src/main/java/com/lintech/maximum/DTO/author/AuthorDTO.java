package com.lintech.maximum.DTO.author;

import com.lintech.maximum.DTO.book.BookDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class AuthorDTO {

    private Long id;
    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "invalid Name : Name is null")
    @Size.List({
            @Size(min = 2, message = "{validation.name.size.too_short}"),
            @Size(max = 10, message = "{validation.name.size.too_long}")
    })
    private String name;
    @NotBlank(message = "Invalid description author: Empty description author")
    @NotNull(message = "invalid description author : description author is null")
    @Size.List({
            @Size(min = 2, message = "{validation.desc.size.too_short}"),
            @Size(max = 10, message = "{validation.desc.size.too_long}")
    })
    private String desc;

    List<BookDTO> books;
}
