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
                "pathsCompareResult":{
                    "unchanged":{
                        "/unchanged/":{ "summary":null },
                        "/unchanged/{unchanged1}":{ "summary":null }
                    },
                    "changed":{
                        "/changed/{changed1}":{
                            "parametersCompareResult":{
                                "unchanged":[],
                                "created":[],
                                "deleted":[],
                                "compareCriticalType":"NONE",
                                "compareResultType":"UNCHANGED"
                            },
                            "refCompareResult":{
                                "left":null,
                                "right":null,
                                "compareResultType":"UNCHANGED",
                                "compareCriticalType":"NONE"
                            },
                            "createdOperations":{},
                            "deletedOperations":{},
                            "unchangedOperations":{},
                            "changedOperations":{
                                "GET":{
                                    "compareCriticalType":"CRITICAL",
                                    "compareResultType":"CHANGED",
                                    "parametersCompareResult":{
                                        "unchanged":[{
                                            "name":"changed1",
                                            "in":"path",
                                        }],
                                        "created":[{
                                            "name":"changed2",
                                            "in":"query",
                                        }],
                                        "deleted":[],
                                        "compareCriticalType":"CRITICAL",
                                        "compareResultType":"CHANGED"
                                    },"deprecatedCompareResult":{
                                        "compareResultType":"UNCHANGED",
                                        "compareCriticalType":"NONE",
                                        "left":null,
                                        "right":null
                                    },"requestBodyCompareResult":{
                                        "left":null,
                                        "right":null,
                                        "compareResultType":"UNCHANGED",
                                        "compareCriticalType":"NONE"
                                    }
                                }
                            },
                            "compareResultType":"CHANGED",
                            "compareCriticalType":"CRITICAL"
                        }
                    },
                    "deleted":{
                        "/deleted/":{ "summary":null }
                    },
                    "created":{
                        "/created/":{ "summary":null }   
                    }
                }
            }"""
        )
        headers {
            contentType(applicationJson())
        }
    }
}

