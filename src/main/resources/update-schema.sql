CREATE TABLE og_clientes
(
    id              RAW(16) NOT NULL,
    usuario         VARCHAR2(255) NOT NULL,
    senha           VARCHAR2(255) NOT NULL,
    nome_completo   VARCHAR2(255) NOT NULL,
    data_nascimento date NOT NULL,
    numero_telefone VARCHAR2(255) NOT NULL,
    email           VARCHAR2(255) NOT NULL,
    endereco_id     RAW(16) NOT NULL,
    CONSTRAINT pk_og_clientes PRIMARY KEY (id)
);

CREATE TABLE og_consultas
(
    id          RAW(16) NOT NULL,
    data        date NOT NULL,
    hora        DATE NOT NULL,
    cliente_id  RAW(16),
    dentista_id RAW(16) NOT NULL,
    CONSTRAINT pk_og_consultas PRIMARY KEY (id)
);

CREATE TABLE og_dentistas
(
    id              RAW(16) NOT NULL,
    nome_completo   VARCHAR2(255) NOT NULL,
    data_nascimento date NOT NULL,
    numero_telefone VARCHAR2(255) NOT NULL,
    email           VARCHAR2(255) NOT NULL,
    endereco_id     RAW(16) NOT NULL,
    CONSTRAINT pk_og_dentistas PRIMARY KEY (id)
);

CREATE TABLE og_enderecos
(
    id         RAW(16) NOT NULL,
    numero     VARCHAR2(10) NOT NULL,
    logradouro VARCHAR2(255) NOT NULL,
    cidade     VARCHAR2(100) NOT NULL,
    bairro     VARCHAR2(50) NOT NULL,
    pais       VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_og_enderecos PRIMARY KEY (id)
);

ALTER TABLE og_clientes
    ADD CONSTRAINT uc_og_clientes_email UNIQUE (email);

ALTER TABLE og_clientes
    ADD CONSTRAINT uc_og_clientes_endereco UNIQUE (endereco_id);

ALTER TABLE og_clientes
    ADD CONSTRAINT uc_og_clientes_numerotelefone UNIQUE (numero_telefone);

ALTER TABLE og_clientes
    ADD CONSTRAINT uc_og_clientes_usuario UNIQUE (usuario);

ALTER TABLE og_dentistas
    ADD CONSTRAINT uc_og_dentistas_email UNIQUE (email);

ALTER TABLE og_dentistas
    ADD CONSTRAINT uc_og_dentistas_endereco UNIQUE (endereco_id);

ALTER TABLE og_dentistas
    ADD CONSTRAINT uc_og_dentistas_numerotelefone UNIQUE (numero_telefone);

ALTER TABLE og_clientes
    ADD CONSTRAINT FK_OG_CLIENTES_ON_ENDERECO FOREIGN KEY (endereco_id) REFERENCES og_enderecos (id);

ALTER TABLE og_consultas
    ADD CONSTRAINT FK_OG_CONSULTAS_ON_CLIENTE FOREIGN KEY (cliente_id) REFERENCES og_clientes (id);

ALTER TABLE og_consultas
    ADD CONSTRAINT FK_OG_CONSULTAS_ON_DENTISTA FOREIGN KEY (dentista_id) REFERENCES og_dentistas (id);

ALTER TABLE og_dentistas
    ADD CONSTRAINT FK_OG_DENTISTAS_ON_ENDERECO FOREIGN KEY (endereco_id) REFERENCES og_enderecos (id);