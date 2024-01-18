Файл README для данного класса может выглядеть следующим образом:

# ContactService

Класс ContactService предоставляет функциональность для работы с контактами. Вы можете отображать, добавлять и удалять контакты, а также сохранять их в файл.

## Установка и запуск

1. Склонируйте репозиторий на свой локальный компьютер.
2. Откройте проект в вашей любимой интегрированной среде разработки (IDE).
3. Установите необходимые зависимости, указанные в файле pom.xml.
4. Запустите приложение.

## Использование
Введите команду addContact
Введите данные контакта в формате: Фамилия Имя Отчество;Номер телефона;Email
Иванов Иван Иванович;+7 123 456 7890;ivanov@example.com
Контакт будет успешно добавлен

Введите команду displayContacts
Будет отображенс писок контактов

Введите команду deleteContactByEmail
Введите Email контакта, который нужно удалить:
ivanov@example.com
Контакт будет успешно удален.

Введите команду saveContactsToFile
Контакты будут успешно сохранены в файл.