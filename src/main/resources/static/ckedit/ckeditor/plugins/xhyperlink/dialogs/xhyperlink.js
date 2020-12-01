CKEDITOR.dialog.add( 'xhyperlinkDialog', function( editor ) {
    return {
        title:          '超链接',
        resizable:      CKEDITOR.DIALOG_RESIZE_BOTH,
        minWidth:       100,
        minHeight:      20,
        contents: [
            {
                id:         'tab1',
                label:      'First Tab',
                title:      'First Tab Title',
                accessKey:  'Q',
                elements: [
                    {
                        type:           'html',
                        label:          'Test Text 1',
                        id:             'testText1',
                        html: '<div align="center">确认移除所有超链接吗？</div>'
                    }
                ]
            }
        ]
    };
} );
