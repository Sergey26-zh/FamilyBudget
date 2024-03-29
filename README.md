# Использованные технологии
* Spring Boot – как основной фрэймворк
* PostgreSQL – как основная реляционная база данных
* HTML, JS - фронтенд

# Запуск Базы Данных в Docker

Для локального развертывания базы данных рекомендуется использовать Docker и Docker Compose. Следуйте инструкциям ниже для запуска базы данных:

1. Перейдите в корневой каталог проекта, где находится файл `docker-compose.yml`.

2. Запустите следующую команду в терминале:

   ```bash
   docker-compose up -d

 # Как начать работу?

`git clone --recurse-submodules https://github.com/Sergey26-zh/FamilyBudget.git`

# Как запустить локально?
Сначала нужно развернуть базу данных

Далее собрать gradle проект

 Нужно запустить из корневой директории, где лежит build.gradle.kts
```
gradle build
```
Запустить jar'ник
```
java -jar build/libs/FamilyBudget - 0.0.1-SNAPSHOT.jar
```
Но легче всё это делать через IDE

# Код 
* Backend: Обычная трёхслойная архитектура – [Controller](src/main/java/com/example/familybudget/controller), [Service](src/main/java/com/example/familybudget/service), [Repository](src/main/java/com/example/familybudget/repository)
* Frontend: [resources](src/main/resources/static)
