<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Замыкания</title>
    <body>
        <ul>
            <li><a>Ссылка №1</a></li>
            <li><a>Ссылка №2</a></li>
            <li><a>Ссылка №3</a></li>
        </ul>
        <script type="text/javascript">
            //Ссылки
            var links = document.body.getElementsByTagName("a");

            //переменная i сохраняется в объекте window, поэтому при вызове функции мы считываем уже
            //инкрементированное значение
    //      for (var i = 1; i <= links.length; i++) {
    //        links[i].onclick = function () {
    //          alert(i);
    //        }
    //      }

            //внутри function(i) создается объект LexicalEnvironment, где переопределяется и сохраняется переменная i
            //при вызове функции ее и считываем
            for (var i = 0; i < links.length; i++) {
              links[i].onclick = function(i) {
                return function() {
                  return alert(i + 1);
                };
              }(i);
            }
        </script>
        <br id="back"/>
        <a href="javascript:history.back();">Вернуться в Меню</a>
    </body>
</html>