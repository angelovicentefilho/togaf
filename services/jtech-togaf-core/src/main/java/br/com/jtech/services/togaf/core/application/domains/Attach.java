package br.com.jtech.services.togaf.core.application.domains;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Attach {
    private Long id;
    private String filename;
    private String type;
    private Long size;
    private byte[] content;
    private Phase phase;
}
