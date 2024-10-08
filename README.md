# Получение максимального n-го числа из Excel файла
Приложение принимает запрос с путем к локальному Excel-файлу, содержащему целые числа в одном столбце и число N. 
Результатом является N-ное максимальное число.
В качестве алгоритма сортировки используется "Быстрая сортировка"

# Этапы сборки и запуска приложения
1. Клонирование репозитория
```shell
git clone https://github.com/EKoregin/getMaxNum.git
```
2. Собрать Maven проект и создать jar
```shell
cd getMaxNum/
mvn package
```
3. Запустить jar-файл
```shell
java -jar target/getMaxNum-0.0.1-SNAPSHOT.jar
```


# Работа приложения
Приложение запускается на порту: 8081

Для использования приложения нужно сделать POST-запрос с параметрами: path и nnum:
где 
* path - это абсолютный путь к файлу формата  *.xlsx (Excel),
* nnum - N-ное максимальное число из файла.

Например используя  curl.
```shell
curl --location --request POST 'localhost:8081/getMaxNumber?path=/home/evgeny/source.xlsx&nnum=2'
```

Или использовать Swagger по адресу
```shell
http://localhost:8081/swagger-ui/index.html
```