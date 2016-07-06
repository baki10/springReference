<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Aquarium</title>
    <script src="<c:url value="/resources/js/aquaScript.js" />"></script>
</head>
<body>
		<script type="text/javascript">
                  var aquarium = new Aquarium(5, 5, 1200, 1000)
                  var fish1 = new CurveFish(100, 20, 30);
                  var fish2 = new LinearFish(200, 200, 40);
                  var star1 = new Star(500, 300);
                  var fish3 = new CurveFish(800, 500, 60);
                  var star2 = new Star(1000, 700);
                  var fish4 = new LinearFish(50, 800, 25);
                  var fish5 = new CurveFish(10, 850, 50);

                  aquarium.addInhabitant(fish1);
                  aquarium.addInhabitant(fish2);
                  aquarium.addInhabitant(star1);
                  aquarium.addInhabitant(fish3);
                  aquarium.addInhabitant(star2);
                  aquarium.addInhabitant(fish4);
                  aquarium.addInhabitant(fish5);

                  aquarium.drawInhabitants();
                  aquarium.startMoving();
        </script>
</body>
</html>