CREATE TABLE emprestimos(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
livro_id BIGINT NOT NULL,
usuario_id BIGINT NOT NULL,
data_emprestimo DATE NOT NULL,
data_devolucao DATE,
data_devolucao_prevista DATE NOT NULL,

FOREIGN KEY (livro_id) REFERENCES livros(id) ON DELETE RESTRICT,
FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE RESTRICT
);