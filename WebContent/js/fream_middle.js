  function preloadImg(src)         
      {         
      var img=new Image();         
      img.src=src         
      }         
      preloadImg("images/fream_middle_img.gif");         
            
      var       displayBar=true;         
      function switchBar(obj)         
      {         
      if       (displayBar)         
      {         
      parent.document.all.mainFrame.cols="0,8,*";         
      displayBar=false;         
      obj.src="images/fream_middle_img1.gif";         
      obj.title="打开左面管理菜单";         
      }         
      else{         
      parent.document.all.mainFrame.cols="192,8,*";         
      displayBar=true;         
      obj.src="images/fream_middle_img.gif";         
      obj.title="关闭左面管理菜单";         
      }         
      }         