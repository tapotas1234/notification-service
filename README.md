# Сервис отправки уведомлений на почту

## Назначение

Считывает сообщение из кафки из топика email-notifications и 
отправляет уведомление на email из сообщения.

## 🚀 Быстрый старт

### Предварительные требования
- Docker Desktop запущен
- Java 17 (или OpenJDK 17)
- склонированный и запущенный репозиторий с БД и кафкой https://github.com/tapotas1234/infrastructure


### Запуск в development-режиме
```bash
# 1. Клонировать репозиторий
git clone git@github.com:tapotas1234/notification-service.git
cd notification-service

# 2. Запустить приложение
mvn spring-boot:run