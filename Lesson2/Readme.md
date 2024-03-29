Учёт студентов

## Описание
Сервис позволяет добавлять, удалять и получать информацию о студентах.

## Настройка

Для настройки сервиса доступны следующие параметры:

-  `app.createStudentsOnStartup`  - указывает, нужно ли создавать студентов при запуске приложения. Значение по умолчанию -  `false` .
-  `app.numberOfStudents`  - указывает количество студентов, которое нужно создать при запуске приложения. Значение по умолчанию -  `0` .

Вы можете изменить эти параметры в файле  `application.properties`  вашего приложения.

## Использование

### Добавление студента

Чтобы добавить нового студента, вызовите метод  `add-student`  
### Удаление студента

Чтобы удалить студента по его идентификатору, вызовите метод  `remove-student`  и передайте идентификатор студента.
### Получение списка всех студентов

Чтобы получить список всех студентов, вызовите метод  `get-allStudents` 
## Запуск приложения

Приложение автоматически создаст студентов при запуске, если параметр  `app.createStudentsOnStartup`  установлен в  `true` . 
Количество создаваемых студентов можно настроить с помощью параметра  `app.numberOfStudents` .

## Docker

Для создания образа в консоли вводим команду `docker image build -t app .`
Для запуска приложения используем команду ` docker run -it  app `
