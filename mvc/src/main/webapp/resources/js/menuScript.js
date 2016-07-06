var n = -1;
var table = document.createElement("table");

function addButton() {
    var element = document.createElement("input");
    element.type = "button";
    element.id = "createButton";
    element.value = "Create menu";
  	element.setAttribute("onclick","createMenu();");

    document.body.appendChild(element);
}

function createMenu() {
		var menu = document.getElementById('menuList');
		table.innerHTML = "";
    var count = prompt("Enter menu size", "");
    if(count.length == 0){
      	alert( "You did NOT enter number!" );
      	return;
    }
    if (isNaN(count)||count.split(".").length > 1) {
      	alert( "NOT INTEGER!" );
      	return;
    }
    n = parseInt(count);
    if (n < 1){
    		alert( "Enter positive number!");
    		return;
    }
    document.body.removeChild(document.getElementById('createButton'));

    for (var i = 0; i < n; i++) {
     		var row = table.insertRow(i);
        var cell = row.insertCell(0);
    		cell.id = (i + 1);
				cell.innerHTML = (i + 1);
				cell.style = "cursor:hand;";
				cell.style.backgroundColor=getRandomColor();
				cell.style.width = '25pt';
				cell.style.textAlign = 'center';
				cell.setAttribute("onclick","showSubMenu(event);");
    }
    menu.appendChild(table);
}

function showSubMenu(e){
		var cellId = e.currentTarget.id
		var level = cellId.split(".").length;
		if(n <= level){
				alert("Nothing to show!")
				return;
		}
		for(var i = 0; i < n; i++){
				var row = table.rows[i];
				var cell = row.insertCell(level);
       	cell.id = cellId+"."+(i + 1);
      	cell.innerHTML = cellId+"."+(i + 1);
     		cell.style = "cursor:hand;";
       	cell.style.backgroundColor=e.currentTarget.style.backgroundColor;
       	cell.style.width = '25pt';
       	cell.style.textAlign = 'center';
       	cell.setAttribute("onclick","showSubMenu(event);");
		}
		for(var j = 0; j < n; j++){
    		var row = table.rows[j];
    		var cellLength = row.cells.length;
    		if(cellLength > level){
    				var k = level+1;
    				while(k < cellLength){
    						row.deleteCell(k);
    						cellLength = row.cells.length;
    				}
    		}
    }
}

function getRandomColor(){
		var letters = '0123456789ABCDEF'.split('');
   	var color = '#';
		for (var i = 0; i < 6; i++ ) {
 				color += letters[Math.floor(Math.random() * 16)];
   	}
    return color;
}