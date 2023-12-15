Файл README для данного класса может выглядеть следующим образом:

# ContactService

Класс ContactService предоставляет функциональность для работы с контактами. Вы можете отображать, добавлять и удалять контакты, а также сохранять их в файл.

## Установка и запуск

1. Склонируйте репозиторий на свой локальный компьютер.
2. Откройте проект в вашей любимой интегрированной среде разработки (IDE).
3. Установите необходимые зависимости, указанные в файле pom.xml.
4. Запустите приложение.

## Использование

### Методы

#### displayContacts

Этот метод отображает все контакты, которые были добавлены в список контактов. 
Если профиь загрузки указан init, контакты будут загружены из файла default-contacts.txt

#### addContact

Этот метод добавляет новый контакт в список контактов. Он принимает параметры в следующем формате: Имя, Фамилия, Email;Номер телефона;Email.
Параметры разделяются точкой с запятой (;). Новый контакт будет создан на основе переданных параметров и добавлен в список контактов.

#### deleteContactByEmail

Этот метод удаляет контакт из списка контактов на основе указанного Email. 
Если контакт с указанным Email не найден, будет возвращено соответствующее сообщение.

#### saveContactsToFile

Этот метод сохраняет все контакты из списка контактов в файл.
Путь к файлу определяется конфигурационным параметром "save.path". Если файл не существует, он будет создан. 
Если сохранение прошло успешно, метод вернет соответствующее сообщение. 