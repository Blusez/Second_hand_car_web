var scanUrl =
"http://www.guazi.com/hz/buy/";// @input(scanUrl,入口url,请输入一个需爬取城市的url，格式为：“http://www.guazi.com/城市名称/buy/”)

if (scanUrl.trim().length > 0) {

	var city = scanUrl.trim().substring(scanUrl.indexOf(".com/") + 5,
			scanUrl.indexOf("/buy/"));
}

var configs = {

	domains : [ "guazi.com" ],

	scanUrls : [ scanUrl ],

	contentUrlRegexes : [ "https?://www\\.guazi\\.com/" + city + "/\\w+\\.htm" ],

	helperUrlRegexes : [ "https?://www\\.guazi\\.com/" + city
			+ "/buy/(o\\d+/)?" ],

	enableJS : false,

	interval : 10000,

	fields : [

	{

		name : "car_name",

		selector : "//h1[contains(@class,'dt-titletype')]"

	}, {

		name : "car_brand",

		selector : "//h1[contains(@class,'dt-titletype')]"

	}, {
		// 成功！！
		name : "car_picture",
		alia : "图片",
		selector : "//ul[contains(@class,'det-picside')]/li/img",
		repeated : true
	// children :[
	// {
	// name: "car_picture_c",
	// selector : "//img"
	// }
	// ]

	}, {

		name : "car_price",

		selector : "//span[contains(@class,'fc-org pricestype')]"

	},

	{

		name : "car_license",

		selector : "//li[contains(@class,'one')]/b"

	},

	{

		name : "car_mileage",

		selector : "//ul[contains(@class,'assort')]/li[2]/b"

	},

	{

		name : "car_gearbox",

		selector : "//ul[contains(@class,'assort')]/li[3]/b"

	},

	{

		name : "car_emission_standard",

		selector : "//li[contains(@class,'em-sta detailHoverTips')]/b"

	},

	{

		name : "car_license_location",

		selector : "//ul[contains(@class,'assort')]/li[5]/b"

	},

	{

		name : "car_owner",

		selector : "//li[contains(@class,'owner')]/text()[2]"

	},

	{

		name : "car_description",

		selector : "//*[@id='base']/p"

	}

	]

};

configs.afterExtractField = function(fieldName,

data, page) {

	if (fieldName == "car_price") {

		var price = extract(data, "//b").replace("¥", "¥");

		var coinUnit = exclude(data, "//b");

		return (price + coinUnit);

	}

	else if (fieldName == "car_brand") {
		var brand = data;
		var regexp = "^[\u4e00-\u9fa5]{2}";
		// 正则
		var bbbb = brand.match(regexp)
		console.debug(bbbb)

		return bbbb + "";

	}

	else if (fieldName == "car_owner") {

		return data.trim();

	}

	else if (fieldName == "car_picture") {

		return data;

	}
	else if (fieldName == "car_description") {
		return exclude(data, "//em");
	}
	return data;
};
var crawler = new Crawler(configs);
crawler.start();