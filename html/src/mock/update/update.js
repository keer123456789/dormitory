import Mock from 'mockjs'

Mock.mock(`/api/update`, 'post', ({
    body
}) => {
    console.log(body);
    let result = {}
    result.code = 200;
    result.msg = "修改成功！";
    //   result.data=[]
    return result
})