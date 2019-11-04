#### DataSwap （因数据加密，安全检测等功能部分涉及国家网络安全法等内容，本作品不做研发方向。）

##### 国家知委最新补正：要求个人软著全名去掉公司名‘德塔’ 和 ‘Deta’ 关键字，
##### 作者在此申明。 罗瑶光 2090927

##### 这个工程用于目前世界出现和流行的常见数据结构载体变量对象进行转换。比如 map, list, object, table, hash, tree, strings, array, json, xml, vector 等160种不同类型载体快速互换。
##### This project mainly for the metadata exchanges of array, list, map, xml, dhml, uml, xslt, json, hash, string, table, tree, forest, vector and other 155 fields etc.


#### 声明：
###### 这个api 包 起源于作者在美国亚米公司设计缓存索引时 用到 gson的list对象进行 redis保存(我写详细点，我用的是List<String[]> 格式来做亚米搜索的索引推荐的隐藏属性，进行快速写入redis，因为考虑String[]需要初始化，所以后来思考替换掉。切记和现在VtoV中的 jsonArrayToList 不是同一个函数性质，别混淆) 出现冗余 不匹配的 问题，于是最早独立设计出gson to object 的 修正思想。但是只有一个10行代码的函数,这个api 包 的 发展来自于作者在洛杉矶走四方公司做数据交换时候，涉及到 xml 和 json的互换， 于是独立设计出第一版VtoV文件，当时包含5个函数：
###### XmlToJsonObject
###### JsonObjectToMap
###### MapToJsonString
###### XmlToMap
###### MapToXml

##### 作者思考了很久，因为个人著作权对个人成就资历极为重要，作者确定剔除这5个函数做 国家个人软著申请。20190829 罗瑶光

###### 最近作者的数据公司长期和互联网数百种不同结构的字符串打交道，于是计划设计一套综合开源版本的数据转换API。全部采用VPCS的注册模式。
###### 作者将之前的6个函数全部修正和加速，同时支持并发注册机制运行，另外优化了 list object 的 嵌套对象辨别。
<!--###### 作者以前和亚米走四方上班的时候签订了2年的保密协议，和工作技术转让协议，这6（改为5，没有用到亚米的那个List<String[]> to jsonString, 这个工程我统一用OBJECT）个函数 以后作者申请著作权的时候会以合作研发的方式申请非个人著作权。-->
###### 备份记录： 这是3年前作者独立设计的代码文件备份（这5个函数（14行代码）使用权和研发权 2016年已转让给走四方公司），用来释疑，上面声明，绝不含有任何欺诈成分。
https://github.com/yaoguangluo/data_format/blob/master/VtoV.java

###### 20190824 今天能导入了，我导过来到国内的gitee上然后重新设置成闭源备份。 https://gitee.com/DetaChina/data_format/blob/master/VtoV.java

###### 当前研发功能
##### ![实例](http://progressed.io/bar/100?title=completed)1 股市网络数据分析转换文件
###### readDBcodeTOList
###### readTodaycodeTOList
###### readStringTOFormatWithoutCode
###### readStringTOFormatWithCode
##### ![实例](http://progressed.io/bar/10?title=completed)2 object 数据分析转换文件
###### objectToJsonString
##### ![实例](http://progressed.io/bar/100?title=completed)3 xml 数据分析转换文件
###### xmlToList
###### xmlToVector
###### xmlToSets
###### xmlToHashtable
##### ![实例](http://progressed.io/bar/100?title=completed)4 json 数据分析转换文件
###### jsonArrayToList
###### jsonObjectToString
###### jsonObjectToXml
##### ![实例](http://progressed.io/bar/100?title=completed)5 string 数据分析转换文件
###### stringToJsonObject
###### stringToXml
###### stringToArray
###### stringToList
###### stringToMap
###### stringToURIencode
###### uRIencodeToURIdecode
###### charsetSwap
###### stringDoubleToDouble
###### stringDoubleToBigDecimalRemainder
###### stringCodeFilter
###### stringToSequency
###### stringToSequencyArrayIncrement
###### stringToSequencyArrayDecrement 
###### An Algorithm of Sorting Mixed String Array with scale based on Theory of Yaoguang. Luo 4D Peak Filter Quicksort: quick4DStringArray
###### LYG4DWithChineseMixStringSort7D: quick4DStringArray with Pictographic and Wedge Swap
###### LYG4DWithMixObjectSort7D: quick4DStringArray where Mixed with Pictographic and Wedge Swap and It's Applications. 2019/11/04
##### ![实例](http://progressed.io/bar/100?title=completed)6 list 数据分析转换文件
###### listToJsonString
###### stringListToJsonString
###### listToXml
###### listToMap
###### listToObjectArray
###### listToIterator
###### listToVector
###### listToSet
###### ListSetsCheck
###### ListSetsFix
##### ![实例](http://progressed.io/bar/100?title=completed)7 map 数据分析转换文件
###### mapToList
###### mapToHash
##### ![实例](http://progressed.io/bar/100?title=completed)8 pdf 数据分析转换文件
##### ![实例](http://progressed.io/bar/100?title=completed)9 office 数据分析转换文件
##### ![实例](http://progressed.io/bar/100?title=completed)10 image 数据分析转换文件
###### pixTableToFile
###### pixRGBTableToFile
###### bufferedImageToFile
###### imageToFile
###### bufferedImageToScaleImageFile
##### ![实例](http://progressed.io/bar/100?title=completed)11 tree 数据分析转换文件
###### treeToJsonString
###### stringTreeToJsonString
###### treeToXml
###### treeToMap
###### treeToObjectArray
###### treeToIterator
###### treeToVector
##### ![实例](http://progressed.io/bar/100?title=completed)12 gradle yml 数据分析转换文件
##### ![实例](http://progressed.io/bar/100?title=completed)13 vector 数据分析转换文件
###### vectorToMap
###### vectorToList
###### vectorToArray
###### vectorToIterator
###### vectorToJsonString
###### vectorToSet
##### ![实例](http://progressed.io/bar/10?title=completed)14 array 数据分析转换文件
###### arrayToMatrix
###### arrayToSet 
###### arrayToXml
###### arrayToJson
###### arrayToMatrix3D
###### arrayToIterator
###### arrayToList 
###### arrayToVector 
###### arrayToMap
###### arrayIntCheck
###### arrayIntFix
###### arrayLongCheck
###### arrayLongFix
###### arrayDoubleCheck
###### arrayDoubleFix
###### arrayFloatCheck
###### arrayFloatFix
##### ![实例](http://progressed.io/bar/10?title=completed)15 sound 数据分析转换文件
##### ![实例](http://progressed.io/bar/100?title=completed)16 matrix 数据分析转换文件
###### matrixInclineSwap
###### matrixPostSwap
###### matrixInSwap
###### matrixReverseSwap
###### matrixToArray
##### ![实例](http://progressed.io/bar/10?title=completed)17 DNA 数据分析转换文件
##### ![实例](http://progressed.io/bar/10?title=completed)18 OBEX 数据分析转换文件
##### ![实例](http://progressed.io/bar/100?title=completed)19 Vector 数据分析转换文件
###### vectorToMap
###### vectorToList
###### vectorToArray
###### vectorToIterator
###### vectorToJsonString
###### vectorToSet
##### ![实例](http://progressed.io/bar/10?title=completed)20 Flips 数据分析转换文件
##### ![实例](http://progressed.io/bar/100?title=completed)21 hash 数据分析转换文件
###### hashTableToJson 
###### hashTableToXml
###### hashTableToList
###### hashTableToObjectArray
##### ![实例](http://progressed.io/bar/100?title=completed)22 xls 数据分析转换文
##### ![实例](http://progressed.io/bar/100?title=completed)23 csv 数据分析转换文件
###### xlsOrCsvFileToObjectMartix
###### xlsOrCsvFileToListObject
###### xlsOrCsvFileToRangedListObject
###### xlsOrCsvFileToRangedObjectMartix
##### ![实例](http://progressed.io/bar/100?title=completed)24 txt 数据分析转换文件
###### txtFileToObjectMatrix
###### txtFileToObjectMatrixWithRange
###### txtFileToListStringWithRange
###### txtFileToListString
###### txtFileToListStringArray
##### ![实例](http://progressed.io/bar/100?title=completed)25 Iterator 数据分析转换文件
###### iteratorToJsonString
###### stringIteratorToJsonString
###### iteratorToXml
###### iteratorToMap
###### iteratorToObjectArray
###### iteratorToList
##### ![实例](http://progressed.io/bar/100?title=completed)26 String Builder 数据分析转换文件
###### stringBuilderToCharArray
###### stringBuilderToString
###### stringBuilderToJson
###### stringBuilderToXml
###### stringBuilderToSplitArray
###### stringBuilderToMap
##### ![实例](http://progressed.io/bar/100?title=completed)27 date 数据分析转换文件
###### dateToGMTString
###### dateToYYYYMMDD
###### dateToHHMMSS
###### dateToMiliSeconds
###### getCurrentMiliSeconds
###### dateToTimeStamp
###### timeStampToMiliSeconds
###### dateStringToMiliSeconds
###### currentSystemTimeCheck
###### currentSystemTimeToUTC
##### ![实例](http://progressed.io/bar/100?title=completed)28 3D matrix 数据表变换文件
###### matrixShiftSwapXYZ
###### matrixInclineSwapXY
###### matrixInclineSwapXZ
###### matrixInclineSwapYZ
###### matrixReverseSwap
###### matrixReverseSwapXY
###### matrixReverseSwapXZ
###### matrixReverseSwapYZ
###### matrixToArray
##### ![实例](http://progressed.io/bar/100?title=completed)29 HTTP 数据表变换文件
###### getJson
###### postXML
###### postJsonWithSercurity
###### postXMLWithSercurity
###### getHTML
##### ![实例](http://progressed.io/bar/100?title=completed)29 时序-频率数据表变换文件
###### 罗瑶光-莱布尼茨-斜率积-快速-变换 第1代
###### 函数研发总数进度 160+/155

罗瑶光 20190812- 20190907
