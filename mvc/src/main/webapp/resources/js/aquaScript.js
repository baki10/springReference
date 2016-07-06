function extend(Child, Parent) {
  var F = function() { };
  F.prototype = Parent.prototype;
  Child.prototype = new F();
  Child.prototype.constructor = Child;
  Child.superclass = Parent.prototype;
}

//Интерфейс отрисовываемых объектов
function Paintable(x, y) {
  var img = document.createElement("img");
  img.style.position = "absolute";
  img.style.left = x;
  img.style.top = y;
  this.img = img;
  this.x = x;
  this.y = y;
}

//Класс Аквариум
function Aquarium(x, y, w, h) {
  Aquarium.superclass.constructor.call(this, x, y);
  this.img.style.width = w;
  this.img.style.height = h;
  this.w = w;
  this.h = h;
  this.img.style.backgroundColor = "Aqua";
  document.body.appendChild(this.img);
  //Жители аквариума
  this.inhabitants = [];
  //Добавляем жителей в аквариум (только с валидными координатами)
  this.addInhabitant = function(inhabitant) {
    if (inhabitant.x > this.x && (inhabitant.x + inhabitant.img.width) < this.w
      && inhabitant.y > this.y && (inhabitant.y + inhabitant.img.height) < this.h)
    {
      this.inhabitants.push(inhabitant);
      inhabitant.home = this;
    }
  }
  //Отрисовываем жителей аквариума
  this.drawInhabitants = function() {
    this.inhabitants.forEach(function(item) {
      document.body.appendChild(item.img);
    });
  }
  //Заставляем двигаться движимых жителей аквариума
  this.startMoving = function() {
    this.inhabitants.forEach(function(item) {
      if (item instanceof Movable) {
        setInterval(function(){item.move()}, item.delay);
      }
    });
  }
}
extend(Aquarium, Paintable);

//Класс Морская Звезда
function Star(x, y) {
  Star.superclass.constructor.call(this, x, y);
  this.img.src = "resources/images/starfish.png";
}
extend(Star, Paintable);

//Интерфейс движимых отрисовываемых объектов
function Movable(x, y, xexpr, yexpr, delay) {
  Movable.superclass.constructor.call(this, x, y);
  this.dx = 1;
  this.delay = delay;
  this.xexpr = !xexpr ? "x" : xexpr;
  this.yexpr = !yexpr ? "x" : yexpr;
  this.move = function() {
    //Если объект достигает стенки аквариума, разворачиваем его
    if (this.img.offsetLeft <= this.home.x) {
      this.dx = -this.dx;
      this.img.src = "resources/images/fish.png";
    }
    if ((this.img.offsetLeft + this.img.width) >= (this.home.x + this.home.w)) {
      this.dx = -this.dx;
      this.img.src = "resources/images/fish-back-icon.png";
    }
    x += this.dx;
    this.img.style.left = eval(xexpr);
    //Если объект достигает верха или дна аквариума, то ограничиваем его движение
    var yEval = eval(yexpr);
    if (yEval > this.home.y && (yEval + this.img.height) < (this.home.y + this.home.h)) {
      this.img.style.top = yEval;
    }
  }
}
extend(Movable, Paintable);

//Класс Рыба
function Fish(x, y, xexpr, yexpr, delay) {
  Fish.superclass.constructor.call(this, x, y, xexpr, yexpr, delay);
  this.img.src = "resources/images/fish.png";
}
extend(Fish, Movable);

//Класс Линейная Рыба
function LinearFish(x, y, delay) {
  LinearFish.superclass.constructor.call(this, x, y, "x", "this.img.style.top", delay);
}
extend(LinearFish, Fish);

//Класс Криволенейная Рыба
function CurveFish(x, y, delay) {
  CurveFish.superclass.constructor.call(this, x, y, "x", "y + 50 * Math.sin(0.03 * x)", delay);
}
extend(CurveFish, Fish);