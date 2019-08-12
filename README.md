# DataSwap
This project mainly for the metadata exchanges of array, list, map, xml, dhml, uml, xslt, json, hash, string, table, tree, forest, vector and other 155 fields etc.
#### 声明：
###### 这个api 包 起源于作者在美国亚米公司设计缓存索引时 用到 gson的list对象进行 redis保存 出现冗余 不匹配的 问题，于是最早独立设计出gson to object  的 修正思想。但是只有一个10行代码的函数
###### 这个api 包 的 发展来自于作者在走四方公司做数据交换时候，涉及到 xml 和 json的互换， 于是独立设计出第一版VtoV文件，当时包含5个函数：xml to map
, map to xml, json to map, json to list, json to string.
###### 最近作者的数据公司长期和互联网数百种不同结构的字符串打交道，于是计划设计一套综合开源版本的数据转换API。全部采用VPCS的注册模式。
###### 作者将之前的6个函数全部修正和加速，同时支持并发注册机制运行，另外优化了 list object 的 嵌套对象辨别。 
###### 作者以前和亚米走四方上班的时候签订了2年的保密协议，和工作技术转让协议，这6个函数 以后作者申请著作权的时候会以合作研发的方式申请非个人著作权。

###### 罗瑶光 20190812
