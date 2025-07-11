package com.freddyzhounyc.databaseDemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Author {
    private Long id;
    private String name;
    private Integer age;
}
