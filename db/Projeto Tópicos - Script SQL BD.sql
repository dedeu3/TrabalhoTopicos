CREATE TABLE usuario (
 id SERIAL NOT NULL,
 nomeCompleto VARCHAR(50) NOT NULL,
 email VARCHAR(30) NOT NULL,
 pin NUMERIC(4) NOT NULL,
 dataNascimento VARCHAR(10) NOT NULL,
 atrib1 VARCHAR(20) NOT NULL,
 atrib2 VARCHAR(20) NOT NULL,
 atrib3 VARCHAR(20) NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT PK_usuario PRIMARY KEY (id);


CREATE TABLE senha
(
  id integer NOT NULL,
  descricao character varying(20) NOT NULL,
  senha character varying(20) NOT NULL,
  CONSTRAINT pk_senha PRIMARY KEY (id),
  CONSTRAINT fk_senha_0 FOREIGN KEY (id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
