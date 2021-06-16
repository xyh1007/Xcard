CKEDITOR.plugins.add( 'vote', {
    icons: 'vote',
    init: function( editor ) {
        //Plugin logic goes here.
        editor.addCommand( 'vote', new CKEDITOR.dialogCommand('voteDialog'));
        editor.ui.addButton( 'Vote', {
            label: '插入单个投票',
            command: 'vote',
            toolbar: 'insert'
        });
        if(editor.contextMenu){
            editor.addMenuGroup('voteGroup');
            editor.addMenuItem('voteItem',{
                label: 'Edit vote',
                icon:this.path+'icons/vote.png',
                command: 'vote',
                group: 'voteGroup'
            })
            editor.contextMenu.addListener(function (element) {
                if(element.getAscendant('vote',true)){
                    return {voteItem:CKEDITOR.TRISTATE_OFF}
                }
            })
        }
        CKEDITOR.dialog.add('voteDialog',this.path+'dialogs/vote.js')
    }
});
