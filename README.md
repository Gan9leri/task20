# 20. Мобильная автоматизация #1. Разрабатываем автотесты с Browserstack

1. Зарегистрировать аккаунт в browserstack.com
2. Запустить автотест локально
3. Разработать еще один автотест на открытие любой статьи
4. Разработать еще один автотест на iOS
5. Адаптировать TestBase / Driver для работы с двумя типами платформ - Android, iOS
6. Вынести данные (логин, пароль, урл браузерстека и т.д.) в .properties с owner
7. Сделать сборку в дженкинсе
  
Для запуска тестов на Android использовать команду ниже:
```shell
gradle clean test -Denv=GooglePixel6

```
