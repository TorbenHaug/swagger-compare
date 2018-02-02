package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/api/compare'
        body("""
    {
      "urlLeft":"https://mocked.mock/basicPathLeft.yaml",
      "urlRight":"https://mocked.mock/basicPathRight.yaml"
    }
    """)
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 200
        body(
            """{
                "pathsResult":{
                    "pathsResultItems":[
                        {"pathLeft":"/unchanged/{unchanged1}","pathRight":"/unchanged/{unchanged2}","compareResultType":"UNCHANGED"},
                        {"pathLeft":"/unchanged/","pathRight":"/unchanged/","compareResultType":"UNCHANGED"},
                        {"pathLeft":null,"pathRight":"/created/","compareResultType":"CREATED"},
                        {"pathLeft":"/deleted/","pathRight":null,"compareResultType":"DELETED"},
                        {"pathLeft":"/changed/{changed1}","pathRight":"/changed/{changed1}","compareResultType":"CHANGED"}
                    ]
                }
            }"""
        )
        headers {
            contentType(applicationJson())
        }
    }
}
