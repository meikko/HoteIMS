
var table=document.body.getElementsByTagName("table")
var odiv=new Array();
for(i=0;i<table.length;i++){
if(table[i].style.display=="none"){
odiv.push(table[i])
}
}
function hideAll() { 
  for(i=0;i<odiv.length;i++) 
  { 
    odiv[i].style.display="none"; 
  } 
}  
function showObj(num)  
{ 
  if(odiv[num]==null)
	return;
  if (odiv[num].style.display=="none")  
  { 
    hideAll(); 
    odiv[num].style.display="inline"; 
  } 
  else { 
    odiv[num].style.display="none"; 
  } 
} 
