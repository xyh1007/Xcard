CKEDITOR.plugins.add( 'ximage', {
    icons: 'ximage',
    init: function( editor ) {
        //Plugin logic goes here.
        editor.addCommand( 'ximage', {
            exec: function( editor ) {
                var now = new Date();
                editor.insertHtml( 'The current date and time is: <em>' + now.toString() + '</em>' );
            }
        });

        editor.ui.addButton( 'Ximage', {
            label: 'Insert Timestamp',
            command: 'ximage',
            toolbar: 'insert,0'
        });
    }
});

CKEDITOR.dialog.add( 'testOnly', function( editor ) {
    return {
        title:          'Test Dialog',
        resizable:      CKEDITOR.DIALOG_RESIZE_BOTH,
        minWidth:       500,
        minHeight:      400,
        contents: [
            {
                id:         'tab1',
                label:      'First Tab',
                title:      'First Tab Title',
                accessKey:  'Q',
                elements: [
                    {
                        type:           'text',
                        label:          'Test Text 1',
                        id:             'testText1',
                        'default':      'hello world!'
                    }
                ]
            }
        ]
    };
} );

