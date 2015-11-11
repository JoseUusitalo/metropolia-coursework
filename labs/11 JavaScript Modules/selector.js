/**
 * Created with Web-tekniikat.
 * User: joseu
 * Date: 2015-11-09
 * Time: 10:52 AM
 */
(function (window) {
    "use strict";

    function finder() {
        this.id = function (ID) {
            return document.getElementById(ID);
        };
    }
    // Export to window
    window = window || {};
    window.finder = finder;
})(window);