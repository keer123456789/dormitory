import Mock from 'mockjs'

Mock.mock(/\/api\/getstudent/, 'get', () => {
    let result = {
        "code": 200,
        "msg": null,
        "data": [{
                key: "1",
                name: "a",
                id: "13222123",
                academy: "123",
                major: "123",
                sex: "123",
                classNum: "123",
                bedNum: "123",
                roomId: "123",
                phoneNum: "123",
                identity_num: "123",
                nation: "123",
                region: "123",
                money: "￥300,000.00",
                address: "New York No. 1 Lake Park",
            },
            {
                key: "2",
                name: "b",
                money: "￥1,256,000.00",
                address: "London No. 1 Lake Park",
            },
            {
                key: "3",
                name: "Joe Black",
                money: "￥120,000.00",
                address: "Sidney No. 1 Lake Park",
            },
            {
                key: "4",
                name: "a",
                money: "￥300,000.00",
                address: "New York No. 1 Lake Park",
            },
            {
                key: "5",
                name: "b",
                money: "￥1,256,000.00",
                address: "London No. 1 Lake Park",
            },
            {
                key: "6",
                name: "Joe Black",
                money: "￥120,000.00",
                address: "Sidney No. 1 Lake Park",
            },
            {
                key: "7",
                name: "a",
                money: "￥300,000.00",
                address: "New York No. 1 Lake Park",
            },
            {
                key: "8",
                name: "b",
                money: "￥1,256,000.00",
                address: "London No. 1 Lake Park",
            },
            {
                key: "9",
                name: "Joe Black",
                money: "￥120,000.00",
                address: "Sidney No. 1 Lake Park",
            },
            {
                key: "10",
                name: "a",
                money: "￥300,000.00",
                address: "New York No. 1 Lake Park",
            },
            {
                key: "11",
                name: "b",
                money: "￥1,256,000.00",
                address: "London No. 1 Lake Park",
            },
            {
                key: "12",
                name: "Joe Black",
                money: "￥120,000.00",
                address: "Sidney No. 1 Lake Park",
            },
        ]
    }
    return result
})