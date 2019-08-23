layui.use('layim', function(layim){
  //基础配置
  var id = 1;
  layim.config({

    init: {
      url:'/user/info'
      ,type:'get'
      ,data:{
        id:id
      }
    } //获取主面板列表信息，下文会做进一步介绍
    ,brief:false
    ,title:"nihao"
    ,min:true
    //获取群员接口（返回的数据格式见下文）
    ,members: {
      url: '' //接口地址（返回的数据格式见下文）
      ,type: 'get' //默认get，一般可不填
      ,data: {} //额外参数
    }

    //上传图片接口（返回的数据格式见下文），若不开启图片上传，剔除该项即可
    ,uploadImage: {
      url: '' //接口地址
      ,type: 'post' //默认post
    }

    //上传文件接口（返回的数据格式见下文），若不开启文件上传，剔除该项即可
    ,uploadFile: {
      url: '' //接口地址
      ,type: 'post' //默认post
    }
    //扩展工具栏，下文会做进一步介绍（如果无需扩展，剔除该项即可）
    ,tool: [{
      alias: 'code' //工具别名
      ,title: '代码' //工具名称
      ,icon: '&#xe64e;' //工具图标，参考图标文档
    }]

    ,msgbox: layui.cache.dir + 'css/modules/layim/html/msgbox.html' //消息盒子页面地址，若不开启，剔除该项即可
    ,find: layui.cache.dir + 'css/modules/layim/html/find.html' //发现页面地址，若不开启，剔除该项即可
    ,chatLog: layui.cache.dir + 'css/modules/layim/html/chatlog.html' //聊天记录页面地址，若不开启，剔除该项即可
  });
  //建立WebSocket通讯
  //注意：如果你要兼容ie8+，建议你采用 socket.io 的版本。下面是以原生WS为例
    var host = window.location.host;
    var socket = null;
    console.log(host)
  if ('WebSocket' in window) {
    socket = new WebSocket("ws:" + host + "/ws/de");
  } else {
    alert('当前浏览器 Not support websocket')
  }
  //连接成功建立的回调方法
  socket.onopen = function() {
    //console.log("WebSocket连接成功")
    socket.send('XXX连接成功');
  };
  //接收到消息的回调方法
  socket.onmessage = function (event) {
    console.log(event.data);
  }
  //发送一个消息
  //socket.send('Hi Server, I am LayIM!');
//更多情况下，一般是传递一个JSON
//   socket.send(JSON.stringify({
//     type: '' //随便定义，用于在服务端区分消息类型
//     ,data: {}
//   }));
  //连接成功时触发

  //另外还有onclose、onerror，分别是在链接关闭和出错时触发。

  //基本上常用的就上面几个了，是不是非一般的简单？
});