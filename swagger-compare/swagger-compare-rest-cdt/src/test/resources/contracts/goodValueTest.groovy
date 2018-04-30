package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/api/compare'
        body("""
    {
      "urlLeft":"http://goodValue/left.yaml",
      "urlRight":"http://goodValue/right.yaml"
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
                "compareResultType":"CHANGED",
                "compareCriticalType":"INFO",
                "compareType":"NODE",
                "values":{
                    "goodValue1_0":{
                        "compareResultType":"CHANGED",
                        "compareCriticalType":"INFO",
                        "compareType":"NODE",
                        "values":{
                            "goodValue2_0":{
                                "compareResultType":"CHANGED",
                                "compareCriticalType":"INFO",
                                "compareType":"LEAF",
                                "valueLeft":"goodValue2_0_left",
                                "valueRight":"goodValue2_0_right"
                            }
                        }
                    },
                    "goodValue1_1":{
                        "compareResultType":"CHANGED",
                        "compareCriticalType":"INFO",
                        "compareType":"LEAF",
                        "valueLeft":"goodValue1_1_left",
                        "valueRight":"goodValue1_1_right"
                    }
                }
            }"""
        )
        headers {
            contentType(applicationJson())
        }
    }
}

