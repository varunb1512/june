Финальный проект по курсу
Задача:
Реализовать полный цикл сборки-поставки приложения, используя
практики CI/CD.

Работа представляет из себя следующее:
При переходе по ссылке по адресу, выводится такая страница.
![image](https://github.com/user-attachments/assets/a20253aa-d3a5-4a41-b64d-3ab0213762ec)

При пушах в репо, автоматически запускается сборка, версионирование и деплой.

В качестве инструмента был выбран Github Actions.
Секреты хранятся в Github Actions secrets.
Разуемеется, мониторинг и логирование тоже настроены. В качестве стека использовано: Prometheus + Grafana, для инфрастурных логов используется ELK стек.
Структура проекта:
```
root@Codeby:~/ex# tree
.
└── java-hello-world-with-maven
    ├── Dockerfile
    ├── README.md
    ├── id_github_ci
    ├── id_github_ci.pub
    ├── pom.xml
    ├── src
    │   └── main
    │       └── java
    │           ── com
    │              └── example
    │                  └── helloweb
    │                      ├── HelloController.java
    │                      └── HelloWebApplication.java
    │           
    └── target
        ├── classes
        │   └── com
        │       └── example
        │           └── helloweb
        │               ├── HelloController.class
        │               └── HelloWebApplication.class
        ├── generated-sources
        │   └── annotations
        ├── java-hello-web-0.1.0.jar
        ├── java-hello-web-0.1.0.jar.original
        ├── maven-archiver
        │   └── pom.properties
        └── maven-status
            └── maven-compiler-plugin
                └── compile
                    └── default-compile
                        ├── createdFiles.lst
                        └── inputFiles.lst

20 directories, 14 files
```
 Как разворачивается
Разработчик пушит изменения в ветку master GitHub-репозитория.
Запускается GitHub Actions workflow (.github/workflows/ci-cd.yaml), где:
Устанавливается JDK 17.
Выполняется сборка проекта с помощью Maven (mvn clean package).
Строится Docker-образ через Dockerfile.
Образ пушится на Docker Hub с двумя тегами:
latest — всегда самый свежий
commit-hash (например b3a2d1f) — версия, привязанная к коммиту.
Через SSH подключение GitHub Actions подключается к удаленному серверу и:
Скачивает последний образ
Удаляет старый контейнер (если есть)
Запускает новый контейнер на порту 8080.

This guide walks you through using Maven to build a simple Java project.

Версионирование
При каждом пуше:
создается тег IMAGE_TAG=${GITHUB_SHA::7} — это первые 7 символов SHA коммита.
пример: java-hello-world:b3a2d1f
Также добавляется тег latest для последней стабильной сборки.
Таким образом, можно:
Всегда иметь стабильную ссылку на последнюю версию (latest)
Иметь уникальную ссылку на конкретную сборку (commit_sha), которую легко откатить или протестировать.

Dockerfile:
Первый этап (stage build) использует Maven для сборки .jar.
Второй этап использует openjdk:17, в него копируется уже собранный .jar.
Приложение запускается с помощью команды java -jar app.jar.

Как устроен мониторинг?
Мониторинг построен на базе Prometheus и Grafana, с использованием Node Exporter для сбора метрик с хоста.
Node Exporter запускается как контейнер и отдаёт системные метрики по адресу :9100. Prometheus по расписанию (каждые 15 секунд) делает HTTP scrape на адрес node-exporter:9100/metrics. Метрики сохраняются во внутреннюю базу данных Prometheus. Grafana подключается к Prometheus как источник данных и отображает метрики на дашборде.
![image](https://github.com/user-attachments/assets/ceb62c09-4f4f-4c96-a80e-ef65a4a9b29f)



