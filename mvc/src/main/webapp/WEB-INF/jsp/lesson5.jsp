<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>AJAX</title>
    <body>
        <script type="text/javascript">
            function ajaxPost() {
                  var xhr = new XMLHttpRequest();
                  xhr.onreadystatechange = function() {
                        //Обработчики состояния соединения
                        if (xhr.readyState == 0) {
                         alert("Начальное состояние");
                         return;
                        }
                        if (xhr.readyState == 1) {
                         alert("Вызван open");
                         return;
                        }
                        if (xhr.readyState == 2) {
                         alert("Получены заголовки");
                         return;
                        }
                        if (xhr.readyState == 3) {
                         alert("Загружается тело (получен очередной пакет данных)");
                         return;
                        }
                        if (xhr.readyState == 4) {
                         alert("Запрос завершён");
                        }
                        //Выводим ответ от сервера
                        if (xhr.status == 200) {
                          alert(xhr.responseText);
                        }
                  }
                  xhr.open("POST", '/serverApp/lesson5', true);
                  //Обработчики событий
                  xhr.loadstart = function() {
                    alert("Запрос начат");
                  }
                  xhr.progress = function() {
                    alert("Браузер получил очередной пакет данных, можно прочитать текущие полученные данные в responseText");
                  }
                  xhr.abort = function() {
                    alert("Запрос был отменён вызовом xhr.abort()");
                  }
                  xhr.error = function() {
                    alert("Произошла ошибка");
                  }
                  xhr.load = function() {
                    alert("Запрос был успешно (без ошибок) завершён");
                  }
                  xhr.timeout = function() {
                    alert("Запрос был прекращён по таймауту");
                  }
                  xhr.loadend = function() {
                    alert("Запрос был завершён (успешно или неуспешно)");
                  }
                  xhr.send();
            }
        </script>
        <button onclick="ajaxPost()">Push me...</button>
        <br id="back"/>
        <a href="javascript:history.back();">Вернуться в Меню</a>
    </body>
</html>