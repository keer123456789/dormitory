import Mock from 'mockjs'
import '@/mock/extend'


Mock.mock(`/api/object`, 'post', ({body}) => {
    let result = {};
    console.log(JSON.parse(body));
    result.code = 200;
    result.message = '添加成功!';
    return result
})