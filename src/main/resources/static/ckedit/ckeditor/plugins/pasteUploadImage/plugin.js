(function () {

    var base64 = 'data:image/png;base64,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'
    var CKEDITOR_NAME = 'pasteUploadImage';

    CKEDITOR.plugins.add(CKEDITOR_NAME, {
        init: function(editor) {
            var config = editor.config;
/*            var notSupportText = 'Your browser is not supported'
            if (!window.Promise || !window.XMLHttpRequest) {
                alert(notSupportText);
                return;
            }*/

            if (!config.pasteUploadFileApi) {
                CKEDITOR.error('You must to config "config.pasteUploadFileApi" in ckeditor/config.js');
                return;
            }

            editor.on('paste', function (event) {
                console.log("start")
                var dataTransfer = event.data.dataTransfer;
                var filesCount = dataTransfer.getFilesCount();
                var oldUrl = event.data.dataValue;
                // base64 paste from word
                if (oldUrl.match(/<img[\s\S]+data:/i)) {
                    return;
                }
                // 去重一些src data-src等造成的重复图片
                //var urls = uniq(oldUrl.match(/(?<=img.*?[\s]src=")[^"]+(?=")/gi));
               // var reg = /<img\s+src=\"(.*?)\"/i
                //var reg = "\< [img][^\\>][src] = [\"\']{0,1}([^\"\'\ >]*)"
                //var urlstemp = oldUrl.match(reg)
                //.log(urlstemp)
                var urlsres = []
                var patt = /<img.*?src="(.*?)".*?\/?>/ig
                var temp
                while((temp =patt.exec(oldUrl))!=null){
                    urlsres.push(temp[1])
                }
                console.log(urlsres)
                var urls = uniq(urlsres)
/*                var items = event.editor.document.getElementsByTag("img")
                console.log(items)
                for(var i=0;i<items.count();i++){
                    var obj=items.getItem(i);
                    console.log("1")
                }*/
                if (filesCount > 0) {
                    for (var i = 0; i < filesCount; i++) {
                        var file = dataTransfer.getFile(i);
                        // 网页复制单个
                        if (urls.length) {
                            modal(urls[0]);
                            uploadFile(urls[0], urls[0], file);
                        }
                        //本地imagename.png
                        else {
                            if (!window.URL || !window.URL.createObjectURL) {
                                alert(notSupportText);
                                return;
                            }
                            var modalUrl = window.URL.createObjectURL(file);
                            var isCreateImage = true;
                            modal(modalUrl);
                            uploadFile(oldUrl, modalUrl, file, isCreateImage)
                        }
                    }
                } else {
                    // 网页上传URL
                    if (urls.length) {
                        for (var i = 0; i < urls.length; i++) {
                            modal(urls[i]);
                            uploadImageUrl(urls[i]);
                        }
                    }
                }
            });

            function uploadFile (oldUrl, modalUrl, file, isCreateImage) {
                var formData = new FormData();
                formData.append('upload', file);
                var option = {
                    url: config.pasteUploadFileApi,
                    data: formData
                };
                ajaxPost(option).then(function (text) {
                    if (text === 'request time out') {
                        updateEditorVal(oldUrl, text, isCreateImage);
                        updateModal(modalUrl, text);
                        return;
                    }

                    // 接口回调URL
                    var newUrl = text;
                    updateEditorVal(oldUrl, newUrl, isCreateImage);
                    updateModal(modalUrl, true);
                }).catch(function () {
                    updateModal(oldUrl, false);
                    updateEditorVal(modalUrl, 'failure');
                });
            }

            function uploadImageUrl (oldUrl) {
                var url = config.pasteUploadImageUrlApi || config.pasteUploadFileApi;
                var form = new FormData();
                //var fileObj = btof(base64, "test");
                //form.append("upload",base64,"test")
                form.append("url",oldUrl)
                var option = {
                    url: url ,
                    data: form
                };
                ajaxPost(option).then(function (text) {
                    if (text === 'request time out') {
                        updateEditorVal(oldUrl, text);
                        updateModal(oldUrl, text);
                        return;
                    }
                    var newUrl = text;
                    updateModal(oldUrl, true);
                    updateEditorVal(oldUrl, newUrl);
                }).catch(function () {
                    updateModal(oldUrl, false);
                    updateEditorVal(oldUrl, 'failure');
                });
            }

            function ajaxPost (option) {
                var timeout = 10000;
                var xhr = new XMLHttpRequest();
                var p = new Promise(function (resolve, reject) {
                    option = option || {};
                    xhr.open('post', option.url);
                    xhr.send(option.data);
                    xhr.onreadystatechange = function() {
                        if(xhr.readyState === 4 && xhr.status == 200) {
                            var text =  xhr.responseText || '{}';
                            var data = JSON.parse(text);
                            if (data.url) {
                                resolve(data.url);
                            } else {
                                // 没有返回图片链接则reject
                                reject();
                            }
                            xhr = null;
                        }
                        else if (xhr.readyState === 4 && xhr.status !== 200) {
                            reject();
                            xhr = null;
                        }
                    }
                });
                var t = new Promise(function(resolve) {
                    var t = setTimeout(function () {
                        if (xhr) {
                            xhr && xhr.abort();
                            resolve('request time out');
                            clearTimeout(t);
                        }
                    }, timeout);
                });
                return Promise.race([p, t]);
            }

            function modal (filename) {
                var html =
                    '<div class="modal-editor-upload" filename="{{filename}}" style="margin-bottom: 5px;border-bottom: 1px solid #ddd;padding-bottom: 5px;">'+
                    '<img style="width:40px;height:40px;vertical-align: middle;" src="{{filename}}" content="no-referrer"/>'+
                    '<label style="color:green;"> uploading...</label>'+
                    '</div>';
                html = html.replace(/\{\{(.+?)\}\}/g, filename);
                var wrapper = document.querySelector('.modal-editor-upload-wrapper');
                if (!wrapper) {
                    var wrapper = document.createElement('div');
                    wrapper.className = 'modal-editor-upload-wrapper';
                    wrapper.style.cssText = 'width:200px;background-color:#fdfdfd;position:absolute;right: 30px;top: 100px;'
                    wrapper.innerHTML = html;
                    var edi = document.getElementById('cke_' + editor.name);
                    edi.appendChild(wrapper);
                    edi.style.position = 'relative';
                } else {
                    wrapper.innerHTML += html;
                }
            }

            function updateModal (filename, result) {
                filename = filename.replace(/&amp;/g, '&');
                var selector = 'div.modal-editor-upload[filename="'+filename+'"]';
                var content = document.querySelector(selector);
                var label = content.querySelector('label');
                if (result === 'request time out') {
                    label.innerHTML = ' ' + result;
                    label.style.color = 'red';
                } else if (result === true) {
                    label.innerHTML = ' success';
                    label.style.color = 'green';
                } else {
                    label.innerHTML = ' failure';
                    label.style.color = 'red';
                }
                var time = result === true ? 3000 : 10000;
                var t = setTimeout(function () {
                    var c = document.querySelector(selector);
                    document.querySelector('.modal-editor-upload-wrapper').removeChild(c);
                    clearTimeout(t);
                }, time);
            }

            // 更新
            function updateEditorVal (oldUrl, newUrl, isCreateImage) {
                var data = editor.getData();
                if (isCreateImage) {
                    if (!oldUrl) {
                        data = data + '<p><img src="'+newUrl+'"/></p>';
                    } else {
                        data = data.replace(oldUrl, '<img src="'+newUrl+'"/>');
                    }
                } else {
                    data = replaceAll(data, oldUrl, newUrl);
                }
                editor.document.$.body.innerHTML = data;
            }

            function uniq (arr) {
                arr = arr || [];
                var list = [];
                for (var i = 0; i < arr.length; i++) {
                    if (list.indexOf(arr[i]) < 0) {
                        list.push(arr[i]);
                    }
                }
                return list;
            }

            function escapeRegExp(str) {
                return str.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1");
            }

            function replaceAll(str, find, replace) {
                return str.replace(new RegExp(escapeRegExp(find), 'g'), replace);
            }

            function getBase64Image(img) {
                var canvas = document.createElement("canvas");
                canvas.width = img.width;
                canvas.height = img.height;
                var ctx = canvas.getContext("2d");
                ctx.drawImage(img, 0, 0, img.width, img.height);
                var ext = img.src.substring(img.src.lastIndexOf(".") + 1).toLowerCase();
                var dataURL = canvas.toDataURL("image/" + ext);

                return dataURL;
            }

        }
    });
})();
