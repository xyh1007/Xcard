CKEDITOR.plugins.add( 'xhyperlink', {
    icons: 'xhyperlink',
    init: function( editor ) {
        //Plugin logic goes here.
        editor.updateElement();
        editor.addCommand( 'xhyperlink', new CKEDITOR.dialogCommand( 'xhyperlinkDialog' ));

        editor.ui.addButton( 'Xhyperlink', {
            label: '移除所有超链接',
            command: 'xhyperlink',
            toolbar: 'links,50'
        });

        CKEDITOR.dialog.add( 'xhyperlinkDialog', this.path+'dialogs/xhyperlink.js');

        CKEDITOR.on('dialogDefinition', function(e) {
            var dialogName = e.data.name;
            var dialog = e.data.definition.dialog;
            if(dialogName == 'xhyperlinkDialog') {
                dialog.on('ok', function () {
                    var oldhtml = e.editor.getData();
/*                    console.log("yuanshi====>"+oldhtml)
                    var items=e.editor.document.getElementsByTag("a")
                    console.log(items.count())
                    //var test = items.toArray()
                     for(var i=0;i<items.count();i++){
                         var obj=items.getItem(i);
  /!*                       var pres = obj.getHtml()
                         console.log('pres:====>'+pres)
                         obj.removeAttribute("data-cke-saved-href")
                         var news = obj.getOuterHtml()
                         console.log('news:====>'+news)
                         oldhtml = oldhtml.replace(news,pres)
                         console.log('reout=====>'+oldhtml)*!/
                         var style = new CKEDITOR.style( { element: 'a', type: CKEDITOR.STYLE_INLINE, alwaysRemoveElement: 1 } );
                         editor.removeStyle( style );
                     }
                    //console.log(e.editor.getData())*/
                    e.editor.setData(oldhtml.replace(/(<\/?a.*?>)|(<\/?span.*?>)/g, ''))
/*            var element = { type:           'text',
                label:          'Test Text 1',
                id:             'testText1'}
                    console.log(dialog.definition.getContents("tab1"))*/
/*                    var element = new CKEDITOR.dom.element( 'span' );
                     element.setValue("xxxxx")
                    dialog.addFocusable(element,0);*/
                   // dialog.setValueOf('tab1','testText1',items)
                });
            }
        });
    }
});





