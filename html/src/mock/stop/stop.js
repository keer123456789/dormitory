import Mock from 'mockjs'

Mock.mock(`/api/stop`, 'post', ({body}) => {
    let result = {};
    body = JSON.parse(body);
    if(body.id != "" && body.id != undefined)
    {
        result.code = 200;
        result.message = '退宿成功!';
    }else{
        result.code = 500;
        result.message = "退宿失败！";
    }
    return result
})