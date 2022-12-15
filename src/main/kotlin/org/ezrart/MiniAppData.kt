package org.ezrart

data class MiniAppData(
    var app: String, // 小程序消息ID 一般默认为com.tencent.miniapp_01
    var desc: String, // 应用名
    var prompt: String, // 标题
    var meta: MetaData,
    var extra: ExtraData
)


data class ExtraData(
    var app_type: Long,
    var appid: Long, // 小程序应用ID
    var uin: Long // 分享人QQ号
)

data class MetaData(
    var detail_1: DetailData
)

data class DetailData(
    var desc: String, // 描述
    var qqdocurl: String, // 原始url
    var preview: String, // 预览图片url
    var title: String // 标题
)