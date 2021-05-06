import Mock from 'mockjs'

Mock.mock(`/api/delobject`, 'post', ({body}) => {
    let result = {};
    body = JSON.parse(body);
    if(body.key != "" && body.key != undefined)
    {
        result.code = 200;
        result.msg = '删除成功!';
    }else{
        result.code = 500;
        result.msg = "删除失败！";
    }
    return result
})