/**
 * @license Copyright (c) 2003-2020, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

/*CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    config.extraPlugins =['image2','exportpdf'];
};*/
CKEDITOR.editorConfig = function( config ) {
    config.extraPlugins =['image2','exportpdf','pasteUploadImage','xhyperlink','vote'];
    config.exportPdf_fileName = function( editor ) {
        return 'fccs' + '.pdf';
    }
    config.toolbarGroups = [
        { name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
        { name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
        { name: 'styles', groups: [ 'styles' ] },
        { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
        { name: 'colors', groups: [ 'colors' ] },
        { name: 'paragraph', groups: [ 'align', 'list', 'indent', 'blocks', 'bidi', 'paragraph' ] },
        { name: 'links', groups: [ 'links' ] },
        { name: 'insert', groups: [ 'insert' ] },
        { name: 'tools', groups: [ 'tools' ] },
        { name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
        { name: 'forms', groups: [ 'forms' ] },
        '/',
        '/',
        { name: 'others', groups: [ 'others' ] },
        { name: 'about', groups: [ 'about' ] }
    ];

    config.removeButtons = 'Save,NewPage,Templates,Preview,Print,Cut,Paste,PasteText,Styles,Subscript,Superscript,Find,Replace,SelectAll,BidiLtr,BidiRtl,Language,CreateDiv,Form,Radio,TextField,Textarea,Select,Button,HiddenField,Anchor,Flash,SpecialChar,HorizontalRule,Smiley,Iframe,ShowBlocks,About,Checkbox,Copy,ExportPdf,PasteFromWord,Blockquote,PageBreak,Scayt';
};


