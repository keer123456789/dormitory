import Mock from 'mockjs'
import { parseUrlParams } from '@/utils/request'

const data = [
    {
        key: "1",
        name: "John Brown",
        role: "管理员",
        buildId: "123322",
        buildName: "一号楼",
        // xlh: '232143-12431'
    },
    {
        key: "2",
        name: "王长贵",
        role: "管理员",
        buildId: "13443322",
        buildName: "二号楼",
        xlh: '232143-12431'
    },
    {
        key: "3",
        name: "谢大脚",
        role: "管理员",
        buildId: "1233234232",
        buildName: "三号楼",
        xlh: '232143-12431'
    },
];
Mock.mock(/\/api\/users/, 'get', (option) => {
    const params = parseUrlParams(decodeURI(option.url));
    console.log(params);
    let result = {
        data: []
    }
    result.data = data;
    return result
})


