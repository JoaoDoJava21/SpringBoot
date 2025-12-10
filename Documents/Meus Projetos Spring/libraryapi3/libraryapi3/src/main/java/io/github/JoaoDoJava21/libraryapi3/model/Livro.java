package io.github.JoaoDoJava21.libraryapi3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn" , length = 20 , nullable = false)
    private String isbn;

    @Column(name = "titulo" , length = 150 , nullable = false)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero" , length = 30 , nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco" , precision = 18 , scale = 2)
    private BigDecimal preco;


    @ManyToOne // Muitos livros para um autor, o autor pode ter um ou mais livros
    @JoinColumn(name = "id_autor")
    private Autor autor;
}
