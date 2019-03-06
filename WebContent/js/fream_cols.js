        
      function       preloadImg(src)         
      {         
      var       img=new       Image();         
      img.src=src         
      }         
      preloadImg("images/show.gif");         
            
      var       displayBar=true;         
      function       switchBar(obj)         
      {         
      if       (displayBar)         
      {         
      parent.document.all.txt.rows="0,*";         
      displayBar=false;         
      obj.src="images/show.gif";         
      obj.title="打开顶部页面";         
      }         
      else{         
      parent.document.all.txt.rows="83,*";         
      displayBar=true;         
      obj.src="images/display.gif";         
      obj.title="关闭顶部页面";         
      }         
      }         
            