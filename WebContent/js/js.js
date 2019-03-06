// JavaScript Document
//时间
function getCurDate()
{
 var d = new Date();
 var week;
 switch (d.getDay()){
 case 1: week="星期一"; break;
 case 2: week="星期二"; break;
 case 3: week="星期三"; break;
 case 4: week="星期四"; break;
 case 5: week="星期五"; break;
 case 6: week="星期六"; break;
 default: week="星期天";
 }
 var years = d.getFullYear();
 var month = add_zero(d.getMonth()+1);
 var days = add_zero(d.getDate());
 var hours = add_zero(d.getHours());
 var minutes = add_zero(d.getMinutes());
 var seconds=add_zero(d.getSeconds());
 var ndate = years+"年"+month+"月"+days+"日 "+week+" "+hours+":"+minutes+":"+seconds;
 divT.innerHTML= ndate;
}

function add_zero(temp)
{
 if(temp<10) return "0"+temp;
 else return temp;
}

setInterval("getCurDate()",100);



$(document).ready(function() {	

      $(".b_left_bg li span").click(function(){

		if($(this).next().css('display')=='none')
		{
		    $(this).next().slideDown();
			$(this).parent().siblings().find('div').slideUp();
			
		}
		else
		{
			$(this).next().slideUp();
		}

		});
	  
});	

function getObject(objectId) {
	if(document.getElementById && document.getElementById(objectId)) {
	return document.getElementById(objectId);
	} else if (document.all && document.all(objectId)) {
	return document.all(objectId);
	} else if (document.layers && document.layers[objectId]) {
	return document.layers[objectId];
	} else {
	return false;
	}
	}
	
function menu(n){
	for(var i=1;i<=5;i++){
	if (i==n){
	getObject('menu'+i).className='menu'+i+'_1';
	getObject('menu'+i).parentNode.className='menu_clk';
    }
	else {
	getObject('menu'+i).className='menu'+i;
	getObject('menu'+i).parentNode.className='';
    }
	}
    }