package model;

public class Shop {
	
	public String sqlPrint(){
		String resString = "null";
		resString = "("+"'"+branchName+"',"+
		"'"+shopId+"',"+"'"+shopName+"',"+"'"+address+"',"+"'"+crossRoad+"',"+"'"+phoneNo+"',"+
		"'"+phoneNo2+"',"+"'"+shopGroupId+"',"+"'"+cityId+"',"+"'"+power+"',"+"'"+hits+"',"+
		"'"+weeklyHits+"',"+"'"+defaultPic+"',"+"'"+defaultPicKey+"',"+"'"+wishTotal+"',"+"'"+score+"',"+
		"'"+score1+"',"+"'"+score2+"',"+"'"+score3+"',"+"'"+score4+"',"+"'"+avgPrice+"',"+
		"'"+writeUp+"',"+"'"+similarShops+"',"+"'"+searchKeyWord+"',"+"'"+prevWeeklyHits+"',"+"'"+todayHits+"',"+
		"'"+monthlyHits+"',"+"'"+popularity+"',"+"'"+glat+"',"+"'"+glng+"',"+"'"+shopPower+"',"+
		"'"+minUserMana+"',"+"'"+businessHours+"',"+"'"+priceInfo+"',"+"'"+publicTransit+"'"+
				")";
		return resString;
	}
//INSERT INTO `dazongdianping`.`shopinfo_single` (`ids`, `shopId`, `shopName`, `address`, `crossRoad`, `phoneNo`, `phoneNo2`, `shopGroupId`, `cityId`, `power`, `hits`, `weeklyHits`, `defaultPic`, `defaultPicKey`, `wishTotal`, `score`, `score1`, `score2`, `score3`, `score4`, `avgPrice`, `writeUp`, `similarShops`, `searchKeyWord`, `prevWeeklyHits`, `todayHits`, `monthlyHits`, `popularity`, `glat`, `glng`, `shopPower`, `minUserMana`, `businessHours`, `priceInfo`, `publicTransit`) VALUES ('', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

	private String displayStatus;
	private String shopId;//1
	private String shopType;
	private String shopName;//2
	private String branchName;
	private String address;//3
	private String crossRoad;//4
	private String phoneNo;//5
	private String phoneNo2;//6
	private String cityId;//7
	private String power;//8
	private String shopGroupId;//9
	private String groupFlag;
	private String altName;
	private String searchName;
	//important
	private String hits;//10
	private String weeklyHits;//11
	private String district;
	private String addDate;
	private String lastDate;
	private String addUser;
	private String lastUser;
	private String lastIp;
	private String defaultPic;//12
	private String defaultPicKey;//13
	private String branchTotal;
	//important
	private String picTotal;
	private String wishTotal;//14
	private String score;//15
	private String score1;//16
	private String score2;//17
	private String score3;//18
	private String score4;//19
	private String avgPrice;//20
	private String priceLevel;
	private String writeUp;//21
	private String similarShops;//22
	private String shopTags;
	private String primaryTag;
	private String dishTags;
	private String searchKeyWord;//23
	private String addUserName;
	private String lastUserName;
	//important
	private String prevWeeklyHits;//24
	private String webSite;
	private String firstReviewId;
	private String firstUserNickName;
	private String firstUserFace;
	//important
	private String todayHits;//25
	private String monthlyHits;//26
	private String nearbyShops;
	private String promoId;
	private String popularity;//27
	private String glat;//28
	private String glng;//29
	private String canSendSms;
	private String shopPower;//30
	private String nearByTags;
	private String hasStaticMap;
	private String minUserMana;//31
	private String businessHours;//32
	private String priceInfo;//33
	private String publicTransit;//34
	private String shopPowerTitle;
	private String clientType;
	private String newDistrict;
	private String newShopType;
	private String userCanUpdate;
	public String getDisplayStatus() {
		return displayStatus;
	}
	public void setDisplayStatus(String displayStatus) {
		this.displayStatus = displayStatus;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getShopType() {
		return shopType;
	}
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCrossRoad() {
		return crossRoad;
	}
	public void setCrossRoad(String crossRoad) {
		this.crossRoad = crossRoad;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPhoneNo2() {
		return phoneNo2;
	}
	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getShopGroupId() {
		return shopGroupId;
	}
	public void setShopGroupId(String shopGroupId) {
		this.shopGroupId = shopGroupId;
	}
	public String getGroupFlag() {
		return groupFlag;
	}
	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}
	public String getAltName() {
		return altName;
	}
	public void setAltName(String altName) {
		this.altName = altName;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getHits() {
		return hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}
	public String getWeeklyHits() {
		return weeklyHits;
	}
	public void setWeeklyHits(String weeklyHits) {
		this.weeklyHits = weeklyHits;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public String getDefaultPic() {
		return defaultPic;
	}
	public void setDefaultPic(String defaultPic) {
		this.defaultPic = defaultPic;
	}
	public String getDefaultPicKey() {
		return defaultPicKey;
	}
	public void setDefaultPicKey(String defaultPicKey) {
		this.defaultPicKey = defaultPicKey;
	}
	public String getBranchTotal() {
		return branchTotal;
	}
	public void setBranchTotal(String branchTotal) {
		this.branchTotal = branchTotal;
	}
	public String getPicTotal() {
		return picTotal;
	}
	public void setPicTotal(String picTotal) {
		this.picTotal = picTotal;
	}
	public String getWishTotal() {
		return wishTotal;
	}
	public void setWishTotal(String wishTotal) {
		this.wishTotal = wishTotal;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getScore1() {
		return score1;
	}
	public void setScore1(String score1) {
		this.score1 = score1;
	}
	public String getScore2() {
		return score2;
	}
	public void setScore2(String score2) {
		this.score2 = score2;
	}
	public String getScore3() {
		return score3;
	}
	public void setScore3(String score3) {
		this.score3 = score3;
	}
	public String getScore4() {
		return score4;
	}
	public void setScore4(String score4) {
		this.score4 = score4;
	}
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	public String getPriceLevel() {
		return priceLevel;
	}
	public void setPriceLevel(String priceLevel) {
		this.priceLevel = priceLevel;
	}
	public String getWriteUp() {
		return writeUp;
	}
	public void setWriteUp(String writeUp) {
		this.writeUp = writeUp;
	}
	public String getSimilarShops() {
		return similarShops;
	}
	public void setSimilarShops(String similarShops) {
		this.similarShops = similarShops;
	}
	public String getShopTags() {
		return shopTags;
	}
	public void setShopTags(String shopTags) {
		this.shopTags = shopTags;
	}
	public String getPrimaryTag() {
		return primaryTag;
	}
	public void setPrimaryTag(String primaryTag) {
		this.primaryTag = primaryTag;
	}
	public String getDishTags() {
		return dishTags;
	}
	public void setDishTags(String dishTags) {
		this.dishTags = dishTags;
	}
	public String getSearchKeyWord() {
		return searchKeyWord;
	}
	public void setSearchKeyWord(String searchKeyWord) {
		this.searchKeyWord = searchKeyWord;
	}
	public String getAddUserName() {
		return addUserName;
	}
	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}
	public String getLastUserName() {
		return lastUserName;
	}
	public void setLastUserName(String lastUserName) {
		this.lastUserName = lastUserName;
	}
	public String getPrevWeeklyHits() {
		return prevWeeklyHits;
	}
	public void setPrevWeeklyHits(String prevWeeklyHits) {
		this.prevWeeklyHits = prevWeeklyHits;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getFirstReviewId() {
		return firstReviewId;
	}
	public void setFirstReviewId(String firstReviewId) {
		this.firstReviewId = firstReviewId;
	}
	public String getFirstUserNickName() {
		return firstUserNickName;
	}
	public void setFirstUserNickName(String firstUserNickName) {
		this.firstUserNickName = firstUserNickName;
	}
	public String getFirstUserFace() {
		return firstUserFace;
	}
	public void setFirstUserFace(String firstUserFace) {
		this.firstUserFace = firstUserFace;
	}
	public String getTodayHits() {
		return todayHits;
	}
	public void setTodayHits(String todayHits) {
		this.todayHits = todayHits;
	}
	public String getMonthlyHits() {
		return monthlyHits;
	}
	public void setMonthlyHits(String monthlyHits) {
		this.monthlyHits = monthlyHits;
	}
	public String getNearbyShops() {
		return nearbyShops;
	}
	public void setNearbyShops(String nearbyShops) {
		this.nearbyShops = nearbyShops;
	}
	public String getPromoId() {
		return promoId;
	}
	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getGlat() {
		return glat;
	}
	public void setGlat(String glat) {
		this.glat = glat;
	}
	public String getGlng() {
		return glng;
	}
	public void setGlng(String glng) {
		this.glng = glng;
	}
	public String getCanSendSms() {
		return canSendSms;
	}
	public void setCanSendSms(String canSendSms) {
		this.canSendSms = canSendSms;
	}
	public String getShopPower() {
		return shopPower;
	}
	public void setShopPower(String shopPower) {
		this.shopPower = shopPower;
	}
	public String getNearByTags() {
		return nearByTags;
	}
	public void setNearByTags(String nearByTags) {
		this.nearByTags = nearByTags;
	}
	public String getHasStaticMap() {
		return hasStaticMap;
	}
	public void setHasStaticMap(String hasStaticMap) {
		this.hasStaticMap = hasStaticMap;
	}
	public String getMinUserMana() {
		return minUserMana;
	}
	public void setMinUserMana(String minUserMana) {
		this.minUserMana = minUserMana;
	}
	public String getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}
	public String getPriceInfo() {
		return priceInfo;
	}
	public void setPriceInfo(String priceInfo) {
		this.priceInfo = priceInfo;
	}
	public String getPublicTransit() {
		return publicTransit;
	}
	public void setPublicTransit(String publicTransit) {
		this.publicTransit = publicTransit;
	}
	public String getShopPowerTitle() {
		return shopPowerTitle;
	}
	public void setShopPowerTitle(String shopPowerTitle) {
		this.shopPowerTitle = shopPowerTitle;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getNewDistrict() {
		return newDistrict;
	}
	public void setNewDistrict(String newDistrict) {
		this.newDistrict = newDistrict;
	}
	public String getNewShopType() {
		return newShopType;
	}
	public void setNewShopType(String newShopType) {
		this.newShopType = newShopType;
	}
	public String getUserCanUpdate() {
		return userCanUpdate;
	}
	public void setUserCanUpdate(String userCanUpdate) {
		this.userCanUpdate = userCanUpdate;
	}
	@Override
	public String toString() {
		return "Shop [displayStatus=" + displayStatus + ", shopId=" + shopId
				+ ", shopType=" + shopType + ", shopName=" + shopName
				+ ", branchName=" + branchName + ", address=" + address
				+ ", crossRoad=" + crossRoad + ", phoneNo=" + phoneNo
				+ ", phoneNo2=" + phoneNo2 + ", cityId=" + cityId + ", power="
				+ power + ", shopGroupId=" + shopGroupId + ", groupFlag="
				+ groupFlag + ", altName=" + altName + ", searchName="
				+ searchName + ", hits=" + hits + ", weeklyHits=" + weeklyHits
				+ ", district=" + district + ", addDate=" + addDate
				+ ", lastDate=" + lastDate + ", addUser=" + addUser
				+ ", lastUser=" + lastUser + ", lastIp=" + lastIp
				+ ", defaultPic=" + defaultPic + ", defaultPicKey="
				+ defaultPicKey + ", branchTotal=" + branchTotal
				+ ", picTotal=" + picTotal + ", wishTotal=" + wishTotal
				+ ", score=" + score + ", score1=" + score1 + ", score2="
				+ score2 + ", score3=" + score3 + ", score4=" + score4
				+ ", avgPrice=" + avgPrice + ", priceLevel=" + priceLevel
				+ ", writeUp=" + writeUp + ", similarShops=" + similarShops
				+ ", shopTags=" + shopTags + ", primaryTag=" + primaryTag
				+ ", dishTags=" + dishTags + ", searchKeyWord=" + searchKeyWord
				+ ", addUserName=" + addUserName + ", lastUserName="
				+ lastUserName + ", prevWeeklyHits=" + prevWeeklyHits
				+ ", webSite=" + webSite + ", firstReviewId=" + firstReviewId
				+ ", firstUserNickName=" + firstUserNickName
				+ ", firstUserFace=" + firstUserFace + ", todayHits="
				+ todayHits + ", monthlyHits=" + monthlyHits + ", nearbyShops="
				+ nearbyShops + ", promoId=" + promoId + ", popularity="
				+ popularity + ", glat=" + glat + ", glng=" + glng
				+ ", canSendSms=" + canSendSms + ", shopPower=" + shopPower
				+ ", nearByTags=" + nearByTags + ", hasStaticMap="
				+ hasStaticMap + ", minUserMana=" + minUserMana
				+ ", businessHours=" + businessHours + ", priceInfo="
				+ priceInfo + ", publicTransit=" + publicTransit
				+ ", shopPowerTitle=" + shopPowerTitle + ", clientType="
				+ clientType + ", newDistrict=" + newDistrict
				+ ", newShopType=" + newShopType + ", userCanUpdate="
				+ userCanUpdate + "]";
	}
	
	
	/*
    "primaryTag": null,
    "dishTags": "",
    "searchKeyWord": "威美斯V-MUSE KTV,,六一中路28号佳盛广场4楼,沃尔玛斜对面,KTV,,",
    "addUserName": "gaga013",
    "lastUserName": "陈俊杰",
    "prevWeeklyHits": 332,
    "webSite": null,
    "firstReviewId": 34040809,
    "firstUserNickName": "gaga013",
    "firstUserFace": null,
    "todayHits": 45,
    "monthlyHits": 1590,
    "nearbyShops": null,
    "promoId": null,
    "popularity": 91,
    "glat": 26.07555,
    "glng": 119.318945,
    "canSendSms": true,
    "shopPower": 50,
    "nearByTags": null,
    "hasStaticMap": false,
    "minUserMana": 25,
    "businessHours": "12:00-次日02:00",
    "priceInfo": "",
    "publicTransit": "紫阳立交桥-公交车站途经公交车：7路, 16路, 17路, 62路, 69路, 71路, 74路, 79路, 80路, 88路, 92路, 97路, 103路, 125路, 129路, 202路夜班空调, 306路, 318路, k2路, 两马航线定时班车",
    "shopPowerTitle": null,
    "clientType": 1,
    "newDistrict": 98,
    "newShopType": 15,
    "userCanUpdate": null
    */
	
	
	/*
    "lastDate": 1457539286000,
    "addUser": 20467000,
    "lastUser": -14393,
    "lastIp": "10.1.120.33",
    "defaultPic": "http://i2.s2.dpfile.com/pc/97d3c4afaf92b402545edd2b06856f3c(120c90)/thumb.jpg",
    "defaultPicKey": "/pc/97d3c4afaf92b402545edd2b06856f3c",
    "branchTotal": 0,
    "voteTotal": 626,
    "picTotal": -84,
    "wishTotal": 470,
    "score": 92,
    "score1": 91,
    "score2": 91,
    "score3": 91,
    "score4": 2,
    "avgPrice": 52,
    "priceLevel": null,
    "writeUp": "台湾KTV专业团队V-MUSE登陆福州。打造KTV业界影音震撼效果。感受BOSE的音响质感。全馆采用高频无线麦，玫瑰金无线复古金色麦克风、无线移动点歌屏。特色美食，体验尊荣服务。V-MUSE KTV欢迎您的莅临。",
    "similarShops": ",5667458|,1995682|,3473587|,6046283",
    "shopTags": "KTV,45|",
    */
	
	 /*"displayStatus": 1,
     "shopId": 6091668,
     "shopType": 15,
     "shopName": "威美斯V-MUSE KTV",
     "branchName": "",
     "address": "六一中路28号佳盛广场4楼",
     "crossRoad": "沃尔玛斜对面",
     "phoneNo": "88555111",
     "phoneNo2": "",
     "cityId": 14,
     "power": 5,
     "shopGroupId": 6091668,
     "groupFlag": false,
     "altName": "",
     "searchName": null,
     "hits": 65359,
     "weeklyHits": 384,
     "district": 98,
     "oldChainId": null,
     "addDate": 1341462339000,
     */
	
	
	
}
