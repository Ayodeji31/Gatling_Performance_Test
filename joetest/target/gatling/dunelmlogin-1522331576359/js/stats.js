var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "13",
        "ok": "13",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "244",
        "ok": "244",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1394",
        "ok": "1394",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "535",
        "ok": "535",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "295",
        "ok": "295",
        "ko": "-"
    },
    "percentiles1": {
        "total": "446",
        "ok": "446",
        "ko": "-"
    },
    "percentiles2": {
        "total": "588",
        "ok": "588",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1055",
        "ok": "1055",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1326",
        "ok": "1326",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 11,
        "percentage": 85
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 1,
        "percentage": 8
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 1,
        "percentage": 8
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.21",
        "ok": "0.21",
        "ko": "-"
    }
},
contents: {
"req_login-99dea": {
        type: "REQUEST",
        name: "Login",
path: "Login",
pathFormatted: "req_login-99dea",
stats: {
    "name": "Login",
    "numberOfRequests": {
        "total": "7",
        "ok": "7",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "244",
        "ok": "244",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1394",
        "ok": "1394",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "526",
        "ok": "526",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "380",
        "ok": "380",
        "ko": "-"
    },
    "percentiles1": {
        "total": "360",
        "ok": "360",
        "ko": "-"
    },
    "percentiles2": {
        "total": "535",
        "ok": "535",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1185",
        "ok": "1185",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1352",
        "ok": "1352",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 6,
        "percentage": 86
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 1,
        "percentage": 14
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.113",
        "ok": "0.113",
        "ko": "-"
    }
}
    },"req_logout-0323d": {
        type: "REQUEST",
        name: "Logout",
path: "Logout",
pathFormatted: "req_logout-0323d",
stats: {
    "name": "Logout",
    "numberOfRequests": {
        "total": "6",
        "ok": "6",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "401",
        "ok": "401",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "829",
        "ok": "829",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "546",
        "ok": "546",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "139",
        "ok": "139",
        "ko": "-"
    },
    "percentiles1": {
        "total": "507",
        "ok": "507",
        "ko": "-"
    },
    "percentiles2": {
        "total": "571",
        "ok": "571",
        "ko": "-"
    },
    "percentiles3": {
        "total": "769",
        "ok": "769",
        "ko": "-"
    },
    "percentiles4": {
        "total": "817",
        "ok": "817",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 5,
        "percentage": 83
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 1,
        "percentage": 17
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.097",
        "ok": "0.097",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
