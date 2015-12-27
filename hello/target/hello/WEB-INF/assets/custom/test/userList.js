;(function($){
    $(function () {
        var page = $('#page');
        var current = page.data("current");
        var size = page.data("size");
        var totalPage = page.data("totalpage");

        var options = {
                currentPage: current,
                totalPages: totalPage,
                numberOfPages: size,

        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "末页";
                case "page":
                    return page;
            }
        },

        pageUrl: function(type, page, current){
            return "http://localhost:8080/test/listByFreemarker?current="+page;
        }
    };

    page.bootstrapPaginator(options);

    });
})(jQuery);