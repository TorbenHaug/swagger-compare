package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/api/compare'
        body("""
    {
      "urlLeft":"https://mocked.mock/test1.yaml",
      "urlRight":"https://mocked.mock/test2.yaml"
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
                    "pathsResultItems":[{
                        "pathLeft":"/pets",
                        "pathRight":"/pets",
                        "compareResultType":"UNCHANGED"
                    },{
                        "pathLeft":"/pets/{id}",
                        "pathRight":"/pets/{id}",
                        "compareResultType":"UNCHANGED"
                    }]
                }
            }"""
        )
        headers {
            contentType(applicationJson())
        }
    }
}
