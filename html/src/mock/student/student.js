import Mock from 'mockjs'

Mock.mock(`/api/student`, 'post', ({
    body
}) => {
    console.log(body);
    let result = {}
    result.code = 200;
    result.msg = "添加成功！";
    //   result.data=[]
    return result
})