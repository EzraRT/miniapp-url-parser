package org.ezrart.data

data class TimMiniAppData(
    var app: String, // 小程序消息ID 一般默认为com.tencent.miniapp_01 以及 com.tencent.structmsg 两种卡片解析方式不同
    var desc: String, // 应用名
    var prompt: String, // 标题
    var meta: TimMetaData
)

data class TimMetaData(
    var news: TimDetailData
)

data class TimDetailData(
    var desc: String, // 描述
    var jumpUrl: String, // 原始url
    var preview: String, // 预览图片url
    var title: String // 标题
)