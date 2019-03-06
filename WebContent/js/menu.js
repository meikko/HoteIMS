function getObject(objectId)
{
	if(document.getElementById && document.getElementById(objectId))
	{
		return document.getElementById(objectId);
	}
	else if (document.all && document.all(objectId))
	{
		return document.all(objectId);
	}
	else if (document.layers && document.layers[objectId])
	{
		return document.layers[objectId];
	}
	else
	{
		return false;
	}
}
var checkedNavID = "01";
var changeNavType = 0; //显示方式 //1 //0 NavIndex

function _onmouseover(id)
{
	if(checkedNavID == id) return;

	var e = eval("document.getElementById('_div_"+ id + "')");
	e.className="nav_column_light";
}

function _onmouseout(id)
{
	if(checkedNavID == id) return;

	var e = eval("document.getElementById('_div_"+ id + "')");
	e.className="nav_column_dark";
}


function changeNav()
{
	if(changeNavType == 0)
	{
		document.getElementById("divNav").style.display = "none";
		document.getElementById("divNavIndex").style.display = "";

		changeNavType = 1;
		document.getElementById("title1").innerHTML = '菜&nbsp;&nbsp;单';
	}
	else
	{
		document.getElementById("divNavIndex").style.display = "none";
		document.getElementById("divNav").style.display = "";
		changeNavType = 0;
		document.getElementById("title1").innerHTML = '最小化';
	}
}

function initNav()
{
	var e = eval("document.getElementById('_div_"+ checkedNavID + "')");
	e.className="nav_column_light";
	changeNav();
	
	document.getElementById("frameColumnNav").src = "menu_outlook_menu.html";
}
function checkNav(id)
{
	var e = eval("document.getElementById('_div_"+ checkedNavID + "')");
	e.className="nav_column_dark";

	checkedNavID = id;
	var e = eval("document.getElementById('_div_"+ id + "')");
	e.className="nav_column_light";

	document.getElementById("frameColumnNav").src = "menu_outlook_menu.html" ;
}