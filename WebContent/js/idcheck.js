// JavaScript Document

function check(a){
	
if(a.length!=18)
			{alert("您输入的身份证号码不是18位！");
			 return;
			}
						
			var g = new Array(18);
			for(var i=1;i<=19;i++){
			 g[i-1]=a.substring(i-1,i);			
			}
			  
			var jiaoyan = g[0]*7+g[1]*9+g[2]*10+g[3]*5+g[4]*8+g[5]*4+g[6]*2+g[7]*1+g[8]*6+g[9]*3+g[10]*7+g[11]*9+g[12]*10+g[13]*5+g[14]*8+g[15]*4+g[16]*2;						  
		
				jiaoyan %= 11;
				//alert(jiaoyan);
			    var mowei = g[17];
			    if(g[17]=="x"||g[17]=="X")
			    	mowei = 10;
			   
			    if(jiaoyan==0)
			    	if(mowei!=1)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==1)
			    	if(mowei!=0)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==2)
			    	if(mowei!=10)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==3)
			    	if(mowei!=9)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==4)
			    	if(mowei!=8)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==5)
			    	if(mowei!=7)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==6)
			    	if(mowei!=6)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==7)
			    	if(mowei!=5)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==8)
			    	if(mowei!=4)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==9)
			    	if(mowei!=3)
			    {alert("您输入的身份证号码有误！");
					return;}
			    if(jiaoyan==10)
			    	if(mowei!=2)
			    {alert("您输入的身份证号码有误！");
					return;}	
	           
	}
	
	