package org.ezrart.data

data class QQMiniAppData(
    var app: String, // 小程序消息ID 一般默认为com.tencent.miniapp_01 以及 com.tencent.structmsg 两种卡片解析方式不同
    var desc: String, // 应用名
    var prompt: String, // 标题
    var meta: QQMetaData,
    var extra: QQExtraData
)


data class QQExtraData(
    var app_type: Long,
    var appid: Long, // 小程序应用ID
    var uin: Long // 分享人QQ号
)

data class QQMetaData(
    var detail_1: QQDetailData
)

data class QQDetailData(
    var desc: String, // 描述
    var qqdocurl: String, // 原始url
    var preview: String, // 预览图片url
    var title: String // 标题
)