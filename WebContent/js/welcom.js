
            function statusMessageObject(p,d) {
            this.msg = MESSAGE
            this.out = " "
            this.pos = POSITION
            this.delay = DELAY
            this.i = 0
            this.reset = clearMessage
            }
            function clearMessage() {
            this.pos = POSITION
            }
            var POSITION = 100
            var DELAY = 5
            var MESSAGE = "欢迎"
            var scroll = new statusMessageObject()
            function scroller() {
            for (scroll.i = 0; scroll.i < scroll.pos; scroll.i++) {
            scroll.out += " "
            }
            if (scroll.pos >= 0)
            scroll.out += scroll.msg
            else scroll.out = 
            scroll.msg.substring(-scroll.pos,scroll.msg.length)
            window.status = scroll.out
            scroll.out = " "
            scroll.pos--
            if (scroll.pos < -(scroll.msg.length)) {
            scroll.reset()
            }
            setTimeout ('scroller()',scroll.delay)
            }
            function snapIn(jumpSpaces,position) {
            var msg = scroll.msg
            var out = ""
            for (var i=0; i<position; i++)
            {out += msg.charAt(i)}
            for (i=1;i<jumpSpaces;i++)
            {out += " "}
            out += msg.charAt(position)
            window.status = out
            if (jumpSpaces <= 1) {
            position++
            if (msg.charAt(position) == ' ')
            {position++ }
            jumpSpaces = 100-position
            } else if (jumpSpaces > 3)
            {jumpSpaces *= .75}
            else
            {jumpSpaces--}
            if (position != msg.length) {
            var cmd = "snapIn(" + jumpSpaces + "," + position + ")";
            scrollID = window.setTimeout(cmd,scroll.delay);
            } else {
            window.status=""
            jumpSpaces=0
            position=0
            cmd = "snapIn(" + jumpSpaces + "," + position + ")";
            scrollID = window.setTimeout(cmd,scroll.delay);
            return false
            }
            return true
            }
            snapIn(100,0);
