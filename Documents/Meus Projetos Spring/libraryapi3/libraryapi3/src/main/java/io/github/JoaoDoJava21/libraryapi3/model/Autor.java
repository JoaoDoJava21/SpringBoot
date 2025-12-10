package io.github.JoaoDoJava21.libraryapi3.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// A regra deve ser a mesma da tabela , nomes iguais tão quanto tabela tão quanto atributos

// Se Colocar @Entity vai funcionar sem @Table , agora se colocar sem @Entity não vai funcionar pois ele é obrigatório
@Entity // Criamos a nossa entidade [Bloco grande]
@Table(name = "autor" , schema = "public") // Mesmo nome da tabel criada do banco de dados
@Getter
@Setter
public class Autor {

    @Id // Para identificar a Primary key
    @Column(name = "id") // Nome da coluna no banco
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome" , length = 100 , nullable = false)
    private String nome;

    @Column(name = "data_nascimento" , nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade" , length = 50 , nullable = false )
    private String nacionalidade;

   @OneToMany(mappedBy = "autor") // Um autor para muitos livros , faz que a JPA saiba que não e uma coluna . Precisa mapear com a outra propriedade
   // MappedBy com outro Many , o mappedBy vai dizer que não tem essa coluna aqui é apenas um mapeamento onetomany
   private List<Livro> livros;





}
