CKEDITOR.dialog.add('voteDialog',function (editor) {
    return {
        title:'插入单个投票',
        resizable: CKEDITOR.DIALOG_RESIZE_BOTH,
        minWidth: 400,
        minHeight: 200,
        contents: [
            {
                id: 'tab-basic',
                label: 'Basic Settings',
                elements: [
                    // UI elements of the first tab    will be defined here.
                    {
                        type: 'text',
                        id: 'vote',
                        label: 'text',
                        validate: CKEDITOR.dialog.validate.notEmpty( "Abbreviation field cannot be empty." ),
                        setup:function (element) {
                            this.setValue(element.getText())
                        },
                        commit:function (element) {
                            element.setText(this.getValue())
                        }
                    },
                    {
                        type: 'text',
                        id: 'title',
                        label: 'title',
                        validate: CKEDITOR.dialog.validate.notEmpty( "Explanation field cannot be empty." ),
                        setup:function (element) {
                            this.setValue(element.getAttribute("title"))
                        },
                        commit:function (element) {
                            element.setAttribute("title",this.getValue())
                        }
                    },
                    {
                        type: 'vbox',
                        align: 'right',
                        width: '200px',
                        children: [
                            {
                                type: 'text',
                                id: 'age',
                                label: 'Age'
                            },
                            {
                                type: 'text',
                                id: 'sex',
                                label: 'Sex'
                            },
                            {
                                type: 'text',
                                id: 'nationality',
                                label: 'Nationality'
                            }
                        ]
                    },
/*                    {
                        type: 'text',
                        id: 'name',
                        label: 'Your name',
                        'default': '',
                        validate: function() {
                            if ( !this.getValue() ) {
                                api.openMsgDialog( '', 'Name cannot be empty.' );
                                return false;
                            }
                        }
                    },
                    {
                        type: 'textarea',
                        id: 'message',
                        label: 'Your comment',
                        'default': '',
                        validate: function() {
                            if ( this.getValue().length < 5 ) {
                                api.openMsgDialog( 'The comment is too short.' );
                                return false;
                            }
                        }
                    },*/
                    {
                        type: 'select',
                        id: 'sport',
                        label: 'Select your favourite sport',
                        items: [ [ 'Basketball' ], [ 'Baseball' ], [ 'Hockey' ], [ 'Football' ] ],
                        'default': 'Football',
                        onChange: function( api ) {
                            // this = CKEDITOR.ui.dialog.select
                            alert( 'Current value: ' + this.getValue() );
                        }
                    },
                    {
                        type: 'radio',
                        id: 'country',
                        label: 'Which country is bigger',
                        items: [ [ 'France', 'FR' ], [ 'Germany', 'DE' ] ],
                        style: 'color: green',
                        'default': 'DE',
                        onClick: function() {
                            // this = CKEDITOR.ui.dialog.radio
                            alert( 'Current value: ' + this.getValue() );
                        }
                    },
                    {
                        type: 'html',
                        html: '<div id="myDiv">Sample <b>text</b>.</div><div id="otherId">Another div.</div>'
                    },
                    {
                        type: 'hbox',
                        widths: [ '25%', '25%', '50%' ],
                        children: [
                            {
                                type: 'text',
                                id: 'id1',
                                width: '40px',
                            },
                            {
                                type: 'text',
                                id: 'id2',
                                width: '40px',
                            },
                            {
                                type: 'text',
                                id: 'id3'
                            }
                        ]
                    },
                    {
                        type: 'file',
                        id: 'upload',
                        label: 'Select file from your computer',
                        size: 38
                    },
/*                    {
                        type: 'fileButton',
                        id: 'fileId',
                        label: 'Upload file',
                        'for': [ 'tab1', 'upload' ],
                        filebrowser: {
                            onSelect: function( fileUrl, data ) {
                                alert( 'Successfully uploaded: ' + fileUrl );
                            }
                        }
                    },*/
                    {
                        type: 'checkbox',
                        id: 'agree',
                        label: 'I agree',
                        'default': 'checked',
                        onClick: function() {
                            // this = CKEDITOR.ui.dialog.checkbox
                            alert( 'Checked: ' + this.getValue() );
                        }
                    },
                    {
                        type: 'button',
                        id: 'buttonId',
                        label: 'Click me',
                        title: 'My title',
                        onClick: function() {
                            // this = CKEDITOR.ui.dialog.button
                            alert( 'Clicked: ' + this.id );
                        }
                    }
                ]
            },
            {
                id: 'tab-adv',
                label: 'Advanced Settings',
                elements: [
                    // UI elements of the second tab will be defined here.
                    {
                        type: 'text',
                        id: 'id',
                        label: 'Id',
                        setup:function (element) {
                            this.setValue(element.getAttribute("id"))
                        },
                        commit:function (element) {
                            var id = this.getValue();
                            if(id){
                                element.setAttribute('id',id)
                            }else if(!this.insertMode){
                                element.removeAttribute('id')
                            }
                        }
                    }
                ]
            },
            {
                id:'tab-vote',
                label:'vote',
                elements:[
                    {
                        type: "html",
                        label:'Vote Text',
                        id:'voteText',
                        html: '<iframe src="/ckedit/ckeditor/plugins/vote/dialogs/vote.html"></iframe>',
                        style: "width:800px;height:580px;padding:0;"
                    }
                ]
            }
        ],
        onShow:function(){
          var selection = editor.getSelection();
          var element = selection.getStartElement();
          if(element){
              //祖先元素是否含有 <vote>
              element = element.getAscendant('vote',true);
          }
          if(!element || element.getName() != 'vote'){
              element = editor.document.createElement('vote');
              this.insertMode = true;

          }else{
              this.insertMode = false;
          }
          this.element = element;
          if(!this.insertMode){
              this.setupContent(element)
          }
        },
        onOk:function () {
            var dialog = this,
                vote = dialog.element
            dialog.commitContent(vote);
            if(dialog.insertMode){
                editor.insertElement(vote);
            }
/*            var vote = editor.document.createElement('vote');
            vote.setAttribute('title',dialog.getValueOf('tab-basic','title'));
            vote.setText(dialog.getValueOf('tab-basic','vote'));
            var id = dialog.getValueOf('tab-adv','id');
            if(id){
                vote.setAttribute('id',id)
            }
            editor.insertElement(vote)*/

        }
    }
})
