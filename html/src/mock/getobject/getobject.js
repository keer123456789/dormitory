import Mock from 'mockjs'

Mock.mock(/\/api\/getobject/, 'get', () => {
    let result = {
        "code": 200,
        "msg": null,
        "data": [{
                key: "1",
                name: "灭火器",
                x: 124,
                y: 342,
                type: "灭火器",
                blockname: "3号楼-男",
                floorname: "2层",
            },
            {
                key: "2",
                name: "消防栓",
                x: 124,
                y: 342,
                type: "消防栓",
                blockname: "3号楼-男",
                floorname: "2层",
            },
            {
                key: "3",
                name: "应急灯",
                x: 124,
                y: 342,
                type: "应急灯",
                blockname: "3号楼-男",
                floorname: "2层",
            },
            {
                key: "4",
                name: "灭火器",
                x: 124,
                y: 342,
                type: "灭火器",
                blockname: "3号楼-男",
                floorname: "2层",
            },
        ]
    }
    return result
})