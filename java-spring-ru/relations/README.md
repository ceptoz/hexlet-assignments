# Relations

В этом домашнем задании мы продолжим работать с статьями и категориями. Статьи связаны с категориями связью "многие к одному". В одной категории может быть множество статей, в то же время, статья всегда находится только в одной категории

## Ссылки

* [Аннотация @Entity – отмечает, что класс является моделью](https://docs.oracle.com/javaee/7/api/javax/persistence/Entity.html)
* [Аннотации @Getter и @Setter для автоматической генерации геттеров и сеттеров](https://projectlombok.org/features/GetterSetter)
* [Аннотация @ManyToOne — задаёт связь "многие к одному"](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/ManyToOne.html)
* [Аннотация @Lob — определяет, что содержимым поля может быть большой объект, например текст](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Lob.html)
* [Аннотация @Id — определяет первичный ключ сущности](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Id.html)
* [Аннотация @GeneratedValue — определяет автогенерацию для первичного ключа сущности](https://docs.oracle.com/javaee/7/api/javax/persistence/GeneratedValue.html)
* [Интерфейс CrudRepository – обеспечивает основные операции по поиску, сохранению и удалению данных](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)
* [Аннотации для привязки запросов к контроллерам и методам обработчика](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/package-summary.html)

## src/main/java/exercise/model/Category.java

## Задачи

* Модель категории уже создана. Изучите код в этом файле. Обратите внимание, что для генерации геттеров и сеттеров используется библиотека Lombok.

## src/main/java/exercise/model/Article.java

## Задачи

* В файле создайте класс `Article`, который будет представлять модель статьи. В классе укажите следующие поля:

  * `id` – первичный ключ, должен генерироваться автоматически
  * `name` – название статьи
  * `body` – содержание статьи
  * `category` – содержит связанную сущность `Category`, категорию, которой принадлежит статья. Статья связанна с категорией связью "многие к одному".

  Тип данных для полей класса выберите самостоятельно, опираясь на полученный опыт

* Добавьте в класс геттеры и сеттеры для манипуляции данными статьи.

* При помощи команды `make generate-migrations` сгенерируйте файл миграции.

## src/main/resources/db/changelog/changelog-master.xml

## Задачи

* Изучите получившийся файл миграции, посмотрите, какие таблицы будут создаваться и как связь сущностей отражается на таблицы

## src/main/java/exercise/controller/ArticlesController.java

## Задачи

* Добавьте метод, который обрабатывает POST-запросы на адрес */articles* и создаёт новую статью в базе данных. Данные приходят в JSON вида:

```json
{
  "name": "Category name",
  "body": "Category body",
  "category": {
    "id": 4
  }
}
```

* Создайте метод, который обрабатывает PATCH-запросы по пути */articles/{id}* и обновляет данные сущности.

* Создайте метод, который обрабатывает GET-запросы по пути */articles/{id}* и возвращает данные конкретной статьи по её id в виде JSON.

* Запустите приложение и попробуйте отправлять ему различные запросы при помощи POSTMAN. Убедитесь, что при просмотре конкретной статьи данные статьи содержат данные категории, которой принадлежит статья. Категории статей, которые добавляются в базу данных, можно посмотреть в файле *src/main/resources/import.sql*

## Подсказки

* Обратите внимание, что в классе модели импортирована библиотека Lombok. Вы можете использовать её аннотации, чтобы не писать геттеры и сеттеры вручную
