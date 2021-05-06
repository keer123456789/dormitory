import Mock from 'mockjs'

Mock.mock(/\/api\/getbuilddata/, 'get', () => {
    let result = {
        "code": 200,
        "msg": null,
        "data": {
            "blocks": [{
                    "name": "3号楼-男",
                    "value": "1"
                },
                {
                    "name": "4号楼-女",
                    "value": "2"
                }
            ],
            "floors": {
                "1": [{
                        "name": "1层",
                        "value": "1"
                    },
                    {
                        "name": "2层",
                        "value": "2"
                    },
                    {
                        "name": "3层",
                        "value": "3"
                    },
                    {
                        "name": "4层",
                        "value": "4"
                    },
                    {
                        "name": "5层",
                        "value": "5"
                    }
                ],
                "2": [{
                        "name": "1层",
                        "value": "6"
                    },
                    {
                        "name": "2层",
                        "value": "7"
                    },
                    {
                        "name": "3层",
                        "value": "8"
                    },
                    {
                        "name": "4层",
                        "value": "9"
                    },
                    {
                        "name": "6层",
                        "value": "10"
                    }
                ]
            }
        }
    }
    return result
})