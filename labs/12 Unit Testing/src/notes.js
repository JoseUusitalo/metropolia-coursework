/**
 * Created with Web-tekniikat.
 * User: joseu
 * Date: 2015-11-09
 * Time: 07:26 AM
 */
var notes = (function () {
    "use strict";
    var list = [];
    return {
        add: function (note) {
            if(("undefined" !== typeof note) && note.trim()) {
                var item = {
                    timestamp: Date.now(),
                    text: note
                };
                list.push(item);
                return true;
            }
            return false;
        },
        remove: function (index) {
            if(("undefined" !== typeof index) && (index >= 0) && (index < list.length)) {
                list.splice(index, 1);
                return true;
            }
            return false;
        },
        count: function () {
            return list.length;
        },
        list: function () {
            return list;
        },
        find: function (str) {
            if(("undefined" !== typeof str) && str.trim()) {
                str = str.toLocaleLowerCase();
                var matches = [];
                var i;
                for(i = 0; i < list.length; i += 1) {
                    if(list[i].text.toLocaleLowerCase().indexOf(str) !== -1) {
                        matches.push(list[i]);
                    }
                }
                if(matches.length === 0) {
                    return false;
                } else {
                    return matches;
                }
            }
            return false;
        },
        clear: function () {
            list.splice(0, list.length);
        }
    };
}());