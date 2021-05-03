# 宿舍管理系统-后端代码说明

## 1.接口说明

### 1.1 用户管理

#### 1 用户登录

1. 接口路径：/user/login
2. 接口说明：用户登录接口
3. 接口方法：GET
4. 请求参数（query）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |username|string|用户名|是|
   |password|string|密码|是|

5. 请求体（body）   
   无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|   
   |----|----|----|----|   
   |code|int|状态码 成功-200 失败-500|是|   
   |msg|string|返回消息|否|   
   |data|user对象|登录对应的用户信息|是|   

   |user对象|参数类型|说明|是否必须|
   |----|----|----|----|
   |name|string|用户名|是|
   |role|int|用户角色 0-admin 1-宿管|是|

#### 2 用户注册

1. 接口路径：/user/register
2. 接口说明：用户注册接口
3. 接口方法：POST
4. 请求参数（query） 无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |username|string|用户名|是|
   |password|string|用户密码|是|
   
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|否|

#### 3 获取用户列表

1. 接口路径：/user
2. 接口说明：获取用户列表，只有在管理员才能查看
3. 接口方法：GET
4. 请求参数（query）  
   无
5. 请求体（body） 
   无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|UserInfo对象 **数组**|用户信息列表|是|

   |UserInfo对象|参数类型|说明|是否必须|
   |----|----|----|----|
   |userName|string|用户名|是|
   |role|string|角色|是|
   |blockInfos|blockInfo **数组**|管理的宿舍楼信息列表|是|

   |blockInfo对象|参数类型|说明|是否必须|
   |----|----|----|----|
   |blockId|string|宿舍楼id|是|
   |blockName|string|宿舍楼名称|是|

#### 4 给宿管分配宿舍楼

1. 接口路径：/user
2. 接口说明：管理员分配宿舍楼给宿管 管理员权限
3. 接口方法：POST
4. 请求参数（query）   
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |userName|string|用户名|是|
   |blockIds|int **数组**|宿舍楼id 数组|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|null|是|

### 1.2 宿舍楼管理

#### 1 增加宿舍楼

1. 接口路径：/block
2. 接口说明：增加宿舍楼
3. 接口方法：POST
4. 请求参数（query） 无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |block|block对象|宿舍楼信息|是|
   |rooms|room对象**数组**|宿舍信息|是|

   |block对象|参数类型|说明|是否必须|
   |----|----|----|----|
   |name|string|宿舍楼名称|是|
   |roomSize|int|宿舍楼宿舍最大人数|是|
   |floorSize|int|宿舍楼层数|是|

   |room对象|参数类型|说明|是否必须|
   |----|----|----|----|
   |name|string|宿舍名称|是|
   |floorNum|int|宿舍所在楼层|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|null|是|

#### 2 删除宿舍楼

1. 接口路径：/block/{id}
2. 接口说明：删除宿舍楼，一并删除相应的楼层，宿舍，
3. 接口方法：GET
4. 请求参数（query）  
   无
5. 请求体（body）  
   无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 3 获取宿舍楼信息列表

1. 接口路径：/block
2. 接口说明：获取宿舍楼信息列表
3. 接口方法：GET
4. 请求参数（query）
   无
5. 请求体（body）  
   无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|blockInfo **数组**|所有相应的宿舍楼信息|是|

   |blockInfo|参数类型|说明|是否必须|
   |----|----|----|----|
   |name|string|宿舍楼名称|是|
   |managerName|string|宿管人员|是|
   |floorNum|int|楼层数|是|
   |roomNum|int|房间数|是|
   |studentNum|int|入住人数|是|

#### 4 批量增加宿舍楼（excel）

1. 接口路径：file/block/upload
2. 接口说明：根据上传的文件，增加宿舍楼和房间
3. 接口方法：POST
4. 请求参数（query）  
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |file|MultipartFile|文件|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 5 校验宿舍楼文件文件正确性

1. 接口路径：file/block/valid
2. 接口说明：校验上传的文件 格式是否符合模板文件
3. 接口方法：POST
4. 请求参数（query）  
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |file|MultipartFile|文件|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 6 增加宿舍楼楼层平面图

1. 接口路径：/block/image-floor
2. 接口说明：为宿舍楼增加平面图
3. 接口方法：POST
4. 请求参数（query）  
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |image|MultipartFile|楼层平面图|是|
   |blockId|int|宿舍楼号|是|
   |floorId|int|楼层id|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 7 获取楼层平面图

1. 接口路径：/block/image-floor
2. 接口说明：获取楼层平面图
3. 接口方法：GET
4. 请求参数（query）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |blockId|int|宿舍楼号|是|
   |floorId|int|楼层id|是|
5. 请求体（body）  
   无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|string|图片地址|是|


#### 7 获取楼层平面图

1. 接口路径：/block/{blockId}
2. 接口说明：获取楼层平面图
3. 接口方法：GET
4. 请求参数（query）
   无
5. 请求体（body）  
   无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|Floor对象数组|图片地址|是|
   
   |Floor对象数组|参数类型|说明|是否必须|
   |----|----|----|----|
   |id|int|楼层号|是|
   |name|string|楼层名称|是|
   |blockId|int|宿舍楼号|是|
   |floorNum|int|楼层数|是|

### 1.3 学生信息管理

#### 1 增加学生

1. 接口路径：/student
2. 接口说明：增加学生
3. 接口方法：POST
4. 请求参数（query） 无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |id|string|学号|是|
   |name|string|姓名|是|
   |phoneNum|string|手机号|是|
   |classNum|string|行政班号|是|
   |identity_num|string|身份证号|否|
   |nation|string|民族|否|
   |sex|string|性别|0-男；1-女|否|
   |academy|string|学院|否|
   |major|string|专业|否|
   |region|string|地区|否|
   |address|string|家庭住址|否|


6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|null|是|

#### 2 修改学生信息

1. 接口路径：/student/update
2. 接口说明：分配学生宿舍
3. 接口方法：POST
4. 请求参数（query） 无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |blockId|int|宿舍楼号|是|
   |floorId|int|楼层id|是|
   |roomId|int|房间id|是|
   |bedNum|int|床号|是|
   |id|string|学号|是|
   |name|string|姓名|是|
   |phoneNum|string|手机号|是|
   |classNum|string|行政班号|是|
   |identity_num|string|身份证号|否|
   |nation|string|民族|否|
   |sex|string|性别|0-男；1-女|否|
   |academy|string|学院|否|
   |major|string|专业|否|
   |region|string|地区|否|
   |address|string|家庭住址|否|


6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|null|是|

#### 3 批量导入学生信息（excel）

1. 接口路径：/student/file
2. 接口说明：根据上传的文件，批量增加学生信息
3. 接口方法：POST
4. 请求参数（query）  
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |file|MultipartFile|文件|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 4 校验文件正确性

1. 接口路径：/student/valid-file
2. 接口说明：根据模板文件将验证上传的文件格式是否正确
3. 接口方法：POST
4. 请求参数（query）  
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |file|MultipartFile|文件|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 4 根据文件给出可分配宿舍楼

1. 接口路径：/student-file/distribute-info
2. 接口说明：根据模板文件给出可以进行分配的宿舍楼
3. 接口方法：POST
4. 请求参数（query）  
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |file|MultipartFile|文件|是|
   |roomSize|int|宿舍人数|是|

6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|distributeInfo 对象|无|是|

   |distributeInfo 对象|参数类型|说明|是否必须|    
   |----|----|----|----|
   |maleBlockInfo|blockInfo 数组对象|符合条件的男宿舍信息|是|
   |femaleBlockInfo|blockInfo 数组对象|符合条件的女宿舍信息|否|

   |blockInfo 对象|参数类型|说明|是否必须|
   |----|----|----|----|
   |emptyRoom|int|空房间人数|是|
   |peopleSize|int|宿舍楼可容纳人数|是|
   |blockId|int|宿舍楼id|是|
   |blockName|String|宿舍楼名称|是|

#### 6 学生退宿

1. 接口路径：/student/stop/{student_id}
2. 接口说明：根据模板文件将验证上传的文件格式是否正确
3. 接口方法：put
4. 请求参数（query）  
   无
5. 请求体（body） 无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 7 获取学生列表

1. 接口路径：/student
2. 接口说明：根据模板文件将验证上传的文件格式是否正确
3. 接口方法：GET
4. 请求参数（query）  
   无
5. 请求体（body） 无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|student数组对象|无|是|

   |student数组对象|参数类型|说明|是否必须|
   |----|----|----|----|
   |roomId|int|房间id|是|
   |bedNum|int|床号|是|
   |id|string|学号|是|
   |name|string|姓名|是|
   |phoneNum|string|手机号|是|
   |classNum|string|行政班号|是|
   |identity_num|string|身份证号|否|
   |nation|string|民族|否|
   |sex|string|性别|0-男；1-女|否|
   |academy|string|学院|否|
   |major|string|专业|否|
   |region|string|地区|否|
   |address|string|家庭住址|否|


### 1.4 物品管理

#### 1 增加物品

1. 接口路径：/object
2. 接口说明：增加物品
3. 接口方法：POST
4. 请求参数（query）  
   无
5. 请求体（body）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |name|string|物品姓名|是|
   |floorId|int|楼层id|是|
   |x|int|x轴位置|是|
   |y|int|y轴位置|是|
   |type|int|物品类别|是|
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 2 删除物品

1. 接口路径：/object
2. 接口说明：删除物品
3. 接口方法：DELETE
4. 请求参数（query）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |objectId|int|物品id|是|
5. 请求体（body） 无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
            |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|null|无|是|

#### 3 获取楼层物品

1. 接口路径：/object
2. 接口说明：获取楼层中物品
3. 接口方法：GET
4. 请求参数（query）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |objectId|int|物品id|是|
5. 请求体（body） 无
6. 返回参数（response）

   |参数名|参数类型|说明|是否必须|
   |----|----|----|----|
   |code|int|状态码 成功-200 失败-500|是|
   |msg|string|返回消息|否|
   |data|objectInfo **数组**|物品对象信息|是|

   |objectInfo|参数类型|说明|是否必须|
   |----|----|----|----|
   |name|string|物品姓名|是|
   |x|int|x轴位置|是|
   |y|int|y轴位置|是|
   |type|int|物品类别|是|

### 1.6 任务管理

#### 1 查看运行的任务列表

