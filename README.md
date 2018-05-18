# Persistencia-Dados-Java
Repositório com projetos de persistência de dados em java.

# Produto API
Para construir o banco referente a API, siga os passos abaixo:

Obs: Deve-se ter o MySQL instalado.

Passo 1: Acessar mysql:
- mysql -h localhost -u <usuario> -p
- senha: <senha>

Passo 2: criar database
CREATE DATABASE aulafaj;

Passo 3: criar tabela de produto
CREATE TABLE produto (
	id int not null,
	nome VARCHAR(255) not null,
	descricao VARCHAR(255) null,
	id_produto_pai int null
);

Passo 4: criar tabela de imagens 
CREATE TABLE imagem (
	id int not null,
	tipo VARCHAR(255) not null,
	id_produto int not null
);

Hora de começar...
