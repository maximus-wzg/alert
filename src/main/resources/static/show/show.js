$(function() {
    var alertTable = $('#alertTbl').bootstrapTable({
        url: 'showAlertRecords',
        method: 'post',
        contentType: 'application/json',
        dataType: 'json', // 服务器返回的数据类型
        pagination: true, // 是否显示分页
        sidePagination: "server", // 分页方式：client客户端分页，server服务端分页
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 25, 50, 100], // 可供选择的每页的行数
        cache: false, // 是否使用缓存，默认为true
        search: true, // 是否搜索
        searchOnEnterKey: true, // 回车搜索
        showRefresh: true,
        queryParamsType: '',
        responseHandler: function(result) {
            return {
                total: result.total,
                rows: result.list
            }
        },
        columns: [{
            field: 'host',
            title: '主机'
        }, {
            field: 'appName',
            title: '应用名称'
        }, {
            field: 'term',
            title: '告警关键字'
        }, {
            field: 'message',
            title: '日志'
        }, {
            field: 'esIdx',
            title: 'es索引'
        }, {
            field: 'msgTime',
            title: '日志时间'
        }, {
            field: 'insertTime',
            title: '告警时间'
        }]
    });

});