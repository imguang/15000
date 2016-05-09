package shopInfoSpider;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import Pipeline.sqlPipeline;
import Utils.DbPoolConnection;
import Utils.JdbcUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class DazongPageProcessor implements PageProcessor {

	// public static final String URL_LIST =
	// "http://t\\.dianping\\.com/list/fuzhou-category_40\\?pageIndex=\\d+";
	// http://www.dianping.com/search/category/14/10/p
	public static String shopIdFirst_food;
	public static String shopIdFirst_ktv;

	public static DbPoolConnection dbp;

	public static final int TYPE_KTV = 1;
	public static final int TYPE_FOOD = 2;
	public static final int TYPE_HOTEL = 3;
	public static final int TYPE_MOVIE = 4;
	public static final int TYPE_JSON = 5;
	public static final int TYPE_SHOP = 6;
	public static final int TYPE_FINDDEAL = 7;
	public static final int TYPE_DEALINFO = 8;
	public static final int TYPE_DEALCOMMENT = 9;
	public static final int TYPE_SHOPCOMMENT = 10;

	public static final String KTV_SHOP_TABLE_NAME = "dazhongdianping_shopinfo_single_ktv_";
	public static String NOWDATE;

	public static final String URLBASE_FOOD = "http://www.dianping.com/search/category/14/10/p";
	public static final String URLBASE_MOVIE = "http://www.dianping.com/search/category/14/30/g136p";
	public static final String URLBASE_SHOP = "http://www.dianping.com/shop/";
	public static final String URLBASE_JSON = "http://www.dianping.com/ajax/json/shop/wizard/BasicHideInfoAjaxFP?_nr_force=";
	public static String unixTime;
	public static Connection connection;
	public static int counter = 1;

	// public HttpHost host = new HttpHost(hostname, port);
	public static List<Map<String, Object>> cityIds;
	public static List<Map<String, Object>> cookies;
	public static int cookieNum = 0;
	public static int nowCookie = 31;

	public static int citySize;

	private Site site = Site
			.me()
			.setRetryTimes(5)
			.setCycleRetryTimes(3)
			.setSleepTime(100)
			.setTimeOut(5000)
			.setDomain(".dianping.com")
			.setUserAgent(
					"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");

	@Override
	public Site getSite() {
		System.out.println("no1:" + site);
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	@Override
	public void process(Page page) {

		Request request = page.getRequest();
		Html html = page.getHtml();

		int type = (int) request.getExtra("type");
		int type2 = (int) request.getExtra("type2");

		switch (type) {
		case TYPE_KTV: {
			int pageNum = (int) request.getExtra("pageNum") + 1;
			String cityId = (String) request.getExtra("cityId");
			// find all shopId
			List<String> shopIds = page
					.getHtml()
					.xpath("//div[@class='operate J_operate Hide']/a[@class='o-map J_o-map']/@data-shopid")
					.all();
			System.out.println(shopIds.toString());
			// page is not the end
			if (null != shopIds
					&& (null == shopIdFirst_food || shopIds.get(0).equals(
							shopIdFirst_food) == false)) {
				shopIdFirst_food = shopIds.get(0);
				int size = shopIds.size();
				// if it has shops
				if (size != 0) {
					String sql = "select 1 from `dazongdianping`.`dazhongdianping_shopinfo_single_ktv_20160507` where shopId = "
							+ shopIds.get(0) + " limit 1";
					// System.out.println(sql);
					try {
						boolean result = JdbcUtils.isExist(sql,
								dbp.getConnection());
						// if not repeat continue
						// else stop
						if (result)
							System.out.println("exist!");
						if (!result) {
							// next page to find shop
							if (size >= 15) {
								Request requestTo = new Request();
								requestTo
										.setUrl("http://www.dianping.com/search/category/"
												+ cityId
												+ "/30/g135p"
												+ pageNum);
								requestTo.putExtra("pageNum", pageNum);
								requestTo.putExtra("type", TYPE_KTV);
								requestTo.putExtra("type2", 0);
								requestTo.putExtra("cityId", cityId);
								page.addTargetRequest(requestTo);
							}
							// find shopinfo

							detailPageProcess detailPageProcess = new detailPageProcess();
							if (nowCookie >= cookieNum) {
								nowCookie %= cookieNum;
							}
							String cookie = (String) cookies.get(nowCookie)
									.get("key");
							nowCookie++;
							detailPageProcess.setSite(detailPageProcess
									.getSite().addCookie("_hc.v", cookie));
							Spider tems = Spider.create(detailPageProcess)
									.addPipeline(new sqlPipeline());
							for (String shopId : shopIds) {

								Request shopInfoRequest2 = new Request();
								shopInfoRequest2.setUrl(URLBASE_SHOP + shopId);
								shopInfoRequest2.putExtra("type", TYPE_SHOP);
								shopInfoRequest2.putExtra("type2", TYPE_KTV);
								shopInfoRequest2.putExtra("shopId", shopId);
								tems.addRequest(shopInfoRequest2);
							}
							tems.thread(5).run();
							tems.close();

						}
						sql = null;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			page.setSkip(true);
			shopIds = null;
			break;
		}
		case TYPE_FOOD: {
			int pageNum = (int) request.getExtra("pageNum") + 1;
			// System.out.println("food!");
			List<String> shopIds = html
					.xpath("//div[@class='operate J_operate Hide']/a[@class='o-map J_o-map']/@data-shopid")
					.all();
			if (null == shopIdFirst_food
					|| shopIds.get(0).equals(shopIdFirst_food) == false) {
				shopIdFirst_food = shopIds.get(0);
				Request requestTo = new Request();
				requestTo.setUrl(URLBASE_FOOD + pageNum);
				requestTo.putExtra("pageNum", pageNum);
				requestTo.putExtra("type", TYPE_FOOD);
				requestTo.putExtra("type2", 0);
				page.addTargetRequest(requestTo);
				page.putField("params", shopIds);
				String sql = "insert ignore into dazongdianping_shopinfo_single_food(shopId) values ";
				int size = shopIds.size();
				for (int i = 1; i <= size; i++) {
					if (1 == i) {
						sql += "(?)";
					} else {
						sql += ",(?)";
					}
				}
				page.putField("sql", sql);

			} else {
				page.setSkip(true);
			}
			break;
		}
		case TYPE_HOTEL: {
			int pageNum = (int) request.getExtra("pageNum") + 1;
			// System.out.println("food!");
			List<String> shopIds = html
					.xpath("//h2[@class='hotel-name']/a[@class='hotel-name-link']/@href")
					.all();
			System.out.println(shopIds.toString());
			/*
			 * if (null == shopIdFirst_food ||
			 * shopIds.get(0).equals(shopIdFirst_food) == false) {
			 * shopIdFirst_food = shopIds.get(0); Request requestTo = new
			 * Request(); requestTo.setUrl(URLBASE_FOOD + pageNum);
			 * requestTo.putExtra("pageNum", pageNum);
			 * requestTo.putExtra("type", TYPE_FOOD);
			 * requestTo.putExtra("type2", 0); page.addTargetRequest(requestTo);
			 * page.putField("params", shopIds); String sql =
			 * "insert ignore into dazongdianping_shopinfo_single_hotel(shopId) values "
			 * ; int size = shopIds.size(); for (int i = 1; i <= size; i++) { if
			 * (1 == i) { sql += "(?)"; } else { sql += ",(?)"; } }
			 * page.putField("sql", sql);
			 * 
			 * } else { page.setSkip(true); }
			 */
			break;
		}
		case TYPE_MOVIE: {

			int pageNum = (int) request.getExtra("pageNum") + 1;
			List<String> shopIds = html
					.xpath("//div[@class='operate J_operate Hide']/a[@class='o-map J_o-map']/@data-shopid")
					.all();

			if (null != shopIds) {
				int size = shopIds.size();
				if (size == 15) {
					Request requestTo = new Request();
					requestTo.setUrl(URLBASE_MOVIE + pageNum);
					requestTo.putExtra("pageNum", pageNum);
					requestTo.putExtra("type", TYPE_MOVIE);
					requestTo.putExtra("type2", 0);
					page.addTargetRequest(requestTo);
				}
				if (size != 0) {
					page.putField("params", shopIds);
					String sql = "insert ignore into dazongdianping_shopinfo_single_movie(shopId) values ";
					for (int i = 1; i <= size; i++) {
						if (1 == i) {
							sql += "(?)";
						} else {
							sql += ",(?)";
						}
					}
					page.putField("sql", sql);
				} else {
					page.setSkip(true);
				}

			} else {
				page.setSkip(true);
			}

			break;
		}

		default:
			System.out.println("fail");
			break;
		}
		html = null;
		request = null;
		/*
		 * else { JSONObject jsonObject =
		 * JSON.parseObject(page.getHtml().toString())
		 * .getJSONObject("msg").getJSONObject("shopInfo"); Shop temShop =
		 * JSON.toJavaObject(jsonObject, Shop.class); // JSONArray jsonArray =
		 * jsonObject.getJSONObject("msg") //
		 * System.out.println(temShop.toString()); page.putField("shopInfo",
		 * temShop);
		 * 
		 * String jsonTemp = jsonArray.toJSONString(); jsonTemp =
		 * jsonTemp.substring(1, jsonTemp.length() - 1); jsonObject =
		 * JSON.parseObject(jsonTemp); tempShop = JSON.toJavaObject(jsonObject,
		 * shop.class); // System.out.println(tempShop.toString()); // add to
		 * list shops.add(tempShop); page.putField("shop",tempShop);
		 * 
		 * }
		 */
		// page.setSkip(true);
	}

	public static void main(String[] args) throws SQLException {
		Site temsite = Site
				.me()
				.setRetryTimes(5)
				.setCycleRetryTimes(3)
				.setSleepTime(100)
				.setTimeOut(5000)
				.setDomain(".dianping.com")
				.setUserAgent(
						"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");

		dbp = DbPoolConnection.getInstance();

		unixTime = String.valueOf(System.currentTimeMillis());

		NOWDATE = GetNowDate();
		cookies = JdbcUtils.findModeResult("select `key` from cookies2", null,
				dbp.getConnection());
		cookieNum = cookies.size();
		cityIds = JdbcUtils
				.findModeResult(
						"select cityId,cityNameCh,cityNameEn from dazhongdianping_city",
						null, dbp.getConnection());
		citySize = cityIds.size();
		DazongPageProcessor temPageProcessor = new DazongPageProcessor();
		sqlPipeline sqlPipeline = new sqlPipeline();
		for (int i = 0; i < citySize; i++) {

			if (nowCookie >= cookieNum) {
				nowCookie %= cookieNum;
			}

			String cookie = (String) cookies.get(nowCookie).get("key");
			temPageProcessor.setSite(temsite.addCookie("_hc.v", cookie));
			String cityId = (String) cityIds.get(i).get("cityId");
			Request request = new Request(
					"http://www.dianping.com/search/category/" + cityId
							+ "/30/g135p1");
			request.putExtra("pageNum", 1);
			request.putExtra("type", TYPE_KTV);
			request.putExtra("type2", 0);
			request.putExtra("cityId", cityId);
			nowCookie++;
			Spider newSpider = Spider.create(temPageProcessor).addPipeline(
					sqlPipeline);
			newSpider.addRequest(request).thread(3).run();
			newSpider.close();
			newSpider = null;
			request = null;
			cookie = null;
		}
		dbp = null;
		// ktv
		/*
		 * request.setUrl("http://www.dianping.com/search/category/14/30/g135p1")
		 * ; request.putExtra("pageNum", 1); request.putExtra("type", TYPE_KTV);
		 * request.putExtra("type2", 0); Spider.create(new
		 * DazongPageProcessor()).addPipeline(new sqlPipeline())
		 * .addRequest(request).thread(3).run();
		 */
		/*
		 * List<Map<String, Object>> shopIds = jdbcUtils.findModeResult(
		 * "select shopId from dazongdianping_shopinfo_single_ktv", null);
		 * Spider temSpider = Spider.create(new
		 * DazongPageProcessor()).addPipeline(new sqlPipeline()); for
		 * (Map<String, Object> map : shopIds) { String shopId = (String)
		 * map.get("shopId"); Request request = new Request();
		 * request.setUrl(URLBASE_JSON + unixTime + "&shopId=" + shopId);
		 * request.putExtra("type", TYPE_JSON); request.putExtra("type2",
		 * TYPE_KTV); request.putExtra("shopId", shopId);
		 * temSpider.addRequest(request); } for (Map<String, Object> map :
		 * shopIds) { String shopId = (String) map.get("shopId"); Request
		 * request2 = new Request(); request2.setUrl(URLBASE_SHOP + shopId);
		 * request2.putExtra("type", TYPE_SHOP); request2.putExtra("type2",
		 * TYPE_KTV); request2.putExtra("shopId", shopId);
		 * temSpider.addRequest(request2); } temSpider.thread(5).run();
		 */
		/*
		 * √¿ ≥
		 * request.setUrl("http://www.dianping.com/search/category/14/10/p1");
		 * request.putExtra("pageNum", 1); request.putExtra("type", TYPE_FOOD);
		 * Spider.create(new DazongPageProcessor()).addPipeline(new
		 * sqlPipeline()) .addRequest(request).thread(3).run();
		 */

		/*
		 * List<Map<String, Object>> shopIds = jdbcUtils.findModeResult(
		 * "select shopId from dazongdianping_shopinfo_single_food where shopName is null"
		 * , null);
		 * 
		 * for (Map<String, Object> map : shopIds) { String shopId = (String)
		 * map.get("shopId"); System.out.println(shopId);
		 * request.setUrl(URLBASE_JSON + unixTime + "&shopId=" + shopId);
		 * request.putExtra("type", TYPE_JSON); request.putExtra("type2",
		 * TYPE_FOOD); request.putExtra("shopId", shopId);
		 * 
		 * request2.setUrl(URLBASE_SHOP + shopId); request2.putExtra("type",
		 * TYPE_SHOP); request2.putExtra("type2", TYPE_FOOD);
		 * request2.putExtra("shopId", shopId);
		 * 
		 * Spider.create(new DazongPageProcessor()).addPipeline(new
		 * sqlPipeline()) .addRequest(request) .addRequest(request2)
		 * .thread(1).run();
		 * 
		 * }
		 */

		// http://www.dianping.com/search/category/14/30/g136p2
		// movie

		/*
		 * request.setUrl("http://www.dianping.com/search/category/14/30/g136p1")
		 * ; request.putExtra("pageNum", 1); request.putExtra("type",
		 * TYPE_MOVIE); request.putExtra("type2", 0); Spider.create(new
		 * DazongPageProcessor()).addPipeline(new sqlPipeline())
		 * .addRequest(request).thread(3).run();
		 */

		/*
		 * List<Map<String, Object>> shopIds = jdbcUtils.findModeResult(
		 * "select shopId from dazongdianping_shopinfo_single_movie where shopName is null"
		 * , null);
		 * 
		 * for (Map<String, Object> map : shopIds) { String shopId = (String)
		 * map.get("shopId"); System.out.println(shopId);
		 * request.setUrl(URLBASE_JSON + unixTime + "&shopId=" + shopId);
		 * request.putExtra("type", TYPE_JSON); request.putExtra("type2",
		 * TYPE_MOVIE); request.putExtra("shopId", shopId);
		 * 
		 * request2.setUrl(URLBASE_SHOP + shopId); request2.putExtra("type",
		 * TYPE_SHOP); request2.putExtra("type2", TYPE_MOVIE);
		 * request2.putExtra("shopId", shopId);
		 * 
		 * Spider.create(new DazongPageProcessor()).addPipeline(new
		 * sqlPipeline()) .addRequest(request) .addRequest(request2)
		 * .thread(1).run();
		 * 
		 * }
		 */

		// http://www.dianping.com/fuzhou/hotel/p1
		// hotel
		/*
		 * request.setUrl("http://www.dianping.com/fuzhou/hotel/p1");
		 * request.putExtra("pageNum", 1); request.putExtra("type", TYPE_HOTEL);
		 * request.putExtra("type2", 0); Spider.create(new
		 * DazongPageProcessor()).addPipeline(new sqlPipeline())
		 * .addRequest(request).thread(3).run();
		 */
		System.out.println("done.");

	}

	public static String GetNowDate() {
		String temp_str = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		temp_str = sdf.format(dt);
		return temp_str;
	}

}
