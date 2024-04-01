# Desafio de Desenvolvimento: Gerenciador de Tarefas Simples

## Objetivos

Criar um aplicativo web simple que permitea aos usuários criar, visualizar, editar e excluir tarefas.
O foco deve estar na simplicidade e funcionalidade, proporcionando uma interface limpa e uma experiência de usuário intuitiva.

## Requesitos Básicos:

### Backend:

* API para gerenciar as tarefas (criar, ler, atualizar, deletar - CRUD).
* Armazenamento persistente das tarefas (pode ser um banco de dados simples).

## Repositorio do Backend

```gitub
https://github.com/maxsanttos/desafiobackend
```

## Links e Comandos

### Links

Github:

projeto mysql:

```dockerhub
docker pull maxsanttos/mysql:max
```

projeto backend:

```dockerhub
docker pull maxsanttos/backend:gerenciador
```

### Comandos

Criando uma rede somente para o desafio no docker.

```docker
docker network create development
docker network ls
```

Baixando os projetos

```docker
docker pull maxsanttos/mysql:max

docker pull maxsanttos/backend:gerenciador
```

Rodando o mysql e o gerenciador

```docker

docker run -d --name mysql --network development -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=desafio maxsanttos/mysql:max

docker run -d --name gerenciador --network development
maxsanttos/backend:gerenciador
```

## Repositorio Front

## Requesitos Básicos frontend:

### Frontend

Uma página para listar todas as tarefas, mostrando seu título e status (completa/incompleta).
Formulário para adicionar uma nova tarefa.
Opção para marcar uma tarefa como completa ou incompleta.
Capacidade de editar o título de uma tarefa.
Botão para excluir uma tarefa.

```github
https://github.com/maxsanttos/gerenciadorAngular
```

### Link do front

```versel
https://gerenciador-angular.vercel.app

```
